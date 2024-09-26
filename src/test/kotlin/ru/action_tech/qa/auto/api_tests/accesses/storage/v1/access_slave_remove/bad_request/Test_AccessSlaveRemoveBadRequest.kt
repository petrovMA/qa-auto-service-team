package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_slave_remove.bad_request

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveRemoveV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.accessSlaveRemove
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_remove.AccessSlaveRemoveRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable


class Test_AccessSlaveRemoveBadRequest {

    private val accessId = "c231969f-50ed-414c-a9e6-84c9a7b120c4"

    private val testsData by lazy {
        listOf(
            Triple(
                "Пустой список slaveIds",
                AccessesRequests.accessSlaveRemove(AccessSlaveRemoveRequest(accessId, emptyList())),
                setOf(BrokenRule(code = 5, message = "UserId can't be less than 1 and greater than 2147483647."))
            ),
            Triple(
                "slaveIds is wrong format",
                AccessesRequests.accessSlaveRemove(AccessSlaveRemoveRequest(accessId, listOf(CommonDtoNameNullable("2", "3")))),
                setOf(BrokenRule(code = -2003, message = "Parameter value is invalid."))
            ),
            Triple(
                "Не указан slaveIds",
                AccessesRequests.accessSlaveRemove(AccessSlaveRemoveRequest(accessId, null)),
                setOf(BrokenRule(code = -2003, message = "Parameter value is invalid."))
            ),
            Triple(
                "accessId not found",
                AccessesRequests.accessSlaveRemove(
                    AccessSlaveRemoveRequest(
                        FieldData.DEFAULT_ID,
                        listOf(2841275, 2841276)
                    )
                ),
                setOf(BrokenRule(code = 3000, message = "Id [${FieldData.DEFAULT_ID}] not found."))
            )
        )
    }


    @Test
    @Issue("ARMAP-19250")
    @Requirements("REQCRM-255")
    @Sale_Accesses
    @AccessSlaveRemoveV1
    @Response_200_Ok
    @DisplayName("$accessSlaveRemove -> 400 Bad Request: Удалить одного slave пользователя")
    @AllureId("238523")
    fun test() {
        testsData.forEach { (testName, request, expected) ->
            testName soft { checkBR(accessesCrmClient, request, expected) }
        }
    }
}