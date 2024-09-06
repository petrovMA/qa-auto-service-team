package ru.action_tech.qa.auto.api_models.payments.qa.v1.payment_create

data class QaPaymentCreateRequest(
    val accountId: String,
    val actionAccountId: String,
    val regMoneys: List<RegMoney>
) {
    data class RegMoney(
        val subscribeId: String,
        val summ: Double?
    )
}