package ru.action_tech.qa.auto.api_tests.accesses.customer.v1.action360_welcome_letter_send.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360WelcomeLetterSendV1
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_welcome_letter_send.Action360WelcomeLetterRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360WelcomeLetterSendPositive {

    private val request by lazy {
        AccessesRequests.action360WelcomeLetterSend(
            Action360WelcomeLetterRequest(
                accessId = "87EBCE20-CCFC-4C3A-92C8-50AF4B6AE183",
                managerId = null,
                lastName = "Автотестов",
                firstName = "Автотест",
                middleName = "Автотестович",
                email = ContactPerson.AUTOTEST_AUTOTESTOV_WITH_ACCESS.email,
                bitrixId = ContactPerson.AUTOTEST_AUTOTESTOV_WITH_ACCESS.bitrixId.toString()
            )
        )
    }

    @Test
    @Requirements("REQCRM-226")
    @Sale_Accesses
    @Aktion360WelcomeLetterSendV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-welcome-letter_send -> 200 Ok")
    @AllureId("145304")
    fun test() {
        accessesCrmClient.send(request).also {
            "Проверяем, в ответе вернулось значение 'True'" { assertTrue(it) }
        }
    }
}