package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_moderate.request

data class Aktion360RequestForAccess(
    val accessId: String?,
    val account: Account?,
    val authorId: String?,
    val contacts: List<Contact>?,
    val errorMessage: String?,
    val id: String?,
    val productNumber: String?,
    val state: Int?
)