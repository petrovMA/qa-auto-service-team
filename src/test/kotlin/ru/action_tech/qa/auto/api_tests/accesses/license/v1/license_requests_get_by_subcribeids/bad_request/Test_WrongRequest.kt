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


class Test_WrongRequest {

    @Test
    @Requirements("REQCRM-1899")
    @Sale_Accesses
    @LicenseRequestsGetBySubscribeIds
    @Response_400_Bad_Request
    @DisplayName("/api/v1/license-requests_get-by-subcribeids -> 400 Bad Request: Не корректный subscribeIds")
    @AllureId("229722")
    fun test() {
        arrayOf(
            arrayOf("test"),
            arrayOf(123.123),
            arrayOf("3fo85f64-5717-4562-b3fc-2c963f66afa6"),
            arrayOf(true),
            arrayOf(false),
            arrayOf("🙂")
        ).forEach {
            checkBR(
                apiClient = accessesCrmClient,
                request = AccessesRequests.licenseRequestsGetBySubscribeIds(it),
                expected = setOf(BrokenRule(100, "Неверные параметры или модель запроса"))
            )
        }
    }
}