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
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_AccessNotFound {

    @Test
    @Sale_Accesses
    @AccessChangeMasterUserV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-973")
    @DisplayName("api/v1/access_change-master-user -> 400 Bad Request: не найден licenseId")
    @AllureId("184899")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessChangeMasterUser(
                AccessChangeMasterUserRequest(
                    contactId = ContactPerson.MAIN_USER_FOR_ACCESS.id,
                    licenseId = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
                )
            ),
            expected = setOf(
                BrokenRule(
                    code = 9,
                    message = "По указанному Id ничего не найдено"
                )
            )
        )
    }
}