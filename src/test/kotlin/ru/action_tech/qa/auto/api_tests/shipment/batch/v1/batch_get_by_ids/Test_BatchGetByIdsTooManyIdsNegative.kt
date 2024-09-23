package ru.action_tech.qa.auto.api_tests.shipment.batch.v1.batch_get_by_ids

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.shipment.BatchGetByIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService


class Test_BatchGetByIdsTooManyIdsNegative {

    @Test
    @Issue("ARMAP-15709")
    @Requirements("REQCRM-1629")
    @Sale_ShipmentService
    @BatchGetByIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/batch_get-by-ids -> 400 Bad Request: слишком много идентификаторов")
    @AllureId("161141")
    fun test() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = ShipmentRequests.batchGetByIds((1..51).map { java.util.UUID.randomUUID().toString() }),
            expected = setOf(BrokenRule(code = 1, message = "Количество значений в запросе больше 100"))
        )
    }

    @Test
    @Issue("ARMAP-15709")
    @Requirements("REQCRM-1629")
    @Sale_ShipmentService
    @BatchGetByIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/batch_get-by-ids -> 400 Bad Request: не корректные параметры")
    @AllureId("158786")
    fun testWrongParams() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = ShipmentRequests.batchGetByIds(listOf("123-123-123")),
            expected = setOf(BrokenRule(code = 2, message = "Отсутвуют параметры в запросе"))
        )
    }
}