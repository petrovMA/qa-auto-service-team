package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.total_sendings_qty_get_by_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests
import ru.action_tech.qa.auto.api_models.shipment.TotalSendingsQtyGetByCustomerId
import ru.action_tech.qa.auto.api_models.shipment.totalSendingsQtyGetByCustomerId
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.shipmentCrmClient


class Test_BadRequest {
    private val testCases by lazy {
        listOf(
            "customerId = не валиден" to {
                checkBR(
                    apiClient = shipmentCrmClient,
                    request = ShipmentRequests.totalSendingsQtyGetByCustomerId(FieldData.INVALID_ID),
                    BrokenRule(code = 0, message = "Отсутствует CustomerId")
                )
            },
            "customerId = пустая строка" to {
                checkBR(
                    apiClient = shipmentCrmClient,
                    request = ShipmentRequests.totalSendingsQtyGetByCustomerId(""),
                    BrokenRule(code = 0, message = "Отсутствует CustomerId")
                )
            },
            "customerId = не передан" to {
                checkBR(
                    apiClient = shipmentCrmClient,
                    request = ShipmentRequests.totalSendingsQtyGetByCustomerId(),
                    BrokenRule(code = 0, message = "Отсутствует CustomerId")
                )
            }
        )
    }

    @Sale_ShipmentService
    @TotalSendingsQtyGetByCustomerId
    @Requirements("REQCRM-1649")
    @Response_400_Bad_Request
    @DisplayName("$totalSendingsQtyGetByCustomerId -> 400 bad request")
    @Test
    @AllureId("257083")
    fun test() {
        testCases.forEach { (testName, case) -> testName soft { case.invoke() } }
    }
}