package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_product_ids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetToCreateLogentriesBatchByProductIdsV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_OrdersGetToCreateLogentriesBatchByProductIds {

    private val request by lazy {
        AccessesRequests.ordersGetToCreateLogentriesBatchByProductIds(
            productIds = listOf("84A4A269-3CC1-4E6F-B1FF-64FA651EE37A", "92e91fb4-1e83-4e6a-8833-a44e6a81597c"),
            isCheckStock = true,
            receiveCaseId = "f88a0590-a4b2-e911-bba3-00155d627f03",
            checkPayment = true,
            isPostPaymentShipment = true
        )
    }


    @Test
    @NotAutomated // todo Need test data :: ARMAP-16589
    @Requirements("REQCRM-1415")
    @Sale_Accesses
    @OrdersGetToCreateLogentriesBatchByProductIdsV1
    @Response_200_Ok
    @DisplayName("/orders_get-to-create-logentries-batch-by-product-ids -> 200 Ok: Вернулся список сделок А360 по подразделению")
    @AllureId("177743")
    fun test() {
        val response = accessesCrmClient.send(request)

        "Проверяем что ответ НЕ пустой" { assertTrue(response.isNotEmpty()) }
    }
}