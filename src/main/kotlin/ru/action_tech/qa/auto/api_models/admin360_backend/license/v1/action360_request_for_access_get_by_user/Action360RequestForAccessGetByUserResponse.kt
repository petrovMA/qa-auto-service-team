package ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_get_by_user

data class Action360RequestForAccessGetByUserResponse(
    val accountName: String?,
    val createdOn: String,
    val firstName: String?,
    val id: String,
    val inn: String?,
    val lastName: String?,
    val middleName: String?,
    val partnerName: String?,
    val result: String?,
    val status: Int?
)