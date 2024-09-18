package ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_add.request

data class BushAction360AddRequest(
    val authorId: String? = null,
    val bushAction360ChangesCount: Int?,
    val factPrice: Int?,
    val factUsersAmount: Int?,
    val mainProductId: String?,
    val suggestedPrice: Int?,
    val suggestedUsersAmount: Int?
)