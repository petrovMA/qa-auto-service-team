package ru.action_tech.qa.auto.api_models.managers.qa.operator_hold

data class OperatorHoldRequest(
    val qaOperatorType: Int, //Тип оператора (1 - внутренний; 2 - партнеры)
    val meta: String? = null,
    val holdingTimeInSeconds: String? //время на холд оператора в секундах, если не задано то 10 минут
)