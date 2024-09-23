package ru.action_tech.qa.auto.api_models.supports.support.v1.analysis_bush_customers_get_by_customer_ids

import com.fasterxml.jackson.databind.JsonNode

data class AnalysisBushCustomersGetByCustomerIdsResponse(
    val analysisBushesCustomers: List<JsonNode>?,
    val analysisBushesCustomersTotal: Int?,
    val clusterId: String?,
    val customerId: String,
    val customerType: Int,
    val sourceTypes: List<String>?
)