package ru.action_tech.qa.auto.api_tests.supports.support.v1.supports_get_for_order.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsGetForOrder
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportsGetForOrder
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.utils.auth.tokenFirstPartnerTestUser
import ru.action_tech.qa.auto.data.PRICE_LIST_US
import ru.action_tech.qa.auto.data.enums.SupportStatus.SUPPORT_STATUS_71
import ru.action_tech.qa.auto.data.enums.SupportStatus.SUPPORT_STATUS_72
import ru.action_tech.qa.auto.data.enums.SupportType.SUPPORT_TYPE_7
import ru.action_tech.qa.auto.data.TEST_DEALER_12345
import ru.action_tech.qa.auto.data.TEST_PARTNER_BOT
import ru.action_tech.qa.auto.helpers.api.ApiSupportsHelper
import ru.action_tech.qa.auto.helpers.api.HoldUserHelper.holdUser
import ru.action_tech.qa.auto.data.PRODUCT_US
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_UsEndDateNull {

    private lateinit var testClientId: String
    private lateinit var testEscortId: String
    private lateinit var testOrderId: String

    private val authToken by lazy { tokenFirstPartnerTestUser }
    private val testProduct by lazy { PRODUCT_US }
    private val testPriceList by lazy { PRICE_LIST_US.id }
    private val escortManager by lazy { TEST_PARTNER_BOT }
    private val escortPartner by lazy { TEST_DEALER_12345 }

    @BeforeEach
    fun setUp() {
        "Подготовить тестовые данные" {
            testClientId = holdUser().id

            "Создать сопровождение ЮС" {
                testEscortId = ApiSupportsHelper.addTestEscort(
                    mainProductId = testProduct.mainProduct.id,
                    supportType = SUPPORT_TYPE_7.number,
                    supportStatus = SUPPORT_STATUS_71.number,
                    contactId = testClientId,
                    partnerId = escortPartner.id,
                    systemUserId = escortManager.id,
                    endDate = null
                )
            }

            testOrderId = ApiOrderHelper.generateAndAddTestOrderV2(
                token = authToken,
                customerId = testClientId,
                customerType = 2,
                contactId = testClientId,
                realContactId = testClientId,
                items = listOf(
                    ApiOrderHelper.generateOrderItems(
                        priceId = testPriceList,
                        products = listOf(
                            ApiOrderHelper.generateOrderProducts(
                                productId = testProduct.id,
                                readerId = testClientId
                            )
                        )
                    )
                )
            ).id
        }
    }

    @AfterEach
    fun cleanUp() {
        if (::testEscortId.isInitialized) {
            ApiSupportsHelper.deleteTestEscort(
                key = "statusJur",
                clientId = testClientId,
                clientType = 2,
                supportId = testEscortId,
                supportStatus = SUPPORT_STATUS_72.number
            )
        }

        if (::testOrderId.isInitialized) {
            ApiOrderHelper.deleteOrder(orderId = testOrderId, authToken)
        }
    }


    @Test
    @Sale_Supports
    @SupportsGetForOrder
    @Response_200_Ok
    @Requirements("REQCRM-1919")
    @DisplayName("/api/v1/supports_get-for-order -> 200 Ok: Получить сопровождения Свой РК Us c endDate = null")
    @AllureId("242629")
    fun test() {
        supportsCrmClient.send(
            supportsGetForOrder(
                customerId = testClientId,
                customerType = 2,
                supportType = SUPPORT_TYPE_7.number,
                mainProductTypeId = testProduct.mainProduct.mainProductTypeId
            )
        ).apply {
            "Проверка что ответ Не пустой" {
                assertTrue(isNotEmpty())
            }

            "Проверка что endDate null" {
                assertTrue(all { it.endDate.isNullOrBlank() })
            }

            "Проверка что в ответе есть supportType ${SUPPORT_TYPE_7.number}" {
                assertTrue(any { it.supportType == SUPPORT_TYPE_7.number })
            }

            "Проверка что в ответе есть status ${SUPPORT_STATUS_71.number}" {
                assertTrue(any { it.status == SUPPORT_STATUS_71.number })
            }
        }
    }
}