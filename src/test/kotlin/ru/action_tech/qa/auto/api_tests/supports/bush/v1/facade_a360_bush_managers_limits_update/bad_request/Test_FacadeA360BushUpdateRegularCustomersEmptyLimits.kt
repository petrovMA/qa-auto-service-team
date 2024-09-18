package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_managers_limits_update.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushManagersLimitsUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_managers_limits_update.request.FacadeA360BushManagersLimitsUpdateRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateRegularCustomersEmptyLimits {

    @Test
    @Sale_Supports
    @FacadeA360BushManagersLimitsUpdate
    @Response_400_Bad_Request
    @Requirements("REQCRM-971")
    @DisplayName("/api/v1/facade-a360-bush-managers-limits_update -> 400 Bad Request: Empty limits")
    @AllureId("198100")
    fun test() {
        "Запрос с limits = []" {
            checkBR(
                apiClient = supportsCrmClient,
                request = SupportsRequests.facadeA360BushManagersLimitsUpdate(
                    FacadeA360BushManagersLimitsUpdateRequest(
                        authorId = "DDEFEB88-E25E-4D94-B3CD-2827E61E3023",
                        limits = emptyList()
                    )
                ),
                expected = setOf(BrokenRule(code = 25, message = "Список Ids менеджеров пуст"))
            )
        }

        "Запрос с limits = null" {
            checkBR(
                apiClient = supportsCrmClient,
                request = SupportsRequests.facadeA360BushManagersLimitsUpdate(
                    FacadeA360BushManagersLimitsUpdateRequest(
                        authorId = "DDEFEB88-E25E-4D94-B3CD-2827E61E3023",
                        limits = null
                    )
                ),
                expected = setOf(BrokenRule(code = 25, message = "Список Ids менеджеров пуст"))
            )
        }
    }
}