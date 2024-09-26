package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_promocode_add

data class LicensePromoCodeAddRequest(
    val createdBy: String?,
    val createdOn: String?,
    val doneOn: String?,
    val id: String?,
    val isDone: Boolean?,
    val promoCodeId: String?,
    val result: String?,
    val taskId: String?
)