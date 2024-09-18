package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_update_regular_customers.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushUpdateRegularCustomers
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushUpdateRegularCustomers
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_regular_customers.request.FacadeA360BushUpdateRegularCustomersRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateRegularCustomersNotFoundManagerNegative {

    private val request: Request by lazy {
        facadeA360BushUpdateRegularCustomers(
            FacadeA360BushUpdateRegularCustomersRequest(
                bushAction360Id = "13116EEA-0298-49EC-866B-043894A3DB2E",
                customerIds = listOf(null),
                factPrice = 0,
                factUsersAmount = 0,
                systemUserId = "2df6b60a-0e5b-4380-85dd-d8879b6c195c"
            )
        )
    }

    @Test
    @Sale_Supports
    @FacadeA360BushUpdateRegularCustomers
    @Response_400_Bad_Request
    @Requirements("REQCRM-969")
    @HistoryIssues("ARMAP-16720")
    @DisplayName("/api/v1/facade-a360-bush_update-regular-customers -> 400 Bad Request: передан customerIds[null]")
    @AllureId("145887")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}