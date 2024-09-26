package ru.action_tech.qa.auto.api_models.erm_backend.license.v1.license_get_susbcribe_info

import java.util.*

data class LicenseGetSubscribeInfoResponse(
    val address: String?,
    val aditionalFood: Int?,
    val aditionalOther: String?,
    val aditionalPlace: Int?,
    val authorizeCode: String?,
    val cheked: Boolean,
    val contactInfoId: UUID,
    val dateBegin: String,
    val dateEnd: String,
    val dateIns: String,
    val dateMod: String?,
    val email: String?,
    val id: UUID,
    val idCustomer: UUID,
    val name: String?,
    val phone: String?
)