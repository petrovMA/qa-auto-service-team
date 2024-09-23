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
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateRegularCustomersCantRemoveClientNegative {

    @Test
    @Sale_Supports
    @FacadeA360BushUpdateRegularCustomers
    @Response_400_Bad_Request
    @Requirements("REQCRM-969")
    @HistoryIssues("ARMAP-16720", "ARMAP-17778")
    @DisplayName("/api/v1/facade-a360-bush_update-regular-customers -> 400 Bad Request: У клиента есть действующий УКД")
    @AllureId("145886")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = facadeA360BushUpdateRegularCustomers(
                FacadeA360BushUpdateRegularCustomersRequest(
                    bushAction360Id = "221AE45A-4E2E-4965-A8CB-50593E604B3A",
                    customerIds = listOf("B07FC502-5CCA-480C-8F6D-667E691F72E3"),
                    factPrice = 0,
                    factUsersAmount = 0,
                    systemUserId = ACTIONUSKA.id
                )
            ),
            expected = setOf(
                BrokenRule(
                    code = 28,
                    message = "Нельзя удалить клиента у которого есть действующий УКД на продукт А 360"
                )
            )
        )
    }
}