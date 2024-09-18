package ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_add.request

import com.fasterxml.jackson.annotation.JsonProperty

data class SupportOpportunityAddRequest(
    val startDate: String? = null,
    val endDate: String? = null,
    val accountId: String?,
    val contactId: String? = null,
    val status: Int?,
    val partnerId: String?,
    val systemUserId: String?,
    val listId: String? = null,
    val supportChangeReasonId: String? = null,
    val bushAction360Id: String? = null,
    @get:JsonProperty(value = "isFixedDates")
    val isFixedDates: Boolean? = null,
    val isForce: Boolean? = null,
    val isCommonStopListLimit: Boolean? = null
)