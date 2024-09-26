package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_subscription_by_block_id.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetSubscriptionByBlockIdV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_AccessGetSubscriptionByBlockIdNotFoundNegative {

    @Test
    @Sale_Accesses
    @AccessGetSubscriptionByBlockIdV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1439")
    @DisplayName("/api/v1/access_get-subscription-by-block-id -> 400 Bad Request: not found by blockAccessId")
    @AllureId("150503")
    fun test_AccessGetSubscriptionByBlockIdNotFoundNegative() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessGetSubscriptionByBlockId(DEFAULT_ID),
            expected = setOf(BrokenRule(code = 6, message = "Доступ не найден/удален."))
        )
    }
}