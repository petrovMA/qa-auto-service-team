package ru.action_tech.qa.auto.api_models.customer.qa.customers.customers_unhold_by_ids

data class CustomersUnholdByIdsRequest(
    val ids: List<String>? //список ид клиентов которых нужно разблокировать
)