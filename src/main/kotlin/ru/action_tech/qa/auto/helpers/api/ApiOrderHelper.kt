package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkNoContent
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests.createOrderV2
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderRequest
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderResponse
import ru.action_tech.qa.auto.api_models.orders.orders.v1.order.OrdersResponse
import ru.action_tech.qa.auto.api_models.orders.qa.delete_order.DeleteOrderRequest
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.core.utils.format
import ru.action_tech.qa.auto.data.*
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.ordersCrmClient
import java.util.*


object ApiOrderHelper {

    fun getInfoOrder(orderId: String): OrdersResponse = ordersCrmClient.send(OrdersRequests.getOrder(orderId))


    fun deleteOrder(orderId: String, token: String? = tokenAutoActionushka) {
        ordersCrmClient.send(
            OrdersRequests.deleteOrder(
                token = token,
                request = DeleteOrderRequest(
                    orderId = orderId
                )
            )
        )

        "Проверить, что заказ деактивирован" {
            ordersCrmClient.send(
                OrdersRequests.getOrder(
                    token = token,
                    orderId = orderId
                )
            ).apply {
                items.isNullOrEmpty()
            }
        }
    }

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

    fun generateOrderItems(
        groupId: String? = null,
        priceId: String? = PRICE_LIST_SS.id,
        personalDiscount: CreateOrderRequest.Items.PersonalDiscount? = generateOrderDiscount(),
        products: List<CreateOrderRequest.Items.Products>? = listOf(generateOrderProducts())
    ): CreateOrderRequest.Items {
        return CreateOrderRequest.Items(
            groupId = groupId,
            priceId = priceId,
            personalDiscount = personalDiscount,
            products = products
        )
    }

    fun generateOrderProducts(
        productId: String? = PRODUCT_SS.id,
        dateStart: String? = "2022-05-01T00:00:00+03:00",
        units: Int? = 1,
        deliveryMethodId: String? = "2ad1cd58-ca0e-44dc-9cc9-2e354e7c53aa",
        readerId: String? = null
    ): CreateOrderRequest.Items.Products {
        return CreateOrderRequest.Items.Products(
            productId = productId,
            dateStart = dateStart,
            units = units,
            deliveryMethodId = deliveryMethodId,
            readerId = readerId
        )
    }

    private fun generateOrderDiscount(
        previousSubscribeId: UUID? = null,
        applyPersonalDiscount: Boolean? = false,
        discountSum: Int? = 0,
        isOrderGenerator: Boolean = false
    ): CreateOrderRequest.Items.PersonalDiscount {
        return CreateOrderRequest.Items.PersonalDiscount(
            previousSubscribeId = previousSubscribeId,
            applyPersonalDiscount = applyPersonalDiscount!!,
            discountSum = discountSum,
            isOrderGenerator = isOrderGenerator
        )
    }

    /** создание заказа (start) */
    fun generateAndAddTestOrderV2(
        token: String? = tokenAutoActionushka,
        paymentScenarioId: String? = SCENARIO_ADVANCE.id!!,
        currencyAccountId: String? = BankAccounts.BANK_ACCOUNT_PARTNER.id,
        items: List<CreateOrderRequest.Items>? = listOf(generateOrderItems()),
        customerId: String? = null,
        customerType: Int? = 1,
        campaignId: String? = AUTO_CAMPAING.id,
        contactId: String? = null,
        phoneCallId: String? = "1064ab55-8c15-46ac-a5b2-af50fa74f1dc",
        paymentPhoneCallDate: String? = "${DateTimeUtils.TOMORROW.format("yyyy-MM-dd")}T15:00:00+03:00",
        contractType: CreateOrderRequest.ContractType? = generateOrderContract(),
        realContactId: String? = null,
        realCustomerId: String? = null
    ): CreateOrderResponse {
        val lazyValue by lazy {
            ordersCrmClient.send(
                createOrderV2(
                    token = token,
                    request = CreateOrderRequest(
                        paymentScenarioId = paymentScenarioId,
                        currencyAccountId = currencyAccountId,
                        items = items,
                        customerId = customerId,
                        customerType = customerType,
                        campaignId = campaignId,
                        contactId = contactId,
                        phoneCallId = phoneCallId,
                        paymentPhoneCallDate = paymentPhoneCallDate,
                        contractType = contractType!!,
                        realContactId = realContactId,
                        realCustomerId = realCustomerId,
                    )
                )
            )
        }
        lazyValue.apply { assertFalse(id.isBlank()) }
        return lazyValue
    }

    private fun generateOrderContract(
        contractTypeId: String? = "3f89e98f-e4f4-e611-bde7-78e3b502da44",
        salesProcedureId: String? = "a7ac1931-3e09-e711-96ea-78e3b502da44"
    ): CreateOrderRequest.ContractType {
        return CreateOrderRequest.ContractType(
            contractTypeId = contractTypeId,
            salesProcedureId = salesProcedureId
        )
    }
}
