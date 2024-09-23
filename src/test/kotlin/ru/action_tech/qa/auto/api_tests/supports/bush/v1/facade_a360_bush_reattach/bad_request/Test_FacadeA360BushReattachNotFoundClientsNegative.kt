package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_reattach.bad_request

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushReattach
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetByManagerIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushReattach
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_reattach.request.FacadeA360BushReattachRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.USER_ACTIONUSKA
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_FacadeA360BushReattachNotFoundClientsNegative {
    private val userId by lazy { USER_ACTIONUSKA.id }
    lateinit var bushAction360Id: String

    @BeforeEach
    fun getDataForTest() {
        val response = supportsCrmClient.send(facadeA360BushGetByManagerIds(listOf(userId)))
        bushAction360Id = "Получение 'bushAction360Id' из предыдущего запроса" {
            response.first()
                .bushesA360
                ?.firstOrNull()
                ?.id
                .also { "Проверка что в ответе вернулся хоть 1 'bushAction360Id'" { assertThat(it).isNotNull } }!!
        }
    }

    @Test
    @Sale_Supports
    @FacadeA360BushReattach
    @Response_400_Bad_Request
    @Requirements("REQCRM-787")
    @DisplayName("/api/v1/facade-a360-bush_reattach -> 400 Bad Request: не найден менеджер")
    @AllureId("145883")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = facadeA360BushReattach(FacadeA360BushReattachRequest(bushAction360Id, DEFAULT_ID)),
            expected = setOf(BrokenRule(code = 20, message = "Не найден менеджер"))
        )
    }
}
