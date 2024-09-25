package ru.action_tech.qa.auto.helpers.api

import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Assertions
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_cancel.AccessCancelRequest
import ru.action_tech.qa.auto.api_models.admin360_backend.Admin360BackendRequests
import ru.action_tech.qa.auto.api_models.admin360_backend.Admin360BackendRequests.contactGetById
import ru.action_tech.qa.auto.api_models.admin360_backend.Admin360BackendRequests.contactSearch
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_accept.Action360RequestForAccessAcceptRequest
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_accept.Action360RequestForAccessAcceptRequest.Aktion360RequestForAccess.Account
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_add.Action360RequestForAccessAddRequest
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_add.Action360RequestForAccessAddRequest.AccessAddContact
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.demoaccess_get_by_id.DemoAccessGetByIdResponse
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.browser.browser
import ru.action_tech.qa.auto.core.commons.generator.deleteUserFromAccess
import ru.action_tech.qa.auto.core.driver.MobProxy
import ru.action_tech.qa.auto.core.driver.ProxyMode
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.properties.BROWSER_PROXY_MODE
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.api_models.access_backend.AccessBackendRequests.accessUserGetActive
import ru.action_tech.qa.auto.data.Constants
import ru.action_tech.qa.auto.data.USER_ACTIONUSKA
import ru.action_tech.qa.auto.utils.*
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_OK
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ApiDemoAccessHelper {

    fun createDemoAccess(
        account: Account,
        productNumber: String = "А360Б10012",
        usersDemoAccess: List<UserDemoAccess>,
    ): DemoAccessGetByIdResponse {
        var accessesIds: Array<String> = emptyArray()

        val users = usersDemoAccess.map { it to admin360BackendCrmClient.send(contactSearch(it.email)) }

        "Создание заявки на выдачу демодоступа" {
            admin360BackendCrmClient.send(
                Admin360BackendRequests.action360RequestForAccessAdd(
                    Action360RequestForAccessAddRequest(
                        authorId = USER_ACTIONUSKA.id,
                        productNumber = productNumber,
                        account = account,
                        contacts = users.map { user ->
                            AccessAddContact(
                                id = user.second.id,
                                lastname = user.second.lastName,
                                firstname = user.second.firstName,
                                middlename = user.second.middleName,
                                jobtitleId = Constants.JOB_TITLE_BUYER.id,
                                email = user.second.email,
                                phone = user.first.phone,
                                additionalPhone = user.first.additionalPhone,
                                isMaster = user.first.isMaster
                            )
                        }
                    )
                )
            )
        }

        val accessByUserSearch = "Поиск ID заявки на выдачу демодоступа" {
            admin360BackendCrmClient.send(
                Admin360BackendRequests.action360RequestForAccessGetByUser(
                    dateFrom = getStringTime(
                        DateTimeUtils.YESTERDAY.minusDays(10),
                        DateTimeFormatter.ISO_LOCAL_DATE
                    ),
                    dateTo = getStringTime(DateTimeUtils.TOMORROW, DateTimeFormatter.ISO_LOCAL_DATE),
                    pageSize = 1000,
                    pageNumber = 0,
                )
            ).first { it.accountName == account.name }
        }

        val oldAccessesCount: Int = "Получаем количество уже выданных демодоступов за день" {
            getDemoAccessIds(account.name, DateTimeUtils.YESTERDAY, DateTimeUtils.TODAY).size
        }

        "Одобрение заявки на выдачу демодоступа id = ${accessByUserSearch.id}" {
            admin360BackendCrmClient.send(
                Admin360BackendRequests.action360RequestForAccessAccept(
                    Action360RequestForAccessAcceptRequest(
                        aktion360RequestForAccess = Action360RequestForAccessAcceptRequest.Aktion360RequestForAccess(
                            authorId = USER_ACTIONUSKA.id,
                            id = accessByUserSearch.id,
                            productNumber = productNumber,
                            state = 100000000,
                            account = Account(
                                id = account.id,
                                inn = account.inn,
                                kpp = account.kpp,
                                name = account.name
                            ),
                            contacts = users.map { user ->
                                Action360RequestForAccessAcceptRequest.Aktion360RequestForAccess.Contact(
                                    id = user.second.id,
                                    lastname = user.second.lastName,
                                    firstname = user.second.firstName,
                                    middlename = user.second.middleName,
                                    jobtitleId = Constants.JOB_TITLE_BUYER.id,
                                    email = user.second.email,
                                    phone = user.first.phone,
                                    additionalPhone = user.first.additionalPhone,
                                    isError = false,
                                    isMaster = user.first.isMaster
                                )
                            }
                        ),
                        modifiedBy = USER_ACTIONUSKA.id
                    )
                )
            )
        }

        "Ждём когда заявка на демодоступ будет одобрена" {
            untilTrue(100.s(), 5.s()) {
                oldAccessesCount < getDemoAccessIds(account.name, DateTimeUtils.YESTERDAY, DateTimeUtils.TODAY)
                    .apply { accessesIds = map { it.id }.toTypedArray() }.size
            }
        }

        val masterUser = users.first { it.first.isMaster }.second

        return "Поиск выданного демодоступа" {
            getDemoAccessesFilterByEmails(listOf(masterUser.email), accessesIds).first()
        }
    }

    fun getDemoAccessIds(companyName: String? = null, dateFrom: LocalDate, dateTo: LocalDate) =
        admin360BackendCrmClient.send(
            Admin360BackendRequests.action360RequestsFind(
                companyName,
                getStringTime(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE),
                getStringTime(dateTo, DateTimeFormatter.ISO_LOCAL_DATE)
            )
        )

    fun getDemoAccessesFilterByEmails(emails: List<String>? = null, accessesIds: Array<String>) =
        if (accessesIds.isEmpty()) emptyList()
        else admin360BackendCrmClient.send(Admin360BackendRequests.demoAccessListGetByDemoAccessRequestIds(*accessesIds))
            .map { admin360BackendCrmClient.send(Admin360BackendRequests.demoAccessGetById(it.accessId)) }
            .map { it to admin360BackendCrmClient.send(contactGetById(it.masterContactId)) }
            .filter { access -> emails?.let { access.second.email in emails } ?: true }
            .map { it.first }

    fun proxyAccountValidateByNalogRu(testOrg: Account) {
        if (BROWSER_PROXY_MODE == ProxyMode.NONE) BROWSER_PROXY_MODE = ProxyMode.LOCAL

        (browser.proxy as MobProxy).server.addResponseFilter { _, contents, messageInfo ->
            if (messageInfo.originalUrl.contains("/api/v1/account_validate-by-nalogru?inn=${testOrg.inn}&kpp=${testOrg.kpp}")) {
                contents.textContents = "{\"isValid\":true,\"message\":null}"
            }
        }
    }

    fun accessesCancel(vararg codes: String) = codes.forEach {
        val request: Request = AccessesRequests.accessCancel(AccessCancelRequest(it)).apply {
            verify = { statusCode(anyOf(`is`(HTTP_OK), `is`(HTTP_BAD_REQUEST))) }
        }
        accessesCrmClient.send(request)
    }

    fun accessCancelForUser(userBitrixId: Int) {
        "Отмена всех демодоступов в CRM для пользователя с bitrixId = $userBitrixId" {
            accessBackendStoragesClient.send(accessUserGetActive(userBitrixId))
                .entities
                ?.mapNotNull { it.data?.find { data -> data?.key == "Code" }?.value as String? }
                ?.let { accessesCancel(*it.toTypedArray()) }
        }

        "Отмена всех демодоступов на платформе для пользователя с bitrixId = $userBitrixId" {
            deleteDemoAccessFromUserAccessList(userBitrixId)
        }
    }

    /**
     * Удаляет демодоступы клиента в storage.
     *
     * @param bitrixId - bitrixId клиента у которого надо удалить демодоступ.
     * @param demoAccessId - uuid демодоступа который надо удалить у клиента (если null то удалит все демодоступы у клиента!).
     */
    fun deleteDemoAccessFromUserAccessList(
        bitrixId: Int,
        demoAccessId: String? = null
    ) {
        "Удалить демодоступ из списка доступов клиента" {

            val accessesIdsForDelete = if (demoAccessId == null) {
                accessBackendStoragesClient.send(accessUserGetActive(bitrixId)).entities?.mapNotNull { it.core?.id }
            } else {
                listOf(demoAccessId)
            }

            accessesIdsForDelete?.let { deleteUserFromAccess(it, bitrixId/*, removeFromAmnesty*/) }
                ?: "Демодоступ не найден в списке демодоступов клиента (удалять нечего)" {}
        }

        "Проверить, что демодоступ удалён из списка доступов клиента" {
            accessBackendStoragesClient.send(accessUserGetActive(bitrixId)).apply {
                Assertions.assertNull(
                    demoAccessId?.let { accessId -> entities!!.firstOrNull { it.core!!.id == accessId } },
                    "Демодоступ не удалён из списка демодоступов клиента"
                )
            }
        }
    }

    data class UserDemoAccess(val email: String, val phone: String, val additionalPhone: String, val isMaster: Boolean)
}