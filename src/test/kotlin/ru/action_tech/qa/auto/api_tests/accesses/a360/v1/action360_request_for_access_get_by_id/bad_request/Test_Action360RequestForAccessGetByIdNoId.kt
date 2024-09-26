package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_id.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByIdV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360RequestForAccessGetByIdNoId {

    @Test
    @HistoryIssues("ARMAP-10194")
    @Requirements("REQCRM-240")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-id -> 400 Bad Request: id заявки не передан")
    @AllureId("145325")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.action360RequestForAccessGetById(null),
            expected = setOf(BrokenRule(code = 8, message = "Запрос не корректный"))
        )
    }
}