package ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_accept

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable

data class Action360RequestForAccessAcceptRequest(
    val aktion360RequestForAccess: Aktion360RequestForAccess?,
    val modifiedBy: String
) {
    data class Aktion360RequestForAccess(
        val accessId: String? = null,
        val account: Account?,
        val authorId: String,
        val contacts: List<Contact>,
        val id: String?,
        val productNumber: String,
        val productVersions: List<CommonDtoNameNullable>? = null,
        val state: Int
    ) {
        data class Contact(
            val additionalPhone: String,
            val email: String,
            val firstname: String,
            val id: String,
            val isError: Boolean,
            val isMaster: Boolean,
            val jobtitleId: String,
            val lastname: String,
            val middlename: String,
            val phone: String,
            val result: String? = null,
            val userId: Int? = null
        )

        data class Account(
            val id: String,
            val inn: String,
            val kpp: String,
            val name: String
        )
    }
}