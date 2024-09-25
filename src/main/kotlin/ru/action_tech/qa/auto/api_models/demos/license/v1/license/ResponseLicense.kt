package ru.action_tech.qa.auto.api_models.demos.license.v1.license

import java.util.UUID

data class ResponseLicense(
    val accountId: UUID?,
    val authorizeCode: String,
    val base: Any,
    val contactId: UUID?,
    val documentFlowCustomerId: UUID?,
    val domainEvents: List<Any>?,
    val id: String,
    val individualSaleApproval: Boolean?,
    val partnerAmount: Double?,
    val priceLevel: PriceLevel?,
    val priceLevelId: UUID?,
    val productId: UUID?,
    val salesOn: String?,
    val salesPartnerId: UUID?,
    val salesSubscribeId: UUID?,
    val serviceActivateOn: String?,
    val setId: String?,
    val status: Int?,
    val supportPartnerId: UUID?,
    val supportResult: SupportResult?
) {
    data class SupportResult(
        val comment: String?,
        val commentModifiedDate: String?,
        val commentModifierId: UUID?,
        val paymentPlannedDate: String?,
        val resultId: UUID?,
        val resultModifiedDate: String?,
        val resultModifierId: UUID?
    )

    data class PriceLevel(
        val domainEvents: List<Any>?,
        val id: UUID,
        val licenses: List<Any>,
        val lotPrice: List<LotPrice>
    ) {
        data class LotPrice(
            val domainEvents: List<Any>?,
            val id: String,
            val price: Double?,
            val priceCategory: Int,
            val priceList: Any,
            val priceListId: UUID?,
            val productId: String
        )
    }
}