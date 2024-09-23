package ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_lists_get_by_partnerid.response

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNullable

data class StopListGetByPartnerIdResponse (
    val id: String,
    val supportType: String?,
    val supportStatus: String?,
    val availableStopListCount: Int?,
    val startDate: String?,
    val endDate: String?,
    val supportManager: CommonDtoNullable,
    val partner: CommonDtoNullable?,
    val customer: CustomerModel?
) {
    data class CustomerModel(
        val id: String?,
        val customerType: String?,
        val name: String?,
        val taxIdNumber: String?,
        val phones: List<String>?,
        val email: String?,
        val registrationCode: String?
    )
}