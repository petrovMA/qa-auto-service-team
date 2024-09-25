package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demoaccess_info

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.WrongRequestData
import ru.action_tech.qa.auto.api_models.demos.DemoAccessInfoV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests
import ru.action_tech.qa.auto.api_models.demos.demoAccessInfoV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_GetInfoWrongRequestData {

    private val testsData by lazy {
        listOf(
            "SystemUserId is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = DemosRequests.getInfo("5500-8475-5451-6449-588"),
                    expected = CheckBadRequests.BrokenRuleWithDevMessage(
                        code = 0,
                        messages = listOf("GetDemoAccess -> Object reference not set to an instance of an object.")
                    )
                )
            },
            "Не передан токен" to {
                CheckBadRequests.testBRUnauthorized(
                    apiClient = demosCrmClient,
                    request = DemosRequests.getInfo("5500-8475-5451-6449-5888", null)
                )
            },
            "Не корректный токен" to {
                CheckBadRequests.testBRUnauthorized(
                    apiClient = demosCrmClient,
                    request = DemosRequests.getInfo("5500-8475-5451-6449-5888", FieldData.WRONG_TOKEN)
                )
            }
        )
    }

    @Test
    @Sale_Demos
    @DemoAccessInfoV1
    @WrongRequestData
    @Requirements("REQCRM-1147")
    @DisplayName("$demoAccessInfoV1 -> WrongRequestData")
    @AllureId("240865")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}