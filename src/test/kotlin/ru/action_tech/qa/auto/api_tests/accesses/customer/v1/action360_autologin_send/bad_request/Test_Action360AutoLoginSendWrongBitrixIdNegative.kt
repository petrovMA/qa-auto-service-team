package ru.action_tech.qa.auto.api_tests.accesses.customer.v1.action360_autologin_send.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AutologinSendV1
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_autologin_send.Action360AutologinSendRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360AutoLoginSendWrongBitrixIdNegative {

    private val request by lazy {
        AccessesRequests.action360AutologinSend(
            Action360AutologinSendRequest(
                accessId = "123-123-123-321-321-321",
                managerId = "E99550C7-237E-E511-8E6E-78E3B502DA44",
                lastName = "string",
                firstName = "string",
                middleName = "string",
                email = "string@qwe.qw",
                bitrixId = "123123123"
            )
        )
    }

    @Test
    @HistoryIssues("ARMAP-10190")
    @Requirements("REQCRM-227")
    @Sale_Accesses
    @Aktion360AutologinSendV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-autologin_send -> 400 Bad Request: accessId не валидный формат")
    @AllureId("145300")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(BrokenRule(3, "У пользователя отсутствует BitrixId."))
        )
    }
}