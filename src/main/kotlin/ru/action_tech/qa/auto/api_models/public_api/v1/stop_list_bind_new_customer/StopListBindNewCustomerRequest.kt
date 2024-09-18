package ru.action_tech.qa.auto.api_models.public_api.v1.stop_list_bind_new_customer

data class StopListBindNewCustomerRequest(
    val comment: String?,
    val customerType: Int?,
    val email: String?,
    val extension: String?,
    val firstName: String?,
    val inn: String?,
    val kpp: String?,
    val lastName: String?,
    val middleName: String?,
    val name: String?,
    val partnerId: String?,
    val phoneNumber: String?,
    val countryId: String? = null
)