package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_get_by_id.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessGetByIdV1
import ru.action_tech.qa.auto.api_models.accesses.storageAccessGetById
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_StorageAccessGetByIdWrongFormat {

    @Test
    @HistoryIssues("ARMAP-10199")
    @Requirements("REQCRM-248")
    @Sale_Accesses
    @StorageAccessGetByIdV1
    @Response_400_Bad_Request
    @DisplayName("$storageAccessGetById -> 400 Bad Request: не корректный id")
    @AllureId("145358")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.storageAccessGetById("123-123-123-123-123"),
            expected = setOf(BrokenRule(code = 9, message = "По указанному Id ничего не найдено"))
        )
    }
}