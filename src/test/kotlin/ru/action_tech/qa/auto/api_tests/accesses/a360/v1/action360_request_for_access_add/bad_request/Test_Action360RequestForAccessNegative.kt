package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_add.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
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
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.customerServiceArmSellerClient
import ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.organization_info.OrganizationInfoResponse
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.data.ermApiTestUser
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.customer.CustomersRequests
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable


class Test_Action360RequestForAccessNegative {

    private lateinit var userInfo: OrganizationInfoResponse

    @BeforeEach
    fun precondition() {
        "Сохраняем запрошенную информацию о созданном физ. лице" {
            userInfo = customerServiceArmSellerClient.send(CustomersRequests.organizationInfo(ermApiTestUser.uuid))
        }
    }

    val account by lazy {
        Account(
            id = DEFAULT_ID,
            inn = null,
            kpp = null,
            name = null
        )
    }

    val contacts by lazy {
        Contact(
            id = ermApiTestUser.uuid,
            lastname = userInfo.lastName,
            firstname = userInfo.firstName,
            middlename = userInfo.middleName,
            jobtitleId = userInfo.jobTitleId,
            email = userInfo.email,
            phone = userInfo.contactInfo!!.first().name,
            additionalPhone = null,
            userId = null,
            isMaster = true,
            result = null
        )
    }

    val request by lazy {
        AccessesRequests.action360RequestForAccessAdd(
            Action360RequestForAccessAddRequest(
                accessId = null,
                account = account,
                authorId = AUTO_ACTIONUSKA.id,
                contacts = listOf(contacts),
                errorMessage = null,
                id = null,
                productNumber = "А360Б1001",
                state = null,
                productVersions = listOf(
                    CommonDtoNameNullable(
                        id = "2F2AFFBC-ECCA-E811-BB9B-00155D627F03",
                        name = "Актион 360 для бюджетников"
                    )
                )
            )
        )
    }

    @Test
    @Requirements("REQCRM-235")
    @Sale_Accesses
    @Aktion360RequestForAccessAddV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/aktion360-request-for-access_add -> 400 bad request: указали несуществующую организацию accounts")
    @AllureId("224167")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = request,
            BrokenRule(code = 88, message = "Организация в системе не найдена")
        )
    }
}