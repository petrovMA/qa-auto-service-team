package ru.action_tech.qa.auto.api_models.managers.v1.role.roles_get

data class RolesGetResponse(
    val alias: String?,
    val description: String?,
    val groupId: String?,
    val groupName: String?,
    val id: String,
    val isVisibleInErm: Boolean,
    val name: String
)