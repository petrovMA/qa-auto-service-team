package ru.action_tech.qa.auto.api_tests.supports.bush.v1.bush_action360_add

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.BushAction360Add
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.bushAction360Add
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_add.request.BushAction360AddRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_BushAction360Add {

    private val request by lazy {
        bushAction360Add(
            BushAction360AddRequest(
                authorId = "94f431ce-2fec-ea11-bba7-00155d627f03",
                bushAction360ChangesCount = 0,
                factPrice = 0,
                factUsersAmount = 0,
                mainProductId = "130dd49e-ecca-e811-bb9b-00155d627f03",
                suggestedPrice = 0,
                suggestedUsersAmount = 0
            )
        )
    }


    @Test
    @Sale_Supports
    @BushAction360Add
    @Response_200_Ok
    @Requirements("REQCRM-783")
    @DisplayName("/api/v1/bush-action360_add -> 200 Ok: Метод создания куста Актион 360")
    @AllureId("145864")
    fun test() {
        supportsCrmClient.send(request)
    }
}