package ru.action_tech.qa.auto.api_models.addresses

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.addresses.country.v1.country_get_by_id.CountryGetByIdResponse
import ru.action_tech.qa.auto.api_models.addresses.country.v1.country_get_by_id.CountryGetListRequest
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.http.QueryParams


object AddressesRequests {

    fun getCountryList() = TRequest(
        desc = "Получение списка стран",
        model = Model<Array<CountryGetByIdResponse>>(),
        spec = { setContentType(ContentType.JSON) },
        send = { get(countryGetListV1) }
    )

    fun getCountryById(request: CountryGetListRequest) = TRequest(
        desc = "Получение страны по id",
        model = Model<CountryGetByIdResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            request.id?.let { addQueryParam(QueryParams.ID, it) }
        },
        send = { get(countryGetByIdV1) }
    )
}