package ru.action_tech.qa.auto.api_tests.supports.support.v1.supports_change_manager

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsChangeManager
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportsChangeManager
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_change_manager.request.SupportsChangeManagerRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_SupportsChangeManagerBadRequest {

    private val testsData by lazy {
        listOf(
            "Смена менеджера сопровождения (пустой modifiedBy)" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsChangeManager(
                        SupportsChangeManagerRequest(
                            modifiedBy = null,
                            newManagerId = DEFAULT_ID,
                            partnerId = DEFAULT_ID,
                            supportsId = emptyList()
                        )
                    ),
                    expected = setOf(BrokenRule(code = 38, message = "Не указан автор изменения"))
                )
            },
            "Смена менеджера сопровождения (пустой newManagerId)" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsChangeManager(
                        SupportsChangeManagerRequest(
                            modifiedBy = DEFAULT_ID,
                            newManagerId = null,
                            partnerId = DEFAULT_ID,
                            supportsId = emptyList()
                        )
                    ),
                    expected = setOf(BrokenRule(code = 3, message = "Не указан менеджер сопровождения."))
                )
            },
            "Смена менеджера сопровождения (пустой partnerId)" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsChangeManager(
                        SupportsChangeManagerRequest(
                            modifiedBy = DEFAULT_ID,
                            newManagerId = DEFAULT_ID,
                            partnerId = null,
                            supportsId = emptyList()
                        )
                    ),
                    expected = setOf(BrokenRule(code = 2, message = "Не указан партнер сопровождения."))
                )
            },
            "Смена менеджера сопровождения (пустой supportsId)" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsChangeManager(
                        SupportsChangeManagerRequest(
                            modifiedBy = DEFAULT_ID,
                            newManagerId = DEFAULT_ID,
                            partnerId = DEFAULT_ID,
                            supportsId = emptyList()
                        )
                    ),
                    expected = setOf(BrokenRule(code = 39, message = "Не указаны Ids сопровождений"))
                )
            },
            "Смена менеджера сопровождения (не существующий partnerId)" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsChangeManager(
                        SupportsChangeManagerRequest(
                            modifiedBy = null,
                            newManagerId = null,
                            partnerId = "3fa85f64-5717-4562-b3fc-2c96",
                            supportsId = listOf(DEFAULT_ID)
                        )
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            }
        )
    }

    @Test
    @Sale_Supports
    @SupportsChangeManager
    @Response_400_Bad_Request
    @Requirements("REQCRM-223")
    @DisplayName("/api/v1/supports_change-manager -> 400 Bad Request")
    @AllureId("174358")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}