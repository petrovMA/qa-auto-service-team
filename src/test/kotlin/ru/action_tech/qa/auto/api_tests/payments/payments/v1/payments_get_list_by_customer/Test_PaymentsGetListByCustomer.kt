package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_list_by_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetListByCustomerV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_PaymentsGetListByCustomer {

    private val custId = "25aebe41-7333-418c-87f9-fddd3a007893"


    @Test
    @Requirements("REQCRM-313")
    @Sale_Payments
    @PaymentsGetListByCustomerV1
    @Response_200_Ok
    @DisplayName("/api/v1/payments_get-list-by-customer -> 200 ok")
    @AllureId("145839")
    fun test() {
        val response = paymentsCrmClient.send(PaymentsRequests.paymentsGetListByCustomer(arrayOf(custId)))

        "Ответ должен содержать данные".assertTrue(response.isNotEmpty())

        "Проверка что в ответе содержатся только custId = $custId" {
            response.forEach { assertEqual(it.customer?.id, custId) }
        }
    }
}