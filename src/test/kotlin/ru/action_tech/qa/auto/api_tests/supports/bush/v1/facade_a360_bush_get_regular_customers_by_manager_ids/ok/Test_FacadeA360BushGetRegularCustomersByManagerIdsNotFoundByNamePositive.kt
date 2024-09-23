package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_get_regular_customers_by_manager_ids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushGetRegularCustomersByManagerIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetRegularCustomersByManagerIds
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_regular_customers_by_manager_ids.request.FacadeA360BushGetRegularCustomersByManagerIdsRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushGetRegularCustomersByManagerIdsNotFoundByNamePositive {

    private val request by lazy {
        facadeA360BushGetRegularCustomersByManagerIds(
            FacadeA360BushGetRegularCustomersByManagerIdsRequest(
                systemUserIds = listOf("3B7AF748-E8BC-48AD-89FF-5DD3E5DC624E"),
                customerIds = listOf("e7408ac0-4d4e-4b8b-8e6f-b4804cc205e0"),
                number = "123123123"
            )
        )
    }


    @Test
    @Sale_Supports
    @FacadeA360BushGetRegularCustomersByManagerIds
    @Response_200_Ok
    @Requirements("REQCRM-968")
    @DisplayName("/api/v1/facade-a360-bush_get-regular-customers-by-manager-ids -> 200 Ok: ничего не найдено по number")
    @AllureId("145879")
    fun test() {
        val response = supportsCrmClient.send(request)

        "Проверяем, что ответ пустой" { assertTrue(response.isEmpty()) }
    }
}