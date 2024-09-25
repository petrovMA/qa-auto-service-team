package ru.action_tech.qa.auto.api_tests.demos.job_titles.v1.jobtitles

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_401_Unauthorized
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.jobTitles
import ru.action_tech.qa.auto.api_models.demos.JobTitlesV1
import ru.action_tech.qa.auto.api_models.demos.jobTitlesV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBRUnauthorizedList
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_GetDemoWrongRequestData {

    private val requests by lazy {
        mapOf(
            "Не передан токен" to jobTitles(null),
            "Не корректный токен" to jobTitles(FieldData.WRONG_TOKEN),
            "Пустой токен" to jobTitles("")
        )
    }

    @Sale_Demos
    @JobTitlesV1
    @Response_401_Unauthorized
    @Requirements("REQCRM-1151")
    @DisplayName("$jobTitlesV1 -> 401 Unauthorized")
    @Test
    @AllureId("240897")
    fun test() {
        checkBRUnauthorizedList(demosCrmClient, requests)
    }
}
