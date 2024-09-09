package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_paid_orders_by_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRuleTechnical
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBRTech
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetPaidOrdersByIds
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.paymentsGetPaidOrdersByIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils.TODAY
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.paymentsCrmClient
import java.time.format.DateTimeFormatter
import java.util.*

class Test_BadRequest {

    private val todayDate: String by lazy {
        getStringTime(TODAY.minusDays(7), DateTimeFormatter.ISO_LOCAL_DATE)
    }

    private val testsData by lazy {
        mapOf(
            "Не переданы order ids" to {
                checkBRTech(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        dateFrom = todayDate,
                    ),
                    expected = setOf(BrokenRuleTechnical(message1 = "The", message2 = "field is required."))
                )
            },
            "Передан массив ids с null" to {
                checkBR(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(null),
                        dateFrom = todayDate,
                    ),
                    expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
                )
            },
            "Передан массив ids с пустой строкой" to {
                checkBR(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(""),
                        dateFrom = todayDate,
                    ),
                    expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
                )
            },
            "Передан массив ids с невалидным id" to {
                checkBR(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(FieldData.INVALID_ID),
                        dateFrom = todayDate,
                    ),
                    expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
                )
            },
            "Не передан from" to {
                checkBRTech(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(UUID.randomUUID().toString()),
                    ),
                    expected = setOf(BrokenRuleTechnical(message1 = "The", message2 = "field is required."))
                )
            },
            "from = null" to {
                checkBRTech(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(UUID.randomUUID().toString()),
                        dateFrom = "null"
                    ),
                    expected = setOf(BrokenRuleTechnical(message1 = "The value", message2 = "is not valid."))
                )
            },
            "from = пустая строка" to {
                checkBRTech(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(UUID.randomUUID().toString()),
                        dateFrom = ""
                    ),
                    expected = setOf(BrokenRuleTechnical(message1 = "The value ", message2 = " is invalid."))
                )
            },
            "to = null" to {
                checkBRTech(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(UUID.randomUUID().toString()),
                        dateFrom = todayDate,
                        dateTo = "null"
                    ),
                    expected = setOf(BrokenRuleTechnical(message1 = "The value", message2 = "is not valid."))
                )
            },
            "to = не валиден" to {
                checkBRTech(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(UUID.randomUUID().toString()),
                        dateFrom = todayDate,
                        dateTo = "qwerty"
                    ),
                    expected = setOf(BrokenRuleTechnical(message1 = "The value", message2 = "is not valid."))
                )
            },
        )
    }

    @Sale_Payments
    @Response_400_Bad_Request
    @PaymentsGetPaidOrdersByIds
    @Requirements("REQCRM-1992")
    @Test
    @DisplayName("$paymentsGetPaidOrdersByIds -> 400 bad request")
    @AllureId("245224")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}