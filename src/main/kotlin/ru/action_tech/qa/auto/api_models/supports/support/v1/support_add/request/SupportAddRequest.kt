package ru.action_tech.qa.auto.api_models.supports.support.v1.support_add.request

data class SupportAddRequest(
    val supportType: Int?,
    val mainProductId: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val accountId: String? = null,
    val contactId: String? = null,
    val partnerId: String?,
    val systemUserId: String?,
    val status: Int?,
    val licenseId: String? = null,
    val listId: String? = null,
    val supportChangeReasonId: String? = null,
    val bushAction360Id: String? = null
)