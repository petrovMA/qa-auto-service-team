package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demoaccess_get_list_by_contacts

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.WrongRequestData
import ru.action_tech.qa.auto.api_models.demos.DemoAccessGetListByContactsV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getDemoAccessGetListByContacts
import ru.action_tech.qa.auto.api_models.demos.demoAccessGetListByContactsV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.person
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_GetDemoAccessGetListByContactsWrongRequestData {

    private val testsData by lazy {
        listOf(
            "ids = [\"test\"]" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getDemoAccessGetListByContacts(ids = arrayOf("test")),
                    BrokenRule(code = 12, message = "Неверная модель в запросе")
                )
            },
            "ids = 1" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getDemoAccessGetListByContacts(ids = 1),
                    BrokenRule(code = 12, message = "Неверная модель в запросе")
                )
            },
            "ids = b74f97a0-7e6e-4050-9321-5d84330be574" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getDemoAccessGetListByContacts(ids = person.customerId),
                    BrokenRule(code = 12, message = "Неверная модель в запросе")
                )
            },
            "ids = [\"-\"]" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getDemoAccessGetListByContacts(ids = arrayOf("-")),
                    BrokenRule(code = 12, message = "Неверная модель в запросе")
                )
            }
        )
    }

    @Test
    @Requirements("REQCRM-1145")
    @Sale_Demos
    @WrongRequestData
    @DemoAccessGetListByContactsV1
    @DisplayName("$demoAccessGetListByContactsV1 -> 400 Bad Request: WrongRequestData")
    @AllureId("158119")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}
