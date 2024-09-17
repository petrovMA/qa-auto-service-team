package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.payment_balance_get_list_by_payment

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentBalanceGetListByPaymentV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.paymentBalanceGetListByPayment
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.payment_balance_get_list_by_payment.request.PaymentBalanceGetListByPaymentRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_PaymentBalanceGetListByPayment {

    private val idsList by lazy {
        listOf(
            "2f5c280d-8c6e-4019-8a10-8f84c66a81de",
            "798ea223-85ce-4d9c-9f63-d8a92892caa7",
            "139e12c2-3888-4764-9ae6-0e4945c0afa4",
            "1f61a7da-049e-4dec-82eb-1dca61eb3afe",
            "953ca173-0c9f-426f-9edf-5cdd9b2f9a8a",
            "bf9b3cce-633a-e911-bb9e-00155d627f03",
            "6bde795c-69eb-40af-ac9a-f55e5998801e",
            "386a8097-25c3-4849-9068-8450cdb2394c",
            "b6db77fb-73e9-e811-bb9d-00155d627f03"
        )
    }

    @Test
    @Requirements("REQCRM-316")
    @Sale_Payments
    @PaymentBalanceGetListByPaymentV1
    @Response_200_Ok
    @DisplayName("$paymentBalanceGetListByPayment -> 200 Ok")
    @AllureId("145845")
    fun test_PaymentBalanceGetListByPaymentPositive() {
        val response = paymentsCrmClient.send(
            PaymentsRequests.paymentBalanceGetListByPayment(
                PaymentBalanceGetListByPaymentRequest(ids = idsList, dateFrom = "2019-12-14T00:00:00")
            )
        )
        assertTrue(response.map { it.id }.containsAll(idsList))
    }
}