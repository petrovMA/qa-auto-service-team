package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_add.bad_request

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessAddV1
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_add.StorageAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.storageAccessAdd
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.access_backend.AccessType.DEMO_ACCESS
import ru.action_tech.qa.auto.api_models.access_backend.AccessType.PAID_ACCESS
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_StorageAccessAddBadRequest {

    private val testsData by lazy {
        listOf(
            Triple(
                "Не корректный AccessType",
                AccessesRequests.storageAccessAdd(
                    StorageAccessAddRequest(
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
                AccessesRequests.storageAccessAdd(
                    StorageAccessAddRequest(
                        accessType = PAID_ACCESS,
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
                "Не передан параметр ActivateDate",
                AccessesRequests.storageAccessAdd(
                    StorageAccessAddRequest(
                        accessType = DEMO_ACCESS,
                        dateStart = "2022-04-02T15:38:21.053Z",
                        dateEnd = "2042-04-02T15:38:21.054Z",
                        productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                        attributes = StorageAccessAddRequest.Attributes(
                            activateDate = null,
                            userCount = 1
                        )
                    )
                ),
                setOf(
                    BrokenRule(
                        code = 12,
                        message = "ActivateDate required when AccessType is 'DemoAccess' and ActivationType is 'FixedStartDate'."
                    )
                )
            ),
            Triple(
                "DateStart is wrong format",
                AccessesRequests.storageAccessAdd(
                    StorageAccessAddRequest(
                        accessType = DEMO_ACCESS,
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
                AccessesRequests.storageAccessAdd(
                    StorageAccessAddRequest(
                        accessType = DEMO_ACCESS,
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
            )
        )
    }


    @Test
    @Issue("ARMAP-19263")
    @Requirements("REQCRM-250")
    @Sale_Accesses
    @StorageAccessAddV1
    @Response_400_Bad_Request
    @DisplayName("$storageAccessAdd -> 400 Bad Request: Создание доступа")
    @AllureId("238591")
    fun test() {
        testsData.forEach { (testName, request, expected) ->
            testName { checkBR(accessesCrmClient, request, expected) }
        }
    }
}