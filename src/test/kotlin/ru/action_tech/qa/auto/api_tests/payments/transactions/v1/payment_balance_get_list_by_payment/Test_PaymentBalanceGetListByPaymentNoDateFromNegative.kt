package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.payment_balance_get_list_by_payment

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentBalanceGetListByPaymentV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.paymentBalanceGetListByPayment
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.payment_balance_get_list_by_payment.request.PaymentBalanceGetListByPaymentRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_PaymentBalanceGetListByPaymentNoDateFromNegative {

    @Test
    @Requirements("REQCRM-316")
    @Sale_Payments
    @PaymentBalanceGetListByPaymentV1
    @Response_400_Bad_Request
    @DisplayName("$paymentBalanceGetListByPayment -> 400 Bad Request: передан пустой ids")
    @AllureId("145843")
    fun test_PaymentBalanceGetListByPaymentNoDateFromNegative() {
        val response = paymentsCrmClient.send(
            PaymentsRequests.paymentBalanceGetListByPayment(
                PaymentBalanceGetListByPaymentRequest(ids = emptyList(), dateFrom = "2019-12-14T00:00:00")
            )
        )
        assertTrue(response.isEmpty())
    }

    @Test
    @HistoryIssues("ARMAP-11037")
    @Requirements("REQCRM-316")
    @Sale_Payments
    @PaymentBalanceGetListByPaymentV1
    @Response_400_Bad_Request
    @DisplayName("$paymentBalanceGetListByPayment -> 400 Bad Request: передан невалидный ids")
    @AllureId("145844")
    fun test() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.paymentBalanceGetListByPayment(
                PaymentBalanceGetListByPaymentRequest(
                    ids = listOf("321-321-321-321-321"),
                    dateFrom = "2019-12-14T00:00:00"
                )
            ),
            expected = setOf(CheckBadRequests.BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }
}