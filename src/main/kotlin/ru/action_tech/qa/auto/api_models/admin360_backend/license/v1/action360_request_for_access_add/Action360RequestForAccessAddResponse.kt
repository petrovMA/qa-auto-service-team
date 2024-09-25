package ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_add

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable

data class Action360RequestForAccessAddResponse(
    val accessId: String?,
    val account: Account,
    val authorId: String?,
    val contacts: List<Contact>,
    val errorMessage: String?,
    val id: String,
    val maxUsersAmount: Int,
    val productNumber: String,
    val state: Int?,
    val productVersion: List<CommonDtoNameNullable>?
) {
    data class Contact(
        val additionalPhone: String,
        val email: String?,
        val firstname: String?,
        val id: String?,
        val isError: Boolean,
        val isMaster: Boolean,
        val jobtitleId: String?,
        val lastname: String?,
        val middlename: String?,
        val phone: String?,
        val result: String?,
        val userId: Int?
    )

    data class Account(val id: String, val inn: String, val kpp: String, val name: String)
}