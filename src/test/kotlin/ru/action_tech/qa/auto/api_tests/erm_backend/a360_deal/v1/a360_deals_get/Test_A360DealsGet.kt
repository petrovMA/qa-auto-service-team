package ru.action_tech.qa.auto.api_tests.erm_backend.a360_deal.v1.a360_deals_get

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_ErmBackend
import ru.action_tech.qa.auto.api_models.erm_backend.A360DealsGetV1
import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests
import ru.action_tech.qa.auto.api_models.erm_backend.a360DealsGet
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.ermBackendArmSellerClient


class Test_A360DealsGet {

    @Test
    @Sale_ErmBackend
    @A360DealsGetV1
    @Response_200_Ok
    @HistoryIssues("ARMSEL-10606")
    @Requirements("REQCRM-1480")
    @DisplayName("$a360DealsGet -> 200 Ok: Получение списка сделок A360")
    @AllureId("145927")
    fun test() {
        val response = ermBackendArmSellerClient.send(ErmBackendRequests.a360DealGet())

        "Проверка что ответ не пустой" { assertTrue(response.isNotEmpty()) }
    }
}