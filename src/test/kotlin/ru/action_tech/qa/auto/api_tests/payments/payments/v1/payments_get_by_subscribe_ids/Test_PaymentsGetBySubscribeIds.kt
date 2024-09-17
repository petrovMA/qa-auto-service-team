package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_by_subscribe_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetBySubscribeIdsV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.paymentsGetBySubscribeIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.paymentsCrmClient
import java.net.HttpURLConnection


class Test_PaymentsGetBySubscribeIds {

    private val subsId = "664537a1-af68-4c79-afd6-1b15cfe10c4d"

    private val request by lazy {
        PaymentsRequests.paymentsGetBySubscribeIds(listOf(subsId)).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }


    @Test
    @Requirements("REQCRM-1620")
    @Sale_Payments
    @PaymentsGetBySubscribeIdsV1
    @Response_200_Ok
    @DisplayName("$paymentsGetBySubscribeIds -> 200 ok")
    @AllureId("155153")
    fun test_PaymentsGetBySubscribeIdsPositive() {
        val response = paymentsCrmClient.send(request)
        "Проверка что ответ не пустой" { assertTrue(response.isNotEmpty()) }
    }
}