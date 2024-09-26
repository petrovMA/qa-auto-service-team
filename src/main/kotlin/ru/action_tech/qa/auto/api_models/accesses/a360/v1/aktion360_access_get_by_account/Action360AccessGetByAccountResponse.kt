package ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_get_by_account

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable

data class Action360AccessGetByAccountResponse(
    val id: String,
    val serviceActivatedOn: String?,
    val serviceExpiresOn: String?,
    val blockVersion: List<CommonDtoNameNullable>?,
)