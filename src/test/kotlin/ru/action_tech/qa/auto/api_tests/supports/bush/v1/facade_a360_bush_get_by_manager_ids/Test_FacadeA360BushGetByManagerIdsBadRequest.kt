package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_get_by_manager_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushGetByManagerIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetByManagerIds
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushGetByManagerIdsBadRequest {

    @Test
    @Sale_Supports
    @FacadeA360BushGetByManagerIds
    @Response_400_Bad_Request
    @Requirements("REQCRM-791")
    @DisplayName("/api/v1/facade-a360-bush_get-by-manager-ids -> 400 Bad Request: не переданы параметры")
    @AllureId("145876")
    fun test_FacadeA360BushGetByManagerIdsNoParamsNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = facadeA360BushGetByManagerIds(),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }

    @Test
    @HistoryIssues("ARMAP-11839")
    @Sale_Supports
    @FacadeA360BushGetByManagerIds
    @Response_400_Bad_Request
    @Requirements("REQCRM-791")
    @DisplayName("/api/v1/facade-a360-bush_get-by-manager-ids -> 400 Bad Request: не корректный формат")
    @AllureId("145877")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = SupportsRequests.facadeA360BushGetByManagerIds(listOf("ecd7917d-c14a-403e-bf1d-15d24fc2166")),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}