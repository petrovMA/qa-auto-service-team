package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.sendings_get_by_customer_id

import io.qameta.allure.AllureId
import org.junit.jupiter.api.*
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.shipment.SendingsGetByCustomerIdV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.sendingsGetByCustomerId
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.data.FieldData


class Test_SendingsGetByCustomerIdPositive {

    @Test
    @HistoryIssues("ARMAP-15132")
    @Requirements("REQCRM-1632")
    @Sale_ShipmentService
    @SendingsGetByCustomerIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/sendings_get-by-customer-id -> 200 ok")
    @AllureId("158795")
    fun test() {
        assertTrue(shipmentCrmClient.send(sendingsGetByCustomerId("e793cb15-afc5-4d8a-967a-aef6f94326c0")).isNotEmpty())
    }


    @Test
    @HistoryIssues("ARMAP-15132")
    @Requirements("REQCRM-1632")
    @Sale_ShipmentService
    @SendingsGetByCustomerIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/sendings_get-by-customer-id -> 200 ok: parameter: limitSendingData = true")
    @AllureId("158796")
    fun testLimitSendingData() {
        assertTrue(shipmentCrmClient.send(sendingsGetByCustomerId("e793cb15-afc5-4d8a-967a-aef6f94326c0", true)).isNotEmpty())
    }

    @Test
    @Requirements("REQCRM-1632")
    @Sale_ShipmentService
    @SendingsGetByCustomerIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/sendings_get-by-customer-id -> 200: Empty result")
    @AllureId("158794")
    fun testNotFound() {
        assertTrue(shipmentCrmClient.send(sendingsGetByCustomerId(FieldData.DEFAULT_ID)).isEmpty())
    }
}