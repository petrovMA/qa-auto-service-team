package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.customer.CustomersRequests
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_can_create.request.OpportunityA360CanCreateRequest
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.customer.customer.v1.create.CreateOrganizationRequest
import ru.action_tech.qa.auto.api_models.customer.search.v1.customers.search_customers.SearchCustomersRequest
import ru.action_tech.qa.auto.utils.customerServiceArmSellerClient
import ru.action_tech.qa.auto.utils.getRandomNumberToString
import ru.action_tech.qa.auto.utils.supportsCrmClient

object ClientHelper {
    private val searchTextTemplate = "ЕРМ тест"
    private val searchCustomerType = 2
    private val orgInn by lazy { getRandomNumberToString() }

    fun getValidClient(excludeClients: List<String> = listOf(), customerType: Int = searchCustomerType): String {
        var orgId = "Получаем список клиентов и выбираем того, для которого можно создать сделку" {
            getFreeClient(excludeClients = excludeClients, customerType = customerType)
        }
        if (orgId.isNullOrBlank()) {
            orgId = "Создаем юр.лицо через api" {
                customerServiceArmSellerClient.send(CustomersRequests.createOrganization(CreateOrganizationRequest(inn = orgInn))).id
            }
        }

        return orgId
    }

    fun getFreeClient(
        searchText: String = searchTextTemplate,
        excludeClients: List<String> = listOf(),
        customerType: Int = searchCustomerType
    ): String? = "Отправляем запрос поиска клиента" {
        customerServiceArmSellerClient.send(
            CustomersRequests.search(
                SearchCustomersRequest(
                    text = searchText,
                    customerType = customerType
                )
            )
        )
    }.items.firstOrNull {
        val resp = "Проверяем, возможно ли создать сделку для клиента \"${it?.email}\"" {
            supportsCrmClient.send(SupportsRequests.opportunityA360CanCreate(OpportunityA360CanCreateRequest(accountId = it?.id)))
        }
        val resp2 = "Проверяем, что для клиента \"${it?.email}\" не существует сделки А360" {
            supportsCrmClient.send(SupportsRequests.opportunityA360GetByCustomer(it?.id))
        }
        resp.id == true && it?.customerType == 1 && resp2.isEmpty() && !excludeClients.contains(it.id)
    }?.id
}
