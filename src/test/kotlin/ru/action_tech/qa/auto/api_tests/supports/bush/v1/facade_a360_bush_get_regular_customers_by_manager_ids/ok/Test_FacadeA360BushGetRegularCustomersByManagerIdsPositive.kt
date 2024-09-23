package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_get_regular_customers_by_manager_ids.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushGetRegularCustomersByManagerIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetRegularCustomersByManagerIds
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_regular_customers_by_manager_ids.request.FacadeA360BushGetRegularCustomersByManagerIdsRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.USER_ACTIONUSKA
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushGetRegularCustomersByManagerIdsPositive {

    private val systemUserId by lazy { USER_ACTIONUSKA.id }
    private val customerIds by lazy {
        listOf(
            "8bc43185-7a9b-49a0-a20c-3636c054491a",
            "a3d616a8-418f-4114-a9fb-2ad10788db1b",
            "40e10414-f429-4c71-813b-07f0ececb710",
            "f33e5468-c2b7-41ae-803b-060828267af7"
        )
    }

    private val number = "66"

    private val request by lazy {
        facadeA360BushGetRegularCustomersByManagerIds(
            FacadeA360BushGetRegularCustomersByManagerIdsRequest(
                systemUserIds = listOf(systemUserId),
                customerIds = customerIds,
                number = number
            )
        )
    }


    @Test
    @Sale_Supports
    @FacadeA360BushGetRegularCustomersByManagerIds
    @Response_200_Ok
    @Requirements("REQCRM-968")
    @HistoryIssues("ARMAP-17783")
    @DisplayName("/api/v1/facade-a360-bush_get-regular-customers-by-manager-ids -> 200 Ok: Метод получения кустов Актион 360 с регулярными клиентами по списку Id менеджеров")
    @AllureId("145881")
    fun test_FacadeA360BushGetRegularCustomersByManagerIdsPositive() {
        val response = supportsCrmClient.send(request)

        "Проверка что в ответе 1 элемент" { assertThat(response).hasSize(1) }

        "Проверка что ответ отфильтрован по systemUserId = $systemUserId" {
            assertThat(response.first().systemUserId).isEqualToIgnoringCase(systemUserId)
        }

        assertThat(response.first().bushesA360).run {
            "Проверка что bushesA360 не пустой" { isNotEmpty }

            "Проверка что ответ отфильтрован по customers и number.contains(\"66\")" {
                allSatisfy {
                    assertThat(it.name).containsIgnoringCase(number)
                    assertThat(it.customers).anySatisfy { customer ->
                        assertThat(customerIds).contains(customer.id)
                        assertThat(customer.hasActiveUkd).isTrue
                    }
                }
            }
        }
    }
}