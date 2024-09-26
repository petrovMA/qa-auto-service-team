package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_validate.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessValidateV1
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360AccessValidatePositive {

    private val request by lazy {
        AccessesRequests.action360AccessValidate(arrayOf("test@tst.ru", "test@tst.org", "erm-test@action-press.ru"))
    }

    @Test
    @HistoryIssues("ARMAP-12352")
    @Requirements("REQCRM-236")
    @Sale_Accesses
    @Aktion360AccessValidateV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-access_validate -> 200 ok")
    @AllureId("145315")
    fun test_Action360AccessValidatePositive() {

        val result = accessesCrmClient.send(request)

        result.first { it.email.equals("test@tst.ru") }.apply {
            "Проверяем, что для email = 'test@tst.ru' нет платного доступа" {
                assertFalse(this.hasAccess)
            }
            "Проверяем, что для email = 'test@tst.ru' нет демо-доступа" {
                assertFalse(this.hasDemoAccess)
            }
        }

        result.first { it.email.equals("test@tst.org") }.apply {
            "Проверяем, что для email = 'test@tst.org' нет платного доступа" {
                assertFalse(this.hasAccess)
            }

            "Проверяем, что для email = 'test@tst.org' нет демо-доступа" {
                assertFalse(this.hasDemoAccess)
            }
        }

        result.first { it.email.equals("erm-test@action-press.ru") }.apply {
            "Проверяем, что для email = 'erm-test@action-press.ru' есть платный доступ" {
                assertTrue(this.hasAccess)
            }

            "Проверяем, что для email = 'erm-test@action-press.ru' есть демо-доступ" {
                assertTrue(this.hasDemoAccess)
            }
        }
    }
}