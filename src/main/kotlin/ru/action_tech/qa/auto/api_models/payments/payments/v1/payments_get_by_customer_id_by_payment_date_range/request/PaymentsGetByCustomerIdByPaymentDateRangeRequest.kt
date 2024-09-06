package ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range.request

data class PaymentsGetByCustomerIdByPaymentDateRangeRequest(
    val customerId: String? = null,
    val from: String? = null,
    val to: String? = null
)