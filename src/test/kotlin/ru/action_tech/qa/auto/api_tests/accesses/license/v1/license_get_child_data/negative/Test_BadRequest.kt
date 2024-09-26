package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_child_data.negative

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetChildData
import ru.action_tech.qa.auto.api_models.accesses.licenseGetChildData
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.data.broken_rules.AccessesBR
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR

class Test_BadRequest {
    private val testsData by lazy {
        mapOf(
            "customerId не валиден" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetChildData(
                        customerId = FieldData.INVALID_ID
                    ),
                    expected = setOf(AccessesBR.BR_130)
                )
            },
            "customerId пустая строка" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetChildData(
                        customerId = ""
                    ),
                    expected = setOf(AccessesBR.BR_130)
                )
            },
            "customerId не передан" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetChildData(
                        customerId = null
                    ),
                    expected = setOf(AccessesBR.BR_130)
                )
            },
            "customerId нулевой id" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetChildData(
                        customerId = FieldData.ZERO_ID
                    ),
                    expected = setOf(AccessesBR.BR_130)
                )
            },
            "customerId не существует" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetChildData(
                        customerId = FieldData.FIRST_ID
                    ),
                    expected = setOf(AccessesBR.BR_1000)
                )
            },
        )
    }

    @Test
    @Requirements("REQCRM-2006")
    @Sale_Accesses
    @LicenseGetChildData
    @Response_400_Bad_Request
    @DisplayName("$licenseGetChildData -> 400 bad request")
    @AllureId("254196")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}