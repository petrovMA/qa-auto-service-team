package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetByCustomerIdByPaymentDateRangeV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range.request.PaymentsGetByCustomerIdByPaymentDateRangeRequest
import ru.action_tech.qa.auto.api_models.payments.paymentsGetByCustomerIdByPaymentDateRange
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.CUSTOMER_TEST
import ru.action_tech.qa.auto.utils.paymentsCrmClient

class Test_PaymentsGetByCustomerIdByPaymentDateRange {

    @Test
    @Requirements("REQCRM-1619")
    @Sale_Payments
    @PaymentsGetByCustomerIdByPaymentDateRangeV1
    @Response_200_Ok
    @DisplayName("$paymentsGetByCustomerIdByPaymentDateRange -> 200 Ok: Получение оплат клиента по диапазону даты")
    @AllureId("155150")
    fun test() {
        val response = paymentsCrmClient.send(
            PaymentsRequests.paymentsGetByCustomerIdByPaymentDateRange(
                PaymentsGetByCustomerIdByPaymentDateRangeRequest(
                    customerId = CUSTOMER_TEST.customerId,
                    from = "2021-06-18",
                    to = "2022-10-28"
                )
            )
        )
        "Проверка что ответ не пустой" { assertTrue(response.isNotEmpty()) }
        "Проверка что в ответе все id = ${CUSTOMER_TEST.customerId}" {
            response.forEach { assertEqual(it.accountId, CUSTOMER_TEST.customerId) }
        }
    }
}
