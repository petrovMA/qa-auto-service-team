package ru.action_tech.qa.auto.api_tests.shipment.batch.v1.batch_get_by_ids

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.shipment.BatchGetByIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.batchGetByIds
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Response_200_Ok


class Test_BatchGetByIdsPositive {

    private val batchIds by lazy {
        listOf(
            "792D11A9-45E2-43A1-93E7-0000402931CD",
            "D1E11820-9350-4E95-BC4C-00007E3FD835",
            "8B1764A0-A3FB-4B96-AFD8-0000A1108C7E",
            "1CC16FF9-7756-41EC-BB0F-0000ABEDF7B3",
            "BD5732E9-2D74-41B2-8C16-0000DDA4F7FD",
            "A4833A90-1B8C-4CA5-B301-00010361ECB8",
            "1D50D39C-F4EA-418C-B02F-000148B0E59E",
            "F3650D3B-22E8-42AC-A518-000167C35482",
            "3DC68D51-5B38-432D-A6BA-0001891CE948",
            "400561B0-B103-45C9-9ADC-0002A4258B7D",
            "307A3528-54D2-4335-86AE-00034B7D633E",
            "CDCD89F5-5F26-4947-8483-00038932FA0A",
            "D663146E-85AC-4D58-ADC5-00039060AF16",
            "379800DE-7AAD-46C2-9BBE-0003CAABCFBB",
            "886A5892-C345-46BB-95B3-0003DA131BAE",
            "EF3615D2-9714-4493-AF63-00044F9E359D"
        )
    }

    @Test
    @Requirements("REQCRM-1629")
    @Sale_ShipmentService
    @BatchGetByIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/batch_get-by-ids -> 200 ok: Список отправлений клиента по ID клиента")
    @AllureId("158787")
    fun test() {
        val resp = shipmentCrmClient.send(batchGetByIds(batchIds))

        "Ответ содержит все Ids из списка batchIds" ("ids" to batchIds) {
            assertThat(resp.map { it.id.uppercase() }).containsAll(batchIds)
        }
    }
}