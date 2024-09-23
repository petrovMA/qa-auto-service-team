package ru.action_tech.qa.auto.api_models.customer.search.v1.customers.search_customers

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SearchCustomersRequest(
    val text: String? = null,
    val customerType: Int? = null,
    val phone: String? = null,
    val entityType: String? = null,
    val inn: String? = null,
    val kpp: String? = null,
    val orderNumber: String? = null,
    val invoiceName: String? = null,
    val bitrixId: String? = null,
    val brand: String? = null,
)
