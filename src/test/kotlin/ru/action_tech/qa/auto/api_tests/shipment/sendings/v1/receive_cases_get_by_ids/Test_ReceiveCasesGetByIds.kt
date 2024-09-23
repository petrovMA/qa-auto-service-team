package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.receive_cases_get_by_ids

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.shipment.ReceiveCasesGetByIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.receiveCasesGetByIds
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.utils.common_models.CommonDto


class Test_ReceiveCasesGetByIds {

    private val receiveCasesIds by lazy {
        listOf(
            "02649244-74e8-4b57-b22e-01f2fbcca50c",
            "78861586-e21c-4a7b-a828-02a7d77422c2",
            "3bece8ce-5ac1-4108-8c85-2aedf6dcfe28"
        )
    }

    @Test
    @Requirements("REQCRM-1623")
    @Sale_ShipmentService
    @ReceiveCasesGetByIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/receive-cases_get-by-ids -> 200 Ok: Receive cases by 3 ids")
    @AllureId("158793")
    fun test() {
        val resp = shipmentCrmClient.send(receiveCasesGetByIds(receiveCasesIds))

        "Проверка что в ответе вернулись все ожидаемые элементы" {
            assertThat(resp).containsOnly(
                CommonDto(
                    id = "02649244-74e8-4b57-b22e-01f2fbcca50c",
                    name = "Курьером: Союзпечать-сервис"
                ),
                CommonDto(
                    id = "78861586-e21c-4a7b-a828-02a7d77422c2",
                    name = "Курьером: Столичный курьер"
                ),
                CommonDto(
                    id = "3bece8ce-5ac1-4108-8c85-2aedf6dcfe28",
                    name = "Курьером: М-СИТИ"
                )
            )
        }
    }
}