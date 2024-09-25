package ru.action_tech.qa.auto.api_tests.demos.license.v2.license

import io.qameta.allure.AllureId
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getLicenseV2
import ru.action_tech.qa.auto.api_models.demos.LicenseV2
import ru.action_tech.qa.auto.api_models.demos.licenseV2
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_LicenseV2 {

    private val id: String = "86b2ad61-71e9-4660-81be-78ca63d6a5df"

    @Test
    @Sale_Demos
    @LicenseV2
    @Response_200_Ok
    @Requirements("REQCRM-1782")
    @DisplayName("$licenseV2 -> 200 Ok: Возвращает УКД c датой начала активации")
    @AllureId("256285")
    fun test() {
        val license = demosCrmClient.send(getLicenseV2(id))

        "Проверяем, что в ответе есть данные".assertEqual(license.id, id)
    }
}