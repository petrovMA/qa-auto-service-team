package ru.action_tech.qa.auto.api_models.managers.qa.operators_unhold_by_ids

data class OperatorsUnholdByIdsRequest(
    val ids: List<String>? //список ид операторов которых нужно разблокировать
)