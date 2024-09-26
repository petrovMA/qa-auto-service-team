package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_cancel.ok

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessCancelV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.accessCancel
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_cancel.AccessCancelRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_cancel.AccessCancelResponse
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.helpers.api.ApiDemoAccessHelper
import ru.action_tech.qa.auto.data.Constants
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessCancelPositive {

    private val demoAccessUserEmail: String = "check_access_cancel_method@action-autotest.ru"
    private val phone = "911 111-11-23"
    private val additionalPhone: String = "45238"
    private val productNumber: String = "А360Б10012"

    private lateinit var request: TRequest<AccessCancelResponse>

    @BeforeEach
    fun createDemoAccessesBeforeTest() {

        val accessesIds = ApiDemoAccessHelper.getDemoAccessIds(
            Constants.TEST_ORGANIZATION_FOR_ACCESS_CANCEL.name,
            DateTimeUtils.YESTERDAY.minusMonths(1),
            DateTimeUtils.TOMORROW
        )
            .map { it.id }.toTypedArray()


        val demoAccesses = "Фильтр только по демодоступам тестового пользователя: $demoAccessUserEmail" {
            ApiDemoAccessHelper.getDemoAccessesFilterByEmails(listOf(demoAccessUserEmail), accessesIds)
        }

        val code = if (demoAccesses.isNotEmpty()) {
            demoAccesses.first().code
        } else {
            ApiDemoAccessHelper.createDemoAccess(
                account = Constants.TEST_ORGANIZATION_FOR_ACCESS_CANCEL,
                productNumber = productNumber,
                usersDemoAccess = listOf(
                    ApiDemoAccessHelper.UserDemoAccess(
                        email = demoAccessUserEmail,
                        phone = phone,
                        additionalPhone = additionalPhone,
                        isMaster = true
                    )
                )
            ).code
        }

        request = AccessesRequests.accessCancel(AccessCancelRequest(code))
    }

    @Issue("ARMAP-18225")
    @Test
    @ResourceLock("access_cancel: TEST_ORGANIZATION_FOR_ACCESS_CANCEL")
    @HistoryIssues("ARMAP-14733", "ARMAP-17327", "ARMAP-16503")
    @Requirements("REQCRM-257")
    @Sale_Accesses
    @AccessCancelV1
    @Response_200_Ok
    @DisplayName("$accessCancel -> 200 ok")
    @AllureId("145349")
    fun test() {
        accessesCrmClient.send(request)
    }
}