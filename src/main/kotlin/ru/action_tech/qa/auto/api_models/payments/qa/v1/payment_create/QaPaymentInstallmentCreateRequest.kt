package ru.action_tech.qa.auto.api_models.payments.qa.v1.payment_create

data class QaPaymentInstallmentCreateRequest(
    val orderId: String,
    val actionAccountId: String,
    val paymentAmount: Double,
    val paymentDate: String,
    val customerEmail: String,
    val customerId: String,
    val orderItemInstallmentDiscounts: List<OrderItemInstallmentDiscounts>
) {
    data class OrderItemInstallmentDiscounts(
        val orderItemId: String,
        val orderItemAmount: Double
    )
}