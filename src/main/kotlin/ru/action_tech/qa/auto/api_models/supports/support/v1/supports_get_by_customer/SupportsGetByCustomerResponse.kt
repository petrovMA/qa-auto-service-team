package ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_customer

data class SupportsGetByCustomerResponse(
    val id: String,
    val name: String?,
    val supportType: Int,
    val mainProductId: String?,
    val startDate: String?,
    val endDate: String?,
    val accountId: String?,
    val contactId: String?,
    val partnerId: String?,
    val bizUnitId: String?,
    val systemUserId: String?,
    val status: Int,
    val licenseId: String?,
    val listId: String?,
    val supportChangeReasonId: String?,
    val bushAction360Id: String?,
    val rejectedOn: String?
)