package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demo

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.WrongRequestData
import ru.action_tech.qa.auto.api_models.demos.DemoV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getDemo
import ru.action_tech.qa.auto.api_models.demos.demoV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.api_models.CheckBadRequests.brokenRuleNotValid
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkNoContent
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_GetDemoWrongRequestData {

    private val testsData by lazy {
        listOf(
            "Id = \"5500-8475-5451-6449-5881\" is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getDemo("5500-8475-5451-6449-5881"),
                    expected = setOf(brokenRuleNotValid("5500-8475-5451-6449-5881"))
                )
            },
            "Id = \"3221.00000001\" is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getDemo(3221.00000001),
                    expected = setOf(brokenRuleNotValid("3221.00000001"))
                )
            },
            "Id не найден" to { checkNoContent(apiClient = demosCrmClient, request = getDemo(DEFAULT_ID)) },
            "Id не передан" to { checkNoContent(apiClient = demosCrmClient, request = getDemo(null)) },
            "Передан пустой токен" to { testBRUnauthorized(demosCrmClient, getDemo("", "")) },
            "Не передан токен" to { testBRUnauthorized(demosCrmClient, getDemo("", null)) },
            "Не корректный токен" to { testBRUnauthorized(demosCrmClient, getDemo("", FieldData.WRONG_TOKEN)) }
        )
    }

    @Sale_Demos
    @DemoV1
    @WrongRequestData
    @Requirements("REQCRM-1975")
    @DisplayName("GET $demoV1 -> WrongRequestData")
    @Test
    @AllureId("240895")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}
