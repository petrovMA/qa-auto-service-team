package ru.action_tech.qa.auto.api_tests.demos.job_titles.v1.jobtitles

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.jobTitles
import ru.action_tech.qa.auto.api_models.demos.JobTitlesV1
import ru.action_tech.qa.auto.api_models.demos.jobTitlesV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_GetDemo {

    @Sale_Demos
    @JobTitlesV1
    @Response_200_Ok
    @Requirements("REQCRM-1151")
    @DisplayName("$jobTitlesV1 -> 200 Ok: Возвращает список должностей")
    @Test
    @AllureId("240896")
    fun test() {
        val response = demosCrmClient.send(jobTitles())

        "Проверка что ответне пустой" { assertTrue(response.isNotEmpty()) }
    }
}
