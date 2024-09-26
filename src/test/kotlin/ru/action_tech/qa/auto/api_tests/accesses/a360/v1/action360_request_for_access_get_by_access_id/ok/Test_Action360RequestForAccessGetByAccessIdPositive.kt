package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_access_id.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByAccessIdV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_access_id.Action360RequestForAccessGetByAccessIdRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_access_id.response.Action360RequestForAccessGetByAccessIdResponse
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360RequestForAccessGetByAccessIdPositive {

    private val request by lazy {
        AccessesRequests.action360RequestForAccessGetByAccessId(
            Action360RequestForAccessGetByAccessIdRequest(
                "57bda2bd-8fba-43c0-bcb7-d49be74072bf"
            )
        )
    }

    @Test
    @Requirements("REQCRM-242")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByAccessIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-accessid -> 200 ok")
    @AllureId("145324")
    fun test() {
        accessesCrmClient.send(request).deserialize<Action360RequestForAccessGetByAccessIdResponse>()
    }
}