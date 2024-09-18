package ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_managers_limits_update.request

data class FacadeA360BushManagersLimitsUpdateRequest(val authorId: String?, val limits: List<Limit>?) {
    data class Limit(
        val id: String?,
        val limitCustomersInDealA360: Int?,
        val limitDealsA360: Int?
    )
}
