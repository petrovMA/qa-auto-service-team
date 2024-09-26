package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_states_get_by_subscribes_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseStatesGetBySubscribeIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_EmptySubscribeIds {

    @Test
    @Sale_Accesses
    @LicenseStatesGetBySubscribeIds
    @Response_400_Bad_Request
    @Requirements("REQCRM-1876")
    @DisplayName("/api/v1/license-states_get-by-subscribe-ids -> 400 Bad Request: пустой список ids")
    @AllureId("220369")
    fun test() {
        arrayOf(emptyArray<Any>(), emptyList<Any>(), "[]", null, "", "null").forEach {
            "Проверяем на пустые значения mainProductIds = '$it'" {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseStatesGetBySubscribeIds(
                        subscribeIds = it
                    ),
                    expected = setOf(
                        BrokenRule(
                            code = 105,
                            message = "Список Ids содержимых заказа пустой"
                        )
                    )
                )
            }
        }

    }
}