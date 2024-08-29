package ru.action_tech.qa.auto.api_models.crm_api

import ru.action_tech.qa.auto.api_models.crm_api.authorization.TokenRequest
import ru.action_tech.qa.auto.api_models.crm_api.authorization.TokenResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest


object CrmApiRequests {

    //region [Authorization]
    fun getToken(request: TokenRequest) = TRequest(
        desc = "Получение токена",
        model = Model<TokenResponse>(),
        spec = {
            setContentType("application/json")
            setBody(request)
        },
        send = { post("/token") }
    )
}