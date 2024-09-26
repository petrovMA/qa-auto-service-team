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
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360DemoValidatePositive {

    private val request by lazy {
        AccessesRequests.action360DemoValidate(listOf("'E99550C7-237E-E511-8E6E-78E3B502DA44'"))
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16572
    @Requirements("REQCRM-237")
    @Sale_Accesses
    @Aktion360DemoValidateV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-demo_validate -> 200 ok")
    @AllureId("145318")
    fun test() {
        "Проверяем что массив в ответе содержит данные" { assertThat(accessesCrmClient.send(request)).isNotEmpty }
    }
}