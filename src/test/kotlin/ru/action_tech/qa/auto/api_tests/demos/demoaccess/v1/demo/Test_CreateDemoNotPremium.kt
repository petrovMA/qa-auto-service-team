package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demo

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemoV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.createDemo
import ru.action_tech.qa.auto.api_models.demos.demoV1
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demo.CreateDemoRequest
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demo.CreateDemoResponse
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.waiting.Wait
import ru.action_tech.qa.auto.api_models.access_backend.AccessBackendRequests.accessUserGetActive
import ru.action_tech.qa.auto.utils.accessBackendStoragesClient
import ru.action_tech.qa.auto.helpers.api.ApiDemoAccessHelper.deleteDemoAccessFromUserAccessList
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.data.ACTION_ADVERTISING
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.demosCrmClient

class Test_CreateDemoNotPremium {
    private val client by lazy { ContactPerson.MAIN_USER_FOR_ACCESS }
    private val product by lazy { ACTION_ADVERTISING.productNumber!! }
    private val request by lazy {
        CreateDemoRequest(
            contactId = client.id,
            mainProductNumber = product,
            phoneCallId = null,
            isRescue = false,
            isPremium = false
        )
    }
    private lateinit var response: CreateDemoResponse

    @AfterEach
    fun cleanUp() {
        deleteDemoAccessFromUserAccessList(client.bitrixId!!, response.demoAccessId!!)
    }

    @Issue("ARMAP-19337")
    @Sale_Demos
    @DemoV1
    @Response_200_Ok
    @Requirements("REQCRM-1146")
    @AllureId("145984")
    @HistoryIssues("ARMAP-17328", "PT-9776")
    @DisplayName("POST $demoV1 -> 200 ok: isPremium = false")
    @Test
    fun test() {
        response = Wait.untilNotNull(
            timeoutInMs = 15000,
            pollingIntervalInMs = 500,
            suppressException = true
        ) {
            demosCrmClient.send(createDemo(request))
        }.apply {
            "Проверить код доступа из ответа" { assertTrue(FieldData.REGEX_FOR_UKD.containsMatchIn(authorizeCode)) }
        }

        "Проверить, что демодоступ добавлен в список доступов клиента" {
            accessBackendStoragesClient.send(accessUserGetActive(client.bitrixId!!)).apply {
                assertTrue(
                    entities!!.map { it.core!!.id }.toList().contains(response.demoAccessId)
                )
            }
        }
    }
}
