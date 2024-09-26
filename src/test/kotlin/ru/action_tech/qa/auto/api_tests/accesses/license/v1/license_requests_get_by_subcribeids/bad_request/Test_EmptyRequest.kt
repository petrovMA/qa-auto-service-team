package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_requests_get_by_subcribeids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseRequestsGetBySubscribeIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_EmptyRequest {

    @Test
    @Requirements("REQCRM-1899")
    @Sale_Accesses
    @LicenseRequestsGetBySubscribeIds
    @Response_400_Bad_Request
    @DisplayName("/api/v1/license-requests_get-by-subcribeids -> 400 Bad Request: Пустой массив subscribeIds")
    @AllureId("229721")
    fun test() {
        arrayOf(emptyArray<Int>(), null).forEach {
            checkBR(
                apiClient = accessesCrmClient,
                request = AccessesRequests.licenseRequestsGetBySubscribeIds(it),
                expected = setOf(BrokenRule(105, "Список Ids содержимых заказа пустой"))
            )
        }
    }
}