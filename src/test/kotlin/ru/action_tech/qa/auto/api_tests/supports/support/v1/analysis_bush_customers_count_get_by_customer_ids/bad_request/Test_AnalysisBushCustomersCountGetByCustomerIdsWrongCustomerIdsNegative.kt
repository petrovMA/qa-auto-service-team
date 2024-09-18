package ru.action_tech.qa.auto.api_tests.supports.support.v1.analysis_bush_customers_count_get_by_customer_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.AnalysisBushCustomersCountGetByCustomerIdV1
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.analysisBushCustomersCountGetByCustomerIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_AnalysisBushCustomersCountGetByCustomerIdsWrongCustomerIdsNegative {

    @Test
    @Requirements("REQCRM-1073")
    @Sale_Supports
    @AnalysisBushCustomersCountGetByCustomerIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/analysis-bush-customers-count_get-by-customer-ids -> 400 Bad Request: не валидный параметр customerIds")
    @AllureId("177314")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = analysisBushCustomersCountGetByCustomerIds(customerIds = listOf(null)),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}