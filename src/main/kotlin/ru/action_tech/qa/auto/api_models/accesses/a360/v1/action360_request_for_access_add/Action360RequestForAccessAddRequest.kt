package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable

data class Action360RequestForAccessAddRequest(
    val id: String? = null,
    val authorId: String?,
    val state: Int?,
    val accessId: String?,
    val account: Account?,
    val contacts: List<Contact>?,
    val productVersions: List<CommonDtoNameNullable>? = null,
    val productNumber: String?,
    val errorMessage: String?,
    val product: CommonDtoNameNullable? = null
)