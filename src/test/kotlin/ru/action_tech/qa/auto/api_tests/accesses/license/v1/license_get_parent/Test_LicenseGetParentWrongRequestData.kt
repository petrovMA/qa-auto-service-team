package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_parent

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetParent
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_LicenseGetParentWrongRequestData {

    private val customerId by lazy { "e5395b2c-73a3-4b28-8fd3-59efd9304aa7".uuid }
    private val blockProductId by lazy { "37f38c01-6b46-4071-95b0-9b23a97b1f66".uuid }

    private val testsData by lazy {
        listOf(
            "blockProductId = null" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetParent(null, customerId),
                    expected = setOf(
                        BrokenRule(76, "Не найдена лицензия с Тип доступа на версии продукта - Подписка")
                    )
                )
            },
            "blockProductId = \"\"" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetParent("", customerId),
                    expected = setOf(
                        BrokenRule(76, "Не найдена лицензия с Тип доступа на версии продукта - Подписка")
                    )
                )
            },
            "customerId = 123.123" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetParent(blockProductId, 123.123),
                    expected = setOf(
                        BrokenRule(76, "Не найдена лицензия с Тип доступа на версии продукта - Подписка")
                    )
                )
            },
            "Запрос без параметров" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetParent(null, null),
                    expected = setOf(
                        BrokenRule(76, "Не найдена лицензия с Тип доступа на версии продукта - Подписка")
                    )
                )
            }
        )
    }

    @Test
    @Requirements("REQCRM-1977")
    @Sale_Accesses
    @LicenseGetParent
    @Response_400_Bad_Request
    @DisplayName("${ru.action_tech.qa.auto.api_models.accesses.licenseGetParent} -> 400 Bad Request")
    @AllureId("240946")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}