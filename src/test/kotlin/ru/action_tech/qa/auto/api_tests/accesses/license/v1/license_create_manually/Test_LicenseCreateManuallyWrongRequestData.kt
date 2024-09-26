package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_create_manually

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseCreateManually
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_create_manually.LicenseCreateManuallyRequest
import ru.action_tech.qa.auto.api_models.accesses.licenseCreateManually
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.SkipForProd
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.core.utils.format
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.utils.ordersCrmClient
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.data.enums.Department
import ru.action_tech.qa.auto.data.SCENARIO_SCHEDULED_PAYMENT
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderRequest
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProd
import ru.action_tech.qa.auto.utils.after_each_if_env_prod.AfterEachIfEnvProdExtension
import java.time.LocalDateTime


@ExtendWith(AfterEachIfEnvProdExtension::class)
class Test_LicenseCreateManuallyWrongRequestData {
    private val customerId by lazy { Department.ORDER_EDIT.id }
    private val insId by lazy { AUTO_ACTIONUSKA.id }
    private lateinit var orderDetailId: String
    private lateinit var orderId: String
    private lateinit var memberId: String
    private lateinit var dateBegin: String
    private lateinit var dateEnd: String

    @BeforeEach
    fun createOrder() {ordersCrmClient
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
            ApiOrderHelper.deleteOrder(orderId)
        }
    }

    private val testsData by lazy {
        listOf(
            "memberId = ''" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseCreateManually(
                        LicenseCreateManuallyRequest(
                            memberId = "",
                            orderDetailId = orderDetailId,
                            dateBegin = dateBegin,
                            dateEnd = dateEnd,
                            insId = insId,
                            orderId = orderId
                        )
                    ),
                    expected = setOf(BrokenRule(100, "Неверные параметры или модель запроса"))
                )
            },
            "orderDetailId not found" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseCreateManually(
                        LicenseCreateManuallyRequest(
                            memberId = memberId,
                            orderDetailId = DEFAULT_ID,
                            dateBegin = dateBegin,
                            dateEnd = dateEnd,
                            insId = insId,
                            orderId = orderId
                        )
                    ),
                    expected = setOf(BrokenRule(132, "В заказе нет содержимого с таким Id"))
                )
            },
            "dateBegin not correct" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseCreateManually(
                        LicenseCreateManuallyRequest(
                            memberId = memberId,
                            orderDetailId = orderDetailId,
                            dateBegin = "20242-05-22T12:30:51.751Z",
                            dateEnd = dateEnd,
                            insId = insId,
                            orderId = orderId
                        )
                    ),
                    expected = setOf(BrokenRule(100, "Неверные параметры или модель запроса"))
                )
            },
            "dateEnd = ''" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseCreateManually(
                        LicenseCreateManuallyRequest(
                            memberId = memberId,
                            orderDetailId = orderDetailId,
                            dateBegin = dateBegin,
                            dateEnd = "",
                            insId = insId,
                            orderId = orderId
                        )
                    ),
                    expected = setOf(BrokenRule(100, "Неверные параметры или модель запроса"))
                )
            },
            "insId not found" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseCreateManually(
                        LicenseCreateManuallyRequest(
                            memberId = memberId,
                            orderDetailId = orderDetailId,
                            dateBegin = dateBegin,
                            dateEnd = dateEnd,
                            insId = DEFAULT_ID,
                            orderId = orderId
                        )
                    ),
                    expected = setOf(BrokenRule(12, "Менеджер не найден"))
                )
            },
            "orderId = null" to {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseCreateManually(
                        LicenseCreateManuallyRequest(
                            memberId = memberId,
                            orderDetailId = orderDetailId,
                            dateBegin = dateBegin,
                            dateEnd = dateEnd,
                            insId = DEFAULT_ID,
                            orderId = null
                        )
                    ),
                    expected = setOf(BrokenRule(100, "Неверные параметры или модель запроса"))
                )
            }
        )
    }

    @Test
    @SkipForProd // Не запускаем на prod т. к. формируется заказ с оплаченным УКД
    @Requirements("REQCRM-1949")
    @Sale_Accesses
    @LicenseCreateManually
    @Response_400_Bad_Request
    @DisplayName("$licenseCreateManually -> 400 Bad Request")
    @AllureId("242612")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}