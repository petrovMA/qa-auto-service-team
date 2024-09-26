package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_upgrade.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseUpgradeV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade.LicenseUpgradeRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade.LicenseUpgradeResponse
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_LicenseUpgradePositive {

    private val request by lazy {
        AccessesRequests.licenseUpgrade(
            LicenseUpgradeRequest(
                campaignId = null,
                code = null,
                licenseId = null,
                priceLevelId = null,
                userId = null
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16576
    @Requirements("REQCRM-238")
    @Sale_Accesses
    @LicenseUpgradeV1
    @Response_200_Ok
    @DisplayName("/api/v1/license_upgrade -> 200 ok")
    @AllureId("145341")
    fun test() {
        accessesCrmClient.send(request).deserialize<LicenseUpgradeResponse>()
    }
}