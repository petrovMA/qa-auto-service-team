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


class Test_ActivityPeriodExpired {

    @Test
    @Sale_Accesses
    @AccessChangeMasterUserV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1065")
    @DisplayName("api/v1/access_change-master-user -> 400 Bad Request: Период активности лицензии истёк.")
    @AllureId("184900")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessChangeMasterUser(
                AccessChangeMasterUserRequest(
                    contactId = "A85943D3-B56D-4A33-A780-E8D09EA57CE1",
                    licenseId = "065d8f9e-648a-4c27-b736-6cd61063a155"
                )
            ),
            expected = setOf(
                BrokenRule(
                    code = 10,
                    message = "Период активности лицензии истёк."
                )
            )
        )
    }
}