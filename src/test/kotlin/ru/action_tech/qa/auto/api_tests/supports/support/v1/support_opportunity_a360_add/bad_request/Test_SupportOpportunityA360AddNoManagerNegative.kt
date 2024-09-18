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
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportOpportunityA360AddNoManagerNegative {

    private val request by lazy {
        SupportsRequests.supportOpportunityA360Add(
            SupportOpportunityA360AddRequest(
                startDate = "2021-09-02T18:21:42.176Z",
                endDate = "2021-09-02T18:21:42.176Z",
                accountId = "325B09A1-2002-48E4-AADC-A978196D8EA4",
                status = 11,
                partnerId = "B89FF32C-5F0B-DF11-809E-001CC45E3D96",
                systemUserId = null,
                isFixedDates = true,
                isForce = false
            )
        )
    }


    @Test
    @Sale_Supports
    @SupportOpportunityA360Add
    @Response_400_Bad_Request
    @Requirements("REQCRM-217")
    @DisplayName("/api/v1/support-opportunitya360_add -> 400 Bad Request: не передан systemUserId")
    @AllureId("145907")
    fun test_SupportOpportunityA360AddNoManagerNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 3, message = "Не указан менеджер сопровождения."))
        )
    }
}