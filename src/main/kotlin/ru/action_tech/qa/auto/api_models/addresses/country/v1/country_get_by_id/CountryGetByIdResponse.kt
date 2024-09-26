package ru.action_tech.qa.auto.api_models.addresses.country.v1.country_get_by_id

data class CountryGetByIdResponse(
    val centerId: String?,
    val countryCode: String?,
    val createDate: String?,
    val createdBy: String?,
    val id: String?,
    val internationalCode: String?,
    val isDeleted: Boolean?,
    val isRussia: Boolean?,
    val iso: String?,
    val modifiedBy: String?,
    val modifyDate: String?,
    val name: String?,
    val phoneMask: String?,
    val showInShowcase: Boolean?
)