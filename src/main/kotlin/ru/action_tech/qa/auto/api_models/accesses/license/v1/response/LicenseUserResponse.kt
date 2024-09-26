package ru.action_tech.qa.auto.api_models.accesses.license.v1.access_get_subscription_by_block_id.response

data class LicenseUserResponse(
    val amount: Int,
    val base: BaseResponse,
    val contactId: String,
    val id: String,
    val isMainUser: Boolean,
    val isSentInvitation: Boolean,
    val licensesId: String,
    val name: String
)