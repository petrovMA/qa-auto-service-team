package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_moderate.request

data class Contact(
    val additionalPhone: String?,
    val email: String?,
    val firstname: String?,
    val id: String?,
    val isMaster: Boolean?,
    val jobtitleId: String?,
    val lastname: String?,
    val middlename: String?,
    val phone: String?,
    val result: String?,
    val userId: Int?
)