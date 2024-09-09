package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_paid_orders_by_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetPaidOrdersByIds
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.paymentsGetPaidOrdersByIds
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils.TODAY
import ru.action_tech.qa.auto.data.Company
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.helpers.api.ApiPaymentHelper
import ru.action_tech.qa.auto.utils.dateOfFirstDayOfMonth
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.paymentsCrmClient
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Test_MultiplePayments {
    private lateinit var paymentIds: List<String>
    private lateinit var orderId: String

    private val firstPaymentDate: LocalDate by lazy { TODAY.minusDays(4) }
    private val lastPaymentDate: LocalDate by lazy { TODAY.plusDays(4) }


    private val testCases by lazy {
        mapOf(
            "from = день первой оплаты и to = день последней оплаты" to Pair(
                getStringTime(firstPaymentDate, DateTimeFormatter.ISO_LOCAL_DATE),
                getStringTime(lastPaymentDate, DateTimeFormatter.ISO_LOCAL_DATE)
            ),
            "from = день первой оплаты + 1 и to = день последней оплаты" to Pair(
                getStringTime(firstPaymentDate.plusDays(1), DateTimeFormatter.ISO_LOCAL_DATE),
                getStringTime(lastPaymentDate, DateTimeFormatter.ISO_LOCAL_DATE)
            ),
            "from = день первой оплаты и to = день последней оплаты - 1" to Pair(
                getStringTime(firstPaymentDate, DateTimeFormatter.ISO_LOCAL_DATE),
                getStringTime(lastPaymentDate.minusDays(1), DateTimeFormatter.ISO_LOCAL_DATE)
            ),
            "from = день первой оплаты - 1" to Pair(
                getStringTime(firstPaymentDate.minusDays(1), DateTimeFormatter.ISO_LOCAL_DATE), null
            ),
        )
    }

    @BeforeEach
    fun precondition() {
        orderId = ApiOrderHelper.orderCreate(
            customerId = Company.PAID_DEMO_ACCESS_COMPANY.id!!,
            contactId = ContactPerson.TESTER_TESTEROVICH.id,
            priceId = "b6f4b90d-0834-4a2a-96f1-4970c88dd6b6",
            productId = "5b304213-6967-4636-97a4-616579e50da1",
            dateStart = getStringTime(dateOfFirstDayOfMonth(), DateTimeFormatter.ISO_LOCAL_DATE)
        ).id

        val subscribeId = "Сохраняем subscribeId" {
            ApiOrderHelper.getInfoOrder(orderId).items!!.first()
        }.id

        paymentIds = "Создаем оплаты и сохраняем идентификаторы" {
            setOf(firstPaymentDate, lastPaymentDate).map {
                ApiPaymentHelper.createPaymentInstallmentForOrder(
                    orderId = orderId,
                    subscribeId = subscribeId,
                    paymentDate = getStringTime(it, DateTimeFormatter.ISO_LOCAL_DATE)
                )
            }
        }
    }

    @AfterEach
    fun tearDown() {
        if (::paymentIds.isInitialized) {
            paymentIds.forEach {
                paymentsCrmClient.send(
                    PaymentsRequests.qaPaymentDelete(
                        paymentId = it
                    )
                )
            }
        }

        if (::orderId.isInitialized) {
            "Очистить тестовые данные" {
                ApiOrderHelper.qaDeleteOrder(orderId)
            }
        }
    }

    @HistoryIssues("ARMAP-19680")
    @Sale_Payments
    @PaymentsGetPaidOrdersByIds
    @Response_200_Ok
    @Requirements("REQCRM-1992")
    @Test
    @DisplayName("$paymentsGetPaidOrdersByIds -> 200 Ok: multiple payments")
    @AllureId("245221")
    fun test() {
        testCases.forEach { (testName, dates) ->
            testName {
                val (from, to) = dates

                paymentsCrmClient.send(
                    PaymentsRequests.paymentsGetPaidOrdersByIds(listOf(orderId), dateFrom = from, dateTo = to)
                ).apply {
                    "Проверяем что массив в ответе не пустой" { assertTrue(isNotEmpty()) }
                    "Проверяем что массив содержит $orderId" { assertTrue(contains(orderId)) }
                }
            }
        }
    }
}