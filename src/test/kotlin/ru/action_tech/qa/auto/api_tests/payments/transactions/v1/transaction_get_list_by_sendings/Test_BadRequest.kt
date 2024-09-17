package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.transaction_get_list_by_sendings

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.TransactionGetListBySendingsV1
import ru.action_tech.qa.auto.api_models.payments.transactionGetListBySendings
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.paymentsCrmClient

class Test_BadRequest {
    private val testsData by lazy {
        setOf(
            "sendingIds не передан" to {
                checkBR(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.transactionGetListBySendings(
                        sendingIds = null
                    ),
                    expected = CheckBadRequests.BrokenRuleWithDevMessage(
                        code = 0,
                        messages = listOf("Передан не валидный Ids")
                    )
                )
            },
            "sendingIds содержит не валидный ids" to {
                checkBR(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.transactionGetListBySendings(sendingIds = listOf(FieldData.INVALID_ID)),
                    expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
                )
            },
            "sendingIds содержит null" to {
                checkBR(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.transactionGetListBySendings(sendingIds = listOf(null)),
                    expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
                )
            },
            "sendingIds содержит валидный и не валидный id" to {
                checkBR(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.transactionGetListBySendings(
                        sendingIds = listOf(FieldData.INVALID_ID, FieldData.FIRST_ID)
                    ),
                    expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
                )
            },
        )
    }

    @Sale_Payments
    @TransactionGetListBySendingsV1
    @Requirements("REQCRM-1701")
    @Response_400_Bad_Request
    @DisplayName("$transactionGetListBySendings -> 400 Bad Request")
    @Test
    @AllureId("257608")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}