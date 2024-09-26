package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade_by_product_id.request

data class LicenseByProduct(
    val authCode: String?,
    val partnerAmount: Int?,
    val productNr: String?
)