package ru.action_tech.qa.auto.api_tests.supports.bush.v1.bush_action360_get_by_incident

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.BushAction360GetByIncident
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.bushAction360GetByIncident
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_get_by_incident.request.BushAction360GetByIncidentRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_BushAction360GetByIncidentPositive {

    private val request by lazy {
        bushAction360GetByIncident(BushAction360GetByIncidentRequest("F4CC8BCA-E82C-4069-B416-896BE8693468"))
    }

    @Test
    @Sale_Supports
    @BushAction360GetByIncident
    @Response_200_Ok
    @Requirements("REQCRM-788")
    @DisplayName("/api/v1/bush-action360_get-by-incident -> 200 Ok: Метод поиска куста Актион 360 по обращению")
    @AllureId("145867")
    fun test_BushAction360GetByIncidentPositive() {
        val response = supportsCrmClient.send(request)

        "Проверка что ответ не пустой" { assertTrue(response.isNotEmpty()) }

        "Проверка что в ответе все id в формате guid" {
            response.forEach { assertTrue(it.id?.matches(FieldData.PATTERN_FOR_ID) ?: false) }
        }
    }
}