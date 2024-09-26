package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_cancel.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessCancelV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.accessCancel
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_cancel.AccessCancelRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR

class Test_AccessCancelCodeNotValidNegative {

    @Test
    @HistoryIssues("ARMAP-14404")
    @Requirements("REQCRM-257")
    @Sale_Accesses
    @AccessCancelV1
    @Response_400_Bad_Request
    @DisplayName("$accessCancel -> 400 Bad Request: authCode not valid")
    @AllureId("145347")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessCancel(AccessCancelRequest(authCode = "5500-6405-2384-5000-830")),
            expected = setOf(BrokenRule(code = 8, message = "Code has wrong format."))
        )
    }
}
