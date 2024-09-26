package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_parent

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetParent
import ru.action_tech.qa.auto.api_models.accesses.licenseGetParent
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_LicenseGetParent {

    private val customerId by lazy { "e5395b2c-73a3-4b28-8fd3-59efd9304aa7".uuid }
    private val blockProductId by lazy { "37f38c01-6b46-4071-95b0-9b23a97b1f66".uuid }

    @Test
    @Requirements("REQCRM-1977")
    @Sale_Accesses
    @LicenseGetParent
    @Response_200_Ok
    @DisplayName("$licenseGetParent -> 200 Ok: Получение родительской лицензии")
    @AllureId("240945")
    fun test() {
        val response = accessesCrmClient.send(AccessesRequests.licenseGetParent(blockProductId, customerId))

        "Проверка что customerId = $customerId" { assertEqual(response.accountId, customerId) }
    }
}