package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demoaccess_info

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemoAccessInfoV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getInfo
import ru.action_tech.qa.auto.api_models.demos.demoAccessInfoV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.demosCrmClient

class Test_GetInfo {

    private val codeId = "5500-8475-5451-6449-5888"


    @Issue("ARMAP-19427")
    @Test
    @Sale_Demos
    @DemoAccessInfoV1
    @Response_200_Ok
    @Requirements("REQCRM-1147")
    @DisplayName("$demoAccessInfoV1 -> 200 Ok")
    @AllureId("145985")
    fun test() {
        val response = "Получаем информацию о выданном демо доступе" { demosCrmClient.send(getInfo(codeId)) }

        "Проверяем что bitrixId не пустой" { assertFalse(response.bitrixId.isNullOrBlank()) }
    }
}