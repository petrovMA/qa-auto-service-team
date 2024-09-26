package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_replace_license_member

data class LicenseReplaceLicenseMemberRequest(
    val insId: String,
    val memberId: String,
    val orderDetailId: String?
)