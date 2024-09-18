package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_get_by_manager_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushGetByManagerIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetByManagerIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_FacadeA360BushGetByManagerIdsPositive {
    private val systemUserId2 by lazy { ACTIONUSKA.id }
    private val systemUserId1 by lazy { AUTO_ACTIONUSKA.id }

    private val request by lazy { facadeA360BushGetByManagerIds(listOf(systemUserId1, systemUserId2)) }

    @Test
    @Sale_Supports
    @FacadeA360BushGetByManagerIds
    @Response_200_Ok
    @Requirements("REQCRM-791")
    @DisplayName("/api/v1/facade-a360-bush_get-by-manager-ids -> 200 Ok: Метод получения куста Актион 360")
    @AllureId("145878")
    fun test() {
        val response = supportsCrmClient.send(request)

        "Проверяем что результат отфильтрован по systemUserIds" {
            val systemUsers = response.map { it.systemUserId }

            assertEqual(systemUsers.size, 2)

            systemUsers.contains(systemUserId1)
            systemUsers.contains(systemUserId2)

            response.find { it.systemUserId == systemUserId1 }?.bushesA360
                ?.forEach { assertTrue(it.customers?.any { customer -> customer.supportSystemUserId.equals(systemUserId1) }!!) }
                ?: fail("В ответе отсутствует поле bushesA360")
        }
    }
}
