package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.receive_cases_get_by_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.shipment.ReceiveCasesGetByIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService


class Test_ReceiveCasesGetByIdsBadRequest {

    @Test
    @Requirements("REQCRM-1623")
    @Sale_ShipmentService
    @ReceiveCasesGetByIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/receive-cases_get-by-ids -> 400 Bad Request: Не валидный id")
    @AllureId("208652")
    fun testWrongId() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = ShipmentRequests.receiveCasesGetByIds(listOf("1234-1234-1234-1234")),
            expected = setOf(BrokenRule(code = 2, message = "Отсутвуют параметры в запросе"))
        )
    }

    @Test
    @Requirements("REQCRM-1623")
    @Sale_ShipmentService
    @ReceiveCasesGetByIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/receive-cases_get-by-ids -> 400 Bad Request: No params")
    @AllureId("158792")
    fun test() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = ShipmentRequests.receiveCasesGetByIds(),
            expected = setOf(BrokenRule(code = 2, message = "Отсутвуют параметры в запросе"))
        )
    }
}