package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_add.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessAddV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Account
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Action360RequestForAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Contact
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.utils.customerServiceArmSellerClient
import ru.action_tech.qa.auto.api_models.customer.CustomersRequests
import ru.action_tech.qa.auto.api_models.customer.customer.v1.create.CreateOrganizationRequest
import ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.create_user.CreateUserRequest
import ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.organization_info.OrganizationInfoResponse
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.utils.getRandom
import ru.action_tech.qa.auto.utils.getRandomNumberToString
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable


class Test_Action360RequestForAccessAddPositive {

    val orgInn by lazy { getRandomNumberToString() }
    val orgName by lazy { "ЕРМ тест Узбекистан $orgInn" }
    private val orgKpp by lazy { getRandomNumberToString() }
    private lateinit var id: String
    private lateinit var userInfo: OrganizationInfoResponse
    private lateinit var userId: String
    val userEmail by lazy { "autotest${getRandom()}@action-autotest.ru" }

    @BeforeEach
    fun precondition() {
        "Создаем организацию через api и сохраняем id" {
            val orgId = customerServiceArmSellerClient.send(
                CustomersRequests.createOrganization(
                    CreateOrganizationRequest(inn = orgInn, name = orgName, kpp = orgKpp)
                )
            ).id

            id = customerServiceArmSellerClient.send(CustomersRequests.organizationInfo(orgId)).id!!
        }

        "Создаем физ.лицо через api и сохраняем id" {
            userId =
                customerServiceArmSellerClient.send(CustomersRequests.createUser(CreateUserRequest(email = userEmail))).id
        }

        "Сохраняем запрошенную информацию о созданном физ. лице" {
            userInfo = customerServiceArmSellerClient.send(CustomersRequests.organizationInfo(userId))
        }
    }

    val account by lazy {
        Account(
            id = id,
            inn = orgInn,
            kpp = orgKpp,
            name = orgName
        )
    }

    val contacts by lazy {
        Contact(
            id = userId,
            lastname = userInfo.lastName,
            firstname = userInfo.firstName,
            middlename = userInfo.middleName,
            jobtitleId = userInfo.jobTitleId,
            email = userEmail,
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
                id = null,
                accessId = null,
                account = account,
                authorId = AUTO_ACTIONUSKA.id,
                contacts = listOf(contacts),
                errorMessage = null,
                productNumber = "А360Б1001",
                state = null,
                productVersions = listOf(
                    CommonDtoNameNullable(
                        id = "2F2AFFBC-ECCA-E811-BB9B-00155D627F03",
                        name = "Актион 360 для бюджетников"
                    )
                )
            ),
            isNonNull = false
        )
    }

    @Test
    @Requirements("REQCRM-235")
    @Sale_Accesses
    @Aktion360RequestForAccessAddV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-request-for-access_add -> 200 ok")
    @AllureId("224169")
    fun test() {
        accessesCrmClient.send(request).apply {

            "Проверить, что параметр account из ответа равен переданному объекту account" soft {
                assertEqual(this.account, account)
            }

            "Проверить, что параметр contacts из ответа равен переданному объекту contacts" soft {
                assertEqual(this.contacts, contacts)
            }

            "Проверить, что параметр productNumber из ответа равен переданному productNumber" soft {
                assertEqual(this.productNumber, productNumber)
            }

            "Проверить, что параметр authorId из ответа равен переданному authorId" soft {
                assertEqual(this.authorId, authorId)
            }

            "Проверить, что id productVersions равен переданному" soft {
                assertEqual(this.productVersions!![0].id.uppercase(), "2F2AFFBC-ECCA-E811-BB9B-00155D627F03")
            }

            "Проверить, что name productVersions равен 'Актион 360 для бюджетников'" {
                assertEqual(this.productVersions!![0].name, "Актион 360 для бюджетников")
            }
        }
    }
}