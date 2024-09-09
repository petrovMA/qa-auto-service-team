package ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_create.request

data class TransactionCreateRequest(
    val accountId: String? = null,
    val fizId: String? = null,
    val fssId: String? = null,
    val id: String,
    val moveSign: Int? = null,
    val operationName: Int? = null,
    val paymentId: String? = null,
    val salesOrderId: String,
    val sendingContentId: String? = null,
    val sendingId: String? = null,
    val subscribeId: String,
    val summ: Int? = null
)