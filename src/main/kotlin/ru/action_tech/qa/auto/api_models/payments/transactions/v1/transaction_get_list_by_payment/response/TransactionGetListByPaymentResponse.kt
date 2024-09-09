package ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_get_list_by_payment.response

data class TransactionGetListByPaymentResponse(
    val author: Author?,
    val basisdocId: String?,
    val createdOn: String?,
    val customer: Customer?,
    val id: String?,
    val moveSign: MoveSign?,
    val number: String?,
    val order: Order?,
    val payment: Payment?,
    val product: Product?,
    val subscribe: Subscribe?,
    val sum: Int?,
    val type: Type?
)