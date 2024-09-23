package ru.action_tech.qa.auto.api_tests.shipment.sendings.v1.packege_format_get_by_ids

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.shipment.PackageFormatGetByIdsV1
import ru.action_tech.qa.auto.api_models.shipment.ShipmentRequests.packageFormatGetByIds
import ru.action_tech.qa.auto.api_models.shipment.sendings.v1.receive_cases_get_by_ids.PackageFormatGetByIdsResponse
import ru.action_tech.qa.auto.utils.shipmentCrmClient
import ru.action_tech.qa.auto.api_models.Sale_ShipmentService
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID


class Test_PackageFormatGetByIds {

    private val formatIds by lazy {
        listOf(
            "8fd275ca-837a-e211-97b0-78e3b502da44",
            "ea644d28-9929-e611-86cf-78e3b502da44",
            "b646a9b7-5d6a-42fd-8a0f-fa95f39fd08a"
        )
    }

    @Test
    @Requirements("REQCRM-1622")
    @Sale_ShipmentService
    @PackageFormatGetByIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/packege-format_get-by-ids -> 200 ok: Метод получения форматов отправки")
    @AllureId("158791")
    fun test() {
        shipmentCrmClient.send(packageFormatGetByIds(formatIds)).also {
            assertThat(it).containsOnly(
                PackageFormatGetByIdsResponse(
                    packageFormatId = "ea644d28-9929-e611-86cf-78e3b502da44",
                    packageFormat = "Для партнеров"
                ),
                PackageFormatGetByIdsResponse(
                    packageFormatId = "8fd275ca-837a-e211-97b0-78e3b502da44",
                    packageFormat = "Конверт крафтовый (1шт.)"
                ),
                PackageFormatGetByIdsResponse(
                    packageFormatId = "b646a9b7-5d6a-42fd-8a0f-fa95f39fd08a",
                    packageFormat = "Конверт крафтовый"
                )
            )
        }
    }


    @Test
    @Requirements("REQCRM-1622")
    @Sale_ShipmentService
    @PackageFormatGetByIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/packege-format_get-by-ids -> 200 ok: Ответ: пустой список")
    @AllureId("169483")
    fun testEmptyResponse() {
        shipmentCrmClient.send(packageFormatGetByIds(listOf(DEFAULT_ID, ZERO_ID))).also {
            "Проверка что ответ пустой" { assertThat(it).isEmpty() }
        }
    }
}