package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_get_by_manager

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushGetByManager
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetByManager
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager.request.FacadeA360BushGetByManagerRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushGetByManagerNotFoundPositive {

    private val systemUserId = "2df6b60a-0e5b-4380-85dd-d8879b6c195c"

    private val request by lazy {
        facadeA360BushGetByManager(FacadeA360BushGetByManagerRequest(systemUserId, null, listOf(DEFAULT_ID, ZERO_ID)))
    }

    @Test
    @Sale_Supports
    @FacadeA360BushGetByManager
    @Response_200_Ok
    @Requirements("REQCRM-789")
    @DisplayName("/api/v1/facade-a360-bush_get-by-manager -> 200 Ok: ничего не найдено")
    @AllureId("145874")
    fun test_FacadeA360BushGetByManagerNotFoundPositive() {
        val response = supportsCrmClient.send(request)

        "Проверяем, что ответ пустой" { assertTrue(response.isEmpty()) }
    }
}