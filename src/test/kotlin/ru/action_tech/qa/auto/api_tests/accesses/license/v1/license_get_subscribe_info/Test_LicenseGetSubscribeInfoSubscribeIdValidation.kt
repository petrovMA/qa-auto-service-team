package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_subscribe_info

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.WrongRequestData
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetSubscribeInfo
import ru.action_tech.qa.auto.api_models.accesses.licenseGetSubscribeInfo
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkNoContent


class Test_LicenseGetSubscribeInfoSubscribeIdValidation {

    private val testsData by lazy {
        mapOf(
            "subscribeId = ''" to {
                checkBR(
                    accessesCrmClient,
                    AccessesRequests.licenseGetSubscribeInfo(""),
                    setOf(BrokenRule(code = 129, message = "Пустой или неправильный OrderDetailId"))
                )
            },
            "subscribeId = '!@#!@#!@#'" to {
                checkBR(
                    accessesCrmClient,
                    AccessesRequests.licenseGetSubscribeInfo("!@#!@#!@#"),
                    setOf(BrokenRule(code = 129, message = "Пустой или неправильный OrderDetailId"))
                )
            },
            "subscribeId = '123.321'" to {
                checkBR(
                    accessesCrmClient,
                    AccessesRequests.licenseGetSubscribeInfo(123.321),
                    setOf(  BrokenRule(code = 129, message = "Пустой или неправильный OrderDetailId"))
                )
            },
            "subscribeId = null" to {
                checkBR(
                    accessesCrmClient,
                    AccessesRequests.licenseGetSubscribeInfo(null),
                    setOf( BrokenRule(code = 129, message = "Пустой или неправильный OrderDetailId"))
                )
            },
            "subscribeId = ${FieldData.INVALID_ID}" to {
                checkBR(
                    accessesCrmClient,
                    AccessesRequests.licenseGetSubscribeInfo(FieldData.INVALID_ID),
                    setOf(    BrokenRule(code = 129, message = "Пустой или неправильный OrderDetailId"))
                )
            },
            "204 No content: subscribeId = ${FieldData.DEFAULT_ID}" to {
                checkNoContent(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseGetSubscribeInfo(FieldData.DEFAULT_ID)
                )
            }
        )
    }

    @Sale_Accesses
    @WrongRequestData
    @LicenseGetSubscribeInfo
    @Requirements("REQCRM-1950")
    @DisplayName("$licenseGetSubscribeInfo -> Не корректные данные в запросе")
    @Test
    @AllureId("238339")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}