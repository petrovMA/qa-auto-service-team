package ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_autologin_send

data class Action360AutologinSendRequest(
    val accessId: String?,
    val bitrixId: String?,
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val managerId: String?,
    val middleName: String?
)