package ru.action_tech.qa.auto.api_tests.payments.bank_statements.v1.bankstatement_get_list_by_payment

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.BankStatementGetListByPaymentV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.bankStatementGetListByPayment
import ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_get_list_by_payment.request.BankStatementGetListByPaymentRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_BankStatementGetListByPayment {

    private val id = "4e5a98d4-6321-ea11-bba4-00155d627f03"


    @Test
    @Requirements("REQCRM-310")
    @Sale_Payments
    @BankStatementGetListByPaymentV1
    @Response_200_Ok
    @DisplayName("$bankStatementGetListByPayment -> 200 Ok")
    @AllureId("145836")
    fun test() {
        val response = paymentsCrmClient.send(PaymentsRequests.bankStatementGetListByPayment(BankStatementGetListByPaymentRequest(listOf(id))))
        assertTrue(response.all { it.payment?.id == id })
    }
}