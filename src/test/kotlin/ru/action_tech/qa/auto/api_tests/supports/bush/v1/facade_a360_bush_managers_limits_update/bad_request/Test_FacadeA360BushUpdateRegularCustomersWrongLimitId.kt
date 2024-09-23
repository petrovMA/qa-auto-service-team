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
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateRegularCustomersWrongLimitId {

    @Test
    @Sale_Supports
    @FacadeA360BushManagersLimitsUpdate
    @Response_400_Bad_Request
    @Requirements("REQCRM-971")
    @DisplayName("/api/v1/facade-a360-bush-managers-limits_update -> 400 Bad Request: wrong limit Id")
    @AllureId("198102")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = SupportsRequests.facadeA360BushManagersLimitsUpdate(
                FacadeA360BushManagersLimitsUpdateRequest(
                    authorId = "null",
                    limits = listOf(
                        FacadeA360BushManagersLimitsUpdateRequest.Limit(
                            id = "DDEFEB88-E25E-4D94-B3CD-2827E61E3023",
                            limitCustomersInDealA360 = 102,
                            limitDealsA360 = 101
                        ),
                        FacadeA360BushManagersLimitsUpdateRequest.Limit(
                            id = "DDEFEB88-E25E-4D94-B3CD-2827E6qwerty",
                            limitCustomersInDealA360 = 102,
                            limitDealsA360 = 101
                        )
                    )
                )
            ),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}