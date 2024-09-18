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
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_BushAction360GetByIncidentNotFoundPositive {


    @Test
    @Sale_Supports
    @BushAction360GetByIncident
    @Response_200_Ok
    @Requirements("REQCRM-788")
    @DisplayName("/api/v1/bush-action360_get-by-incident -> 200 Ok: ничего не найдено")
    @AllureId("145866")
    fun test() {
        val response = supportsCrmClient.send(bushAction360GetByIncident(BushAction360GetByIncidentRequest(DEFAULT_ID)))

        "Проверяем, что ответ пустой" { assertTrue(response.isEmpty()) }
    }
}