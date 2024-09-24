package ru.action_tech.qa.auto.api_tests.arm_shipment.v1.sending_get_list_by_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRuleWithDevMessage
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_ArmSellerShipment
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.arm_shipment.ArmShipmentRequests.sendingGetListByCustomer
import ru.action_tech.qa.auto.api_models.arm_shipment.SendingGetListByCustomerV1
import ru.action_tech.qa.auto.api_models.arm_shipment.sendingGetListByCustomerV1
import ru.action_tech.qa.auto.utils.shipmentArmSellerClient


class Test_SendingGetListByCustomerWrongRequest {

    @Test
    @Requirements("REQCRM-1139")
    @Sale_ArmSellerShipment
    @SendingGetListByCustomerV1
    @Response_400_Bad_Request
    @DisplayName("$sendingGetListByCustomerV1 -> 400 Bad Request: не передан параметр id")
    @AllureId("184049")
    fun testNoId() {
        checkBR(
            apiClient = shipmentArmSellerClient,
            request = sendingGetListByCustomer(id = null, type = "1", limitSendingData = "true"),
            expected = BrokenRuleWithDevMessage(0, listOf("Идентификатор клиента не может быть пустым"))
        )
    }

    @Test
    @Requirements("REQCRM-1139")
    @Sale_ArmSellerShipment
    @SendingGetListByCustomerV1
    @Response_400_Bad_Request
    @DisplayName("$sendingGetListByCustomerV1 -> 400 Bad Request: не передан параметр type")
    @AllureId("184050")
    fun testNoType() {
        checkBR(
            apiClient = shipmentArmSellerClient,
            request = sendingGetListByCustomer("f88a0590-a4b2-e911-bba3-00155d627f03", true, null),
            expected = BrokenRuleWithDevMessage(code = 0, messages = listOf("Неизвестный тип клиента"))
        )
    }

    @Test
    @Requirements("REQCRM-1139")
    @Sale_ArmSellerShipment
    @SendingGetListByCustomerV1
    @Response_400_Bad_Request
    @DisplayName("$sendingGetListByCustomerV1 -> 400 Bad Request: не валидный параметр type")
    @AllureId("184051")
    fun testTypeNotValid() {
        checkBR(
            apiClient = shipmentArmSellerClient,
            request = sendingGetListByCustomer("e793cb15-afc5-4d8a-967a-aef6f94326c0", true, "123"),
            expected = BrokenRuleWithDevMessage(code = 0, messages = listOf("Неизвестный тип клиента"))
        )
    }
}