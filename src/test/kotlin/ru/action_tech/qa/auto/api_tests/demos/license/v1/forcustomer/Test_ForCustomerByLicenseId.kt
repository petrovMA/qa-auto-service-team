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
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.License.CUSTOMER_ID
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_ForCustomerByLicenseId {

    @Test
    @Sale_Demos
    @ForCustomerV1
    @Response_200_Ok
    @Requirements("REQCRM-1156")
    @DisplayName("$licensesForCustomerV1 -> 200 ok, получение лицензии по licenseId")
    @AllureId("234287")
    fun test() {
        val licenseByCustomer = demosCrmClient.send(
            getLicenseForCustomer(
                customerId = CUSTOMER_ID,
                includeLocked = false,
                onlyWithPrice = true
            )
        ).filterNot { it.id == "00000000-0000-0000-0000-000000000000" }.first()
        val licenseById = demosCrmClient.send(
            getLicenseForCustomer(
                licenseId = licenseByCustomer.id,
            )
        ).first()

        "Лицензии полученные по customerId и licenseId одинаковые" {
            assertEqual(licenseById, licenseByCustomer)
        }
    }
}