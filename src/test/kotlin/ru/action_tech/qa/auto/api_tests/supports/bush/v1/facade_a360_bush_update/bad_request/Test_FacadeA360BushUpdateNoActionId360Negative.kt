package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_update.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushUpdate
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update.request.FacadeA360BushUpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient
import java.net.HttpURLConnection


class Test_FacadeA360BushUpdateNoActionId360Negative {

    private val request: Request by lazy {
        facadeA360BushUpdate(
            FacadeA360BushUpdateRequest(
                bushAction360Id = ZERO_ID,
                customerIds = listOf("72FA8235-DBB7-E811-BB96-00155D627F03"),
                factPrice = 0,
                factUsersAmount = 0,
                systemUserId = "94f431ce-2fec-ea11-bba7-00155d627f03"
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_BAD_REQUEST) } }
    }


    @Test
    @Sale_Supports
    @FacadeA360BushUpdate
    @Response_400_Bad_Request
    @Requirements("REQCRM-785")
    @DisplayName("/api/v1/facade-a360-bush_update -> 400 Bad Request: некорректный bushAction360Id")
    @AllureId("145884")
    fun test_FacadeA360BushUpdateNoActionId360Negative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 21, message = "Не найден куст А360"))
        )
    }
}