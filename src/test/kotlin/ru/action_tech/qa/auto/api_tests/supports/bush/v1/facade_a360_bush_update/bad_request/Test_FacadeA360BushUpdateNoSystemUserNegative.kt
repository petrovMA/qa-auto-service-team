package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_update.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushUpdate
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update.request.FacadeA360BushUpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateNoSystemUserNegative {

    private val request by lazy {
        facadeA360BushUpdate(
            FacadeA360BushUpdateRequest(
                bushAction360Id = "C5409CA1-F4CA-435E-9007-D0ABE22CBD56",
                customerIds = listOf("2df6b60a-0e5b-4380-85dd-d8879b6c195c"),
                factPrice = 0,
                factUsersAmount = 0,
                systemUserId = null
            )
        )
    }

    @Test
    @Sale_Supports
    @FacadeA360BushUpdate
    @Response_400_Bad_Request
    @Requirements("REQCRM-785")
    @DisplayName("/api/v1/facade-a360-bush_update -> 400 Bad Request: не передан systemUserId")
    @AllureId("145885")
    fun test_FacadeA360BushUpdateNoSystemUserNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 35, message = "Идентефикатор не валиден или пуст"))
        )
    }
}