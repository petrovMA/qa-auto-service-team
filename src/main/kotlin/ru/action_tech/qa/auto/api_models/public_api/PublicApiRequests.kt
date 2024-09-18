package ru.action_tech.qa.auto.api_models.public_api

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.public_api.authorization.token.PublicAuthRequest
import ru.action_tech.qa.auto.api_models.public_api.authorization.token.PublicAuthResponse
import ru.action_tech.qa.auto.api_models.public_api.v1.stop_lists_get_by_partner_id.StopListsGetByPartnerIdResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.ApiUtils.getPublicToken
import ru.action_tech.qa.auto.utils.auth.publicApiToken
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams
import ru.action_tech.qa.auto.utils.setBody

object PublicApiRequests {

    private val token: String by lazy { getPublicToken() }

    fun publicAuth(request: PublicAuthRequest? = null, isNonNull: Boolean = true) = TRequest(
        desc = "Получение Public-Api токена",
        model = Model<PublicAuthResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/token") }
    )

    fun stopListsGetByPartnerId(partnerId: Any?, token: String? = publicApiToken) = TRequest(
        model = Model<Array<StopListsGetByPartnerIdResponse>>(),
        desc = "Получить стоплисты по id партнера",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            partnerId?.let { addQueryParam(QueryParams.PARTNER_ID, it) }
        },
        send = { get(stopListsGetByPartnerId) }
    )

}