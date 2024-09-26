package ru.action_tech.qa.auto.api_tests.accesses.license.v1.lic_upsert.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicUpsertV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.lic_upsert.LicUpsertRequest
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_LicUpsertPositive {

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16578
    @Requirements("REQCRM-230")
    @Sale_Accesses
    @LicUpsertV1
    @Response_200_Ok
    @DisplayName("/api/v1/lic-upsert -> 200 ok")
    @AllureId("145335")
    fun test() {
        accessesCrmClient.send(request).deserialize<String>()
    }

    private val request by lazy {
        AccessesRequests.licUpsert(
            LicUpsertRequest(
                accountId = null,
                activateOn = null,
                activatedContactId = null,
                authCode = null,
                bitrixId = null,
                bonusOrderId = null,
                contactId = null,
                digitalSignatureNumber = null,
                extensionSystemUserId = null,
                externalLicId = null,
                individualSaleApproval = null,
                instAccess = null,
                isAutoReg = null,
                isDateFixed = null,
                isEmailSent = null,
                isExternalRegistration = null,
                isForce = null,
                isPrint = null,
                isRegisterPastPeriod = null,
                isRegisteredByAnotherPartner = null,
                isRegisteredInMcfr = null,
                isService = null,
                licId = null,
                licTypeCode = null,
                loginActivated = null,
                mcfrCardId = null,
                mcfrRkCode = null,
                parentLicensesId = null,
                partnerAmount = null,
                priceLevelId = null,
                productId = null,
                productProgram = null,
                promocodeDiscount = null,
                promocodeIds = null,
                salesContactBitrixId = null,
                salesContactId = null,
                salesOn = null,
                salesPartnerId = null,
                salesSubscribeId = null,
                salesSystemUserId = null,
                serviceAccessOn = null,
                serviceActivateOn = null,
                serviceExpiresOn = null,
                setId = null,
                status = null,
                superSchoolInviteId = null,
                supportPartnerId = null,
                supportSystemUserId = null
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }
}