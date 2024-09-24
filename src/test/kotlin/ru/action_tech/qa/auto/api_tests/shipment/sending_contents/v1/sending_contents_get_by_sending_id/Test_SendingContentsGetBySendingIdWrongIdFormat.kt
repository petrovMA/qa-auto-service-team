package ru.action_tech.qa.auto.api_tests.shipment.sending_contents.v1.sending_contents_get_by_sending_id

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.shipment.SendingContentsGetBySendingIdV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.sendingContentsGetBySendingId
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService


class Test_SendingContentsGetBySendingIdWrongIdFormat {

    @Test
    @Requirements("REQCRM-1627")
    @Sale_ShipmentService
    @SendingContentsGetBySendingIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/sending-contents_get-by-sending-id -> 400 Bad Request: не валидный sendingId")
    @AllureId("158788")
    fun test() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = sendingContentsGetBySendingId("***-***-***-***-***"),
            BrokenRule(code = 2, message = "Отсутвуют параметры в запросе")
        )
    }
}