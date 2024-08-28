package ru.action_tech.qa.auto.utils.auth

import io.restassured.http.ContentType.URLENC
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenActionushka
import ru.action_tech.qa.auto.utils.http.Headers.AUTHORIZATION

fun getToken(
    login: String,
    pass: String? = null,
    clientId: String = "js",
    grantType: String = "password",
    token: String? = null
) = Request(
    desc = "Получение токена",
    spec = {
        setContentType(URLENC)
        addParam("client_id", clientId)
        addParam("grant_type", grantType)
        addParam("username", login)
        pass?.let { addParam("password", it) }
        token?.let { addHeader(AUTHORIZATION, "Bearer $it") }
    },
    send = { post("/connect/token") }
)

fun getQAToken(
    grantType: String = "client_credentials",
    clientId: String = "QaApplication",
    clientSecret: String = "WyjGaYzJmSC44vGTvDBL3CVvHJKHrBCLjZv2M64MDZQSLum5JvVPYQPPbYmX2dH6T",
) = TRequest(
    model = Model<ConnectTokenResponse>(),
    desc = "Получение QA токена",
    spec = {
        setContentType(URLENC)
        addParam("grant_type", grantType)
        addParam("client_id", clientId)
        addParam("client_secret", clientSecret)
    },
    send = { post("/connect/token") }
)

fun getTelephonyBackendToken(
    grantType: String = "client_credentials",
    clientId: String = "TelephonyBackEnd",
    clientSecret: String = "G9QUIRCIQ59QegZ8AA8Ac2v2GCGkQGmiNbBjnphS7U5C30taEawt7Ezi6OcrRdmsF",
) = TRequest(
    model = Model<ConnectTokenResponse>(),
    desc = "Получаем токен для сервиса телефонии",
    spec = {
        setContentType(URLENC)
        addParam("grant_type", grantType)
        addParam("client_id", clientId)
        addParam("client_secret", clientSecret)
    },
    send = { post("/connect/token") }
)

fun userInfo(token: String? = tokenActionushka) = TRequest(
    model = Model<UserInfoResponse>(),
    desc = "Получаем данные по текущему пользователю",
    spec = { token?.let { addHeader(AUTHORIZATION, "Bearer $it") } },
    send = { get("/connect/userinfo") }
)
