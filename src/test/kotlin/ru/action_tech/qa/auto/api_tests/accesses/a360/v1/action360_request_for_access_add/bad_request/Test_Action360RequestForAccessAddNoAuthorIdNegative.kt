package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_add.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessAddV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Account
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Action360RequestForAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Contact
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.getRandomNumberToString
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.getRandom


class Test_Action360RequestForAccessAddNoAuthorIdNegative {


    val request by lazy {
        AccessesRequests.action360RequestForAccessAdd(
            Action360RequestForAccessAddRequest(
                accessId = null,
                account = Account(
                    id = DEFAULT_ID,
                    inn = getRandomNumberToString(),
                    kpp = getRandomNumberToString(),
                    name = "ЕРМ тест Узбекистан"
                ),
                authorId = null,
                contacts = listOf(
                    Contact(
                        id = DEFAULT_ID,
                        lastname = "userInfo.lastName",
                        firstname = "userInfo.firstName",
                        middlename = "userInfo.middleName",
                        jobtitleId = "userInfo.jobTitleId",
                        email = "autotest${getRandom()}@action-autotest.ru",
                        phone = "userInfo.contactInfo",
                        additionalPhone = null,
                        userId = null,
                        isMaster = false,
                        result = null
                    )
                ),
                errorMessage = null,
                id = null,
                productNumber = "А360К10012",
                state = null
            )
        )
    }

    @Test
    @Requirements("REQCRM-235")
    @Sale_Accesses
    @Aktion360RequestForAccessAddV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-request-for-access_add -> 400 Bad Request: Не указан authorId")
    @AllureId("224172")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(BrokenRule(8, "Запрос не корректный"))
        )
    }
}