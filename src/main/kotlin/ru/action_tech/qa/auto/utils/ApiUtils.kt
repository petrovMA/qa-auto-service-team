package ru.action_tech.qa.auto.utils

import ru.action_tech.qa.auto.api_models.crm_api.CrmApiRequests
import ru.action_tech.qa.auto.api_models.crm_api.authorization.TokenRequest
import ru.action_tech.qa.auto.api_models.crm_api.authorization.response.TokenResponse
import ru.action_tech.qa.auto.api_models.public_api.PublicApiRequests
import ru.action_tech.qa.auto.api_models.public_api.authorization.token.PublicAuthRequest
import ru.action_tech.qa.auto.core.api.ApiClient
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.crm.properties.IDENTITY_URL
import ru.action_tech.qa.auto.erm.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.utils.crmApiCrmClient
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.publicApiCrmClient

object ApiUtils {
    val sellerServiceUrl by lazy {
        ApiClient(
            url = IDENTITY_URL,
            spec = { addHeader(Headers.CONTENT_TYPE, "application/x-www-form-urlencoded") }
        )
    }

    private fun getSellerToken(login: String, pass: String) = Request(
        desc = "Получение токена",
        spec = {
            setContentType("application/x-www-form-urlencoded")
            setBody("client_id=js&grant_type=password&username=$login&password=$pass")
        },
        send = { post("/connect/token") }
    )

    private fun getApiToken(appId: String, secretKey: String, login: String? = null): TokenResponse =
        crmApiCrmClient.send(CrmApiRequests.getToken(TokenRequest(appId, secretKey, login)))

    fun getArmToken(login: String = AUTO_ACTIONUSKA.login, pass: String = AUTO_ACTIONUSKA.erm_pass.toString()): String =
        sellerServiceUrl.send(getSellerToken(login, pass)).jsonPath().getString("access_token")

    fun getPlatformAppToken(): String = getApiToken(
        appId = "E30384A4-CB0C-4C85-A1DF-295FAC09081E",
        secretKey = "bJ9|3Qq~ZgSdD7r1SgBMMi8mfnai~AFR6~lqwN*Itljs}a9xgp"
    ).accessToken

    fun getGlAssistantAppToken(): String =
        getApiToken("8F3D3028-C089-4D05-A92F-81A6A9085545", "QX3FkmKzk0REiBSAP7XmBJZZ0mnJD5Pgl14h").accessToken

    fun getArnikaAppToken(): String =
        getApiToken("D515C927-5968-4122-A290-7557C4E200A1", "xJP82MxqsognT4R28KhGJgcQtN4|e0").accessToken

    fun getXssSitesToken(): String = getApiToken(
        appId = "5DCB38EE-EB55-486F-AD73-D299D9A44B68",
        secretKey = "FAj7zQjdomCDTtS3oWLyGXe0IcPKkCBQ"
    ).accessToken

    fun getPressAppToken(): String = getApiToken(
        appId = "A9B36672-2CD6-44BB-97B6-3A59F5334380",
        secretKey = "2Piua8bbWv83tGtI7hBngX2R0s8M2KbGoatN",
        login = "action-crm\\Partner-716303"
    ).accessToken

    fun getUkrAppToken(): String =
        getApiToken("4E670C3D-6A32-484A-80C6-B84F8012FCAF", "8giHPBdXXPbNfCdVis9N").accessToken

    fun getGisAppToken(): String =
        getApiToken("9B6F2EEA-9513-4854-B50F-F97FE9884933", "4V14H{xsmCDTtS3oWOp1|f~zkS|").accessToken

    fun getSchoolAppToken(): String =
        getApiToken("8115CCA9-C3CF-4C67-A582-3F27F90A5E3C", "zJDmJj1Osc88aNAtjCoVP4rvdFbEe7").accessToken

    fun getTechPlatToken(): String =
        getApiToken("CFF5BF22-7D1E-4AE3-A487-6335D1F99D3D", "ShRtpNaLWCR2jT4fdxmKcYwr2").accessToken

    fun getHomePortalAppToken(): String =
        getApiToken("87CB73F6-F984-4155-B381-5445429B023A", "zG5kj3Nwsg2nkInSzwkOrrBHyb29wkonWx6P").accessToken

    fun getArmSellerAppToken(): String =
        getApiToken("40FC4A6C-BC0F-4AA5-9983-BCA94CCEDA03", "YqMDVdZlYEebYXZxcjOp1|f~zkS|4V14H{xs").accessToken

    fun getExternalToken(): String =
        getApiToken("3AB64286-FC22-43C0-83D3-7A704316D038", "KhhmdGW{GVo5JoCNF~Buo0iyUDITGDmY4aBM|{VR").accessToken

    fun getPublicToken(): String = publicApiCrmClient.send(
        PublicApiRequests.publicAuth(
            PublicAuthRequest(
                id = "415ef297-8313-4833-a085-882aae147391",
                key = "e,\$TZiC!N_dyXi.gFeZ55His.9Tx8h9d&-vzAd&UN5hfE7rh"
            )
        )
    ).accessToken!!

    fun getPublicJustAIToken(): String = publicApiCrmClient.send(
        PublicApiRequests.publicAuth(
            PublicAuthRequest("080c26a4-1817-4a52-9e8f-4f8a0d099272", "IL9Arb#s#w72o83jbgpU%-qyeTxF5ZtKCXFYE3&VSyB")
        )
    ).accessToken!!
}