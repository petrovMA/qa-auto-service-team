package ru.action_tech.qa.auto.api_models.public_api.v1.stop_list_bind_new_customer

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNullable

data class StopListBindNewCustomerResponse(
    val availableStopListCount: Int?,
    val customer: Customer?,
    val endDate: String?,
    val id: String?,
    val partner: CommonDtoNullable?,
    val startDate: String?,
    val supportManager: CommonDtoNullable?,
    val supportStatus: String?,
    val supportType: String?
) {
    data class Customer(
        val analytic: Analytic?,
        val customerType: String?,
        val email: String?,
        val id: String?,
        val name: String?,
        val phones: List<String>?,
        val registrationCode: String?,
        val statusForPartner: Int?,
        val taxIdNumber: String?
    ) {
        data class Analytic(
            val className: String?,
            val param1Name: String?,
            val param1Value: String?,
            val param2Name: String?,
            val param2Value: String?,
            val param3Name: String?,
            val param3Value: String?,
            val salesForecast: SalesForecast?
        ) {
            data class SalesForecast(
                val name: String?,
                val value: Int?
            )
        }
    }
}