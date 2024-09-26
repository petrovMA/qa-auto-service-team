package ru.action_tech.qa.auto.api_tests.accesses.customer.v1.action360_autologin_send.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AutologinSendV1
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_autologin_send.Action360AutologinSendRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360AutoLoginSendPositive {

    private val request by lazy {
        AccessesRequests.action360AutologinSend(
            Action360AutologinSendRequest(
                accessId = "c231969f-50ed-414c-a9e6-84c9a7b120c4",
                managerId = "E99550C7-237E-E511-8E6E-78E3B502DA44",
                lastName = "Выдача",
                firstName = "Автотест",
                middleName = "Демодоступа",
                email = "aktion360-access-tree_get-by-access-account@action-autotest.ru",
                bitrixId = "18753605"
            )
        )
    }

    @Test
    @Requirements("REQCRM-227")
    @Sale_Accesses
    @Aktion360AutologinSendV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-autologin_send -> 200 ok")
    @AllureId("145301")
    fun test() {
        val response = "отправляем запрос" { accessesCrmClient.send(request) }

        "Проверяем что запрос выполнился успешно" { assertThat(response).isTrue }
    }
}