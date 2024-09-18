package ru.action_tech.qa.auto.api_tests.supports.support.v1.opportunity_a360_get_by_customer.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.OpportunityA360GetByCustomer
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360GetByCustomer
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_OpportunityA360GetByCustomerWrongFormatNegative {


    @Test
    @Requirements("REQCRM-220")
    @Sale_Supports
    @OpportunityA360GetByCustomer
    @Response_400_Bad_Request
    @DisplayName("/api/v1/opportunity-a360_get-by-customer -> 400 Bad Request: не корректный формат accountId")
    @AllureId("145902")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = opportunityA360GetByCustomer("123-321"),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}