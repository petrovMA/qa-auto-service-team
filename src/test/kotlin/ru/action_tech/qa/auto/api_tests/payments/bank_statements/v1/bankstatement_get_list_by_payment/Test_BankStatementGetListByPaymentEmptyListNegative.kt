package ru.action_tech.qa.auto.api_tests.payments.bank_statements.v1.bankstatement_get_list_by_payment

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.BankStatementGetListByPaymentV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests.bankStatementGetListByPayment
import ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_get_list_by_payment.request.BankStatementGetListByPaymentRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_BankStatementGetListByPaymentEmptyListNegative {

    @Test
    @Requirements("REQCRM-310")
    @Sale_Payments
    @BankStatementGetListByPaymentV1
    @Response_400_Bad_Request
    @DisplayName("${ru.action_tech.qa.auto.api_models.payments.bankStatementGetListByPayment} -> 400 Bad Request: передан пустой список ids")
    @AllureId("145834")
    fun testBrokenRule() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = bankStatementGetListByPayment(BankStatementGetListByPaymentRequest(listOf(null))),
            expected = setOf(CheckBadRequests.BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }


    @Test
    @Requirements("REQCRM-310")
    @Sale_Payments
    @BankStatementGetListByPaymentV1
    @Response_400_Bad_Request
    @DisplayName("${ru.action_tech.qa.auto.api_models.payments.bankStatementGetListByPayment} -> 400 Bad Request: по переданным ids ничего не найдено")
    @AllureId("145835")
    fun test() {
        assertTrue(
            paymentsCrmClient.send(
                bankStatementGetListByPayment(
                    BankStatementGetListByPaymentRequest(listOf(FieldData.DEFAULT_ID, FieldData.ZERO_ID))
                )
            ).isEmpty()
        )
    }
}