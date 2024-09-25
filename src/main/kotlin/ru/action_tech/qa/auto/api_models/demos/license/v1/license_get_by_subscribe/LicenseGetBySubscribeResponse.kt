package ru.action_tech.qa.auto.api_models.demos.license.v1.license_get_by_subscribe

import com.fasterxml.jackson.databind.JsonNode
import java.util.*

data class LicenseGetBySubscribeResponse(
    val accountId: String?,
    val authorizeCode: String?,
    val base: JsonNode,
    val contactId: String?,
    val documentFlowCustomerId: String?,
    val domainEvents: List<JsonNode>?,
    val id: String?,
    val individualSaleApproval: Boolean?,
    val partnerAmount: Int?,
    val priceLevel: PriceLevel?,
    val priceLevelId: String?,
    val productId: UUID?,
    val salesOn: String?,
    val salesPartnerId: String?,
    val salesSubscribeId: UUID?,
    val serviceActivateOn: String?,
    val setId: String?,
    val status: Int,
    val supportPartnerId: String?,
    val supportResult: SupportResult
) {
    data class SupportResult(
        val comment: String?,
        val commentModifiedDate: String?,
        val commentModifierId: String?,
        val paymentPlannedDate: String?,
        val resultId: String?,
        val resultModifiedDate: String?,
        val resultModifierId: String?
    )

    data class PriceLevel(
        val domainEvents: List<JsonNode>?,
        val id: String,
        val licenses: List<String>,
        val lotPrice: List<LotPrice>
    ) {
        data class LotPrice(
            val domainEvents: List<JsonNode>?,
            val id: String,
            val price: Int?,
            val priceCategory: Int,
            val priceList: String?,
            val priceListId: String?,
            val productId: String?
        )
    }
}