package ru.action_tech.qa.auto.api_tests.supports.support.v1.opportunity_a360_can_create.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.OpportunityA360CanCreate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360CanCreate
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_can_create.request.OpportunityA360CanCreateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_OpportunityA360CanCreateWrongAccountIdNegative {


    @Test
    @Requirements("REQCRM-219")
    @Sale_Supports
    @OpportunityA360CanCreate
    @Response_400_Bad_Request
    @DisplayName("/api/v1/opportunity-a360_can-create -> 400 Bad Request: не валидный accountId")
    @AllureId("145896")
    fun test_OpportunityA360CanCreateWrongAccountIdNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = opportunityA360CanCreate(OpportunityA360CanCreateRequest(contactId = "-----")),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}