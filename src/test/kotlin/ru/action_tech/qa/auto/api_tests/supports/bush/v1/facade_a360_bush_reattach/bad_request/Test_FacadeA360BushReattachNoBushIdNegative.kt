package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_reattach.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushReattach
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushReattach
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_reattach.request.FacadeA360BushReattachRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushReattachNoBushIdNegative {

    @Test
    @Sale_Supports
    @FacadeA360BushReattach
    @Response_400_Bad_Request
    @Requirements("REQCRM-787")
    @DisplayName("/api/v1/facade-a360-bush_reattach -> 400 Bad Request: не передан bushAction360Id")
    @AllureId("145882")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = facadeA360BushReattach(
                FacadeA360BushReattachRequest(
                    bushAction360Id = null,
                    systemUserId = "94f431ce-2fec-ea11-bba7-00155d627f03"
                )
            ),
            expected = setOf(BrokenRule(code = 21, message = "Не найден куст А360"))
        )
    }
}