package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_get_by_account.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessGetByAccountV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR



class Test_Action360AccessGetByAccount {

    @Test
    @Requirements("REQCRM-1576")
    @Sale_Accesses
    @Aktion360AccessGetByAccountV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-access_get-by-account -> 400 bad request")
    @AllureId("154444")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.aktion360AccessGetByAccount(),
            expected = setOf(BrokenRule(code = 85, message = "Не указан клиент"))
        )
    }
}