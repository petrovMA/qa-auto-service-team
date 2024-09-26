package ru.action_tech.qa.auto.api_tests.addresses.country.v1.country_get_list

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Addresses
import ru.action_tech.qa.auto.api_models.addresses.AddressesRequests
import ru.action_tech.qa.auto.api_models.addresses.CountryGetListV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.addressesCrmClient


class Test_CountryGetList {

    @Test
    @Requirements("REQCRM-1038")
    @Sale_Addresses
    @CountryGetListV1
    @Response_200_Ok
    @DisplayName("/api/v1/country_get-list -> 200 Ok: Получение списка стран")
    @AllureId("145364")
    fun test() {
        assertThat(addressesCrmClient.send(AddressesRequests.getCountryList())).isNotEmpty
    }
}