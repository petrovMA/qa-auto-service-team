package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_get_by_code.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessGetByCodeV1
import ru.action_tech.qa.auto.api_models.accesses.storageAccessGetByCode
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_StorageAccessGetByCodeWrongCodeFormat {

    @Test
    @Requirements("REQCRM-249")
    @Sale_Accesses
    @StorageAccessGetByCodeV1
    @Response_400_Bad_Request
    @DisplayName("$storageAccessGetByCode -> 400 Bad Request: Не корректный код")
    @AllureId("174515")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.storageAccessGetByCode("123-123-123-123-123"),
            expected = setOf(BrokenRule(code = 8, message = "Code has wrong format."))
        )
    }
}