package ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_manager.response

import com.fasterxml.jackson.databind.JsonNode

data class SupportsGetByManagerResponse(
    val account: JsonNode?,
    val accountId: JsonNode?,
    val base: JsonNode?,
    val bizUnitId: JsonNode?,
    val bushAction360: JsonNode?,
    val bushAction360Id: JsonNode?,
    val contact: JsonNode?,
    val contactId: String?,
    val endDate: String?,
    val id: String?,
    val license: JsonNode?,
    val licenseId: String?,
    val listId: JsonNode?,
    val mainProduct: JsonNode?,
    val mainProductId: String?,
    val name: JsonNode?,
    val partner: JsonNode?,
    val partnerId: String?,
    val rejectedOn: JsonNode?,
    val startDate: String?,
    val status: Int?,
    val supportChangeReason: JsonNode?,
    val supportChangeReasonId: String?,
    val supportLicenses: JsonNode?,
    val supportType: Int?,
    val systemUser: JsonNode?,
    val systemUserId: String?
)