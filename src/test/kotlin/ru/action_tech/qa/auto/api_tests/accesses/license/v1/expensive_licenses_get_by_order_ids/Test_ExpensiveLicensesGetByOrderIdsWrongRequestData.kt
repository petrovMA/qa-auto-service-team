package ru.action_tech.qa.auto.api_tests.accesses.license.v1.expensive_licenses_get_by_order_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.ExpensiveLicensesGetByOrderIds
import ru.action_tech.qa.auto.api_models.accesses.expensiveLicensesGetByOrderIds
import ru.action_tech.qa.auto.api_models.accesses.license.v1.expensive_licenses_get_by_order_ids.ExpensiveLicensesGetByOrderIdsRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRuleTechnical
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBRTech


class Test_ExpensiveLicensesGetByOrderIdsWrongRequestData {

    private val testsData by lazy {
        listOf(
            "orderIds = []" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.expensiveLicensesGetByOrderIds(
                        request = ExpensiveLicensesGetByOrderIdsRequest(orderIds = listOf())
                    ),
                    expected = setOf(
                        BrokenRule(136, "Список идентификаторов заказов пуст или равен NULL")
                    )
                )
            },
            "Request is empty" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.expensiveLicensesGetByOrderIds(request = null),
                    expected = setOf(
                        BrokenRule(
                            code = 100,
                            message = "Неверные параметры или модель запроса: A non-empty request body is required."
                        )
                    )
                )
            },
            "orderIds = null" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.expensiveLicensesGetByOrderIds(
                        request = ExpensiveLicensesGetByOrderIdsRequest(orderIds = null)
                    ),
                    expected = setOf(
                        BrokenRule(136, "Список идентификаторов заказов пуст или равен NULL")
                    )
                )
            },
            """orderIds = ["123"]""" to {
                checkBRTech(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.expensiveLicensesGetByOrderIds(
                        request = ExpensiveLicensesGetByOrderIdsRequest(orderIds = listOf("123"))
                    ),
                    expected = setOf(
                        BrokenRuleTechnical(
                            code = 100,
                            message1 = "Неверные параметры или модель запроса: Error converting value ",
                            message2 = " to type 'System.Guid'"
                        )
                    )
                )
            },
            "orderIds = [123.123, \"1234567890\", 123456789]" to {
                checkBRTech(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.expensiveLicensesGetByOrderIds(
                        request = ExpensiveLicensesGetByOrderIdsRequest(orderIds = listOf(123.123, "1234567890", 123456789))
                    ),
                    expected = setOf(
                        BrokenRuleTechnical(
                            code = 100,
                            message1 = "Неверные параметры или модель запроса: Error converting value ",
                            message2 = " to type 'System.Guid'"
                        )
                    )
                )
            }
        )
    }

    @Test
    @Requirements("REQCRM-1981")
    @Sale_Accesses
    @ExpensiveLicensesGetByOrderIds
    @Response_400_Bad_Request
    @DisplayName("$expensiveLicensesGetByOrderIds -> 400 Bad Request: Не корректные данные запроса")
    @AllureId("243595")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}