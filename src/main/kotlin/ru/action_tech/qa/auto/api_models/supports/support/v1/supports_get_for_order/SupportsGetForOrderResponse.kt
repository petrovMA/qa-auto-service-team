package ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_for_order

import java.util.*

data class SupportsGetForOrderResponse(
    val accountId: UUID?,
    val bizUnitId: UUID?,
    val bushAction360Id: UUID?,
    val contactId: UUID?,
    val endDate: String?,
    val id: UUID,
    val licenseId: UUID?,
    val listId: UUID?,
    val mainProductId: UUID?,
    val name: String?,
    val partnerId: UUID?,
    val rejectedOn: String?,
    val startDate: String?,
    val status: Int,
    val supportChangeReasonId: UUID?,
    val supportType: Int,
    val systemUserId: UUID?
)