package ru.action_tech.qa.auto.api_models.admin360_backend.customer.v1.contact_get_by_id

data class ContactGetByIdResponse(
    val bitrixId: String,
    val email: String,
    val id: String,
    val jobTitleName: String,
    val name: String,
    val pin: String
)