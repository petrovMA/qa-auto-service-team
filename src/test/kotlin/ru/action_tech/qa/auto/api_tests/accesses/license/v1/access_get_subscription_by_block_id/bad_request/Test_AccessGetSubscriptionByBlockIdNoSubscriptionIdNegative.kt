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
import ru.action_tech.qa.auto.data.License.BLOCK_ACCESS_ID_WITHOUT_SUBSCRIPTION
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_AccessGetSubscriptionByBlockIdNoSubscriptionIdNegative {

    @Test
    @Sale_Accesses
    @AccessGetSubscriptionByBlockIdV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1439")
    @DisplayName("/api/v1/access_get-subscription-by-block-id -> 400 Bad Request: No Subscription Id")
    @AllureId("150504")
    fun test_AccessGetSubscriptionByBlockIdNoSubscriptionIdNegative() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessGetSubscriptionByBlockId(BLOCK_ACCESS_ID_WITHOUT_SUBSCRIPTION),
            expected = setOf(BrokenRule(code = 77, message = "На блочной лицензии нет Id подписки"))
        )
    }
}