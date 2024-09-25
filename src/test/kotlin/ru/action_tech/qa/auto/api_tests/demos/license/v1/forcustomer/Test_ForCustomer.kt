package ru.action_tech.qa.auto.api_tests.demos.license.v1.forcustomer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getLicenseForCustomer
import ru.action_tech.qa.auto.api_models.demos.ForCustomerV1
import ru.action_tech.qa.auto.api_models.demos.licensesForCustomerV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.License.CUSTOMER_ID
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_ForCustomer {

    @Test
    @Sale_Demos
    @ForCustomerV1
    @Response_200_Ok
    @Requirements("REQCRM-1156")
    @DisplayName("$licensesForCustomerV1 -> 200 ok")
    @AllureId("151332")
    fun test() {
        val licenses = demosCrmClient.send(
            getLicenseForCustomer(customerId = CUSTOMER_ID, includeLocked = false, onlyWithPrice = true)
        )

        "Проверяем, что в ответе есть данные".assertTrue(licenses.isNotEmpty())
    }
}