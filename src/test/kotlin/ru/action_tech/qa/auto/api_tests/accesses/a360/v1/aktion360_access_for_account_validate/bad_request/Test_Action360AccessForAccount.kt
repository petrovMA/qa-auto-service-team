package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.aktion360_access_for_account_validate.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessForAccountValidateV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360AccessForAccount {

    @Test
    @Requirements("REQCRM-1575")
    @Sale_Accesses
    @Aktion360AccessForAccountValidateV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-access-for-account_validate -> 400 Bad Request: не передан accountId")
    @AllureId("154453")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.action360AccessForAccountValidate(),
            expected = setOf(BrokenRule(code = 85, message = "Не указан клиент"))
        )
    }
}