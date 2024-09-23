package ru.action_tech.qa.auto.api_tests.supports.stoplist.v1.stop_list_bind

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import ru.action_tech.qa.auto.api_models.NegativeScenario
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.supports.StopListBind
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.stopListBind
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind.StopListBindRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.auth.tokenHomePortalApp
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.data.person
import ru.action_tech.qa.auto.data.specialProjectsManagement
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_StopListBindBadRequest {

    private val testsData by lazy {
        mapOf(
            "partnerId = null" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBind(StopListBindRequest(person.customerId, null)),
                    expected = setOf(BrokenRule(46, "Не указан партнер для стоп-листа"))
                )
            },
            "customerId = null" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBind(
                        StopListBindRequest(
                            null,
                            specialProjectsManagement.partnerId
                        )
                    ),
                    expected = setOf(BrokenRule(44, "Идентификатор клиента не передан"))
                )
            },
            "partnerId = 123.123" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBind(StopListBindRequest(ACTIONUSKA.id, 123.123f)),
                    expected = setOf(BrokenRule(34, "Неверные параметры или модель запроса"))
                )
            },
            "partnerId = 123.123" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBind(
                        StopListBindRequest(
                            "cf329ac2-9cca-49b9-bb9d-2ac8134812da",
                            specialProjectsManagement.partnerId
                        )
                    ),
                    expected = setOf(
                        BrokenRule(
                            47,
                            "Клиент с id=cf329ac2-9cca-49b9-bb9d-2ac8134812da Чужой потенциальный клиент партнера Внутреннее подразделение"
                        )
                    )
                )
            },
            "Токен = null" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    SupportsRequests.stopListBind(StopListBindRequest(null, null), null)
                )
            },
            "Пустой токен" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    SupportsRequests.stopListBind(StopListBindRequest(null, null), "")
                )
            },
            "Невалидный токен" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    SupportsRequests.stopListBind(StopListBindRequest(null, null), tokenHomePortalApp)
                )
            }
        )
    }

    @Test
    @ResourceLock("customerId = cf329ac2-9cca-49b9-bb9d-2ac8134812da")
    @Sale_Supports
    @StopListBind
    @NegativeScenario
    @Requirements("REQCRM-1942")
    @DisplayName("$stopListBind -> Negative Scenario")
    @AllureId("246963")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}