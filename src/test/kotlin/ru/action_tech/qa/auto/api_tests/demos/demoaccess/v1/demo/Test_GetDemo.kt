package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demo

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemoV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests.getDemo
import ru.action_tech.qa.auto.api_models.demos.demoV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.utils.demosCrmClient
import java.net.HttpURLConnection

class Test_GetDemo {

    @Sale_Demos
    @DemoV1
    @Response_200_Ok
    @Requirements("REQCRM-1975")
    @DisplayName("GET $demoV1 -> 200 Ok: Получить демо-доступ по идентификатору")
    @Test
    @AllureId("240894")
    fun test() {
        demosCrmClient.send(getDemo("c231969f-50ed-414c-a9e6-84c9a7b120c4".uuid).apply {
            verify = {
                "Проверка что вернулся код 200 (Не 204)" { statusCode(HttpURLConnection.HTTP_OK) }
            }
        })
    }
}
