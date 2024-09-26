package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_ids_get_by_subscribe_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessIdsGetBySubscribeIdsV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_SubscribeIdInvalid {

    @Test
    @Requirements("REQCRM-1778")
    @Sale_Accesses
    @AccessIdsGetBySubscribeIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/access-ids_get-by-subscribe-ids -> 400 Bad Request: невалидный subscribeIds")
    @AllureId("200505")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessIdsGetBySubscribeIds(listOf<Any>("480140981408dffs")),
            expected = setOf(
                BrokenRule(
                    code = 100,
                    message = "Неверные параметры или модель запроса"
                )
            )
        )
    }
}