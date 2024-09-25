package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demoaccess_get_list_by_contacts

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemoAccessGetListByContactsV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getDemoAccessGetListByContacts
import ru.action_tech.qa.auto.api_models.demos.demoAccessGetListByContactsV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.person
import ru.action_tech.qa.auto.utils.demosCrmClient

class Test_GetDemoAccessGetListByContacts {

    val mainProductId = "3bc0ec52-be55-e711-bb08-78e3b502da44"
    val authorId = "2df6b60a-0e5b-4380-85dd-d8879b6c195c"

    @Test
    @Requirements("REQCRM-1145")
    @Sale_Demos
    @Response_200_Ok
    @DemoAccessGetListByContactsV1
    @DisplayName("$demoAccessGetListByContactsV1 -> 200 ok")
    @AllureId("158123")
    fun test() {

        val response = demosCrmClient.send(getDemoAccessGetListByContacts(arrayOf(person.customerId)))
            .find { it.contactId == person.customerId }

        "Проверяем в ответе email" {
            assertEqual(response?.contactEmail, person.email)
        }

        "Проверяем в ответе pin" {
            assertEqual(response?.mainProductId, mainProductId)
        }

        "Проверяем в ответе id" {
            assertEqual(response?.authorId, authorId)
        }
    }
}