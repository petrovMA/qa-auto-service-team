package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_subscription_by_block_id.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetSubscriptionByBlockIdV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.data.License.BLOCK_ACCESS_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessGetSubscriptionByBlockIdPositive {

    val request by lazy { AccessesRequests.accessGetSubscriptionByBlockId(blockAccessId = BLOCK_ACCESS_ID) }

    @Test
    @Sale_Accesses
    @AccessGetSubscriptionByBlockIdV1
    @Response_200_Ok
    @Requirements("REQCRM-1439")
    @DisplayName("/api/v1/access_get-subscription-by-block-id -> 200 Ok: Получить подписку по идентификатору блока")
    @AllureId("150502")
    fun test_AccessGetSubscriptionByBlockIdPositive() {
        assertEqual(accessesCrmClient.send(request).previousAccessId?.uppercase(), "A21BB20D-DF36-4B11-A0E5-B929EC604B4E")
    }
}