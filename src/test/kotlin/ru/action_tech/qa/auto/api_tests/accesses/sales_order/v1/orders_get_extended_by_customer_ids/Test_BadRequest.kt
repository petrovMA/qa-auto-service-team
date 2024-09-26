package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_extended_by_customer_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetExtendedByCustomerIds
import ru.action_tech.qa.auto.api_models.accesses.ordersGetExtendedByCustomerIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.data.broken_rules.AccessesBR
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR

class Test_BadRequest {
    private val testCases by lazy {
        listOf(
            "массив содержит не валидый id" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.ordersGetExtendedByCustomerIds(listOf(FieldData.INVALID_ID)),
                    expected = setOf(AccessesBR.BR_100)
                )
            },
            "массив содержит null" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.ordersGetExtendedByCustomerIds(listOf(null)),
                    expected = setOf(AccessesBR.BR_100)
                )
            },
            "массив содержит валидные и не валидные id" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.ordersGetExtendedByCustomerIds(
                        listOf(
                            FieldData.FIRST_ID,
                            FieldData.INVALID_ID
                        )
                    ),
                    expected = setOf(AccessesBR.BR_100)
                )
            },
        )
    }

    @Test
    @Sale_Accesses
    @OrdersGetExtendedByCustomerIds
    @Response_400_Bad_Request
    @Requirements("REQCRM-1634")
    @DisplayName("$ordersGetExtendedByCustomerIds -> 400 bad request")
    @AllureId("257104")
    fun test() {
        testCases.forEach { (testName, case) -> testName soft { case.invoke() } }
    }
}