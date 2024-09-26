package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_access_validate

data class Action360AccessValidateResponse(
    val email: String?,
    val hasAccess: Boolean,
    val hasDemoAccess: Boolean
)