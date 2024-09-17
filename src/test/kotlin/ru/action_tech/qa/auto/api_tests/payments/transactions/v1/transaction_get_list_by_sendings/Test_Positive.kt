package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.transaction_get_list_by_sendings

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests.sendingsGetByCustomerId
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.TransactionGetListBySendingsV1
import ru.action_tech.qa.auto.api_models.payments.transactionGetListBySendings
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.ermBackendArmSellerClient
import ru.action_tech.qa.auto.utils.paymentsCrmClient

class Test_Positive {
    private val customerId = "e793cb15-afc5-4d8a-967a-aef6f94326c0"
    private lateinit var sendingIds: List<String>
    private val emptyIds: List<String> by lazy { listOf() }

    @BeforeEach
    fun getSendings() {
        sendingIds = ermBackendArmSellerClient
            .send(sendingsGetByCustomerId(customerId, limit = "20"))
            .map { it.sendingId }
    }

    @Sale_Payments
    @TransactionGetListBySendingsV1
    @Requirements("REQCRM-1701")
    @Response_200_Ok
    @DisplayName("$transactionGetListBySendings -> 200 OK : получение транзакций по отправлениям")
    @Test
    @AllureId("257609")
    fun test() {
        listOf(
            sendingIds,
            listOf(FieldData.FIRST_ID),
            emptyIds
        ).forEach { sendingIds ->
            paymentsCrmClient.send(
                PaymentsRequests.transactionGetListBySendings(
                    sendingIds = sendingIds
                )
            ).apply {
                "Все sendingId транзакций совпадают с переданными".assertTrue(all { sendingIds.contains(it.sendingId) })
            }
        }
    }
}