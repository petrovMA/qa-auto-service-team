package ru.action_tech.qa.auto.api_tests.accesses.license.v1.expensive_licenses_get_by_order_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.ExpensiveLicensesGetByOrderIds
import ru.action_tech.qa.auto.api_models.accesses.expensiveLicensesGetByOrderIds
import ru.action_tech.qa.auto.api_models.accesses.license.v1.expensive_licenses_get_by_order_ids.ExpensiveLicensesGetByOrderIdsRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.expensive_licenses_get_by_order_ids.ExpensiveLicensesGetByOrderIdsResponse
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_ExpensiveLicensesGetByOrderIds {

    private val expectedResult by lazy {
        listOf(
            ExpensiveLicensesGetByOrderIdsResponse(
                orderId = "00e9a3b2-3af7-4cbe-8c5b-393fff8c709c".uuid,
                licenseId = "b51ebc81-3908-4bce-8966-41b1518d6da7".uuid,
                authCode = "2227-0855-6468-2051-7411"
            )
        )
    }

    @Test
    @Requirements("REQCRM-1981")
    @Sale_Accesses
    @ExpensiveLicensesGetByOrderIds
    @Response_200_Ok
    @DisplayName("$expensiveLicensesGetByOrderIds -> 200 Ok: Получить список УКД с самой высокой ценой по идентификаторам заказов")
    @AllureId("243594")
    fun test() {
        val response = accessesCrmClient.send(
            AccessesRequests.expensiveLicensesGetByOrderIds(
                request = ExpensiveLicensesGetByOrderIdsRequest(
                    orderIds = listOf(
                        "00e9a3b2-3af7-4cbe-8c5b-393fff8c709c",
                        "6b8b233d-d99c-44d4-b99f-35c3128a3969",
                        "3a056ee7-1f3d-4daa-a974-4a1441e0845a"
                    )
                )
            )
        )

        "Проверка что в ответе содержатся только 2 элемента" ("expectedResult" to expectedResult) {
            assertEqual(response.size, expectedResult.size)
            assertTrue(response.toList().containsAll(expectedResult))
        }
    }
}