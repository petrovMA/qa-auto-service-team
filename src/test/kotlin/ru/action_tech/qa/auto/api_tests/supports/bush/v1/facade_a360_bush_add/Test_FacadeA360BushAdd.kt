package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_add

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushAdd
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushAdd
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_add.request.FacadeA360BushAddRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushAdd {

    private val request by lazy {
        facadeA360BushAdd(
            FacadeA360BushAddRequest(
                customerIds = listOf("2abe4858-e21a-4b57-a78c-7f363c5f21dd"),
                factPrice = 0,
                factUsersAmount = 0,
                mainProductId = "130dd49e-ecca-e811-bb9b-00155d627f03",
                systemUserId = "94f431ce-2fec-ea11-bba7-00155d627f03"
            )
        )
    }

    @Test
    @Sale_Supports
    @FacadeA360BushAdd
    @Response_200_Ok
    @HistoryIssues("ARMAP-13618")
    @Requirements("REQCRM-784")
    @DisplayName("/api/v1/facade-a360-bush_add -> 200 Ok: Метод создания куста Актион 360")
    @AllureId("145870")
    fun test() {
        val response = supportsCrmClient.send(request)

        "Проверка что вернулся ID в формате guid" { assertTrue(response.id.matches(FieldData.PATTERN_FOR_ID)) }
    }
}