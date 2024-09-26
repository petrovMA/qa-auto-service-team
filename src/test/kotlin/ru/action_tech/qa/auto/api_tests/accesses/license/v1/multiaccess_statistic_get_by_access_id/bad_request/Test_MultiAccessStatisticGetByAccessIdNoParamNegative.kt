package ru.action_tech.qa.auto.api_tests.accesses.license.v1.multiaccess_statistic_get_by_access_id.bad_request

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.MultiaccessStatisticGetByAccessIdV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.multi_access_statistic_get_by_access_id.MultiAccessStatisticGetByAccessIdRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.multi_access_statistic_get_by_access_id.MultiAccessStatisticGetByAccessIdResponse
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_MultiAccessStatisticGetByAccessIdNoParamNegative {

    private val request by lazy {
        AccessesRequests.multiAccessStatisticGetByAccessId(
            MultiAccessStatisticGetByAccessIdRequest(null)
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @Requirements("REQCRM-244")
    @Sale_Accesses
    @MultiaccessStatisticGetByAccessIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/multiaccess-statistic_get-by-accessid -> 400 Bad Request: accessId не передан")
    @AllureId("145343")
    fun test_MultiAccessStatisticGetByAccessIdNoParamNegative() {
        assertThat(
            accessesCrmClient.send(request).deserialize<Array<MultiAccessStatisticGetByAccessIdResponse>>()
        ).isEmpty()
    }
}