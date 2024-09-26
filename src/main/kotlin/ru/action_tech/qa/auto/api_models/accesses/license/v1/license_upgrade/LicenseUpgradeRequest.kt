package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade

data class LicenseUpgradeRequest(
    val campaignId: String?,
    val code: String?,
    val licenseId: String?,
    val priceLevelId: String?,
    val userId: String?
)