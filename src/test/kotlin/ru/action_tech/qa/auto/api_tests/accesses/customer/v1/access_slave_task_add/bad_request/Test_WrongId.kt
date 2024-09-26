package ru.action_tech.qa.auto.api_tests.accesses.customer.v1.access_slave_task_add.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveTaskAddV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.access_slave_task_add.AccessSlaveTaskAddRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_WrongId {

    @Test
    @HistoryIssues("ARMAP-10172")
    @Requirements("REQCRM-228")
    @Sale_Accesses
    @AccessSlaveTaskAddV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/access-slave-task_add -> 400 Bad Request: accessId = некорректный формат")
    @AllureId("145297")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessSlaveTaskAdd(
                isNonNull = true,
                request = AccessSlaveTaskAddRequest(
                    accessId = "123123123",
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
            ),
            expected = setOf(BrokenRule(code = 8, message = "Запрос не корректный"))
        )
    }
}