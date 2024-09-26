package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_add.ok

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessAddV1
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_add.StorageAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate.StorageAccessDeactivateRequest
import ru.action_tech.qa.auto.api_models.accesses.storageAccessAdd
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.access_backend.AccessType.DEMO_ACCESS
import ru.action_tech.qa.auto.data.FieldData.REGEX_FOR_UKD
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_StorageAccessAdd {

    @Test
    @Issue("ARMAP-19294")
    @Requirements("REQCRM-250", "REQCRM-251", "REQCRM-253")
    @Sale_Accesses
    @StorageAccessAddV1
    @Response_200_Ok
    @DisplayName("$storageAccessAdd -> 200 Ok: Создание доступа")
    @AllureId("145354")
    fun test() {
        val createdAccess = accessesCrmClient.send(
            AccessesRequests.storageAccessAdd(
                StorageAccessAddRequest(
                    accessType = DEMO_ACCESS,
                    dateStart = "2022-04-02T15:38:21.053Z",
                    dateEnd = "2042-04-02T15:38:21.054Z",
                    productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                    attributes = StorageAccessAddRequest.Attributes(
                        activateDate = "2024-04-02T15:38:21.060Z",
                        userCount = 1
                    )
                )
            )
        )

        "Проверка что в ответе вернулся код доступа" {
            assertTrue(createdAccess.code?.matches(REGEX_FOR_UKD) ?: false)
            assertTrue(createdAccess.codeValue?.matches(REGEX_FOR_UKD) ?: false)
        }

        "Проверка что версия доступа = 0" { assertEqual(createdAccess.version?.version, 0) }

        val updatedAccess = accessesCrmClient.send(
            AccessesRequests.storageAccessUpdate(
                StorageAccessAddRequest(
                    commonId = createdAccess.commonId,
                    accessType = DEMO_ACCESS,
                    dateStart = "2022-04-02T15:38:21.053Z",
                    dateEnd = "2042-04-02T15:38:21.054Z",
                    productVersionId = "86ff646c-2f29-ed11-bbbc-bcda0251696c",
                    attributes = StorageAccessAddRequest.Attributes(
                        activateDate = "2024-04-02T15:38:21.060Z",
                        userCount = 100
                    )
                )
            )
        )

        "Проверка что версия доступа = 1" { assertEqual(updatedAccess.version?.version, 1) }
        "Проверка что пользователи обновились userCount = 100" { assertEqual(updatedAccess.attributes?.userCount, 100) }

        accessesCrmClient.send(AccessesRequests.storageAccessDeactivate(StorageAccessDeactivateRequest(createdAccess.commonId)))

        val deactivatedAccess = accessesCrmClient.send(AccessesRequests.storageAccessGetById(createdAccess.commonId))

        "Проверка что демодоступ деактивирован" { assertFalse(deactivatedAccess.isActive!!) }
        "Проверка что версия доступа = 2" { assertEqual(deactivatedAccess.version?.version, 2) }
    }
}