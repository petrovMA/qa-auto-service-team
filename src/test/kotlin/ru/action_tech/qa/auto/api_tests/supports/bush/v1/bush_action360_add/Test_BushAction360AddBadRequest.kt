package ru.action_tech.qa.auto.api_tests.supports.bush.v1.bush_action360_add

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.BushAction360Add
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.bushAction360Add
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_add.request.BushAction360AddRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_BushAction360AddBadRequest {


    @Test
    @Sale_Supports
    @BushAction360Add
    @Response_400_Bad_Request
    @HistoryIssues("ARMAP-13096")
    @Requirements("REQCRM-783")
    @DisplayName("/api/v1/bush-action360_add -> 400 Bad Request: mainProductId не существует")
    @AllureId("145862")
    fun test_BushAction360AddNotFondProductIdNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = bushAction360Add(
                BushAction360AddRequest(
                    bushAction360ChangesCount = 0,
                    factPrice = 0,
                    factUsersAmount = 0,
                    mainProductId = ZERO_ID,
                    suggestedPrice = 0,
                    suggestedUsersAmount = 0
                )
            ),
            expected = setOf(CheckBadRequests.BrokenRule(code = 18, message = "Неверный головной продукт"))
        )
    }


    @Test
    @Sale_Supports
    @BushAction360Add
    @Response_400_Bad_Request
    @Requirements("REQCRM-783")
    @DisplayName("/api/v1/bush-action360_add -> 400 Bad Request: некорректный формат authorId")
    @AllureId("145863")
    fun test_BushAction360AddWrongFormatProductIdNegative() {
        checkBR(
            apiClient = supportsCrmClient,
            request = bushAction360Add(
                BushAction360AddRequest(
                    authorId = "123",
                    bushAction360ChangesCount = 0,
                    factPrice = 0,
                    factUsersAmount = 0,
                    mainProductId = ZERO_ID,
                    suggestedPrice = 0,
                    suggestedUsersAmount = 0
                )
            ),
            expected = setOf(CheckBadRequests.BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
        )
    }
}