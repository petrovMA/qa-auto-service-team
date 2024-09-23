package ru.action_tech.qa.auto.api_tests.supports.support.v1.support_update.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportUpdate
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_update.request.SupportUpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests.supportsGetByManager
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.utils.ermBackendArmSellerClient
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportUpdateWrongStatus {

    private lateinit var supportsId: String

    @BeforeEach
    fun before() {
        supportsId = ermBackendArmSellerClient.send(supportsGetByManager(ACTIONUSKA.id, 3)).firstOrNull()?.supportId
            ?: fail("Не найдено сопровождение для теста")
    }

    private val request: Request by lazy {
        supportUpdate(
            SupportUpdateRequest(
                id = supportsId,
                status = 0,
                endDate = "2021-09-02T14:46:33.667Z",
                supportChangeReasonId = "2df6b60a-0e5b-4380-85dd-d8879b6c195c"
            )
        )
    }


    @Test
    @HistoryIssues("ARMAP-16853")
    @Sale_Supports
    @SupportUpdate
    @Response_400_Bad_Request
    @Requirements("REQCRM-214")
    @DisplayName("/api/v1/support-update -> 400 Bad Request: Метод обновления сопровождения клиента (не корректный status)")
    @AllureId("145916")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 7, message = "Неверный статус сопровождения."))
        )
    }
}