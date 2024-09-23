package ru.action_tech.qa.auto.api_tests.supports.support.v1

import io.qameta.allure.AllureId
import io.qameta.allure.Feature
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_add.request.SupportAddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_update.request.SupportUpdateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_change_manager.request.SupportsChangeManagerRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_manager.request.SupportsGetByManagerRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.data.VTM_CALL
import ru.action_tech.qa.auto.utils.d
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.supportsCrmClient
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


class Test_SupportAddChangeManagerUpdate {
    private val supportId = "F2E97F35-96AB-408B-89A0-1596CC19522C"


    @Test
    @Sale_Supports
    @Feature("/api/v1/support-add /api/v1/supports_change-manager /api/v1/support-update")
    @Response_200_Ok
    @HistoryIssues("ARMAP-11024")
    @Requirements("REQCRM-213", "REQCRM-214", "REQCRM-222", "REQCRM-223")
    @DisplayName("Методы создания сопровождения клиента, смена менеджера и обновления сопровождения клиента")
    @AllureId("145892")
    fun test() {

        val requestSupportAdd = SupportsRequests.supportAdd(
            SupportAddRequest(
                supportType = 3,
                startDate = getStringTime(
                    time = Instant.now() - (Instant.now().atZone(ZoneId.systemDefault()).dayOfMonth - 1).d(),
                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())
                ),
                endDate = "${Instant.now().atZone(ZoneId.systemDefault()).year}-12-31",
                accountId = "325B09A1-2002-48E4-AADC-A978196D8EA4",
                partnerId = "B89FF32C-5F0B-DF11-809E-001CC45E3D96",
                systemUserId = VTM_CALL.id,
                status = 31
            )
        )

        val id = supportsCrmClient.send(requestSupportAdd)

        val requestSupportsGetByManager = SupportsRequests.supportsGetByManager(SupportsGetByManagerRequest(ACTIONUSKA.id))

        val amount = "Получение размера списка" { supportsCrmClient.send(requestSupportsGetByManager).size }

        supportsCrmClient.send(
            SupportsRequests.supportsChangeManager(
                SupportsChangeManagerRequest(
                    modifiedBy = VTM_CALL.id,
                    newManagerId = ACTIONUSKA.id,
                    partnerId = "B89FF32C-5F0B-DF11-809E-001CC45E3D96",
                    supportsId = listOf(id)
                )
            )
        )

        assertThat(supportsCrmClient.send(requestSupportsGetByManager)).run {
            "Проверка что у менеджера ${ACTIONUSKA.id} на 1 сопровождение больше ($amount + 1)" { hasSize(amount + 1) }
        }


        supportsCrmClient.send(
            SupportsRequests.supportUpdate(
                SupportUpdateRequest(
                    endDate = getStringTime(
                        time = Instant.now() - 1.d(),
                        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())
                    ),
                    id = supportId,
                    status = 134
                )
            )
        ).apply {
            "Проверка что в ответе id менеджера: $supportId" {
                assertEqual(this.uppercase(), supportId.uppercase())
            }
        }
    }
}