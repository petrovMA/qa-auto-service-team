package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_requests_get_by_subcribeids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseRequestsGetBySubscribeIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_EmptyResponse {

    @Test
    @Requirements("REQCRM-1899")
    @Sale_Accesses
    @LicenseRequestsGetBySubscribeIds
    @Response_200_Ok
    @DisplayName("/api/v1/license-requests_get-by-subcribeids -> 200 Ok: Пустой список")
    @AllureId("229723")
    fun test() {
        val resp = accessesCrmClient.send(AccessesRequests.licenseRequestsGetBySubscribeIds(arrayOf(DEFAULT_ID)))

        "Проверка, что возвращается пустой список".assertTrue(resp.isEmpty())
    }
}