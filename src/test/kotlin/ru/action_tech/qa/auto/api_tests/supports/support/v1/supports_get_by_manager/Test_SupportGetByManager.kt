package ru.action_tech.qa.auto.api_tests.supports.support.v1.supports_get_by_manager

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsGetByManager
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportsGetByManager
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_manager.request.SupportsGetByManagerRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_manager.response.SupportsGetByManagerResponse
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportGetByManager {

    private lateinit var response: Array<SupportsGetByManagerResponse>

    @Test
    @Sale_Supports
    @SupportsGetByManager
    @Response_200_Ok
    @Requirements("REQCRM-222")
    @DisplayName("/api/v1/supports_get-by-manager -> 200 Ok")
    @AllureId("145921")
    fun test() {

        "Получить действующие сопровождения по менеджеру" {
            response = supportsCrmClient.send(supportsGetByManager(SupportsGetByManagerRequest("3C2E2E6F-E4B7-E711-A20D-00155DFBF212")))

            "Проверка что ответ не пустой" { assertTrue(response.isNotEmpty()) }
        }

        "Получить действующие сопровождения по менеджеру (пустой запрос)" {
            response = supportsCrmClient.send(supportsGetByManager(SupportsGetByManagerRequest()))

            "Проверяем, что ответ пустой" { assertTrue(response.isEmpty()) }
        }

        "Получить действующие сопровождения по менеджеру (ничего не найдено)" {
            val response = supportsCrmClient.send(supportsGetByManager(SupportsGetByManagerRequest(FieldData.ZERO_ID)))

            "Проверяем, что ответ пустой" { assertTrue(response.isEmpty()) }
        }
    }
}