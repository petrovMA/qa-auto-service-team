package ru.action_tech.qa.auto.api_tests.erm_backend.a360_deal.v1.a360_deals_get

import io.qameta.allure.AllureId
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBRUnauthorizedList
import ru.action_tech.qa.auto.api_models.Response_401_Unauthorized
import ru.action_tech.qa.auto.api_models.Sale_ErmBackend
import ru.action_tech.qa.auto.api_models.erm_backend.A360DealsGetV1
import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests
import ru.action_tech.qa.auto.api_models.erm_backend.a360DealsGet
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.ermBackendArmSellerClient


class Test_A360DealsGetAuthErrors {

    private val requests by lazy {
        mapOf(
            "Не передан токен" to ErmBackendRequests.a360DealGet(null),
            "Не корректный токен" to ErmBackendRequests.a360DealGet(RandomStringUtils.randomNumeric(100)),
            "Пустой токен" to ErmBackendRequests.a360DealGet("")
        )
    }

    @Test
    @Sale_ErmBackend
    @A360DealsGetV1
    @Response_401_Unauthorized
    @Requirements("REQCRM-1480")
    @DisplayName("$a360DealsGet -> 401 Unauthorized: Получение списка сделок A360")
    @AllureId("177565")
    fun test() {
        checkBRUnauthorizedList(ermBackendArmSellerClient, requests)
    }
}
