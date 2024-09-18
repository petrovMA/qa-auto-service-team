package ru.action_tech.qa.auto.api_tests.supports.stoplist.v1.stop_lists_get_by_partnerid

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.NegativeScenario
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.supports.StopListsGetByPartnerId
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.stopListGetByPartnerId
import ru.action_tech.qa.auto.api_models.supports.stopListsGetByPartnerId
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.auth.tokenHomePortalApp
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_StopListGetByPartnerIdBadRequest {
    private val testsData by lazy {
        listOf(
            "partnerId is not valid" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = stopListGetByPartnerId(FieldData.INVALID_ID),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "partnerId = ''" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = stopListGetByPartnerId(""),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "Токен = null" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    stopListGetByPartnerId(null, null)
                )
            },
            "Пустой токен" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    stopListGetByPartnerId(null, "")
                )
            },
            "Невалидный токен" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    stopListGetByPartnerId(null, tokenHomePortalApp)
                )
            }
        )
    }

    @Test
    @StopListsGetByPartnerId
    @Sale_Supports
    @NegativeScenario
    @Requirements("REQCRM-1943")
    @DisplayName("$stopListsGetByPartnerId -> 400 Bad Request")
    @AllureId("236901")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}