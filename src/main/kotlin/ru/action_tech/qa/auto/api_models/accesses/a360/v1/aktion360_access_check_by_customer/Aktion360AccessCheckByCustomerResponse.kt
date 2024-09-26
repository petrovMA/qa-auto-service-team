package ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_check_by_customer

data class Aktion360AccessCheckByCustomerResponse(
    val customerId: String?,
    val isExist: Boolean,
    val licenseId: String?,
    val productId: String?,
    val serviceActivateOn: String?,
    val serviceExpiresOn: String?
)