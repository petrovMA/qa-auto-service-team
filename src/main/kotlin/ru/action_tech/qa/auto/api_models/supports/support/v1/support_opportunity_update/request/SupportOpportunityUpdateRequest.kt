package ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_update.request

data class SupportOpportunityUpdateRequest(
    val id: String?,
    val status: Int?,
    val endDate: String? = null,
    val supportChangeReasonId: String? = null,
    val rejectedOn: String? = null
)