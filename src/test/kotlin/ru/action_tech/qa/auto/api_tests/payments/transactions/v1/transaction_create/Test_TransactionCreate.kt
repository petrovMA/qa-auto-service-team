package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.transaction_create

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.TransactionCreateV1
import ru.action_tech.qa.auto.api_models.payments.transactionCreate
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_create.request.TransactionCreateRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_TransactionCreate {

    private val request by lazy {
        PaymentsRequests.transactionCreate(
            TransactionCreateRequest(
                id = "7be40d2a-6e89-4387-be2d-05ac4b0d3122",
                salesOrderId = "f4df308c-a3e3-4928-a400-920579a5d399",
                subscribeId = "a053e782-c797-455d-8071-de7c171be8db"
            )
        )
    }


    @Test
    @Requirements("REQCRM-1621")
    @Sale_Payments
    @TransactionCreateV1
    @Response_200_Ok
    @DisplayName("$transactionCreate -> 200 Ok")
    @AllureId("155156")
    fun test_TransactionCreatePositive() {
        val response = paymentsCrmClient.send(request)
        assertTrue(response)
    }
}