package ru.action_tech.qa.auto.api_models.customer

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customers_unhold_by_ids.CustomersUnholdByIdsRequest
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold.CustomerHoldRequest
import ru.action_tech.qa.auto.utils.auth.tokenQA
import ru.action_tech.qa.auto.utils.http.Headers


object CustomersRequests {

    fun customersUnholdByIds(
        request: CustomersUnholdByIdsRequest?, token: String? = tokenQA
    ) = Request(
        desc = "Unhold клиента по id",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/v1/customers_unhold-by-ids") }
    )

    fun customerHold(request: CustomerHoldRequest?, token: String? = tokenQA) = Request(
        desc = "Холдируем клиента",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/v1/customer_hold") }
    )
}