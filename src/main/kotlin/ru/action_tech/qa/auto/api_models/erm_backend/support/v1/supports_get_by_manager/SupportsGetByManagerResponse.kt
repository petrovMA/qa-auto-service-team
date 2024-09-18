package ru.action_tech.qa.auto.api_models.erm_backend.support.v1.supports_get_by_manager

data class SupportsGetByManagerResponse(
    val customerId: String,
    val customerName: String,
    val customerPin: String,
    val supportId: String
)
