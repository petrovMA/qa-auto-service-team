package ru.action_tech.qa.auto.api_models.payments.transactions.v1.customer_balance_get.request

data class CustomerBalanceGetRequest(
    val customerId: String?,
    val paymentAccountId: String? = null,
    val dateFrom: String? = null
)
