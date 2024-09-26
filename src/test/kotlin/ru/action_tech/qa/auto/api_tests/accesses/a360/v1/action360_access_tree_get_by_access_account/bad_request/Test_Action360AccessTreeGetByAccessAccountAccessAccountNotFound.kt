package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_tree_get_by_access_account.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessModerateV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.access_backend.access.v2.user_get_active.response.UserGetActiveResponse
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360AccessTreeGetByAccessAccountAccessAccountNotFound {
    lateinit var access: UserGetActiveResponse

    private val request by lazy {
        AccessesRequests.action360AccessTreeGetByAccessAccount(accessId = DEFAULT_ID)
    }

    @Test
    @Requirements("REQCRM-1577")
    @Sale_Accesses
    @Aktion360RequestForAccessModerateV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-access-tree_get-by-access-account -> 400 Bad request: Клиент не указан")
    @AllureId("154447")
    fun test_Action360AccessTreeGetByAccessAccountAccessAccountNotFound() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            BrokenRule(code = 85, message = "Не указан клиент")
        )
    }
}