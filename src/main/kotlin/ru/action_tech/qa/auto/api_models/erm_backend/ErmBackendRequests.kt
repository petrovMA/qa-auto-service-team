package ru.action_tech.qa.auto.api_models.erm_backend

import ru.action_tech.qa.auto.api_models.erm_backend.a360_deal.a360_deals_get.A360DealsGetResponse
import ru.action_tech.qa.auto.api_models.erm_backend.shipment.v1.sendings_get_by_customer_id.SendingsGetByCustomerIdResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams


object ErmBackendRequests {
    fun a360DealGet(token: String? = tokenAutoActionushka) = TRequest(
        model = Model<Array<A360DealsGetResponse>>(),
        desc = "Получение списка сделок A360",
        spec = { token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") } },
        send = { get(a360DealsGet) }
    )

    fun sendingsGetByCustomerId(
        id: String? = null,
        limitSendingData: Boolean? = null,
        limit: String? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        model = Model<Array<SendingsGetByCustomerIdResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            id?.let { addQueryParam(QueryParams.ID, it) }
            limitSendingData?.let { addQueryParam(QueryParams.LIMIT_SENDING_DATA, it) }
            limit?.let { addQueryParam(QueryParams.LIMIT, it) }
        },
        desc = "Получения списка отправлений по ID клиента",
        send = { get("/api/v1/sendings_get-by-customer-id") }
    )
}