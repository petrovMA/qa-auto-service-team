package ru.action_tech.qa.auto.api_models.payments.transactions.v1.transactions_get_list_by_sendings

data class TransactionGetLisBySendingsResponse(
    val accountId: String?,
    val fizId: String?,
    val fssId: String?,
    val id: String?,
    val moveSign: Int?,
    val operationName: Int?,
    val paymentId: String?,
    val salesOrderId: String?,
    val sendingContentId: String?,
    val sendingId: String?,
    val subscribeId: String?,
    val summ: Int?
)