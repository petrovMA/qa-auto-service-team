package ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager.request

data class FacadeA360BushGetByManagerRequest(
    val systemUserId: String?,
    val number: String?,
    val customerIds: List<String>?
)