package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.customer_balance_get

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.CustomerBalanceGetV1
import ru.action_tech.qa.auto.api_models.payments.customerBalanceGet
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.customer_balance_get.request.CustomerBalanceGetRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.paymentsCrmClient

class Test_CustomerBalanceGetWrongRequest {

    @Test
    @Requirements("REQCRM-315")
    @Sale_Payments
    @CustomerBalanceGetV1
    @Response_400_Bad_Request
    @DisplayName("$customerBalanceGet -> 400 Bad Request: некорректный формат даты")
    @AllureId("145841")
    fun test() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.customerBalanceGet(CustomerBalanceGetRequest(null, dateFrom = "19-11-11")),
            expected = setOf(CheckBadRequests.BrokenRule(code = 0, message = "The value '19-11-11' is not valid."))
        )
    }

    @Test
    @Requirements("REQCRM-315")
    @Sale_Payments
    @CustomerBalanceGetV1
    @Response_400_Bad_Request
    @DisplayName("$customerBalanceGet -> 400 Bad Request: запрос без параметров")
    @AllureId("145840")
    fun test_CustomerBalanceGetNoParamsNegative() {
        val response = paymentsCrmClient.send(PaymentsRequests.customerBalanceGet(CustomerBalanceGetRequest(null)))
        assertTrue(response.freeSum == null)
        assertTrue(response.usedSum == null)
    }
}