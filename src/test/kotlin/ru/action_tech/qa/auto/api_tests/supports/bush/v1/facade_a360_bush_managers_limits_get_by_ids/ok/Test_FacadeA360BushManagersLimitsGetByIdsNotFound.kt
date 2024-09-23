package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_managers_limits_get_by_ids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushManagersLimitsGetByIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushManagersLimitsGetByIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushManagersLimitsGetByIdsNotFound {


    @Test
    @Sale_Supports
    @FacadeA360BushManagersLimitsGetByIds
    @Response_200_Ok
    @Requirements("REQCRM-970")
    @DisplayName("/api/v1/facade-a360-bush-managers-limits_get-by-ids -> 200 Ok: Ничего не найдено")
    @AllureId("194128")
    fun test() {
        val response = supportsCrmClient.send(facadeA360BushManagersLimitsGetByIds(listOf(DEFAULT_ID)))

        "Проверяем, что ответ пустой" { assertTrue(response.isEmpty()) }
    }
}