package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_deactivate.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessDeactivateV1
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate.StorageAccessDeactivateRequest
import ru.action_tech.qa.auto.api_models.accesses.storageAccessDeactivate
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_StorageAccessDeactivateBadRequest {

    private val testsData by lazy {
        listOf(
            Triple(
                "Указан не существующий accessId",
                AccessesRequests.storageAccessDeactivate(StorageAccessDeactivateRequest(DEFAULT_ID)),
                setOf(BrokenRule(code = 9, message = "Id [$DEFAULT_ID] not found."))
            ),
            Triple(
                "Не указан accessId",
                AccessesRequests.storageAccessDeactivate(StorageAccessDeactivateRequest(null)),
                setOf(BrokenRule(code = 10, message = "Id can't be empty."))
            ),
            Triple(
                "Указан не валидный accessId",
                AccessesRequests.storageAccessDeactivate(StorageAccessDeactivateRequest("123123123")),
                setOf(BrokenRule(code = 7, message = "Request format is invalid."))
            ),
            Triple(
                "Указан пустой accessId",
                AccessesRequests.storageAccessDeactivate(StorageAccessDeactivateRequest("")),
                setOf(BrokenRule(code = 7, message = "Request format is invalid."))
            ),
            Triple(
                "Пустой запрос",
                AccessesRequests.storageAccessDeactivate(null),
                setOf(BrokenRule(code = 7, message = "Request format is invalid."))
            ),
        )
    }


    @Test
    @Requirements("REQCRM-253")
    @Sale_Accesses
    @StorageAccessDeactivateV1
    @Response_400_Bad_Request
    @DisplayName("$storageAccessDeactivate -> 400 Bad Request: Отключение доступа")
    @AllureId("239184")
    fun test() {
        testsData.forEach { (testName, request, expected) ->
            testName { checkBR(accessesCrmClient, request, expected) }
        }
    }
}