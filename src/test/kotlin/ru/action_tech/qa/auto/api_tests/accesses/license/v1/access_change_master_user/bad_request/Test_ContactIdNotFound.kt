package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_change_master_user.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessChangeMasterUserV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.license.v1.access_change_master_user.AccessChangeMasterUserRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_ContactIdNotFound {

    @Test
    @Sale_Accesses
    @AccessChangeMasterUserV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-973")
    @DisplayName("api/v1/access_change-master-user -> 400 Bad Request: не найден contactId")
    @AllureId("184902")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessChangeMasterUser(
                AccessChangeMasterUserRequest(
                    contactId = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                    licenseId = "EAAAC3C3-ADCA-491B-8AC1-D81164F385DB"
                )
            ),
            expected = setOf(
                BrokenRule(
                    code = 1000,
                    message = "Клиент не найден"
                )
            )
        )
    }
}