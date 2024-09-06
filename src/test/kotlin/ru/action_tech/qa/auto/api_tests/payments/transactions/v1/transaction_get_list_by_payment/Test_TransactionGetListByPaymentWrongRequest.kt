package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.transaction_get_list_by_payment

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.TransactionGetListByPaymentV1
import ru.action_tech.qa.auto.api_models.payments.transactionGetListByPayment
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_get_list_by_payment.request.TransactionGetListByPaymentRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_TransactionGetListByPaymentWrongRequest {

    private val request by lazy {
        PaymentsRequests.transactionGetListByPayment(TransactionGetListByPaymentRequest(listOf(ZERO_ID, DEFAULT_ID)))
    }

    @Test
    @Requirements("REQCRM-317")
    @Sale_Payments
    @TransactionGetListByPaymentV1
    @Response_400_Bad_Request
    @DisplayName("$transactionGetListByPayment -> 400 Bad Request: по ids=[$ZERO_ID, $DEFAULT_ID] ничего не найдено) ")
    @AllureId("145846")
    fun test_TransactionGetListByPaymentNotFoundNegative() {
        val response = paymentsCrmClient.send(request)
        assertTrue(response.isEmpty())
    }


    private val idsList by lazy { listOf("00155d627f03-00155d627f03-00155d627f03-00155d627f03-00155d627f03") }

    @Test
    @HistoryIssues("ARMAP-11037")
    @Requirements("REQCRM-317")
    @Sale_Payments
    @TransactionGetListByPaymentV1
    @Response_400_Bad_Request
    @DisplayName("$transactionGetListByPayment -> 400 Bad Request: не корректный формат id в параметре ids")
    @AllureId("145847")
    fun test() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.transactionGetListByPayment(TransactionGetListByPaymentRequest(idsList)),
            expected = setOf(
                CheckBadRequests.BrokenRule(code = 100, message = "Неверные параметры или модель запроса")
            )
        )
    }
}