package ru.action_tech.qa.auto.api_tests.demos.license.v1.license

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getLicenseV1
import ru.action_tech.qa.auto.api_models.demos.LicenseV1
import ru.action_tech.qa.auto.api_models.demos.licenseV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_LicenseV1 {

    private val id: String = "86b2ad61-71e9-4660-81be-78ca63d6a5df"

    @Test
    @Issue("ARMAP-20074")
    @Sale_Demos
    @LicenseV1
    @Response_200_Ok
    @Requirements("REQCRM-1155")
    @DisplayName("$licenseV1 -> 200 Ok: Возвращает УКД")
    @AllureId("256303")
    fun test() {
        val license = demosCrmClient.send(getLicenseV1(id))

        "Проверяем, что в ответе есть данные".assertEqual(license.id, id)
    }
}