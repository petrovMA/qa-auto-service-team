package ru.action_tech.qa.auto.api_tests.accesses.license.v1.task_queue_get_grouped_by_program.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.TaskQueueGetGroupedByProgramV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.task_queue_get_grouped_by_program.TaskQueueGetGroupedByProgramResponse
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_TaskQueueGetGroupedByProgramPositive {

    private val request by lazy {
        AccessesRequests.taskQueueGetGroupedByProgram()
            .apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @Requirements("REQCRM-243")
    @Sale_Accesses
    @TaskQueueGetGroupedByProgramV1
    @Response_200_Ok
    @DisplayName("/api/v1/task-queue_get-grouped-by-program -> 200 ok")
    @AllureId("145346")
    fun test_TaskQueueGetGroupedByProgramPositive() {
        assertThat(
            accessesCrmClient.send(request).deserialize<Array<TaskQueueGetGroupedByProgramResponse>>()
        ).isNotEmpty
    }
}