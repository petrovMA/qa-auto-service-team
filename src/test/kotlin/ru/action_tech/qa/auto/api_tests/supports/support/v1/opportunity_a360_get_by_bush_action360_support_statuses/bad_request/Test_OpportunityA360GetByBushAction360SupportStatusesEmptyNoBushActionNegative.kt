package ru.action_tech.qa.auto.api_tests.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.OpportunityA360GetByBushAction360SupportStatuses
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360GetByBushAction360SupportStatuses
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.request.OpportunityA360GetByBushAction360SupportStatusesRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_OpportunityA360GetByBushAction360SupportStatusesEmptyNoBushActionNegative {


    private val request by lazy {
        opportunityA360GetByBushAction360SupportStatuses(
            OpportunityA360GetByBushAction360SupportStatusesRequest(supportStatuses = emptyList())
        )
    }


    @Test
    @Sale_Supports
    @OpportunityA360GetByBushAction360SupportStatuses
    @Response_400_Bad_Request
    @Requirements("REQCRM-221")
    @DisplayName("/api/v1/opportunity-a360_get-by-bush-action360-support-statuses -> 400 Bad Request: не передан bushAction360Id")
    @AllureId("145899")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}