package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_product_ids_by_customer_id.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetToCreateLogentriesBatchByProductIdsByCustomerIdV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_OrdersGetToCreateLogentriesBatch {

    private val request by lazy {
        AccessesRequests.ordersGetToCreateLogentriesBatchByProductIdsByCustomerId(
            productIds = listOf("84A4A269-3CC1-4E6F-B1FF-64FA651EE37A", "92e91fb4-1e83-4e6a-8833-a44e6a81597c"),
            customerId = "F04F02EC-8C1E-4FFC-AA0C-6A5304A503DC"
        )
    }


    @Test
    @NotAutomated // todo Need test data :: ARMAP-16587
    @Requirements("REQCRM-1416")
    @Sale_Accesses
    @OrdersGetToCreateLogentriesBatchByProductIdsByCustomerIdV1
    @Response_200_Ok
    @DisplayName("/orders_get-to-create-logentries-batch-by-product-ids-by-customer-id -> 200 Ok: Вернулся список сделок А360 по подразделению")
    @AllureId("177653")
    fun test() {
        val response = accessesCrmClient.send(request)

        "Проверяем что ответ НЕ пустой" { assertTrue(response.isNotEmpty()) }
    }
}