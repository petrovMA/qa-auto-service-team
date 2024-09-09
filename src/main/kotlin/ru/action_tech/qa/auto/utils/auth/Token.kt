package ru.action_tech.qa.auto.utils.auth

import io.restassured.response.Response
import ru.action_tech.qa.auto.data.*
import ru.action_tech.qa.auto.utils.ApiUtils
import ru.action_tech.qa.auto.helpers.api.ServiceToolsApiHelper
import ru.action_tech.qa.auto.utils.identityApi
import ru.action_tech.qa.auto.utils.uuid

val consumerId by lazy { "6cda9a6a-408d-4dea-9633-6350ac722cb4".uuid }

val tokenAutoActionushka by lazy { getAuthToken() }
val publicToken by lazy { ApiUtils.getPublicToken() }
val publicJustAIToken by lazy { ApiUtils.getPublicJustAIToken() }
val gisAppToken by lazy { ApiUtils.getGisAppToken() }
val tokenGlAssistantApp by lazy { ApiUtils.getGlAssistantAppToken() }
val pressAppToken by lazy { ApiUtils.getPressAppToken() }
val tokenHomePortalApp by lazy { ApiUtils.getHomePortalAppToken() }
val tokenPlatformApp: String by lazy { ApiUtils.getPlatformAppToken() }
val tokenTechPlat: String by lazy { ApiUtils.getTechPlatToken() }
val tokenArm by lazy { ApiUtils.getArmToken() }
val tokenQA by lazy { identityApi.send(getQAToken()).accessToken }

val tokenActionushka by lazy {
    getAuthToken(
        login = ACTIONUSKA.login,
        pass = ACTIONUSKA.erm_pass!!
    )
}

val tokenTopActionushka by lazy {
    getAuthToken(
        login = TOP_ACTIONUSKA.login,
        pass = TOP_ACTIONUSKA.erm_pass.toString()
    )
}

val tokenFifthPartnerTestUser by lazy {
    getAuthToken(
        TEST_PARTNER_FIFTH_USER.login,
        TEST_PARTNER_FIFTH_USER.erm_pass!!
    )
}

val tokenFirstPartnerTestUser by lazy {
    ServiceToolsApiHelper.getErmTokenForManager(login = TEST_PARTNER_FIRST_USER.login)
}

val tokenTestUserRegressovich by lazy {
    ServiceToolsApiHelper.getErmTokenForManager(login = TEST_REGRESSOVICH.login)
}

val publicApiToken
    get() = identityApi.send(
        getToken(
            login = ACTIONUSKA.login,
            pass = ACTIONUSKA.erm_pass,
            clientId = "public-api",
            grantType = "password"
        )
    ).getValue("access_token")

val tokenTelephonyBackend by lazy { identityApi.send(getTelephonyBackendToken()).accessToken }

fun Response.getValue(path: String): String = this.jsonPath().getString(path)
fun Response.getValue(): String = this.asString()