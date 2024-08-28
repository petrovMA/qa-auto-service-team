package ru.action_tech.qa.auto.api_tests.admin360_backend.customer.v1.jobtitles_get

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.admin360_backend.JobTitlesGetV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.Sale_Admin360Backend
import ru.action_tech.qa.auto.utils.admin360BackendCrmClient
import ru.action_tech.qa.auto.api_models.admin360_backend.Admin360BackendRequests.jobTitlesGet
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.core.assertions.assertTrue


class Test_JobTitlesGet {

    @Test
    @Requirements("REQA360ADM-17")
    @Sale_Admin360Backend
    @Response_200_Ok
    @JobTitlesGetV1
    @DisplayName("/api/v1/jobtitles_get -> 200 ok")
    @AllureId("152340")
    fun test() {
        assertTrue(admin360BackendCrmClient.send(jobTitlesGet()).isEmpty().not())
    }
}