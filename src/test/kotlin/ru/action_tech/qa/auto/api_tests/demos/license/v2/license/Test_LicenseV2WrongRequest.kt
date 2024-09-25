package ru.action_tech.qa.auto.api_tests.demos.license.v2.license

import io.qameta.allure.AllureId
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getLicenseV2
import ru.action_tech.qa.auto.api_models.demos.LicenseV2
import ru.action_tech.qa.auto.api_models.demos.licenseV2
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.CheckBadRequests.brokenRuleInvalid
import ru.action_tech.qa.auto.api_models.CheckBadRequests.brokenRuleNotValid
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_LicenseV2WrongRequest {

    @Test
    @Sale_Demos
    @LicenseV2
    @Response_400_Bad_Request
    @Requirements("REQCRM-1782")
    @DisplayName("$licenseV2 -> 400 Bad Request: Пустой ID")
    @AllureId("256287")
    fun testEmptyId() {
        checkBR(apiClient = demosCrmClient, request = getLicenseV2(""), expected = setOf(brokenRuleInvalid()))
    }

    @Test
    @Sale_Demos
    @LicenseV2
    @Response_400_Bad_Request
    @Requirements("REQCRM-1782")
    @DisplayName("$licenseV2 -> 400 Bad Request: Не корректный ID")
    @AllureId("256288")
    fun testWrongId() {
        checkBR(apiClient = demosCrmClient, request = getLicenseV2("123"), expected = setOf(brokenRuleNotValid("123")))
    }
}