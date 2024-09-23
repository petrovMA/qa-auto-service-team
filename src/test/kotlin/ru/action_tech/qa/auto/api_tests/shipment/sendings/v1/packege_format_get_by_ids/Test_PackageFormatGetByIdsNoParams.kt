package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.packege_format_get_by_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.shipment.PackageFormatGetByIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService


class Test_PackageFormatGetByIdsNoParams {

    @Test
    @Requirements("REQCRM-1622")
    @Sale_ShipmentService
    @PackageFormatGetByIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/packege-format_get-by-ids -> 400 Bad Request: Не переданы параметры")
    @AllureId("158790")
    fun test() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = ShipmentRequests.packageFormatGetByIds(),
            expected = setOf(BrokenRule(code = 2, message = "Отсутвуют параметры в запросе"))
        )
    }
}