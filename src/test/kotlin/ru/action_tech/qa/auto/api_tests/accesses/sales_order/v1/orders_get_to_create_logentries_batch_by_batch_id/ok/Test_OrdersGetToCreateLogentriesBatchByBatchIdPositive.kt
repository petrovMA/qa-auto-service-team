package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_batch_id.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetToCreateLogentriesBatchByBatchIdV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient

class Test_OrdersGetToCreateLogentriesBatchByBatchIdPositive {

    private val request by lazy {
        AccessesRequests.ordersGetToCreateLogentriesBatchByBatchId(batchId = "a3fdce31-2985-4f07-9a9d-f8989602dcd9")
    }


    @Test
    @Sale_Accesses
    @NotAutomated // todo Need test data :: ARMAP-16588
    @OrdersGetToCreateLogentriesBatchByBatchIdV1
    @Response_200_Ok
    @Requirements("REQCRM-1721")
    @DisplayName("/api/v1/orders_get-to-create-logentries-batch-by-batch-id -> 200 Ok: Рассчитанные Ids заказов для формирования записей журнала батчей по Id батча")
    @AllureId("177194")
    fun test() {
        val response = accessesCrmClient.send(request)

        "Проверяем, что ответ НЕ пустой" { assertTrue(response.isNotEmpty()) }
    }
}