package ru.action_tech.qa.auto.api_tests.accesses.customer.v1.access_slave_task_add.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveTaskAddV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.access_slave_task_add.AccessSlaveTaskAddRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessSlaveTaskAdd {

    private val request by lazy {
        AccessesRequests.accessSlaveTaskAdd(
            AccessSlaveTaskAddRequest(
                accessId = "CEBE039A-F5DB-46A5-8B65-18FEB3B07A12",
                contactModels = listOf(
                    AccessSlaveTaskAddRequest.ContactModel(
                        lastName = "string",
                        firstName = "string",
                        middleName = "string",
                        email = "string",
                        jobtitleId = DEFAULT_ID,
                        phone = "string",
                        additionalPhone = "string"
                    )
                )
            )
        )
    }

    @Test
    @Requirements("REQCRM-228")
    @Sale_Accesses
    @AccessSlaveTaskAddV1
    @Response_200_Ok
    @DisplayName("/api/v1/access-slave-task_add -> 200 Ok: Метод создание задачи на добавление слейв-пользователя")
    @AllureId("145298")
    fun test() {
        assertTrue(accessesCrmClient.send(request))
    }
}