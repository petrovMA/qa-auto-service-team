package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_child_data

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetChildData
import ru.action_tech.qa.auto.api_models.accesses.licenseGetChildData
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.accessesCrmClient

class Test_CustomerNotHaveValidUkds {

    @Test
    @Requirements("REQCRM-2006")
    @Sale_Accesses
    @LicenseGetChildData
    @Response_200_Ok
    @DisplayName("$licenseGetChildData -> 200 ok - у клиента нет УКД подходящих под выборку")
    @AllureId("254195")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.licenseGetChildData(
                customerId = "1413B4CC-0DC2-4A08-84E6-62335440D200"
            )
        ).apply {
            "Ответ пустой".assertTrue(isEmpty())
        }
    }
}