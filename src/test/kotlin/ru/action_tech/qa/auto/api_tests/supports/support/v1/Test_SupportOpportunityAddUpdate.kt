package ru.action_tech.qa.auto.api_tests.supports.support.v1

import io.qameta.allure.AllureId
import io.qameta.allure.Feature
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_add.request.SupportOpportunityAddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_update.request.SupportOpportunityUpdateRequest
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.d
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.VTM_CALL
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.supportsCrmClient
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


class Test_SupportOpportunityAddUpdate {

    private val request by lazy {
        SupportsRequests.supportOpportunityAdd(
            SupportOpportunityAddRequest(
                startDate = getStringTime(
                    time = Instant.now() - (Instant.now().atZone(ZoneId.systemDefault()).dayOfMonth - 1).d(),
                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())
                ),
                endDate = "${Instant.now().atZone(ZoneId.systemDefault()).year}-12-31",
                accountId = "325B09A1-2002-48E4-AADC-A978196D8EA4",
                status = 11,
                partnerId = "B89FF32C-5F0B-DF11-809E-001CC45E3D96",
                systemUserId = VTM_CALL.id,
                isFixedDates = true,
                isForce = false
            )
        )
    }


    @Test
    @HistoryIssues("ARMAP-16854")
    @Sale_Supports
    @Feature("/api/v1/support-opportunity_add /api/v1/support-opportunity_update")
    @Response_200_Ok
    @Requirements("REQCRM-215", "REQCRM-216")
    @DisplayName("Методы создания и обновление возможной сделки клиента")
    @AllureId("145894")
    fun test() {

        val id = "Создание возможной сделки /api/v1/support-opportunity_add" { supportsCrmClient.send(request) }

        "Обновление возможной сделки (отмена ВЗ) /api/v1/support-opportunity_update" {
            supportsCrmClient.send(
                SupportsRequests.supportOpportunityUpdate(
                    SupportOpportunityUpdateRequest(
                        endDate = getStringTime(
                            time = Instant.now() - 1.d(),
                            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())
                        ),
                        id = id,
                        status = 14
                    )
                )
            ).run { assertTrue(matches(FieldData.REGEX_FOR_ID)) }
        }
    }
}