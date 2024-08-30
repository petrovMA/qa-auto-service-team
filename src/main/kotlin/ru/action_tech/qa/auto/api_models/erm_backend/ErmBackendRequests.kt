package ru.action_tech.qa.auto.api_models.erm_backend

import ru.action_tech.qa.auto.api_models.erm_backend.a360_deal.a360_deals_get.A360DealsGetResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.http.Headers


object ErmBackendRequests {
    fun a360DealGet(token: String? = tokenAutoActionushka) = TRequest(
        model = Model<Array<A360DealsGetResponse>>(),
        desc = "Получение списка сделок A360",
        spec = { token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") } },
        send = { get(a360DealsGet) }
    )
}