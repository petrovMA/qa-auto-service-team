package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_previous_access_id.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetPreviousAccessIdV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.CommonRequestConst.DEMO_ACCESS_ID
import ru.action_tech.qa.auto.data.CommonRequestConst.AUTO_TEST_BITRIX_ID
import ru.action_tech.qa.auto.data.CommonRequestConst.PREVIOUS_ACCESS_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.uuid


class Test_GetPreviousAccessIdPositiveDemoAccess {
    val request by lazy {
        AccessesRequests.accessesGetPreviousAccessId(
            accessId = DEMO_ACCESS_ID,
            userId = AUTO_TEST_BITRIX_ID
        )
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16562
    @Sale_Accesses
    @AccessGetPreviousAccessIdV1
    @Response_200_Ok
    @Requirements("REQCRM-1065")
    @DisplayName("/api/v1/access_get-previous-access-id -> 200 Ok (Демо-доступ)")
    @AllureId("145312")
    fun test() {
        accessesCrmClient.send(request).apply {

            "Проверка параметра accessId" {
                assertEqual(this.accessId, DEMO_ACCESS_ID.uuid)
            }

            "Проверка параметра previousAccessId" {
                assertEqual(this.previousAccessId, PREVIOUS_ACCESS_ID.uuid)
            }
        }
    }
}