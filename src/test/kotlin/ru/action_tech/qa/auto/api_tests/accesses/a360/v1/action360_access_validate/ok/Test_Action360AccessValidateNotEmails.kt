package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_validate.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessValidateV1
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360AccessValidateNotEmails {

    private val request by lazy {
        AccessesRequests.action360AccessValidate(emptyArray())
    }

    @Test
    @HistoryIssues("ARMAP-12352")
    @Requirements("REQCRM-236")
    @Sale_Accesses
    @Aktion360AccessValidateV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-access_validate -> 200 ok: email = передан пустой")
    @AllureId("145313")
    fun test_Action360AccessValidateNotEmails() {
        accessesCrmClient.send(request).apply {
            "Проверяем, что массив в ответе не содержит данные" { assertThat(this).isEmpty() }
        }
    }
}