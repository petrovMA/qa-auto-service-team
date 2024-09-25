package ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.access_slaves_get_by_id

import java.util.*

data class AccessSlavesGetByIdResponse(
    val contactId: UUID,
    val email: String?,
    val jobtitle: String?,
    val name: String?,
    val pin: String?,
    val requestDate: String?,
    val userId: Int?
)