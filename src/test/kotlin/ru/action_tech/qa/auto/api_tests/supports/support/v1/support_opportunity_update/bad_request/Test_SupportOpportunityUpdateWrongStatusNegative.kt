package ru.action_tech.qa.auto.api_tests.supports.support.v1.support_opportunity_update.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportOpportunityUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_update.request.SupportOpportunityUpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportOpportunityUpdateWrongStatusNegative {

    private val request: Request by lazy {
        SupportsRequests.supportOpportunityUpdate(
            SupportOpportunityUpdateRequest(
                id = FieldData.DEFAULT_ID,
                status = 0,
                endDate = "2021-09-02T18:02:09.827Z"
            )
        )
    }

    @Test
    @Sale_Supports
    @SupportOpportunityUpdate
    @Response_400_Bad_Request
    @Requirements("REQCRM-216")
    @DisplayName("/api/v1/support-opportunity_update -> 400 Bad Request: Метод обновления возможной сделки клиента (не корректный status)")
    @AllureId("145914")
    fun test_SupportOpportunityUpdateWrongStatusNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 7, message = "Неверный статус сопровождения."))
        )
    }
}