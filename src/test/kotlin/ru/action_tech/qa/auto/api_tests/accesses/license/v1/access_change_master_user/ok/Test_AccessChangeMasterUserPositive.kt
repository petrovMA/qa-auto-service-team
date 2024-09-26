package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_change_master_user.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessChangeMasterUserV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.license.v1.access_change_master_user.AccessChangeMasterUserRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessChangeMasterUserPositive {

    @Test
    @Sale_Accesses
    @AccessChangeMasterUserV1
    @Response_200_Ok
    @Requirements("REQCRM-973")
    @DisplayName("api/v1/access_change-master-user -> 200 Ok (Успешная смена пользователя)")
    @AllureId("184905")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.accessChangeMasterUser(
                AccessChangeMasterUserRequest(
                    contactId = "3F1B3DA0-E7B4-4FA1-B775-484B8FC2A722",
                    licenseId = "D677A04A-40D8-4D4F-8F43-FCA2E8023455"
                )
            )
        ).apply {
            assertTrue(this)
        }
    }
}