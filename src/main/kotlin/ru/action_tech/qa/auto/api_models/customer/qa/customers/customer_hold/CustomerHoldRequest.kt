package ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold

data class CustomerHoldRequest(
    val countryId: String?, //Идентификатор страны
    val meta: String? = null,
    val holdingTimeInSeconds: String? //время на холд клиента в секундах, если не задано то 10 минут
)