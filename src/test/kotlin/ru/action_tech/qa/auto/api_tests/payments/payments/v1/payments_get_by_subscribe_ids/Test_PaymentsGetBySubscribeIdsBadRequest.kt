package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_by_subscribe_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetBySubscribeIdsV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.paymentsGetBySubscribeIds
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_PaymentsGetBySubscribeIdsBadRequest {

    @Test
    @Requirements("REQCRM-1620")
    @HistoryIssues("ARMAP-15090")
    @Sale_Payments
    @PaymentsGetBySubscribeIdsV1
    @Response_400_Bad_Request
    @DisplayName("$paymentsGetBySubscribeIds -> 400 Bad Request: не корректный id")
    @AllureId("155152")
    fun testWrongId() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.paymentsGetBySubscribeIds(listOf("664537a1-af68-4c79-afd6")),
            expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }


    @Test
    @Requirements("REQCRM-1620")
    @HistoryIssues("ARMAP-15090")
    @Sale_Payments
    @PaymentsGetBySubscribeIdsV1
    @Response_400_Bad_Request
    @DisplayName("$paymentsGetBySubscribeIds -> 400 Bad Request: нет параметров")
    @AllureId("155151")
    fun testNoParams() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.paymentsGetBySubscribeIds(),
            expected = setOf(BrokenRule(code = 8, message = "Список Ids содержимых заказа пустой"))
        )
    }
}