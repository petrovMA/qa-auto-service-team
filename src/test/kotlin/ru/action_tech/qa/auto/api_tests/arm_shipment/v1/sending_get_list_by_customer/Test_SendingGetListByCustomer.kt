package ru.action_tech.qa.auto.api_tests.arm_shipment.v1.sending_get_list_by_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.arm_shipment.ArmShipmentRequests.sendingGetListByCustomer
import ru.action_tech.qa.auto.utils.shipmentArmSellerClient
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_ArmSellerShipment
import ru.action_tech.qa.auto.api_models.arm_shipment.SendingGetListByCustomerV1
import ru.action_tech.qa.auto.api_models.arm_shipment.sendingGetListByCustomerV1


class Test_SendingGetListByCustomer {

    private val request by lazy {
        sendingGetListByCustomer(id = "e793cb15-afc5-4d8a-967a-aef6f94326c0", type = "1", limitSendingData = "true")
    }

    @Test
    @Requirements("REQCRM-1139")
    @Sale_ArmSellerShipment
    @SendingGetListByCustomerV1
    @Response_200_Ok
    @DisplayName("$sendingGetListByCustomerV1 -> 200 Ok: Вернулся список сделок А360 по подразделению")
    @AllureId("184052")
    fun test() {
        val response = shipmentArmSellerClient.send(request)

        "Проверяем что ответ НЕ пустой" { assertTrue(response.isNotEmpty()) }
    }
}