package ru.action_tech.qa.auto.api_tests.demos.license.v1.license

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import ru.action_tech.qa.auto.api_models.CheckBadRequests.brokenRuleInvalid
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getLicenseV1
import ru.action_tech.qa.auto.api_models.demos.LicenseV1
import ru.action_tech.qa.auto.api_models.demos.licenseV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_LicenseV1WrongRequest {

    @Test
    @Issue("ARMAP-20074")
    @Sale_Demos
    @LicenseV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1155")
    @DisplayName("$licenseV1 -> 400 Bad Request: Ничего не найдено по переданному ID")
    @AllureId("256306")
    fun testNotFound() {
        checkBR(demosCrmClient, getLicenseV1(DEFAULT_ID), setOf(brokenRuleInvalid()))
    }

    @Test
    @Issue("ARMAP-20074")
    @Sale_Demos
    @LicenseV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1155")
    @DisplayName("$licenseV1 -> 400 Bad Request: Не переданы параметры")
    @AllureId("256305")
    fun testNoParams() {
        checkBR(demosCrmClient, getLicenseV1(null), setOf(brokenRuleInvalid()))
    }
}