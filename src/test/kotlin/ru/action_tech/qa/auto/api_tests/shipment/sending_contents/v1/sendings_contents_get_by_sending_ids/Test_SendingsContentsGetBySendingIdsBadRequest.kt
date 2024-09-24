package ru.action_tech.qa.auto.api_tests.shipment.sending_contents.v1.sendings_contents_get_by_sending_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.shipment.SendingsContentsGetBySendingIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService


class Test_SendingsContentsGetBySendingIdsBadRequest {

    @Test
    @Requirements("REQCRM-1648")
    @Sale_ShipmentService
    @SendingsContentsGetBySendingIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/sendings-contents_get-by-sending-ids -> 400 Bad Request: не корректный id")
    @AllureId("161143")
    fun test() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = ShipmentRequests.sendingsContentsGetBySendingIds(listOf("123-123-123")),
            expected = setOf(BrokenRule(code = 2, message = "Отсутвуют параметры в запросе"))
        )
    }
}