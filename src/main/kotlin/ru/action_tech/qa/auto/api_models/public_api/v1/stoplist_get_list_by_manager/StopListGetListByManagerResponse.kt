package ru.action_tech.qa.auto.api_models.public_api.v1.stoplist_get_list_by_manager

import java.util.*

data class StopListGetListByManagerResponse(
    val id: UUID,
    val customerId: UUID,
    val pin: String?,
    val inn: String?,
    val customerName: String?,
    val contactInfo: List<ContactInfo?>?,
    val supportStatus: String?,
    val supportStatusA360: String?,
    val endDate: String?,
    val remainStopLists: Int?,
    val maxSupportCount: Int,
    val customerType: Int,
    val operatorFullName: String?,
    val customerSizeName: String?,
    val income: Double?,
    val accountingType: String?,
    val rating: Int?,
) {
    data class ContactInfo(
        val name: String?,
        val type: Int,
    )
}
