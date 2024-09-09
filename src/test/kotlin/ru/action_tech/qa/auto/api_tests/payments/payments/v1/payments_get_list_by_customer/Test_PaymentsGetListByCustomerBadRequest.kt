package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_list_by_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetListByCustomerV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_PaymentsGetListByCustomerBadRequest {

    @Test
    @HistoryIssues("ARMAP-11037")
    @Requirements("REQCRM-313")
    @Sale_Payments
    @PaymentsGetListByCustomerV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/payments_get-list-by-customer -> 400 Bad Request: ids = null")
    @AllureId("145838")
    fun testWrongRequest() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.paymentsGetListByCustomer(arrayOf(null)),
            expected = setOf(CheckBadRequests.BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }

    @Test
    @Requirements("REQCRM-313")
    @Sale_Payments
    @PaymentsGetListByCustomerV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/payments_get-list-by-customer -> 400 Bad Request: не передан параметр ids")
    @AllureId("145837")
    fun testWrongIds() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.paymentsGetListByCustomer(null),
            expected = CheckBadRequests.BrokenRuleWithDevMessage(code = 0, messages = listOf("Передан не валидный Ids"))
        )
    }
}