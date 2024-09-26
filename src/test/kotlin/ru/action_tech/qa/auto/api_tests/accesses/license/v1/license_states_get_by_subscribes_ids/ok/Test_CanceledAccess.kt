package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_states_get_by_subscribes_ids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseStatesGetBySubscribeIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_CanceledAccess {

    @Test
    @Sale_Accesses
    @LicenseStatesGetBySubscribeIds
    @Response_200_Ok
    @Requirements("REQCRM-1877")
    @DisplayName("/api/v1/license-states_get-by-subscribe-ids -> 200 ok: Отмененная лицензия")
    @AllureId("220372")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.licenseStatesGetBySubscribeIds(
                //пока используем захардкоженные данные, обсудим вопрос генерации либо выдачу лицензии тестовому пользователю
                subscribeIds = arrayOf(
                    "D14CCAB3-B187-4F21-AEE3-507537166554"
                )
            )
        ).first().apply {
            "Проверяем, что параметр licenseStatus = 2 (Отменен)" {
                assertEqual(this.licenseStatus, 2)
            }
        }
    }
}