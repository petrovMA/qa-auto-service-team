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
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.USER_ACTIONUSKA
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushGetByManagerPositive {

    private val userId by lazy { USER_ACTIONUSKA.id }
    private val number = "3"
    private val customerIds by lazy {
        listOf(
            "6b505a7f-a3c4-415f-bc83-00011e4352e9",
            "0c3ecbc4-f74a-43af-bfcf-e6fd5d1f6cce",
            "6b505a7f-a3c4-415f-bc83-00011e4352e9",
            "d4aaba13-fc88-4838-881a-00044cf37b4a",
            "2721afb9-5af0-4077-bab6-00053f8e1025",
            "0ddc0646-bbc7-e811-bb9b-00155d627f03",
            "780592ec-80a2-4f20-95df-beae4036bea3",
            "6e4cfdcb-dc00-4984-9570-0b77a6c1a111",
            "b40f87f7-9971-494e-a0db-0822ba7a67d5",
            "cc32eb0c-fea1-4392-97b8-0aedb05aa588",
            "b8a3b05f-8cfb-4ab8-a634-28ab7ae6caa7"
        )
    }

    val request by lazy { facadeA360BushGetByManager(FacadeA360BushGetByManagerRequest(userId, number, customerIds)) }

    @Test
    @Sale_Supports
    @FacadeA360BushGetByManager
    @Response_200_Ok
    @Requirements("REQCRM-789")
    @DisplayName("/api/v1/facade-a360-bush_get-by-manager -> 200 Ok: Метод получения куста Актион 360")
    @AllureId("145875")
    fun test_FacadeA360BushGetByManagerPositive() {
        val response = supportsCrmClient.send(request)

        "Проверка что в каждом элементе name содержит $number, supportSystemUserId=$userId, customerIds содержит id" {
            response.forEach {
                assertTrue(it.name?.contains(number) ?: false)
                it.customers?.forEach { cust -> assertEqual(cust.supportSystemUserId, userId) }
                it.customers?.forEach { cust -> assertTrue(customerIds.contains(cust.id)) }
            }
        }
    }
}