package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_states_get_by_subscribes_ids.bad_request

import io.qameta.allure.AllureId
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseStatesGetBySubscribeIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_WrongAccessIds {

    @Test
    @Sale_Accesses
    @LicenseStatesGetBySubscribeIds
    @Response_400_Bad_Request
    @Requirements("REQCRM-1876")
    @DisplayName("/api/v1/access_get-by-ids -> 400 Bad Request: неверная модель")
    @AllureId("220370")
    fun test_AccessIsNotInTheStatusActivated() {
        arrayOf(
            "test",
            123,
            RandomStringUtils.randomAlphanumeric(1000),
            true,
            false,
            "{}",
            "[null]",
            "[\"\"]",
            "[\"null\"]",
            "[\"${RandomStringUtils.randomAlphanumeric(1000)}\"]",
            *"~!@#\$%^&*()-_=+[{]};:'\"\\|,<.>/?".toCharArray().toTypedArray(),
            "🙂"
        ).forEach {
            checkBR(
                apiClient = accessesCrmClient,
                request = AccessesRequests.licenseStatesGetBySubscribeIds(
                    subscribeIds = it
                ),
                expected = setOf(
                    BrokenRule(
                        code = 100,
                        message = "Неверные параметры или модель запроса"
                    )
                )
            )
        }
    }
}