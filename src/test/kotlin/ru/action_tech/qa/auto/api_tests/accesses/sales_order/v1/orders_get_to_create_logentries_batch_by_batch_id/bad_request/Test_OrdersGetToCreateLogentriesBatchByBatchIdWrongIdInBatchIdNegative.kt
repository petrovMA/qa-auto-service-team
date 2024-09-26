package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_batch_id.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetToCreateLogentriesBatchByBatchIdV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR

class Test_OrdersGetToCreateLogentriesBatchByBatchIdWrongIdInBatchIdNegative {


    @Test
    @Requirements("REQCRM-1721")
    @Sale_Accesses
    @OrdersGetToCreateLogentriesBatchByBatchIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/orders_get-to-create-logentries-batch-by-batch-id -> 400 Bad Request: не корректные параметры в batchId")
    @AllureId("177193")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.ordersGetToCreateLogentriesBatchByBatchId(batchId = "123___321"),
            expected = setOf(BrokenRule(code = 103, message = "Не указан Id батча"))
        )
    }
}