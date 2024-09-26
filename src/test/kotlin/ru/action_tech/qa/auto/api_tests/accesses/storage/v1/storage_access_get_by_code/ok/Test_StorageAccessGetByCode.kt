package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_get_by_code.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessGetByCodeV1
import ru.action_tech.qa.auto.api_models.accesses.storageAccessGetByCode
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_StorageAccessGetByCode {

    @Sale_Accesses
    @StorageAccessGetByCodeV1
    @Response_200_Ok
    @Requirements("REQCRM-249")
    @AllureId("145356")
    @HistoryIssues("PT-9776", "ARMAP-17376")
    @DisplayName("$storageAccessGetByCode -> 200 Ok: Доступ по коду")
    @Test
    fun test() {
        accessesCrmClient.send(AccessesRequests.storageAccessGetByCode("5500-6375-4448-8573-3203")).run {
            "Проверить, что в ответе code = 5500-6375-4448-8573-3203" {
                assertEqual(codeValue, "5500-6375-4448-8573-3203")
            }
        }
    }
}