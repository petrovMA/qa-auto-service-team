package ru.action_tech.qa.auto.api_tests.supports.support.v1.support_opportunity_a360_update.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportOpportunityA360Update
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_update.request.SupportOpportunityA360UpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportOpportunityA360UpdateWrongStatusNegative {

    private val request: Request by lazy {
        SupportsRequests.supportOpportunityA360Update(
            SupportOpportunityA360UpdateRequest(
                id = DEFAULT_ID,
                status = 2,
                endDate = "2021-09-02T19:09:00.946Z",
                rejectedOn = "2021-09-02T19:09:00.946Z"
            )
        )
    }

    @Test
    @Sale_Supports
    @SupportOpportunityA360Update
    @Response_400_Bad_Request
    @Requirements("REQCRM-218")
    @DisplayName("/api/v1/support-opportunitya360_update -> 400 Bad Request: Метод обновления возможной сделки A360 клиента (не корректный status)")
    @AllureId("145910")
    fun test_SupportOpportunityA360UpdateWrongStatusNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 7, message = "Неверный статус сопровождения."))
        )
    }
}