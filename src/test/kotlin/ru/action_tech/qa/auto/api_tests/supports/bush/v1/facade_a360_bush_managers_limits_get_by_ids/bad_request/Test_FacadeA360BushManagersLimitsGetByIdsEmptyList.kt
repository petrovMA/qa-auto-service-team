package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_managers_limits_get_by_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushManagersLimitsGetByIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushManagersLimitsGetByIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_FacadeA360BushManagersLimitsGetByIdsEmptyList {

    @Test
    @Sale_Supports
    @FacadeA360BushManagersLimitsGetByIds
    @Response_400_Bad_Request
    @Requirements("REQCRM-970")
    @DisplayName("/api/v1/facade-a360-bush-managers-limits_get-by-ids -> 400 Bad Request: Пустой массив")
    @AllureId("194124")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = facadeA360BushManagersLimitsGetByIds(emptyList()),
            expected = setOf(BrokenRule(code = 25, message = "Список Ids менеджеров пуст"))
        )
    }
}