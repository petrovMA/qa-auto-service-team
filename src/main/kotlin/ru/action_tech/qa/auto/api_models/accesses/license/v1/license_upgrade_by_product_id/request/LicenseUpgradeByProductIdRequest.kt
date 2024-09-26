package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade_by_product_id.request

data class LicenseUpgradeByProductIdRequest(
    val authorId: String?,
    val licenseByProduct: List<LicenseByProduct>?
)