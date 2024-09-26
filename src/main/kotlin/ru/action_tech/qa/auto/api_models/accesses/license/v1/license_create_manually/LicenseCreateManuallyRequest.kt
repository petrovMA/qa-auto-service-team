package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_create_manually

data class LicenseCreateManuallyRequest(
    val dateBegin: String,
    val dateEnd: String,
    val memberId: String?,
    val orderDetailId: String,
    val orderId: String?,
    val insId: String
)