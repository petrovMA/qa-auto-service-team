package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade_by_product_id

data class LicenseUpgradeByProductIdResponse(
    val authorizeCode: String?,
    val error: String?,
    val taskId: String?
)