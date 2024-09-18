package ru.action_tech.qa.auto.api_tests.supports.bush.v1.bush_action360_get_by_incident

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.BushAction360GetByIncident
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.bushAction360GetByIncident
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_get_by_incident.request.BushAction360GetByIncidentRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_BushAction360GetByIncidentNoIncidentIdNegative {

    @Test
    @Sale_Supports
    @BushAction360GetByIncident
    @Response_200_Ok
    @Requirements("REQCRM-788")
    @DisplayName("/api/v1/bush-action360_get-by-incident -> 400 Bad Request: не передан incidentId")
    @AllureId("145865")
    fun test_BushAction360GetByIncidentNoIncidentIdNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = bushAction360GetByIncident(BushAction360GetByIncidentRequest()),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}