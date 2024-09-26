package ru.action_tech.qa.auto.api_models.accesses.license.v1.access_change_master_user

data class AccessChangeMasterUserRequest(
    val contactId: String,
    val licenseId: String
)