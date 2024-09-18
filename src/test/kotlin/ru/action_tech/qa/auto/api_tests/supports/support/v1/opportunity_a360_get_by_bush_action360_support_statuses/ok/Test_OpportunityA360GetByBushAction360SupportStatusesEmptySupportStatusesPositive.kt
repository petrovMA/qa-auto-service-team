package ru.action_tech.qa.auto.api_tests.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.OpportunityA360GetByBushAction360SupportStatuses
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360GetByBushAction360SupportStatuses
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.request.OpportunityA360GetByBushAction360SupportStatusesRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_OpportunityA360GetByBushAction360SupportStatusesEmptySupportStatusesPositive {


    private val request by lazy {
        opportunityA360GetByBushAction360SupportStatuses(
            OpportunityA360GetByBushAction360SupportStatusesRequest(
                bushAction360Id = "C5409CA1-F4CA-435E-9007-D0ABE22CBD56",
                supportStatuses = emptyList()
            )
        )
    }


    @Test
    @Sale_Supports
    @OpportunityA360GetByBushAction360SupportStatuses
    @Response_200_Ok
    @Requirements("REQCRM-221")
    @DisplayName("/api/v1/opportunity-a360_get-by-bush-action360-support-statuses -> 200 Ok: пустой supportStatuses")
    @AllureId("145900")
    fun test() {
        val response = supportsCrmClient.send(request)

        "Проверяем, что ответ пустой" { assertThat(response).isEmpty() }
    }
}