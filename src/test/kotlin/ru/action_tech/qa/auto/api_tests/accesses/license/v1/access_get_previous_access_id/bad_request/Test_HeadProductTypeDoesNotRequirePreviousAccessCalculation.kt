package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_previous_access_id.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetPreviousAccessIdV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_HeadProductTypeDoesNotRequirePreviousAccessCalculation {

    @Test
    @Sale_Accesses
    @AccessGetPreviousAccessIdV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1065")
    @DisplayName("/api/v1/access_get-previous-access-id -> 400 Bad Request: accessId not found")
    @AllureId("145308")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessesGetPreviousAccessId(accessId = null, userId = 15909195),
            expected = setOf(BrokenRule(code = 6, message = "Доступ не найден/удален."))
        )
    }
}