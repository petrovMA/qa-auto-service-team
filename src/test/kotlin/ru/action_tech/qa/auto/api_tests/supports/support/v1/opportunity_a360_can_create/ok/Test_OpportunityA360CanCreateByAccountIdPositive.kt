package ru.action_tech.qa.auto.api_tests.supports.support.v1.opportunity_a360_can_create.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.OpportunityA360CanCreate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360CanCreate
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_can_create.request.OpportunityA360CanCreateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_can_create.response.OpportunityA360CanCreateResponse
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_OpportunityA360CanCreateByAccountIdPositive {

    private val request by lazy {
        opportunityA360CanCreate(OpportunityA360CanCreateRequest(accountId = "94f431ce-2fec-ea11-bba7-00155d627f03"))
    }

    @Test
    @Requirements("REQCRM-219")
    @Sale_Supports
    @OpportunityA360CanCreate
    @Response_200_Ok
    @DisplayName("/api/v1/opportunity-a360_can-create -> 200 Ok: Проверка организации на наличие сопровождения с возможной сделкой Актион 360 (accountId запрос)")
    @AllureId("145897")
    fun test_OpportunityA360CanCreateByAccountIdPositive() {
        val response = supportsCrmClient.send(request)

        "Проверка что в ответе True и Ok" {
            assertThat(response).isEqualTo(OpportunityA360CanCreateResponse(true, "Ок"))
        }
    }
}