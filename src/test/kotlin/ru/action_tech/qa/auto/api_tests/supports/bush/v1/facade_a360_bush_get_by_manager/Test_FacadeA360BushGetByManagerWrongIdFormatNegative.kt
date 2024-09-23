package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_get_by_manager

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushGetByManager
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetByManager
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager.request.FacadeA360BushGetByManagerRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushGetByManagerWrongIdFormatNegative {

    private val systemUserId = "2df6b60a-0e5b-4380-85dd-d8879b6c195"
    private val customerIds by lazy { emptyList<String>() }

    private val request: Request by lazy {
        facadeA360BushGetByManager(
            FacadeA360BushGetByManagerRequest(systemUserId, null, customerIds)
        )
    }

    @Test
    @Sale_Supports
    @FacadeA360BushGetByManager
    @Response_400_Bad_Request
    @HistoryIssues("ARMAP-11840")
    @Requirements("REQCRM-789")
    @DisplayName("/api/v1/facade-a360-bush_get-by-manager -> 400 Bad Request: не корректный systemUserId")
    @AllureId("145873")
    fun test_FacadeA360BushGetByManagerWrongIdFormatNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}