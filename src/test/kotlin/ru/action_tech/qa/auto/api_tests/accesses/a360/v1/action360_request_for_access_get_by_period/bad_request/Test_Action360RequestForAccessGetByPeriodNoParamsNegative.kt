package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_period.bad_request

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByPeriodV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_period.Action360RequestForAccessGetByPeriodRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360RequestForAccessGetByPeriodNoParamsNegative {

    private val request by lazy {
        AccessesRequests.action360RequestForAccessGetByPeriod(
            Action360RequestForAccessGetByPeriodRequest(
                dateFrom = null,
                dateTo = null
            )
        )
    }

    @Test
    @Requirements("REQCRM-245")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByPeriodV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-period -> 400 Bad Request: параметры не переданы")
    @AllureId("145328")
    fun test_Action360RequestForAccessGetByPeriodNoParamsNegative() {
        assertThat(accessesCrmClient.send(request)).isEmpty()
    }
}