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
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.data.Company
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.helpers.api.ApiPaymentHelper.createPaymentForOrder
import ru.action_tech.qa.auto.utils.dateOfFirstDayOfMonth
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.paymentsCrmClient
import java.time.format.DateTimeFormatter

class Test_OnePayment {
    private lateinit var paymentId: String
    private lateinit var orderId: String

    private val todayDate: String by lazy { getStringTime(TODAY, DateTimeFormatter.ISO_LOCAL_DATE) }

    private val dayMinusOneDate: String by lazy {
        getStringTime(TODAY.minusDays(1), DateTimeFormatter.ISO_LOCAL_DATE)
    }

    private val dayPlusOneDate: String by lazy {
        getStringTime(TODAY.plusDays(1), DateTimeFormatter.ISO_LOCAL_DATE)
    }

    private val testCases by lazy {
        mapOf(
            "from и to = день оплаты" to Pair(todayDate, todayDate),
            "from = день оплаты -1 и to = день оплаты + 1" to Pair(dayMinusOneDate, dayPlusOneDate),
            "from = день оплаты и to = null" to Pair(todayDate, null)
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

        val subscribeId = "Сохраняем subscribeId" { ApiOrderHelper.getInfoOrder(orderId).items!!.first().id }

        paymentId = "Создаем оплату и сохраняем идентификатор" {
            createPaymentForOrder(
                orderId = orderId,
                subscribeId = subscribeId,
                accountId = Company.PAID_DEMO_ACCESS_COMPANY.id!!
            )
        }
    }

    @AfterEach
    fun tearDown() {
        if (::paymentId.isInitialized) {
            paymentsCrmClient.send(PaymentsRequests.qaPaymentDelete(paymentId = paymentId))
        }

        if (::orderId.isInitialized) {
            ApiOrderHelper.qaDeleteOrder(orderId)
        }
    }

    @HistoryIssues("ARMAP-19680")
    @Sale_Payments
    @PaymentsGetPaidOrdersByIds
    @Response_200_Ok
    @Requirements("REQCRM-1992")
    @Test
    @DisplayName("$paymentsGetPaidOrdersByIds -> 200 Ok: one payment")
    @AllureId("245222")
    fun test() {
        testCases.forEach { (testName, dates) ->
            testName {
                val (from, to) = dates

                paymentsCrmClient.send(
                    PaymentsRequests.paymentsGetPaidOrdersByIds(
                        listOf(orderId),
                        dateFrom = from,
                        dateTo = to
                    )
                ).apply {
                    "Проверяем что массив в ответе не пустой" { assertTrue(isNotEmpty()) }
                    "Проверяем что массив содержит $orderId" { assertTrue(contains(orderId)) }
                }
            }
        }
    }
}