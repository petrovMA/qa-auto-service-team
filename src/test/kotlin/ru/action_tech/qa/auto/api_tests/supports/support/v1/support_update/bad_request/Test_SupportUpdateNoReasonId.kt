package ru.action_tech.qa.auto.api_tests.supports.support.v1.support_update.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportUpdate
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_update.request.SupportUpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportUpdateNoReasonId {

    private val request: Request by lazy {
        supportUpdate(
            SupportUpdateRequest(
                id = "5b2f6d0b-f8a7-4cbe-8f52-264fd5c52d24",
                status = 32,
                endDate = "2023-01-09T00:00:00",
                supportChangeReasonId = null
            ),
            isNonNull = false
        )
    }


    @Test
    @Sale_Supports
    @SupportUpdate
    @Response_400_Bad_Request
    @Requirements("REQCRM-214")
    @DisplayName("/api/v1/support-update -> 400 Bad Request: Не передано сопровождение")
    @AllureId("174403")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 37, message = "Не найдено сопровождение"))
        )
    }
}