package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_update_support_manager.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushUpdateSupportManager
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushUpdateSupportManager
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_support_manager.request.FacadeA360BushUpdateSupportManagerRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateSupportManagerEmptyBushIdsNegative {

    private val request by lazy {
        facadeA360BushUpdateSupportManager(
            FacadeA360BushUpdateSupportManagerRequest(
                authorId = "94f431ce-2fec-ea11-bba7-00155d627f03",
                bushA360Ids = listOf(),
                supportSystemUserId = "94f431ce-2fec-ea11-bba7-00155d627f03"
            )
        )
    }


    @Test
    @Sale_Supports
    @FacadeA360BushUpdateSupportManager
    @Response_400_Bad_Request
    @Requirements("REQCRM-790")
    @DisplayName("/api/v1/facade-a360-bush_update-support-manager -> 400 Bad Request: пустой bushA360Ids")
    @AllureId("145889")
    fun test_FacadeA360BushUpdateSupportManagerEmptyBushIdsNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 24, message = "Список Ids кустов A360 пуст"))
        )
    }
}