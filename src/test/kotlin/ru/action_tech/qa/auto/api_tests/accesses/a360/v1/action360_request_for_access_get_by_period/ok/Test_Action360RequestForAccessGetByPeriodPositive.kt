package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_period.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByPeriodV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_period.Action360RequestForAccessGetByPeriodRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360RequestForAccessGetByPeriodPositive {

    private val request by lazy {
        AccessesRequests.action360RequestForAccessGetByPeriod(
            Action360RequestForAccessGetByPeriodRequest(
                dateFrom = "2021-07-08",
                dateTo = "2021-07-20"
            )
        )
    }

    @Test
    @Requirements("REQCRM-245")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByPeriodV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-period -> 200 ok")
    @AllureId("145330")
    fun test_Action360RequestForAccessGetByPeriodPositive() {
        assertThat(accessesCrmClient.send(request)).isNotEmpty
    }
}