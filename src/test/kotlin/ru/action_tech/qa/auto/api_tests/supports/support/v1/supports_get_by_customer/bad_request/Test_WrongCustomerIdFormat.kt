package ru.action_tech.qa.auto.api_tests.supports.support.v1.supports_get_by_customer.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsGetByCustomer
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportsGetByCustomer
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_WrongCustomerIdFormat {

    @Test
    @Requirements("REQCRM-1875")
    @Sale_Supports
    @SupportsGetByCustomer
    @Response_400_Bad_Request
    @DisplayName("/api/v1/supports_get-by-customer -> 400 Bad Request: Wrong CustomerId Format")
    @AllureId("218763")
    fun test() {
        checkBR(
            apiClient = supportsCrmClient,
            request = supportsGetByCustomer("22310905-603f-454c-a0d4-91b15deffd9z", 2),
            expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}