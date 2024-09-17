package ru.action_tech.qa.auto.api_tests.payments.transactions.v1.customer_balance_get

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.CustomerBalanceGetV1
import ru.action_tech.qa.auto.api_models.payments.customerBalanceGet
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.customer_balance_get.request.CustomerBalanceGetRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_CustomerBalanceGet {

    @Test
    @Requirements("REQCRM-315")
    @Sale_Payments
    @CustomerBalanceGetV1
    @Response_200_Ok
    @DisplayName("$customerBalanceGet -> 200 Ok")
    @AllureId("145842")
    fun test_CustomerBalanceGetPositive() {
        val response = paymentsCrmClient.send(
            PaymentsRequests.customerBalanceGet(
                CustomerBalanceGetRequest(
                    customerId = "58e336fd-b0e5-4efd-aa54-458c1e170bed",
                    dateFrom = "2019-12-14T00:00:00"
                )
            )
        )
        assertEqual(response.freeSum, 429.0000)
    }
}