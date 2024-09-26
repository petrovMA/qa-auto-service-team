package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_demo_validate.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360DemoValidateV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360DemoValidateWrongFormatNegative {

    private val request by lazy {
        AccessesRequests.action360DemoValidate(listOf("'123-123-123-123'"))
    }

    @Test
    @Requirements("REQCRM-237")
    @Sale_Accesses
    @Aktion360DemoValidateV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-demo_validate -> 400 Bad Request: передан не корректный формат id")
    @AllureId("145317")
    fun test_Action360DemoValidateWrongFormatNegative() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(
                BrokenRule(
                    code = 100,
                    message = "Неверные параметры или модель запроса"
                )
            )
        )
    }
}