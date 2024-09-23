package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.api_models.erm_backend.order.v1.order_get_license_preview.OrderGetLicensePreviewResponse
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.api_models.erm_backend.order.v1.order_create.OrderCreateRequest
import ru.action_tech.qa.auto.api_models.erm_backend.order.v1.order_create.OrderCreateResponse
import ru.action_tech.qa.auto.data.BankAccounts
import ru.action_tech.qa.auto.data.PRICE_LIST_SS
import ru.action_tech.qa.auto.data.SCENARIO_ADVANCE
import ru.action_tech.qa.auto.data.PRODUCT_SS
import ru.action_tech.qa.auto.utils.auth.tokenFirstPartnerTestUser
import ru.action_tech.qa.auto.utils.ermBackendArmSellerClient
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.uuid
import java.util.*


object ApiErmBackendHelper {

    fun getLicensePreview(orderId: String, token: String? = tokenFirstPartnerTestUser): OrderGetLicensePreviewResponse {
        return ermBackendArmSellerClient.send(
            ErmBackendRequests.orderGetLicensePreview(token = token, orderId = orderId)
        )
    }

    /** создание тестового заказа (start) */
    fun generateAndAddTestOrder(
        token: String? = tokenAutoActionushka,
        realContactId: UUID? = null,
        realCustomerId: UUID? = null,
        customerId: UUID? = null,
        contactId: UUID? = null,
        items: List<OrderCreateRequest.Item>,
        currencyAccountId: UUID? = BankAccounts.BANK_ACCOUNT_PARTNER.id.uuid
    ): OrderCreateResponse = ermBackendArmSellerClient.send(
        OrdersRequests.orderCreate(
            token = token,
            request = OrderCreateRequest(
                realContactId = realContactId,
                realCustomerId = realCustomerId,
                customerId = customerId,
                contactId = contactId,
                items = items,
                paymentScenarioId = SCENARIO_ADVANCE.id!!.uuid,
                currencyAccountId = currencyAccountId,
                orderId = null,
                discount = null,
                paymentPhoneCallDate = DateTimeUtils.TOMORROW.toString(),
                campaignId = "0cfdc690-8f9a-4295-bc12-a30e72201a23".uuid,
                phoneCallId = "526f88ab-cb2f-4fe2-ba80-233d80656d31".uuid,
                contractType = generateTestContractType(),
                paymentPlannedDate = null,
                contractPaymentDate = null,
                paymentSchedules = null
            )
        )
    )

    fun generateTestItem(
        priceId: String? = PRICE_LIST_SS.id,
        products: List<OrderCreateRequest.Item.Product>
    ): OrderCreateRequest.Item {
        return OrderCreateRequest.Item(
            groupId = UUID.randomUUID(),
            priceId = priceId!!.uuid,
            personalDiscount = generateTestPersonalDiscount(),
            products = products
        )
    }

    private fun generateTestPersonalDiscount(
        previousSubscribeId: UUID? = null,
        applyPersonalDiscount: Boolean? = false,
        discountSum: Int? = 0
    ): OrderCreateRequest.Item.PersonalDiscount {
        return OrderCreateRequest.Item.PersonalDiscount(
            previousSubscribeId = previousSubscribeId,
            applyPersonalDiscount = applyPersonalDiscount,
            discountSum = discountSum
        )
    }

    fun generateTestProduct(
        productId: String? = PRODUCT_SS.id,
        units: Int? = 1,
        readerId: UUID? = null
    ): OrderCreateRequest.Item.Product {
        return OrderCreateRequest.Item.Product(
            itemId = UUID.randomUUID(),
            productId = productId!!.uuid,
            units = units,
            dateStart = "2023-01-01T00:00:00+03:00",
            deliveryMethodId = "2ad1cd58-ca0e-44dc-9cc9-2e354e7c53aa".uuid,
            readerId = readerId
        )
    }

    private fun generateTestContractType(
        contractTypeId: String? = "3f89e98f-e4f4-e611-bde7-78e3b502da44",
        salesProcedureId: String? = "a7ac1931-3e09-e711-96ea-78e3b502da44"
    ): OrderCreateRequest.ContractType {
        return OrderCreateRequest.ContractType(
            contractTypeId = contractTypeId!!.uuid,
            salesProcedureId = salesProcedureId!!.uuid
        )
    }
    /** создание тестового заказа (end) */


}