package ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_update.request

data class SupportOpportunityA360UpdateRequest(
    val id: String?,
    val status: Int?,
    val endDate: String?,
    val supportChangeReasonId: String? = null,
    val rejectedOn: String?
)