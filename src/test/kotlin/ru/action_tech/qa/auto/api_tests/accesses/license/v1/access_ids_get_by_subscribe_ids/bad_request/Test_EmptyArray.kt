package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_ids_get_by_subscribe_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessIdsGetBySubscribeIdsV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests.accessIdsGetBySubscribeIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_EmptyArray {

    @Test
    @Requirements("REQCRM-1778")
    @Sale_Accesses
    @AccessIdsGetBySubscribeIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/access-ids_get-by-subscribe-ids -> 400 Bad Request: пустой subscribeIds")
    @AllureId("200504")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = accessIdsGetBySubscribeIds(emptyArray<Any>()),
            expected = setOf(
                BrokenRule(
                    code = 105,
                    message = "Список Ids содержимых заказа пустой"
                )
            )
        )
    }
}
