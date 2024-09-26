package ru.action_tech.qa.auto.api_models.accesses.license.v1.multi_access_statistic_get_by_access_id

data class MultiAccessStatisticGetByAccessIdResponse(
    val duration: Int?,
    val userId: Int?,
    val visitDate: String?,
    val visitedSite: String?
)