package ru.action_tech.qa.auto.api_tests.supports.support.v1.analysis_bush_customers_get_by_customer_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.AnalysisBushCustomersGetByCustomerIdsV1
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.analysisBushCustomersGetByCustomerIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_AnalysisBushCustomersGetByCustomerIdsNoParamsNegative {

    @Test
    @Requirements("REQCRM-967")
    @Sale_Supports
    @AnalysisBushCustomersGetByCustomerIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/analysis-bush-customers_get-by-customer-ids -> 400 Bad Request: не корректные параметры в priceListIds")
    @AllureId("177260")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = analysisBushCustomersGetByCustomerIds(customerIds = null),
            expected = setOf(BrokenRule(code = 29, message = "Список Ids клиентов пуст"))
        )
    }
}