package ru.action_tech.qa.auto.api_tests.demos.license.v1.license_get_by_subscribe

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.brokenRuleNotValid
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.WrongRequestData
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.licenseGetBySubscribe
import ru.action_tech.qa.auto.api_models.demos.LicenseGetBySubscribeV1
import ru.action_tech.qa.auto.api_models.demos.licenseGetBySubscribeV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.brokenRuleInvalid
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkNoContent
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.WRONG_TOKEN
import ru.action_tech.qa.auto.utils.*


class Test_LicenseGetBySubscribeWrongRequestData {

    private val testsData by lazy {
        listOf(
            "subscribeId is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = licenseGetBySubscribe(123.123f),
                    expected = setOf(brokenRuleNotValid("123.123"))
                )
            },
            "subscribeId is empty" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = licenseGetBySubscribe(""),
                    expected = setOf(brokenRuleInvalid())
                )
            },
            "subscribeId is empty" to { checkNoContent(demosCrmClient, licenseGetBySubscribe(null)) },
            "Не передан токен" to { testBRUnauthorized(demosCrmClient, licenseGetBySubscribe(null, null)) },
            "Передан пустой токен" to { testBRUnauthorized(demosCrmClient, licenseGetBySubscribe(null, "")) },
            "Не корректный токен" to { testBRUnauthorized(demosCrmClient, licenseGetBySubscribe(null, WRONG_TOKEN)) }
        )
    }

    @Test
    @Sale_Demos
    @LicenseGetBySubscribeV1
    @WrongRequestData
    @Requirements("REQCRM-1781")
    @DisplayName("$licenseGetBySubscribeV1 -> WrongRequestData")
    @AllureId("240867")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}