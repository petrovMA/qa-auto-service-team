package ru.action_tech.qa.auto.api_models.erm_backend.order.v1.order_get_license_preview

import java.util.*

data class OrderGetLicensePreviewResponse(
    val orderId: UUID,

    val saleSysUserId: UUID?, //менеджер продажи
    val canEditSaleSysUserId: Boolean,
    val saleSysUserName: String?,

    val salePartnerId: UUID?, //бэкофис продажи
    val canEditSalePartnerId: Boolean,
    val salePartnerName: String,

    val extensionSysUserId: UUID?, //менеджер расширения
    val canEditExtensionSysUserId: Boolean,
    val extensionSysUserName: String?,

    val extensionPartnerId: UUID?, //бэкофис расширения
    val canEditExtensionPartnerId: Boolean,
    val extensionPartnerName: String?,

    val supportSysUserId: UUID?, //менеджер сопровождения
    val supportSysUserName: String?,
    val canEditSupportSysUserId: Boolean,

    val supportPartnerId: UUID?, //бэкофис сопровождения
    val canEditSupportPartnerId: Boolean,
    val supportPartnerName: String?,

    val orderNumber: String?,
    val customerPin: String?,
    val customerName: String?,
    val customerInn: String?,
    val customerKpp: String?,
    val paymentScenarioName: String?,
    val contactName: String?,
    val contactJobName: String?,
    val productCount: Int,
    val totalAmount: Double,
    val products: List<Product>?,
    val availablePartners: List<AvailablePartner>?,
    val availableManagers: List<AvailableManager>?,
    val isPrevMonthRegistrationAllowed: Boolean,
    val statusJur: String?,
    val statusSs: String?,
    val statusA360: String?,
    val orderSupportTypes: List<Int>?,
    val userIsRegistrar: Boolean
) {
    data class Product(
        val productId: String,
        val productName: String?,
        val programName: String?,
        val licenseTypeCode: Int?,
        val userName: String?,
        val userEmail: String?,
        val userJobName: String?,
        val startAt: String,
        val endAt: String,
        val amount: Double
    )

    data class AvailablePartner(
        val newPartnerId: UUID,
        val newPartnerName: String?,
        val newPartnerFullName: String?,
        val newPartnerEmail: String?,
        val newPartnerShortname: String?
    )

    data class AvailableManager(
        val id: UUID,
        val fullName: String?
    )
}