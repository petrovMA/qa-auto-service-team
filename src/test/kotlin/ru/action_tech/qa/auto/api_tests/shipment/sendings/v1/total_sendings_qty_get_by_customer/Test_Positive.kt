package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.total_sendings_qty_get_by_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests
import ru.action_tech.qa.auto.api_models.shipment.TotalSendingsQtyGetByCustomerId
import ru.action_tech.qa.auto.api_models.shipment.totalSendingsQtyGetByCustomerId
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.enums.Company
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.shipmentCrmClient

class Test_Positive {
    private val testCustomerId by lazy { Company.COMPANY_FOR_SENDING.id!! }
    private val minTotalSendings = 7000

    @Sale_ShipmentService
    @TotalSendingsQtyGetByCustomerId
    @Requirements("REQCRM-1649")
    @Response_200_Ok
    @DisplayName("$totalSendingsQtyGetByCustomerId -> 200 Ok : список отправлений клиента")
    @Test
    @AllureId("257084")
    fun test() {
        checkSendingsResponseAmount("Ответ больше $minTotalSendings", "false") { a -> a > minTotalSendings }
        checkSendingsResponseAmount("Ответ меньше $minTotalSendings") { a -> a < minTotalSendings }
        checkSendingsResponseAmount("Ответ = 0", customerId = FieldData.FIRST_ID) { a -> a == 0 }
    }

    private fun checkSendingsResponseAmount(
        message: String,
        isLimit: String = "true",
        customerId: String = testCustomerId,
        check: (input: Int) -> Boolean
    ) {
        shipmentCrmClient.send(ShipmentRequests.totalSendingsQtyGetByCustomerId(customerId, isLimit))
            .apply { message.assertTrue { check(this) } }
    }
}