package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_slave_bulk_update.bad_request

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveBulkUpdateV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.accessSlaveBulkUpdate
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_bulk_update.AccessSlaveBulkUpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable


class Test_AccessSlaveBulkUpdateBadRequest {

    private val accessId = "c231969f-50ed-414c-a9e6-84c9a7b120c4"

    private val testsData by lazy {
        listOf(
            Triple(
                "Не указан slaveIds",
                AccessesRequests.accessSlaveBulkUpdate(
                    AccessSlaveBulkUpdateRequest(accessId, slaveIds = null)
                ),
                setOf(BrokenRule(code = -2003, message = "Parameter value is invalid."))
            ),
            Triple(
                "slaveIds is wrong format",
                AccessesRequests.accessSlaveBulkUpdate(
                    AccessSlaveBulkUpdateRequest(accessId, slaveIds = listOf(CommonDtoNameNullable("2", "3")))
                ),
                setOf(BrokenRule(code = -2003, message = "Parameter value is invalid."))
            ),
            Triple(
                "accessId is wrong format",
                AccessesRequests.accessSlaveBulkUpdate(
                    AccessSlaveBulkUpdateRequest("accessId", slaveIds = listOf(2841275, 2841276))
                ),
                setOf(BrokenRule(code = 7, message = "Request format is invalid."))
            ),
            Triple(
                "accessId = null",
                AccessesRequests.accessSlaveBulkUpdate(
                    AccessSlaveBulkUpdateRequest(null, slaveIds = listOf(2841275, 2841276))
                ),
                setOf(BrokenRule(code = 10, message = "Id can't be empty."))
            ),
            Triple(
                "accessId not found",
                AccessesRequests.accessSlaveBulkUpdate(
                    AccessSlaveBulkUpdateRequest(DEFAULT_ID, slaveIds = listOf(2841275, 2841276))
                ),
                setOf(BrokenRule(code = 3000, message = "Id [$DEFAULT_ID] not found."))
            )
        )
    }

    @Test
    @Issue("ARMAP-19250")
    @Requirements("REQCRM-256")
    @Sale_Accesses
    @AccessSlaveBulkUpdateV1
    @Response_400_Bad_Request
    @DisplayName("$accessSlaveBulkUpdate -> 400 Bad Request: Полная перезапись slave пользователей")
    @AllureId("238497")
    fun test() {
        testsData.forEach { (testName, request, expected) ->
            testName soft { checkBR(accessesCrmClient, request, expected) }
        }
    }
}