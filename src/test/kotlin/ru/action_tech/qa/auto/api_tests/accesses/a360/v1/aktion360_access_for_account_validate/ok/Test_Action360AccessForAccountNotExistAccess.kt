package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.aktion360_access_for_account_validate.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessForAccountValidateV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.enums.Company.UKD_DONT_TOUCH
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360AccessForAccountNotExistAccess {

    val request by lazy {
        AccessesRequests.action360AccessForAccountValidate(
            accountId = UKD_DONT_TOUCH.id
        )
    }

    @Test
    @Requirements("REQCRM-1575")
    @Sale_Accesses
    @Aktion360AccessForAccountValidateV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-access-for-account_validate -> 200 ok: нет действующего ДД по A360")
    @AllureId("154455")
    fun test() {
        "Проверяем, что у организации нет действующего ДД по A360" {
            assertFalse(accessesCrmClient.send(request))
        }
    }
}