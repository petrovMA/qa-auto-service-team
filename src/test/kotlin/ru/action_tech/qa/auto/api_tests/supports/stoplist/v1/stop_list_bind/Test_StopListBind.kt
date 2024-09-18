package ru.action_tech.qa.auto.api_tests.supports.stoplist.v1.stop_list_bind

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold.CustomerHoldResponse
import ru.action_tech.qa.auto.api_models.managers.ManagersRequests.postUserRolesAdd
import ru.action_tech.qa.auto.api_models.managers.v1.role.user_roles_add.UserRolesAddRequest
import ru.action_tech.qa.auto.api_models.supports.StopListBind
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.stopListBind
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind.StopListBindRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.ATTACH
import ru.action_tech.qa.auto.data.specialProjectsManagement
import ru.action_tech.qa.auto.helpers.api.CustomerHelper.dropStopListCountForCustomer
import ru.action_tech.qa.auto.helpers.api.CustomerHelper.holdCustomerForTest
import ru.action_tech.qa.auto.utils.*
import java.time.ZonedDateTime


class Test_StopListBind {

    private lateinit var manager: Manager
    private lateinit var customer: CustomerHoldResponse.Customer
    private lateinit var token: String
    private val partnerId by lazy { specialProjectsManagement.partnerId }

    @BeforeEach
    fun setUp() {
        customer = holdCustomerForTest().customer
        dropStopListCountForCustomer(customerId = customer.id.uuid)

        manager = Manager.holdManagerForTest()
        managersArmSellerClient.send(postUserRolesAdd(UserRolesAddRequest(userId = manager.id, roleIds = listOf(ATTACH.id))))
        token = getTokenByLogin(login = manager.login.toString())
    }


    @Test
    @ResourceLock("customerId = cf329ac2-9cca-49b9-bb9d-2ac8134812da")
    @Sale_Supports
    @StopListBind
    @Response_200_Ok
    @Requirements("REQCRM-1942")
    @DisplayName("$stopListBind -> 200 OK: Закрепить существующего свободного клиента в в стоп-лист")
    @AllureId("246962")
    fun test() {
        supportsCrmClient.send(SupportsRequests.stopListBind(StopListBindRequest(customer.id, partnerId), token)).also {

            "Проверяем в ответе customerId=${customer.id}" {
                "customerId в ответе отличается от ожидаемого"
                    .assertEqual(it.customer!!.id, customer.id)
            }

            "Проверяем в ответе endDate=${ZonedDateTime.parse(it.startDate).plusDays(30)}" {
                "endDate в ответе отличается от ожидаемого"
                    .assertEqual(ZonedDateTime.parse(it.endDate), ZonedDateTime.parse(it.startDate).plusDays(30))
            }

            "Проверяем в ответе partnerId=${specialProjectsManagement.partnerId}" {
                "customerId в ответе отличается от ожидаемого"
                    .assertEqual(it.partner.id, partnerId)
            }
        }
    }
}