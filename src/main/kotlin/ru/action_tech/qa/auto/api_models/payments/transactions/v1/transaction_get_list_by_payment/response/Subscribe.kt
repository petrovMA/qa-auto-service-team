package ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_get_list_by_payment.response

data class Subscribe(
    val amount: Int?,
    val discount: Int?,
    val finalCost: Int?,
    val finalNdsSumm: Int?,
    val id: String?,
    val licSum: Int?,
    val lics: List<Lic>?,
    val name: String?,
    val ndsRate: Int?,
    val ndsSumm: Int?,
    val partnerAdditionalDiscountSum: Int?,
    val partnerDiscountSum: Int?,
    val partnerOrderPercentDiscount: Int?,
    val partnerSupportChannel: PartnerSupportChannel?,
    val paymentStatus: Int?,
    val price: Int?,
    val sendingContents: List<SendingContent>?,
    val shouldUpdate: Boolean?,
    val sodSumm: Int?,
    val subsWeight: Int?,
    val sum: Int?,
    val sumBase: Int?,
    val totalDiscountSumm: Int?,
    val totalItemsSumm: Int?,
    val totalSumm: Int?
)