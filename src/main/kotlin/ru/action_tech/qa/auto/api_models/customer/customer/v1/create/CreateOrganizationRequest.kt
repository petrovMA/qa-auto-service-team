package ru.action_tech.qa.auto.api_models.customer.customer.v1.create

import ru.action_tech.qa.auto.data.Country
import ru.action_tech.qa.auto.utils.getRandomNumberToString

data class CreateOrganizationRequest(
    val customerType: Int? = 1,
    val inn: String? = getRandomNumberToString(),
    val kpp: String? = null,
    val name: String? = "ЕРМ тест Узбекистан $inn",
    val legalFormId: String? = "e67104c7-036c-e411-82a0-78e3b502da44",
    val phoneNumber: String? = "111111111",
    val countryId: String? = Country.UZ.id
)