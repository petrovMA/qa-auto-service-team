package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable
import java.util.*

data class Action360RequestForAccessAddResponse(
    val accessId: String?,
    val account: Account?,
    val authorId: String,
    val contacts: List<Contact>?,
    val errorMessage: String?,
    val id: UUID?,
    val productNumber: String?,
    val state: Int?,
    val productVersions: List<CommonDtoNameNullable>?
)