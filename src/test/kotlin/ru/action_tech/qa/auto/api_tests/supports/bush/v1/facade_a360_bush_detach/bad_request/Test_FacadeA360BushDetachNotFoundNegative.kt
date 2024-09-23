package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_detach.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushDetach
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushDetach
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_detach.request.FacadeA360BushDetachRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushDetachNotFoundNegative {

    private val request by lazy {
        facadeA360BushDetach(FacadeA360BushDetachRequest(ZERO_ID, "94f431ce-2fec-ea11-bba7-00155d627f03"))
    }

    @Test
    @Sale_Supports
    @FacadeA360BushDetach
    @Response_400_Bad_Request
    @Requirements("REQCRM-786")
    @DisplayName("/api/v1/facade-a360-bush_detach -> 400 Bad Request: ничего не найдено")
    @AllureId("145871")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 21, message = "Не найден куст А360"))
        )
    }
}