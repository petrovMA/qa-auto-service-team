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


class Test_ThisProductNotAllowModifyUser {

    @Test
    @Sale_Accesses
    @AccessChangeMasterUserV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1065")
    @DisplayName("api/v1/access_change-master-user -> 400 Bad Request: не допускается изменение пользователя.")
    @AllureId("184904")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessChangeMasterUser(
                AccessChangeMasterUserRequest(
                    contactId = "A85943D3-B56D-4A33-A780-E8D09EA57CE1",
                    licenseId = "AD799362-DE31-4F44-BB44-16CAA74D90AC"
                )
            ),
            expected = setOf(
                BrokenRule(
                    code = 12,
                    message = "Для данного продукта не допускается открепление\\изменение пользователя."
                )
            )
        )
    }
}