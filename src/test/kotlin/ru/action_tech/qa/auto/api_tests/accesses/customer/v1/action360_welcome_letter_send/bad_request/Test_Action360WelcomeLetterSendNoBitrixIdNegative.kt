package ru.action_tech.qa.auto.api_tests.accesses.customer.v1.action360_welcome_letter_send.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360WelcomeLetterSendV1
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_welcome_letter_send.Action360WelcomeLetterRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Action360WelcomeLetterSendNoBitrixIdNegative {

    private val request by lazy {
        AccessesRequests.action360WelcomeLetterSend(
            isNonNull = true,
            request = Action360WelcomeLetterRequest(
                accessId = "CEBE039A-F5DB-46A5-8B65-18FEB3B07A12",
                managerId = "E99550C7-237E-E511-8E6E-78E3B502DA44",
                lastName = "Кондрина",
                firstName = "Валентина",
                middleName = "Юрьевна",
                email = "valusia_k@mail.ru",
                bitrixId = null
            )
        )
    }


    val expectedError by lazy {
        BrokenRule(
            code = 3,
            message = "У пользователя отсутствует BitrixId."
        )
    }

    @Test
    @Requirements("REQCRM-226")
    @Sale_Accesses
    @Aktion360WelcomeLetterSendV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-welcome-letter_send -> 400 Bad Request: не передан bitrixId")
    @AllureId("145303")
    fun test_Action360WelcomeLetterSendNoBitrixIdNegative() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(expectedError)
        )
    }
}