package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkNoContent
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests.createOrderV2
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderRequest
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderResponse
import ru.action_tech.qa.auto.api_models.orders.orders.v1.order.OrdersResponse
import ru.action_tech.qa.auto.api_models.orders.qa.delete_order.DeleteOrderRequest
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.AUTO_CAMPAING
import ru.action_tech.qa.auto.data.BankAccounts
import ru.action_tech.qa.auto.data.SCENARIO_ADVANCE
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.ordersCrmClient


object ApiOrderHelper {

    fun getInfoOrder(orderId: String): OrdersResponse = ordersCrmClient.send(OrdersRequests.getOrder(orderId))

    fun orderCreate(
        paymentScenarioId: String = SCENARIO_ADVANCE.id!!, //Авансовый
        customerId: String,
        contactId: String,
        priceId: String,
        groupId: String? = null,
        productId: String,
        dateStart: String,
        token: String? = tokenAutoActionushka,
        campaignId: String? = AUTO_CAMPAING.id,
        phoneCallId: String? = "1064ab55-8c15-46ac-a5b2-af50fa74f1dc",
        items: List<CreateOrderRequest.Items> = listOf(
            CreateOrderRequest.Items(
                priceId = priceId,
                groupId = groupId,
                products = listOf(
                    CreateOrderRequest.Items.Products(
                        productId = productId,
                        dateStart = dateStart
                    )
                )
            )
        ),
        realContactId: String? = null,
        realCustomerId: String? = null,
        paymentPlannedDate: String? = null,
        contractPaymentDate: String? = null
    ): CreateOrderResponse = ordersCrmClient.send(
        createOrderV2(
            CreateOrderRequest(
                realContactId = realContactId,
                realCustomerId = realCustomerId,
                paymentScenarioId = paymentScenarioId,
                currencyAccountId = BankAccounts.BANK_ACCOUNT_FOR_AUTOTEST.id, //Р/с для автотестов
                customerId = customerId,
                contactId = contactId,
                campaignId = campaignId,
                phoneCallId = phoneCallId,
                contractPaymentDate = contractPaymentDate,
                paymentPlannedDate = paymentPlannedDate,
                items = items
            ),
            token = token
        )
    )

    fun qaDeleteOrder(orderId: String) {
        ordersCrmClient.send(OrdersRequests.qaOrderDelete(DeleteOrderRequest(orderId)))
            .apply { "Проверяем, что в ответе пришло true" { assertTrue(this) } }

        "Проверяем, что заказы удалились" {
            checkNoContent(apiClient = ordersCrmClient, request = OrdersRequests.getOrder(orderId))
        }
    }
}
