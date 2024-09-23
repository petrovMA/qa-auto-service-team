package ru.action_tech.qa.auto.api_tests.shipment.sending_contents.v1.sending_contents_get_by_sending_id

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.shipment.SendingContentsGetBySendingIdV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.sendingContentsGetBySendingId
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import java.util.*


class Test_SendingContentsGetBySendingId {

    @Test
    @HistoryIssues("ARMAP-15766")
    @Requirements("REQCRM-1627")
    @Sale_ShipmentService
    @SendingContentsGetBySendingIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/sending-contents_get-by-sending-id -> 200 Ok: Метод получения позиции отправления по ID отправления")
    @AllureId("158789")
    fun test() {
        val resp = shipmentCrmClient.send(sendingContentsGetBySendingId("686ef31e-950b-4c12-a73e-00000016d223"))

        "Ответ содержит данные" { assertThat(resp).isNotEmpty }
    }

    @Test
    @Requirements("REQCRM-1627")
    @Sale_ShipmentService
    @SendingContentsGetBySendingIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/sending-contents_get-by-sending-id -> 200 Ok: sendingId не найден")
    @AllureId("169054")
    fun testNotFound() {
        val resp = shipmentCrmClient.send(sendingContentsGetBySendingId(UUID.randomUUID().toString()))

        "Ответ не содержит данных" { assertThat(resp).isEmpty() }
    }
}