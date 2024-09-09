package ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range.response

data class RegMoney(
    val accountId: String?,
    val fizId: String?,
    val fssId: String?,
    val id: String,
    val moveSign: Int?,
    val operationName: Int?,
    val paymentId: String?,
    val salesOrderId: String,
    val sendingContentId: String?,
    val sendingId: String?,
    val subscribeId: String,
    val summ: Int?
)