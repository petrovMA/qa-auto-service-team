package ru.action_tech.qa.auto.api_tests.demos.license.v1.forcustomer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.WrongRequestData
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getLicenseForCustomer
import ru.action_tech.qa.auto.api_models.demos.ForCustomerV1
import ru.action_tech.qa.auto.api_models.demos.licensesForCustomerV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.data.License
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_ForCustomerWrongRequestData {

    private val testsData by lazy {
        listOf(
            "SystemUserId is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getLicenseForCustomer(customerId = null, systemUserId = 987654321),
                    BrokenRule(0, "The value '987654321' is not valid for SystemUserId.")
                )
            },
            "onlyWithPrice is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getLicenseForCustomer(
                        customerId = null,
                        includeLocked = true,
                        onlyWithPrice = 123.123f,
                        systemUserId = ACTIONUSKA.id
                    ),
                    BrokenRule(0, "The value '123.123' is not valid for OnlyWithPrice.")
                )
            },
            "licenseId is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getLicenseForCustomer(
                        customerId = License.CUSTOMER_ID,
                        includeLocked = true,
                        onlyWithPrice = true,
                        systemUserId = ACTIONUSKA.id,
                        licenseId = 123.123f
                    ),
                    BrokenRule(0, "The value '123.123' is not valid for LicenseId.")
                )
            },
            "IncludeLocked is not valid" to {
                checkBR(
                    apiClient = demosCrmClient,
                    request = getLicenseForCustomer(customerId = null, includeLocked = 123.123f, systemUserId = ACTIONUSKA.id),
                    BrokenRule(0, "The value '123.123' is not valid for IncludeLocked.")
                )
            }
        )
    }

    @Test
    @Sale_Demos
    @ForCustomerV1
    @WrongRequestData
    @Requirements("REQCRM-1156")
    @DisplayName("$licensesForCustomerV1 -> 400 Bad Request")
    @AllureId("227588")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}