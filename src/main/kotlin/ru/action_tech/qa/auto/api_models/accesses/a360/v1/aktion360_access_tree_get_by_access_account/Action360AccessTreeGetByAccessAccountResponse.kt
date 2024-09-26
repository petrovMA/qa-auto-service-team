package ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_tree_get_by_access_account

data class Action360AccessTreeGetByAccessAccountResponse(
    val id: String,
    val productId: String?,
    val serviceActivatedOn: String?,
    val serviceExpiresOn: String?,
    val authCode: String?,
    val isDemo: Boolean,
    val children: Any?
)