package ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_add

import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_accept.Action360RequestForAccessAcceptRequest
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable

data class Action360RequestForAccessAddRequest(
    val accessId: String? = null,
    val account: Action360RequestForAccessAcceptRequest.Aktion360RequestForAccess.Account? = null,
    val authorId: String,
    val contacts: List<AccessAddContact>,
    val id: String? = null,
    val productNumber: String? = null,
    val state: Int? = null,
    val productVersions: List<CommonDtoNameNullable>? = null,
    val product: CommonDtoNameNullable? = null
) {
    data class AccessAddContact(
        val id: String?,
        val lastname: String?,
        val firstname: String?,
        val middlename: String?,
        val jobtitleId: String?,
        val email: String?,
        val phone: String?,
        val additionalPhone: String? = null,
        val isMaster: Boolean? = null,
        val result: String? = null
    )
}