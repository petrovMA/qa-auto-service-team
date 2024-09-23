package ru.action_tech.qa.auto.api_tests.shipment.track_number.track_numbers_get_by_sending_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.api_models.shipment.TrackNumbersGetBySendingIdsV1
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService


class Test_TrackNumbersGetBySendingIdsNegative {

    @Test
    @NotAutomated
    @Requirements("REQCRM-1625")
    @Sale_ShipmentService
    @TrackNumbersGetBySendingIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/track-numbers_get-by-sending-ids -> 400 Bad Request: ")
    @AllureId("158798")
    fun test_TrackNumbersGetBySendingIdsNegative() {

    }
}