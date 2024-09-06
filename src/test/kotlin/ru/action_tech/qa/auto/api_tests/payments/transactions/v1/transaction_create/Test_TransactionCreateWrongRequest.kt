package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.transaction_create

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.TransactionCreateV1
import ru.action_tech.qa.auto.api_models.payments.transactionCreate
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_create.request.TransactionCreateRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_TransactionCreateWrongRequest {


    @Test
    @Requirements("REQCRM-1621")
    @HistoryIssues("ARMAP-15091")
    @Sale_Payments
    @TransactionCreateV1
    @Response_400_Bad_Request
    @DisplayName("$transactionCreate -> 400 Bad Request: Содержимое заказа не существует")
    @AllureId("155155")
    fun test_TransactionCreatePositive() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.transactionCreate(
                TransactionCreateRequest(
                    id = "7be40d2a-6e89-4387-be2d-05ac4b0d3122",
                    salesOrderId = "f4df308c-a3e3-4928-a400-920579a5d399",
                    subscribeId = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
                )
            ),
            expected = setOf(CheckBadRequests.BrokenRule(code = 10, message = "Содержимое заказа не существует"))
        )
    }

    @Test
    @Requirements("REQCRM-1621")
    @HistoryIssues("ARMAP-15091")
    @Sale_Payments
    @TransactionCreateV1
    @Response_400_Bad_Request
    @DisplayName("$transactionCreate -> 400 Bad Request: Заказ не существует")
    @AllureId("155154")
    fun test() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.transactionCreate(
                TransactionCreateRequest(
                    id = "7be40d2a-6e89-4387-be2d-05ac4b0d3122",
                    salesOrderId = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                    subscribeId = "a053e782-c797-455d-8071-de7c171be8db"
                )
            ),
            expected = setOf(CheckBadRequests.BrokenRule(code = 9, message = "Заказ не существует"))
        )
    }
}