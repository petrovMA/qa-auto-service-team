package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.sendings_get_by_customer_id

import io.qameta.allure.AllureId
import org.junit.jupiter.api.*
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.shipment.SendingsGetByCustomerIdV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.sendingsGetByCustomerId
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.Response_200_Ok


class Test_SendingsGetByCustomerIdWrongId {

    @Test
    @HistoryIssues("ARMAP-15132")
    @Requirements("REQCRM-1632")
    @Sale_ShipmentService
    @SendingsGetByCustomerIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/sendings_get-by-customer-id -> 200 ok: Empty response, Not found by Id")
    @AllureId("158797")
    fun test() {
        checkBR(
            apiClient = shipmentCrmClient,
            request = sendingsGetByCustomerId("123321"),
            BrokenRule(code = 0, message = "Отсутствует CustomerId")
        )
    }
}