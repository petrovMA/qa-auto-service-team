package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_moderate.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessModerateV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_moderate.request.Action360RequestForAccessModerateRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360RequestForAccessModeratePositive {

    private val request by lazy {
        AccessesRequests.action360RequestForAccessModerate(
            Action360RequestForAccessModerateRequest(
                aktion360RequestForAccess = null,
                modifiedBy = null
            )
        )
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16577
    @Requirements("REQCRM-241")
    @Sale_Accesses
    @Aktion360RequestForAccessModerateV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-request-for-access_moderate -> 200 ok")
    @AllureId("145334")
    fun test_Action360RequestForAccessModeratePositive() {
        accessesCrmClient.send(request)
    }
}