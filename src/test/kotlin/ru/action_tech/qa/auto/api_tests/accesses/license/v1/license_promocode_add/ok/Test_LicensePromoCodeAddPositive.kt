package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_promocode_add.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicensePromocodeAddV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_promocode_add.LicensePromoCodeAddRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.deserialize
import java.net.HttpURLConnection


class Test_LicensePromoCodeAddPositive {

    private val request by lazy {
        AccessesRequests.licensePromoCodeAdd(
            LicensePromoCodeAddRequest(
                createdBy = null,
                createdOn = null,
                doneOn = null,
                id = null,
                isDone = null,
                promoCodeId = null,
                result = null,
                taskId = null
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16574
    @Requirements("REQCRM-233")
    @Sale_Accesses
    @LicensePromocodeAddV1
    @Response_200_Ok
    @DisplayName("/api/v1/license-promocode_add -> 200 ok")
    @AllureId("145339")
    fun test() {
        accessesCrmClient.send(request).deserialize<String>()
    }
}