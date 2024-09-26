package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_departments_get.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360DepartmentsGetV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_departments_get.Action360DepartmentsResponse
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_Action360DepartmentsGetPositive {

    private val request by lazy {
        AccessesRequests.getAction360Departments()
            .apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @Requirements("REQCRM-234")
    @Sale_Accesses
    @Aktion360DepartmentsGetV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-departments_get -> 200 ok")
    @AllureId("145319")
    fun test_Action360DepartmentsGetPositive() {
        val response = accessesCrmClient.send(request).deserialize<Array<Action360DepartmentsResponse>>()

        "Проверяем что массив в ответе содержит данные" { assertThat(response).isNotEmpty }
    }
}