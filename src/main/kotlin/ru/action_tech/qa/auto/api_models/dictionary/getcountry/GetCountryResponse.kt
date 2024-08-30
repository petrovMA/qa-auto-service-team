package ru.action_tech.qa.auto.api_models.dictionary.getcountry

import java.util.*

data class GetCountryResponse(
    val countryId: UUID,
    val name: String?,
    val showInShowcase: Boolean?,
    val countryCode: String?,
    val iso: String?,
    val code: String?,
    val phoneMask: String?
)