package ru.action_tech.qa.auto.api_tests.accesses.license.v1.multiaccess_statistic_get_by_access_id.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.MultiaccessStatisticGetByAccessIdV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.multi_access_statistic_get_by_access_id.MultiAccessStatisticGetByAccessIdRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.multi_access_statistic_get_by_access_id.MultiAccessStatisticGetByAccessIdResponse
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_MultiAccessStatisticGetByAccessIdPositive {

    private val request by lazy {
        AccessesRequests.multiAccessStatisticGetByAccessId(
            MultiAccessStatisticGetByAccessIdRequest("f86a9ad0-4499-4629-abe8-ed1ae74e3968")
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @Requirements("REQCRM-244")
    @Sale_Accesses
    @MultiaccessStatisticGetByAccessIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/multiaccess-statistic_get-by-accessid -> 200 ok")
    @AllureId("145345")
    fun test_MultiAccessStatisticGetByAccessIdPositive() {
        assertThat(
            accessesCrmClient.send(request).deserialize<Array<MultiAccessStatisticGetByAccessIdResponse>>()
        ).isNotEmpty
    }
}