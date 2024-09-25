package ru.action_tech.qa.auto.api_tests.demos.demoaccess.v1.demo

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Demos
import ru.action_tech.qa.auto.api_models.demos.DemoV1
import ru.action_tech.qa.auto.api_models.demos.DemosRequests
import ru.action_tech.qa.auto.api_models.demos.demoV1
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demo.CreateDemoRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.demosCrmClient
import java.net.HttpURLConnection

class Test_CreateDemoIncorrectMainProductNumber {

    private val demoRequest by lazy {
        CreateDemoRequest(
            contactId = "a6f516b4-a876-4d0f-88a1-702d109a9958",
            mainProductNumber = 0,
            phoneCallId = "404318b4-0fd6-412f-8a46-e1c0216a2217",
            isRescue = true,
            isPremium = true
        )
    }


    @Sale_Demos
    @DemoV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1146")
    @Test
    @DisplayName("POST $demoV1 -> 400 Bad Request: mainProductNumber = 0")
    @AllureId("145982")
    fun test() {
        val request: Request = DemosRequests.createDemo(demoRequest)

        "Проверяем код ответа 400" {
            demosCrmClient.send(request.apply { verify = { statusCode(HttpURLConnection.HTTP_BAD_REQUEST) } })
        }
    }
}