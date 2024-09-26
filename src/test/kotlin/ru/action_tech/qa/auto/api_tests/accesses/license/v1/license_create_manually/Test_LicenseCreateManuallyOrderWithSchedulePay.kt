package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_create_manually

import com.codeborne.selenide.Selenide
import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseCreateManually
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_create_manually.LicenseCreateManuallyRequest
import ru.action_tech.qa.auto.api_models.accesses.licenseCreateManually
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.commons.tags.SkipForProd
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.core.utils.format
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.data.enums.Department
import ru.action_tech.qa.auto.data.SCENARIO_SCHEDULED_PAYMENT
import ru.action_tech.qa.auto.helpers.api.ApiAccessesHelper
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProd
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProdExtension
import ru.action_tech.qa.auto.utils.ordersCrmClient
import java.time.LocalDateTime


@ExtendWith(AfterEachIfEnvProdExtension::class)
class Test_LicenseCreateManuallyOrderWithSchedulePay {
    private val customerId by lazy { Department.ORDER_EDIT.id }
    private val insId by lazy { AUTO_ACTIONUSKA.id }
    private lateinit var orderDetailId: String
    private lateinit var orderId: String
    private lateinit var memberId: String
    private lateinit var dateBegin: String
    private lateinit var dateEnd: String
    private lateinit var taskId: String

    @BeforeEach
    fun createOrder() {
        "Создаем заказ через API" {
            ordersCrmClient.send(
                OrdersRequests.createOrderV2(
                    CreateOrderRequest(
                        customerId = customerId,
                        contactId = ContactPerson.ERMAPI.id,
                        paymentScenarioId = SCENARIO_SCHEDULED_PAYMENT.id,
                        paymentPlannedDate = LocalDateTime.now().plusDays(1).toString(),
                        contractPaymentDate = LocalDateTime.now().plusDays(1).toString(),
                        paymentSchedules = listOf(
                            CreateOrderRequest.Schedule(
                                LocalDateTime.now().plusDays(1).toString(),
                                23364
                            )
                        ),
                        items = listOf(
                            CreateOrderRequest.Items(
                                products = listOf(
                                    CreateOrderRequest.Items.Products(
                                        dateStart = "${DateTimeUtils.TODAY.format("yyyy-MM")}-01T15:00:00+03:00"
                                    )
                                )
                            )
                        )
                    )
                )
            ).apply {
                "Сохраняем id заказа" {
                    orderId = id
                }
            }
        }
        "Получаем данные по заказу" {
            ordersCrmClient.send(OrdersRequests.getOrder(orderId)).apply {
                orderDetailId = items!!.first().id
                dateBegin = items!!.first().dateStart.toString()
                dateEnd = items!!.first().dateEnd.toString()
                memberId = contactId.toString()
            }
        }
        "Отправить заказ на реализацию" {
            accessesCrmClient.send(AccessesRequests.qaSendOrderToShipment(orderId))
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
    @Requirements("REQCRM-1949", "REQCRM-1950")
    @Sale_Accesses
    @SkipForProd // Не запускаем на prod т. к. формируется заказ с оплаченным УКД
    @LicenseCreateManually
    @Response_200_Ok
    @DisplayName("$licenseCreateManually -> 200 ok: Заказ с оплатой по графику")
    @AllureId("238301")
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
    }
}