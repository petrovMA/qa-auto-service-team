package ru.action_tech.qa.auto.api_tests.demos.license.v2.license

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_401_Unauthorized
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests
import ru.action_tech.qa.auto.api_models.demos.LicenseV2
import ru.action_tech.qa.auto.api_models.demos.licenseV2
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBRUnauthorizedList
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_LicenseV2Unauthorized {

    private val id: String = "86b2ad61-71e9-4660-81be-78ca63d6a5df"

    private val requests by lazy {
        mapOf(
            "Не передан токен" to DemosRequests.getLicenseV2(id, token = null),
            "Не корректный токен" to DemosRequests.getLicenseV2(id, token = FieldData.WRONG_TOKEN),
            "Пустой токен" to DemosRequests.getLicenseV2(id, token = "")
        )
    }

    @Test
    @Sale_Demos
    @LicenseV2
    @Response_401_Unauthorized
    @Requirements("REQCRM-1782")
    @DisplayName("$licenseV2 -> 401 Unauthorized")
    @AllureId("256286")
    fun test() {
        checkBRUnauthorizedList(demosCrmClient, requests)
    }
}