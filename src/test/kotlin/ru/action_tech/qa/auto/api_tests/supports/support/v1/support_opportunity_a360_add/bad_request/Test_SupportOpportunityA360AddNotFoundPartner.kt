package ru.action_tech.qa.auto.api_tests.supports.support.v1.support_opportunity_a360_add.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportOpportunityA360Add
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_add.request.SupportOpportunityA360AddRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.VTM_CALL
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportOpportunityA360AddNotFoundPartner {

    private val request by lazy {
        SupportsRequests.supportOpportunityA360Add(
            SupportOpportunityA360AddRequest(
                startDate = "2021-09-02T18:21:42.176Z",
                endDate = "2021-09-02T18:21:42.176Z",
                accountId = "325B09A1-2002-48E4-AADC-A978196D8EA3",
                status = 11,
                partnerId = DEFAULT_ID,
                systemUserId = VTM_CALL.id,
                isFixedDates = true,
                isForce = false
            )
        )
    }


    @Test
    @Sale_Supports
    @SupportOpportunityA360Add
    @Response_400_Bad_Request
    @HistoryIssues("ARMAP-13610")
    @Requirements("REQCRM-217")
    @DisplayName("/api/v1/support-opportunitya360_add -> 400 Bad Request: не найден партнёр")
    @AllureId("145908")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 11, message = "Не найден партнер с таким Id."))
        )
    }
}