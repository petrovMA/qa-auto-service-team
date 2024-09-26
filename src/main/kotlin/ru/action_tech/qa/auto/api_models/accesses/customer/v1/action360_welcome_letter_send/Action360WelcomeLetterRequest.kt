package ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_welcome_letter_send

data class Action360WelcomeLetterRequest(
    val accessId: String?,
    val bitrixId: String?,
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val managerId: String?,
    val middleName: String?
)