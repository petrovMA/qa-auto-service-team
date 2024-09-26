package ru.action_tech.qa.auto.api_tests.addresses.country.v1.country_get_by_id

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Addresses
import ru.action_tech.qa.auto.api_models.addresses.AddressesRequests.getCountryById
import ru.action_tech.qa.auto.api_models.addresses.CountryGetByIdV1
import ru.action_tech.qa.auto.api_models.addresses.country.v1.country_get_by_id.CountryGetListRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.addressesCrmClient


class Test_CountryGetByIdPositive {

    @Test
    @Requirements("REQCRM-1039")
    @Sale_Addresses
    @CountryGetByIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/country_get-by-id -> 200 Ok: Получение страны по id")
    @AllureId("145363")
    fun test() {
        val resp = addressesCrmClient.send(getCountryById(CountryGetListRequest("7a3586fe-0243-e811-a233-00155dfb5103")))
        assertThat(resp.id).isEqualTo("7a3586fe-0243-e811-a233-00155dfb5103")
        assertThat(resp.name).isEqualTo("Байконур")
    }
}