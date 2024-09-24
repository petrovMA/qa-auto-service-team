package ru.action_tech.qa.auto.api_models.shipment.sending_contents.sendings_contents_get_by_sending_ids

data class SendingsContentsGetBySendingIdsResponse(val contents: List<Content>, val sendingId: String) {
    data class Content(
        val actionAccountId: String?,
        val adjustmentInvoiceId: String?,
        val amount: Int?,
        val articleId: String?,
        val fssId: String?,
        val id: String,
        val invoiceId: String?,
        val mcfrId: String?,
        val ndsId: String?,
        val ndsSum: Int?,
        val ndsSumBase: Int?,
        val orderContentId: String?,
        val orderId: String?,
        val partnerSubsId: String?,
        val productId: String?,
        val sendingContentNr: String?,
        val sendingContentState: Int,
        val sendingId: String?,
        val subscribeId: String?,
        val totalSum: Int?,
        val totalSumBase: Int?
    )
}