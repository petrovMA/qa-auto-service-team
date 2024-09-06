package ru.action_tech.qa.auto.api_models.payments.transactions.v1.customer_balance_get.response

data class CustomerBalanceGetResponse(
    val freeSum: Double?,
    val usedSum: Double?
)