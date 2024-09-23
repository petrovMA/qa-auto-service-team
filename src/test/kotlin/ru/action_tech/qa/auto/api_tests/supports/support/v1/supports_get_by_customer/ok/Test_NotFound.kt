package ru.action_tech.qa.auto.api_tests.supports.support.v1.supports_get_by_customer.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsGetByCustomer
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportsGetByCustomer
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_NotFound {

    @Test
    @Requirements("REQCRM-1875")
    @Sale_Supports
    @SupportsGetByCustomer
    @Response_200_Ok
    @DisplayName("/api/v1/supports_get-by-customer -> 200 Ok: Ничего не найдено.")
    @AllureId("218765")
    fun test() {
        supportsCrmClient.send(supportsGetByCustomer(DEFAULT_ID, 2)).run {
            "Проверка что ответ Пустой" {
                assertTrue(isEmpty())
            }
        }
    }
}