package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_replace_license_member

import com.codeborne.selenide.Selenide
import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseReplaceLicenseMember
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_create_manually.LicenseCreateManuallyRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_replace_license_member.LicenseReplaceLicenseMemberRequest
import ru.action_tech.qa.auto.api_models.accesses.licenseReplaceLicenseMember
import ru.action_tech.qa.auto.api_models.customer.customer.v1.info_bybitrix.InfoBybitrixResponse
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.commons.tags.SkipForProd
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.ordersCrmClient
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.data.enums.Department
import ru.action_tech.qa.auto.data.SCENARIO_ADVANCE
import ru.action_tech.qa.auto.helpers.api.ApiAccessesHelper
import ru.action_tech.qa.auto.helpers.api.ApiPaymentHelper
import ru.action_tech.qa.auto.helpers.api.HoldUserHelper.holdUser
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProd
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProdExtension


@ExtendWith(AfterEachIfEnvProdExtension::class)
class Test_LicenseReplaceLicenseMemberOrderPrePaid {
    private val customerId by lazy { Department.ORDER_EDIT.id }
    private val insId by lazy { AUTO_ACTIONUSKA.id }
    private lateinit var member2: InfoBybitrixResponse
    private lateinit var orderDetailId: String
    private lateinit var orderId: String
    private lateinit var memberId: String
    private lateinit var dateBegin: String
    private lateinit var dateEnd: String
    private lateinit var accountId: String
    private lateinit var taskId: String

    @BeforeEach
    fun createOrder() {

        member2 = holdUser()

        "Создаем заказ через API" {
            ordersCrmClient.send(
                OrdersRequests.createOrderV2(
                    CreateOrderRequest(
                        customerId = customerId,
                        contactId = ContactPerson.ERMAPI.id,
                        paymentScenarioId = SCENARIO_ADVANCE.id
                    )
                )
            ).apply {
                "Сохраняем id заказа" { orderId = id }
            }
        }

        "Получаем данные по заказу" {
            ordersCrmClient.send(OrdersRequests.getOrder(orderId)).apply {
                orderDetailId = items!!.first().id
                dateBegin = items!!.first().dateStart.toString()
                dateEnd = items!!.first().dateEnd.toString()
                memberId = contactId.toString()
                accountId = currencyAccountId.toString()
            }
        }

        "Создаем оплату" {
            ApiPaymentHelper.createPaymentForOrder(
                orderId = orderId,
                subscribeId = orderDetailId,
                accountId = customerId
            )
        }
    }

    @AfterEachIfEnvProd
    fun cleanUp() {
        "Очистить тестовые данные" {
            if (::taskId.isInitialized) {
                ApiAccessesHelper.deactivateLicense(taskId = taskId)
            }
        }
    }

    @Test
    @Requirements("REQCRM-1980", "REQCRM-1950")
    @Sale_Accesses
    @SkipForProd // Не запускаем на prod т. к. формируется заказ с оплаченным УКД
    @LicenseReplaceLicenseMember
    @Response_200_Ok
    @DisplayName("$licenseReplaceLicenseMember -> 200 Ok: Замена пользователя в лицензии")
    @AllureId("242610")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.licenseCreateManually(
                LicenseCreateManuallyRequest(
                    memberId = memberId,
                    orderDetailId = orderDetailId,
                    dateBegin = dateBegin,
                    dateEnd = dateEnd,
                    insId = insId,
                    orderId = orderId
                )
            )
        )

        "Создана заявка на получение лицензии" {
            Selenide.sleep(5000)
            taskId = accessesCrmClient.send(AccessesRequests.licenseRequestsGetBySubscribeIds(listOf(orderDetailId)))
                .first().id.toString()
        }

        accessesCrmClient.send(AccessesRequests.licenseGetSubscribeInfo(orderDetailId)).apply {
            assertEqual(idCustomer, ContactPerson.ERMAPI.id.uuid)
            assertEqual(phone, ContactPerson.ERMAPI.phone)
            assertEqual(name, ContactPerson.ERMAPI.title)
        }

        accessesCrmClient.send(
            AccessesRequests.licenseReplaceLicenseMember(
                LicenseReplaceLicenseMemberRequest(
                    insId,
                    member2.id,
                    orderDetailId
                )
            )
        )

        accessesCrmClient.send(AccessesRequests.licenseGetSubscribeInfo(orderDetailId)).apply {
            assertEqual(idCustomer, member2.id.uuid)
            assertEqual(name, member2.name)
        }
    }
}