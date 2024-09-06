package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_paid_orders_by_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.api_models.Response_401_Unauthorized
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetPaidOrdersByIds
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.paymentsGetPaidOrdersByIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.core.utils.DateTimeUtils.TODAY
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.paymentsCrmClient
import java.time.format.DateTimeFormatter
import java.util.*

class Test_Unauthorized {

    @Sale_Payments
    @PaymentsGetPaidOrdersByIds
    @Requirements("REQCRM-1992")
    @Response_401_Unauthorized
    @Test
    @DisplayName("$paymentsGetPaidOrdersByIds -> 401 Unauthorized")
    @AllureId("245225")
    fun test() {
        setOf(null, "", FieldData.INVALID_TOKEN, FieldData.WRONG_TOKEN).forEach { data ->
            "token = $data" soft {
                testBRUnauthorized(
                    apiClient = paymentsCrmClient,
                    request = PaymentsRequests.paymentsGetPaidOrdersByIds(
                        ids = listOf(UUID.randomUUID().toString()),
                        dateFrom = getStringTime(TODAY, DateTimeFormatter.ISO_LOCAL_DATE),
                        token = data
                    )
                )
            }
        }
    }
}