package ru.action_tech.qa.auto.api_tests.supports.support.v1.support_add.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportAdd
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportAdd
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_add.request.SupportAddRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportAddWrongStatusNegative {

    private val request: Request by lazy {
        supportAdd(
            SupportAddRequest(
                supportType = 3,
                startDate = "2021-09-01",
                endDate = "2021-12-31",
                accountId = "325B09A1-2002-48E4-AADC-A978196D8EA4",
                partnerId = "B89FF32C-5F0B-DF11-809E-001CC45E3D96",
                systemUserId = null,
                status = 31
            )
        )
    }


    @Test
    @Sale_Supports
    @SupportAdd
    @Response_400_Bad_Request
    @Requirements("REQCRM-213")
    @DisplayName("/api/v1/support-add -> 400 Bad Request: Метод создания сопровождения клиента (не указан менеджер)")
    @AllureId("145905")
    fun test_SupportAddWrongStatusNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 3, message = "Не указан менеджер сопровождения."))
        )
    }
}