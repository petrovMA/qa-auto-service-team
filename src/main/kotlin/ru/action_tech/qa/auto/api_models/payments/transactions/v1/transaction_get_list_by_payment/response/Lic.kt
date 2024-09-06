package ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_get_list_by_payment.response

data class Lic(
    val authCode: String?,
    val id: String?,
    val name: String?,
    val partnerAmount: Int?,
    val serviceActivateOn: String?,
    val serviceExpiresOn: String?
)