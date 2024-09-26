package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_update.bad_request

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessUpdateV1
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_add.StorageAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.storageAccessUpdate
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.access_backend.AccessType
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_StorageAccessUpdateBadRequest {

    private val testsData by lazy {
        listOf(
            Triple(
                "Не корректный AccessType",
                AccessesRequests.storageAccessUpdate(
                    StorageAccessAddRequest(
                        commonId = FieldData.DEFAULT_ID,
                        accessType = "DemoAccesssss",
                        dateStart = "2022-04-02T15:38:21.053Z",
                        dateEnd = "2042-04-02T15:38:21.054Z",
                        productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                        attributes = StorageAccessAddRequest.Attributes(
                            activateDate = "2024-04-02T15:38:21.060Z",
                            userCount = 1
                        )
                    )
                ),
                setOf(BrokenRule(code = 14, message = "AccessType is invalid."))
            ),
            Triple(
                "Не корректный параметр UserCount = 0",
                AccessesRequests.storageAccessUpdate(
                    StorageAccessAddRequest(
                        commonId = FieldData.DEFAULT_ID,
                        accessType = AccessType.PAID_ACCESS,
                        dateStart = "2022-04-02T15:38:21.053Z",
                        dateEnd = "2042-04-02T15:38:21.054Z",
                        productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                        attributes = StorageAccessAddRequest.Attributes(
                            activateDate = "2024-04-02T15:38:21.060Z",
                            userCount = 0
                        )
                    )
                ),
                setOf(BrokenRule(code = 12, message = "UserCount can't be less than 1."))
            ),
            Triple(
                "Передан не существующий accessId",
                AccessesRequests.storageAccessUpdate(
                    StorageAccessAddRequest(
                        commonId = FieldData.DEFAULT_ID,
                        accessType = AccessType.DEMO_ACCESS,
                        dateStart = "2022-04-02T15:38:21.053Z",
                        dateEnd = "2042-04-02T15:38:21.054Z",
                        productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                        attributes = StorageAccessAddRequest.Attributes(activateDate = null, userCount = 1)
                    )
                ),
                setOf(BrokenRule(code = 9, message = "Id [${FieldData.DEFAULT_ID}] not found."))
            ),
            Triple(
                "DateStart is wrong format",
                AccessesRequests.storageAccessUpdate(
                    StorageAccessAddRequest(
                        commonId = FieldData.DEFAULT_ID,
                        accessType = AccessType.DEMO_ACCESS,
                        dateStart = "20-04-2022",
                        dateEnd = "2042-04-02T15:38:21.054Z",
                        productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                        attributes = StorageAccessAddRequest.Attributes(
                            activateDate = "2024-04-02T15:38:21.060Z",
                            userCount = 1
                        )
                    )
                ),
                setOf(BrokenRule(code = 12, message = "DateStart is invalid."))
            ),
            Triple(
                "userCount is wrong value",
                AccessesRequests.storageAccessUpdate(
                    StorageAccessAddRequest(
                        commonId = FieldData.DEFAULT_ID,
                        accessType = AccessType.DEMO_ACCESS,
                        dateStart = "2022-04-02T15:38:21.053Z",
                        dateEnd = "2042-04-02T15:38:21.054Z",
                        productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                        attributes = StorageAccessAddRequest.Attributes(
                            activateDate = "2024-04-02T15:38:21.060Z",
                            userCount = Long.MAX_VALUE
                        )
                    )
                ),
                setOf(BrokenRule(code = 12, message = "UserCount is invalid."))
            ),
        )
    }


    @Test
    @Issue("ARMAP-19295")
    @AllureId("145360")
    @Requirements("REQCRM-251")
    @Sale_Accesses
    @StorageAccessUpdateV1
    @Response_400_Bad_Request
    @DisplayName("$storageAccessUpdate -> 400 Bad Request: Обновление доступа")
    fun test() {
        testsData.forEach { (testName, request, expected) ->
            testName { checkBR(accessesCrmClient, request, expected) }
        }
    }
}