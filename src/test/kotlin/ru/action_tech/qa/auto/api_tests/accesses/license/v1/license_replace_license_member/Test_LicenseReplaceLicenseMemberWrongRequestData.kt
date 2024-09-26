package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_replace_license_member

import com.codeborne.selenide.Selenide
import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseReplaceLicenseMember
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_create_manually.LicenseCreateManuallyRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_replace_license_member.LicenseReplaceLicenseMemberRequest
import ru.action_tech.qa.auto.api_models.accesses.licenseReplaceLicenseMember
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.SkipForProd
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.ordersCrmClient
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.data.enums.Department
import ru.action_tech.qa.auto.data.SCENARIO_ADVANCE
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.customer.customer.v1.info_bybitrix.InfoBybitrixResponse
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderRequest
import ru.action_tech.qa.auto.helpers.api.ApiAccessesHelper
import ru.action_tech.qa.auto.helpers.api.ApiPaymentHelper
import ru.action_tech.qa.auto.helpers.api.HoldUserHelper.holdUser
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProd
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProdExtension


@ExtendWith(AfterEachIfEnvProdExtension::class)
class Test_LicenseReplaceLicenseMemberWrongRequestData {
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
    }

    @AfterEachIfEnvProd
    fun cleanUp() {
        "Очистить тестовые данные" {
            if (::taskId.isInitialized) {
                ApiAccessesHelper.deactivateLicense(taskId = taskId)
            }
        }
    }

    private val testsData by lazy {
        listOf(
            "insId not found" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseReplaceLicenseMember(
                        LicenseReplaceLicenseMemberRequest(DEFAULT_ID, member2.id, orderDetailId)
                    ),
                    expected = setOf(BrokenRule(12, "Менеджер не найден"))
                )
            },
            "memberId not found" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseReplaceLicenseMember(
                        LicenseReplaceLicenseMemberRequest(insId, DEFAULT_ID, orderDetailId)
                    ),
                    expected = setOf(BrokenRule(1000, "Клиент не найден"))
                )
            },
            "orderDetailId not found" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseReplaceLicenseMember(
                        LicenseReplaceLicenseMemberRequest(insId, memberId, DEFAULT_ID)
                    ),
                    expected = setOf(BrokenRule(135, "Не найдена заявка для пользователя укд с таким OrderDetailsId"))
                )
            },
            "orderDetailId = null" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseReplaceLicenseMember(
                        LicenseReplaceLicenseMemberRequest(insId, memberId, null)
                    ),
                    expected = setOf(BrokenRule(100, "Неверные параметры или модель запроса"))
                )
            }
        )
    }

    @Test
    @Requirements("REQCRM-1980")
    @Sale_Accesses
    @SkipForProd // Не запускаем на prod т. к. формируется заказ с оплаченным УКД
    @LicenseReplaceLicenseMember
    @Response_400_Bad_Request
    @DisplayName("$licenseReplaceLicenseMember -> 400 Bad Request")
    @AllureId("242611")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}