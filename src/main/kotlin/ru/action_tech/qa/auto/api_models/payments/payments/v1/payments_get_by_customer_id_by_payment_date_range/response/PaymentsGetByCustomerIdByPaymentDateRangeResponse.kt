package ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range.response

data class PaymentsGetByCustomerIdByPaymentDateRangeResponse(
    val accountId: String,
    val actionAccountId: String,
    val advanceId: String,
    val id: String,
    val paymentDate: String,
    val paymentOrderNumber: String?,
    val paymentType: Int?,
    val paymentTypeId: String?,
    val regMoneys: List<RegMoney>,
    val stringOrderingId: String?
)