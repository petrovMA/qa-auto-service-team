package ru.action_tech.qa.auto.api_models.supports.support.v1.supports_change_manager.request

data class SupportsChangeManagerRequest(
    val modifiedBy: String?,
    val newManagerId: String?,
    val partnerId: String?,
    val supportsId: List<String>?
)