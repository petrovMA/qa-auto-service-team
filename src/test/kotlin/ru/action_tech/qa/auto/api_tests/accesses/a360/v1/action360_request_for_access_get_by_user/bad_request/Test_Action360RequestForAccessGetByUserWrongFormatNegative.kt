package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_user.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByUserV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360RequestForAccessGetByUserWrongFormatNegative {

    private val request by lazy { AccessesRequests.action360RequestForAccessGetByUser(userIds = listOf("123", "321")) }

    @Test
    @Requirements("REQCRM-239")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByUserV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-user -> 400 Bad Request: невалидный userIds")
    @AllureId("145332")
    fun test_Action360RequestForAccessGetByUserWrongFormatNegative() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }
}