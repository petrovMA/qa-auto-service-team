package ru.action_tech.qa.auto.api_tests.demos.license.v1.license_get_by_subscribe

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.licenseGetBySubscribe
import ru.action_tech.qa.auto.api_models.demos.LicenseGetBySubscribeV1
import ru.action_tech.qa.auto.api_models.demos.licenseGetBySubscribeV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.utils.demosCrmClient


class Test_LicenseGetBySubscribe {

    private val subscribeId by lazy { "F3A90B9F-1954-4AE5-BDDA-AE404020B3F0".uuid }

    @Test
    @Sale_Demos
    @LicenseGetBySubscribeV1
    @Response_200_Ok
    @Requirements("REQCRM-1781")
    @DisplayName("$licenseGetBySubscribeV1 -> 200 Ok: Возвращает УКД c датой начала активации по ид содержимого заказа")
    @AllureId("240866")
    fun test() {
        val license = demosCrmClient.send(licenseGetBySubscribe(subscribeId))

        "Проверяем, что salesSubscribeId = $subscribeId" { assertEqual(license.salesSubscribeId, subscribeId) }
    }
}