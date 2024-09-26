package ru.action_tech.qa.auto.api_tests.addresses.country.v1.country_get_by_id

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Addresses
import ru.action_tech.qa.auto.api_models.addresses.AddressesRequests
import ru.action_tech.qa.auto.api_models.addresses.CountryGetByIdV1
import ru.action_tech.qa.auto.api_models.addresses.country.v1.country_get_by_id.CountryGetListRequest
import ru.action_tech.qa.auto.api_models.addresses.countryGetByIdV1
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.addressesCrmClient


class Test_CountryGetByIdNoIdBadRequest {

    @Test
    @HistoryIssues("ARMAP-11275")
    @Requirements("REQCRM-1039")
    @Sale_Addresses
    @CountryGetByIdV1
    @Response_400_Bad_Request
    @DisplayName("$countryGetByIdV1 -> 400 Bad Request: Не передан ID")
    @AllureId("145361")
    fun testNoId() {
        checkBR(
            apiClient = addressesCrmClient,
            request = AddressesRequests.getCountryById(CountryGetListRequest(null)),
            BrokenRule(1, "Параметр обязателен для заполнения")
        )
    }


    @Test
    @HistoryIssues("ARMAP-11275")
    @Requirements("REQCRM-1039")
    @Sale_Addresses
    @CountryGetByIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/country_get-by-id -> 400 Bad Request: Не корректный ID")
    @AllureId("145362")
    fun testWrongId() {
        checkBR(
            apiClient = addressesCrmClient,
            request = AddressesRequests.getCountryById(CountryGetListRequest(DEFAULT_ID)),
            expected = setOf( BrokenRule(2, "Запись по переданному параметру не найдена"))
        )
    }
}