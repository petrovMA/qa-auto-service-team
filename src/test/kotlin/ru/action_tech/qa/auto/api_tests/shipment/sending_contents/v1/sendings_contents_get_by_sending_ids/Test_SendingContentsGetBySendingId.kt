package ru.action_tech.qa.auto.api_tests.shipment.sending_contents.v1.sendings_contents_get_by_sending_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.*
import org.assertj.core.api.Assertions.assertThat
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.shipment.SendingsContentsGetBySendingIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.sendingsContentsGetBySendingIds
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import java.util.*


class Test_SendingContentsGetBySendingId {

    private val sendingIds by lazy {
        listOf(
            "686EF31E-950B-4C12-A73E-00000016D223",
            "E810689D-4DCF-4CA0-8B59-00000045C764",
            "177E7C57-33B8-4EDE-9D3A-00000084E9A6",
            "20F4C976-4968-46F6-A033-00000092E31F"
        )
    }

    @Test
    @Requirements("REQCRM-1648")
    @Sale_ShipmentService
    @SendingsContentsGetBySendingIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/sendings-contents_get-by-sending-ids -> 200 Ok: Метод получения позиций отправления по ID отправлений")
    @AllureId("161144")
    fun test() {
        val resp = shipmentCrmClient.send(sendingsContentsGetBySendingIds(sendingIds))

        "Ответ содержит все Ids из списка batchIds" ("ids" to sendingIds) {
            assertThat(resp.map { it.sendingId.uppercase() }).containsAll(sendingIds)
        }
    }

    @Test
    @Requirements("REQCRM-1648")
    @Sale_ShipmentService
    @SendingsContentsGetBySendingIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/sendings-contents_get-by-sending-ids -> 200 Ok: Ничего не найдено")
    @AllureId("161145")
    fun testEmptyResponse() {
        val resp = shipmentCrmClient.send(sendingsContentsGetBySendingIds((1..10).map { UUID.randomUUID().toString() }))

        "Ответ не содержит данных" { assertThat(resp).isEmpty() }
    }
}