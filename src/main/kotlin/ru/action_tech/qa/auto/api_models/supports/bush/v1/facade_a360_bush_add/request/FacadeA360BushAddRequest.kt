package ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_add.request

data class FacadeA360BushAddRequest(
    val customerIds: List<String>?,
    val factPrice: Int?,
    val factUsersAmount: Int?,
    val mainProductId: String?,
    val systemUserId: String?
)