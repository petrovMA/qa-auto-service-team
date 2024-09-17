package ru.action_tech.qa.auto.api_tests.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Response_401_Unauthorized
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.PaymentsGetByCustomerIdByPaymentDateRangeV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range.request.PaymentsGetByCustomerIdByPaymentDateRangeRequest
import ru.action_tech.qa.auto.api_models.payments.paymentsGetByCustomerIdByPaymentDateRange
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.CUSTOMER_TEST
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.paymentsCrmClient


class Test_PaymentsGetByCustomerIdByPaymentDateRangeBadRequest {

    @Test
    @Requirements("REQCRM-1619")
    @Sale_Payments
    @PaymentsGetByCustomerIdByPaymentDateRangeV1
    @Response_400_Bad_Request
    @DisplayName("$paymentsGetByCustomerIdByPaymentDateRange -> 400 Bad Request: Dates value is not valid.")
    @AllureId("160103")
    fun testWrongIdFormat() {
        val fromDate = "2011"
        val toDate = "2012"
        val request by lazy {
            PaymentsRequests.paymentsGetByCustomerIdByPaymentDateRange(
                PaymentsGetByCustomerIdByPaymentDateRangeRequest(CUSTOMER_TEST.customerId, fromDate, toDate)
            )
        }

        checkBR(
            apiClient = paymentsCrmClient,
            request = request,
            expected = setOf(
                CheckBadRequests.BrokenRule(code = 0, message = "The value '$toDate' is not valid."),
                CheckBadRequests.BrokenRule(code = 0, message = "The value '$fromDate' is not valid.")
            )
        )
    }


    @Test
    @Requirements("REQCRM-1619")
    @Sale_Payments
    @PaymentsGetByCustomerIdByPaymentDateRangeV1
    @Response_400_Bad_Request
    @DisplayName("$paymentsGetByCustomerIdByPaymentDateRange -> 400 Bad Request: Id value is not valid.")
    @AllureId("177535")
    fun testEmptyString() {
        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.paymentsGetByCustomerIdByPaymentDateRange(
                PaymentsGetByCustomerIdByPaymentDateRangeRequest("")
            ),
            expected = setOf(CheckBadRequests.BrokenRule(code = 0, message = "The value '' is invalid."))
        )
    }


    @Test
    @Requirements("REQCRM-1619")
    @Sale_Payments
    @PaymentsGetByCustomerIdByPaymentDateRangeV1
    @Response_401_Unauthorized
    @DisplayName("$paymentsGetByCustomerIdByPaymentDateRange -> 401 Unauthorized")
    @AllureId("160102")
    fun test() {
        testBRUnauthorized(
            apiClient = paymentsCrmClient, request = PaymentsRequests.paymentsGetByCustomerIdByPaymentDateRange(
                PaymentsGetByCustomerIdByPaymentDateRangeRequest(
                    customerId = CUSTOMER_TEST.customerId,
                    from = "2021-06-18",
                    to = "2022-10-28"
                ),
                token = DEFAULT_ID
            )
        )
    }



    @Test
    @Requirements("REQCRM-1619")
    @Sale_Payments
    @PaymentsGetByCustomerIdByPaymentDateRangeV1
    @Response_400_Bad_Request
    @DisplayName("$paymentsGetByCustomerIdByPaymentDateRange -> 400 Bad Request: Id value is not valid.")
    @AllureId("155149")
    fun testIdNotValid() {
        val custId = "a12e8520-770-4498-8c5f-e8ff274ebed3"

        checkBR(
            apiClient = paymentsCrmClient,
            request = PaymentsRequests.paymentsGetByCustomerIdByPaymentDateRange(
                PaymentsGetByCustomerIdByPaymentDateRangeRequest(custId, "2021-06-18", "2022-10-28")
            ),
            expected = setOf(CheckBadRequests.BrokenRule(code = 0, message = "The value '$custId' is not valid."))
        )
    }
}
