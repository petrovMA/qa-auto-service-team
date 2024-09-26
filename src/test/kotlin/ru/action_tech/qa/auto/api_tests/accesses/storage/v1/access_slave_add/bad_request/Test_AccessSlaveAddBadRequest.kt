package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_slave_add.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveAddV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_add.AccessSlaveAddRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_AccessSlaveAddBadRequest {

    private val accessId = "c231969f-50ed-414c-a9e6-84c9a7b120c4"

    private val testsData by lazy {
        listOf(
            Triple(
                "Не указан userId",
                AccessesRequests.accessSlaveAdd(AccessSlaveAddRequest(accessId, slaveIds = listOf(123.123, 1234123))),
                setOf(BrokenRule(code = -2003, message = "Parameter value is invalid."))
            ),
            Triple(
                "userId = null",
                AccessesRequests.accessSlaveAdd(AccessSlaveAddRequest(accessId, slaveIds = listOf(123123, ""))),
                setOf(BrokenRule(code = -2003, message = "Parameter value is invalid."))
            ),
            Triple(
                "slaveIds is empty",
                AccessesRequests.accessSlaveAdd(AccessSlaveAddRequest(accessId, slaveIds = listOf())),
                setOf(BrokenRule(code = 5, message = "UserId can't be less than 1 and greater than 2147483647."))
            ),
            Triple(
                "accessId = null",
                AccessesRequests.accessSlaveAdd(AccessSlaveAddRequest(null, slaveIds = listOf(2841275, 2841276))),
                setOf(BrokenRule(code = 10, message = "Id can't be empty."))
            )
        )
    }

    @Test
    @Requirements("REQCRM-254")
    @Sale_Accesses
    @AccessSlaveAddV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/access-slave_add -> 400 Bad Request: Добавить одного slave пользователя")
    @AllureId("238418")
    fun test() {
        testsData.forEach { (testName, request, expected) ->
            testName soft { checkBR(accessesCrmClient, request, expected) }
        }
    }
}