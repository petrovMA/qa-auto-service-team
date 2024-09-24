package ru.action_tech.qa.auto.api_tests.shipment.track_number.track_numbers_get_by_sending_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.*
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.shipment.TrackNumbersGetBySendingIdsV1
import ru.action_tech.qa.auto.api_models.Response_200_Ok


class Test_TrackNumbersGetBySendingIdsPositive {

    @Test
    @NotAutomated
    @Requirements("REQCRM-1625")
    @Sale_ShipmentService
    @TrackNumbersGetBySendingIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/track-numbers_get-by-sending-ids -> 200 ok")
    @AllureId("158799")
    fun test_TrackNumbersGetBySendingIdsPositive() {

    }
}