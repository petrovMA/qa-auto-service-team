package ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.request

data class OpportunityA360GetByBushAction360SupportStatusesRequest(
    val bushAction360Id: String? = null,
    val supportStatuses: List<Int>? = null
)
