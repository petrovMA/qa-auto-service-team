package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_add

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushAdd
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_add.request.FacadeA360BushAddRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushAddBadRequest {

    @Test
    @Sale_Supports
    @FacadeA360BushAdd
    @Response_400_Bad_Request
    @Requirements("REQCRM-784")
    @DisplayName("/api/v1/facade-a360-bush_add -> 400 Bad Request: не передан SystemUserId")
    @AllureId("174867")
    fun testNoSystemUserId() {
        checkBR(
            apiClient = supportsCrmClient,
            request = SupportsRequests.facadeA360BushAdd(
                FacadeA360BushAddRequest(
                    customerIds = listOf("2abe4858-e21a-4b57-a78c-7f363c5f21dd"),
                    factPrice = 0,
                    factUsersAmount = 0,
                    systemUserId = null,
                    mainProductId = "130dd49e-ecca-e811-bb9b-00155d627f03"
                )
            ),
            expected = setOf(BrokenRule(code = 35, message = "Идентефикатор не валиден или пуст"))
        )
    }



    @Test
    @Sale_Supports
    @FacadeA360BushAdd
    @Response_400_Bad_Request
    @HistoryIssues("ARMAP-14130", "ARMAP-15854")
    @Requirements("REQCRM-784")
    @DisplayName("/api/v1/facade-a360-bush_add -> 400 Bad Request: передан не валидный customerIds")
    @AllureId("145868")
    fun testWrongCustomerIds() {
        checkBR(
            apiClient = supportsCrmClient,
            request = SupportsRequests.facadeA360BushAdd(
                FacadeA360BushAddRequest(
                    customerIds = listOf("null"),
                    factPrice = 0,
                    factUsersAmount = 0,
                    mainProductId = "130dd49e-ecca-e811-bb9b-00155d627f03",
                    systemUserId = "94f431ce-2fec-ea11-bba7-00155d627f03"
                )
            ),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }


    @Test
    @Sale_Supports
    @FacadeA360BushAdd
    @Response_400_Bad_Request
    @Requirements("REQCRM-784")
    @DisplayName("/api/v1/facade-a360-bush_add -> 400 Bad Request: не передан mainProductId")
    @AllureId("145869")
    fun testNoMainProductId() {
        checkBR(
            apiClient = supportsCrmClient,
            request = SupportsRequests.facadeA360BushAdd(
                FacadeA360BushAddRequest(
                    customerIds = listOf("72FA8235-DBB7-E811-BB96-00155D627F03"),
                    factPrice = 0,
                    factUsersAmount = 0,
                    mainProductId = null,
                    systemUserId = "94f431ce-2fec-ea11-bba7-00155d627f03"
                )
            ),
            expected = setOf(BrokenRule(code = 18, message = "Неверный головной продукт"))
        )
    }
}