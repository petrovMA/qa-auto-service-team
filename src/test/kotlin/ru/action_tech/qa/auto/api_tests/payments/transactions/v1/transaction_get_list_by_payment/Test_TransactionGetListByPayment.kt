package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.transaction_get_list_by_payment

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.TransactionGetListByPaymentV1
import ru.action_tech.qa.auto.api_models.payments.transactionGetListByPayment
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_get_list_by_payment.request.TransactionGetListByPaymentRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_TransactionGetListByPayment {

    private val ids by lazy { listOf("67f14541-de27-eb11-bba9-00155d627f03", "4e5a98d4-6321-ea11-bba4-00155d627f03") }


    @Test
    @Requirements("REQCRM-317")
    @Sale_Payments
    @TransactionGetListByPaymentV1
    @Response_200_Ok
    @DisplayName("$transactionGetListByPayment -> 200 ok")
    @AllureId("145848")
    fun test_TransactionGetListByPaymentPositive() {
        val response =
            paymentsCrmClient.send(PaymentsRequests.transactionGetListByPayment(TransactionGetListByPaymentRequest(ids)))
        assertTrue(response.map { it.payment?.id }.containsAll(ids))
    }
}