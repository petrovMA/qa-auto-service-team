package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_demo_validate.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360DemoValidateV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360DemoValidateNotFound {

    private val request by lazy { AccessesRequests.action360DemoValidate(listOf("'$ZERO_ID'")) }

    @Test
    @Requirements("REQCRM-237")
    @Sale_Accesses
    @Aktion360DemoValidateV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-demo_validate -> 400 Bad Request: по id ничего не найдено")
    @AllureId("145316")
    fun test_Action360DemoValidateNotFound() {

        "Проверяем что массив в ответе НЕ содержит данные" { assertThat(accessesCrmClient.send(request)).isEmpty() }
    }
}