package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade

data class LicenseUpgradeResponse(
    val authorizeCode: String?,
    val error: String?,
    val taskId: String?
)