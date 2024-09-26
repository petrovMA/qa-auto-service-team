package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_upgrade_by_product_id.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseUpgradeByProductIdV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade_by_product_id.LicenseUpgradeByProductIdResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade_by_product_id.request.LicenseUpgradeByProductIdRequest
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_LicenseUpgradeByProductIdPositive {

    private val request by lazy {
        AccessesRequests.licenseUpgradeByProductId(
            LicenseUpgradeByProductIdRequest(
                authorId = null,
                licenseByProduct = null
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16569
    @Requirements("REQCRM-246")
    @Sale_Accesses
    @LicenseUpgradeByProductIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/license_upgrade–by-productid -> 200 ok")
    @AllureId("145342")
    fun test() {
        accessesCrmClient.send(request).deserialize<Array<LicenseUpgradeByProductIdResponse>>()
    }
}