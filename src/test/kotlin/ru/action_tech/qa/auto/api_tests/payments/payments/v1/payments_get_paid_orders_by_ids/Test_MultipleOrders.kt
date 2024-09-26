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
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils.TODAY
import ru.action_tech.qa.auto.data.enums.Company
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.helpers.api.ApiPaymentHelper.createPaymentForOrder
import ru.action_tech.qa.auto.utils.dateOfFirstDayOfMonth
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.paymentsCrmClient
import java.time.format.DateTimeFormatter

class Test_MultipleOrders {
    private lateinit var orderIds: List<String>
    private val paymentIds: MutableList<String> by lazy { mutableListOf() }
    private val todayDate: String by lazy { getStringTime(TODAY, DateTimeFormatter.ISO_LOCAL_DATE) }

    @BeforeEach
    fun precondition() {
        orderIds = (1..2).map {
            val orderId = ApiOrderHelper.orderCreate(
                customerId = Company.PAID_DEMO_ACCESS_COMPANY.id!!,
                contactId = ContactPerson.TESTER_TESTEROVICH.id,
                priceId = "b6f4b90d-0834-4a2a-96f1-4970c88dd6b6",
                productId = "5b304213-6967-4636-97a4-616579e50da1",
                dateStart = getStringTime(dateOfFirstDayOfMonth(), DateTimeFormatter.ISO_LOCAL_DATE)
            ).id

            val subscribeId = "Сохраняем subscribeId" {
                ApiOrderHelper.getInfoOrder(orderId).items!!.first().id
            }

            val paymentId = "Создаем оплату и сохраняем идентификатор" {
                createPaymentForOrder(
                    orderId = orderId,
                    subscribeId = subscribeId,
                    accountId = Company.PAID_DEMO_ACCESS_COMPANY.id!!
                )
            }

            paymentIds.add(paymentId)
            orderId
        }
    }

    @AfterEach
    fun tearDown() {
        paymentIds.forEach {
            paymentsCrmClient.send(
                PaymentsRequests.qaPaymentDelete(
                    paymentId = it
                )
            )
        }

        if (::orderIds.isInitialized) {
            orderIds.forEach {
                ApiOrderHelper.qaDeleteOrder(it)
            }
        }
    }

    @Sale_Payments
    @PaymentsGetPaidOrdersByIds
    @Requirements("REQCRM-1992")
    @Response_200_Ok
    @Test
    @DisplayName("$paymentsGetPaidOrdersByIds -> 200 Ok: multiple orders")
    @AllureId("245220")
    fun test() {
        paymentsCrmClient.send(PaymentsRequests.paymentsGetPaidOrdersByIds(orderIds, dateFrom = todayDate))
            .apply {
                "Проверяем что массив в ответе не пустой" { assertTrue(isNotEmpty()) }
                "Проверяем что массив содержит $orderIds" { orderIds.forEach { assertTrue(contains(it)) } }
            }
    }
}

