package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_add.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Admin360Backend
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessAddV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Account
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Action360RequestForAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Contact
import ru.action_tech.qa.auto.api_models.admin360_backend.Admin360BackendRequests.contactSearch
import ru.action_tech.qa.auto.api_models.admin360_backend.customer.v1.contact_search.ContactSearchResponse
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.admin360BackendCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable


class Test_Aktion360RequestForAccessAddNotCorrectNegative {

    private val demoAccessTestEmail: String = "user_for_api_test_demo_access@action-autotest.ru"
    private val productNumber: String = "А360Б1001"
    private val account: Account by lazy {
        Account(
            id = "906d1d01-110a-464c-9f30-cf9fcaf218aa",
            inn = "4086505102",
            kpp = "9205195206",
            name = "ЕРМ тест Узбекистан 4086505102"
        )
    }
    private val contact: Contact by lazy {
        Contact(
            email = "autotest31697451@action-autotest.ru",
            firstname = "ERM",
            id = "f3be6e38-5c48-4875-b68b-6439b4cb4745",
            jobtitleId = "b9626a79-269d-4627-9cb4-308bd33e92f4",
            lastname = "Ермапи",
            middlename = "api",
            phone = "9111111111",
            isMaster = false
        )
    }

    lateinit var user: ContactSearchResponse

    @BeforeEach
    fun setUp() {
        user = admin360BackendCrmClient.send(contactSearch(demoAccessTestEmail))
    }

    private val request by lazy {
        AccessesRequests.action360RequestForAccessAdd(
            Action360RequestForAccessAddRequest(
                accessId = null,
                account = account,
                authorId = AUTO_ACTIONUSKA.id,
                contacts = listOf(contact),
                errorMessage = null,
                id = null,
                state = null,
                productVersions = listOf(
                    CommonDtoNameNullable(
                        id = "C8DCC947-EECA-E811-BB9B-00155D627F033",
                        name = "Актион 360 для бюджетников"
                    )
                ),
                productNumber = productNumber
            )
        )
    }

    @Test
    @HistoryIssues("ARMAP-15054")
    @Requirements("REQCRM-235")
    @Sale_Admin360Backend
    @Aktion360RequestForAccessAddV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-request-for-access_add -> 400 Bad Request: Запрос не корректный")
    @AllureId("224168")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            expected = setOf(BrokenRule(code = 8, message = "Запрос не корректный"))
        )
    }
}