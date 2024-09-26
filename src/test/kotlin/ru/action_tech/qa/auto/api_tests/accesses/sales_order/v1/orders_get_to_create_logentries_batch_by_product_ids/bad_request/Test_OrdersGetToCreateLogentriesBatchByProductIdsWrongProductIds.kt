package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_product_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetToCreateLogentriesBatchByProductIdsV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_OrdersGetToCreateLogentriesBatchByProductIdsWrongProductIds {

    private val request by lazy {
        AccessesRequests.ordersGetToCreateLogentriesBatchByProductIds(
            productIds = listOf("123-123-123-123-123"),
            isCheckStock = false,
            receiveCaseId = "f88a0590-a4b2-e911-bba3-00155d627f03",
            checkPayment = false,
            isPostPaymentShipment = false,
            from = "2020-01-01T00:00:00",
            to = "2020-01-01T00:00:00"
        )
    }

    @Test
    @Requirements("REQCRM-1415")
    @Sale_Accesses
    @OrdersGetToCreateLogentriesBatchByProductIdsV1
    @Response_400_Bad_Request
    @DisplayName("/orders_get-to-create-logentries-batch-by-product-ids -> 400 Bad Request: не валидный параметр productIds")
    @AllureId("177742")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }
}