package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_validate.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessValidateV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360AccessValidateWrongFormatNegative {

    private val request by lazy {
        AccessesRequests.action360AccessValidate(arrayOf("testtst.ru"))
    }

    @Test
    @HistoryIssues("ARMAP-10183", "ARMAP-12352", "ARMAP-15055")
    @Requirements("REQCRM-236")
    @Sale_Accesses
    @Aktion360AccessValidateV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-access_validate -> 400 Bad Request: email = не корректный формат")
    @AllureId("145314")
    fun test_Action360AccessValidateWrongFormatNegative() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 89, message = "Получен невалидный email"))
        )
    }
}