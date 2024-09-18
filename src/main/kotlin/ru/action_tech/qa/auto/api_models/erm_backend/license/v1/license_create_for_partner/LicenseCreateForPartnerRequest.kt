package ru.action_tech.qa.auto.api_models.erm_backend.license.v1.license_create_for_partner

data class LicenseCreateForPartnerRequest(
    val orderId: Any?,
    val saleSysUserId: Any?,
    val salePartnerId: Any? = null,
    val extensionSysUserId: Any?,
    val supportSysUserId: Any?,
    val supportPartnerId: Any?,
    val isPrevMonthRegistration: Boolean? = false
)