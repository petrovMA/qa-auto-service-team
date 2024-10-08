package ru.action_tech.qa.auto.api_tests.admin360_backend.customer.v1.jobtitles_get

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.api_models.admin360_backend.JobTitlesGetV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.api_models.Sale_Admin360Backend
import ru.action_tech.qa.auto.utils.admin360BackendCrmClient
import ru.action_tech.qa.auto.api_models.admin360_backend.Admin360BackendRequests.jobTitlesGet
import ru.action_tech.qa.auto.api_models.Response_401_Unauthorized


class Test_JobTitlesGetUnauthorized {

    @Test
    @Requirements("REQA360ADM-17")
    @Sale_Admin360Backend
    @Response_401_Unauthorized
    @JobTitlesGetV1
    @DisplayName("/api/v1/jobtitles_get -> 401 Unauthorized: (не передан токен)")
    @AllureId("152342")
    fun testTokenNull() {
        testBRUnauthorized(admin360BackendCrmClient, jobTitlesGet(null))
    }

    @Test
    @Requirements("REQA360ADM-17")
    @Sale_Admin360Backend
    @Response_401_Unauthorized
    @JobTitlesGetV1
    @DisplayName("/api/v1/jobtitles_get -> 401 Unauthorized: (некорректный токен)")
    @AllureId("152341")
    fun testTokenWrong() {
        testBRUnauthorized(admin360BackendCrmClient, jobTitlesGet("12321"))
    }
}