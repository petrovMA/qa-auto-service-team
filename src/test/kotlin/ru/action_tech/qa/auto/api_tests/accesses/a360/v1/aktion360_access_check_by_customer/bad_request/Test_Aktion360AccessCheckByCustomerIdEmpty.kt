package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.aktion360_access_check_by_customer.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessCheckByCustomerV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_check_by_customer.Aktion360AccessCheckByCustomersRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_Aktion360AccessCheckByCustomerIdEmpty {

    @Test
    @Requirements("REQCRM-1706")
    @Sale_Accesses
    @Aktion360AccessCheckByCustomerV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-access_check-by-customer -> 400 Bad Request: customerId is empty")
    @AllureId("160822")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.aktion360AccessCheckByCustomer(
                Aktion360AccessCheckByCustomersRequests(
                    customerId = "",
                    checkDateTime = DateTimeUtils.TODAY.toString()
                )
            ),
            expected = setOf(
                BrokenRule(
                    code = 85,
                    message = "Не указан клиент"
                )
            )
        )
    }
}