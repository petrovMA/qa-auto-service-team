package ru.action_tech.qa.auto.api_tests.supports.support.v1

import io.qameta.allure.AllureId
import io.qameta.allure.Feature
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_add.request.SupportOpportunityA360AddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_update.request.SupportOpportunityA360UpdateRequest
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.d
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.VTM_CALL
import ru.action_tech.qa.auto.helpers.api.ClientHelper.getValidClient
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.utils.supportsCrmClient
import java.net.HttpURLConnection
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class Test_SupportOpportunityA360AddUpdate {
    private lateinit var orgId: String
    private val formatter by lazy { DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()) }

    @BeforeEach
    fun getOrCreateClient() {
        orgId = getValidClient()
    }

    @Test
    @Sale_Supports
    @Feature("/api/v1/support-opportunitya360_add /api/v1/support-opportunitya360_update")
    @HistoryIssues("ARMAP-16119")
    @Response_200_Ok
    @Requirements("REQCRM-217", "REQCRM-218")
    @DisplayName("Методы создания и обновления возможной сделки A360 клиента")
    @AllureId("145893")
    fun test_SupportOpportunityA360AddUpdatePositive() {
        var request: Request = SupportsRequests.supportOpportunityA360Add(
            SupportOpportunityA360AddRequest(
                startDate = getStringTime(
                    time = Instant.now() - (Instant.now().atZone(ZoneId.systemDefault()).dayOfMonth - 1).d(),
                    formatter = formatter
                ),
                endDate = "${Instant.now().atZone(ZoneId.systemDefault()).year}-12-31",
                accountId = orgId,
                status = 125,
                partnerId = "B89FF32C-5F0B-DF11-809E-001CC45E3D96",
                systemUserId = VTM_CALL.id,
                isFixedDates = true,
                isForce = false
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }


        val id = "Создание возможной сделки Актион360 /api/v1/support-opportunitya360_add для клиента $orgId" {
            supportsCrmClient.send(request).deserialize<String>()
        }

        "Обновление возможной сделки (отмена ВЗ Актион360) /api/v1/support-opportunitya360_update для клиента $orgId" {
            request = SupportsRequests.supportOpportunityA360Update(
                SupportOpportunityA360UpdateRequest(
                    id = id,
                    status = 127,
                    endDate = getStringTime(
                        time = Instant.now() - 1.d(),
                        formatter = formatter
                    ),
                    rejectedOn = getStringTime(
                        time = Instant.now() - 1.d(),
                        formatter = formatter
                    )
                )
            ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }

            supportsCrmClient.send(request).deserialize<String>()
        }
    }
}
