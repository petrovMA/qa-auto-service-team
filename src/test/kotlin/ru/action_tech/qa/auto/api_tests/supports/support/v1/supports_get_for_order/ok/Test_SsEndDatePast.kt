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
import ru.action_tech.qa.auto.data.PRICE_LIST_SS
import ru.action_tech.qa.auto.data.PRODUCT_SS
import ru.action_tech.qa.auto.data.enums.SupportStatus.SUPPORT_STATUS_11
import ru.action_tech.qa.auto.data.enums.SupportType.SUPPORT_TYPE_1
import ru.action_tech.qa.auto.data.enums.SupportType.SUPPORT_TYPE_3
import ru.action_tech.qa.auto.data.TEST_DEALER_12345
import ru.action_tech.qa.auto.data.TEST_PARTNER_FOR_SASHA
import ru.action_tech.qa.auto.helpers.api.ApiSupportsHelper
import ru.action_tech.qa.auto.helpers.api.HoldUserHelper.holdUser
import ru.action_tech.qa.auto.utils.supportsCrmClient
import java.time.OffsetDateTime
import java.time.ZoneOffset

class Test_SsEndDatePast {

    private lateinit var testClientId: String
    private lateinit var testPossibleDealId: String
    private lateinit var testOrderId: String

    private val authToken by lazy { tokenFirstPartnerTestUser }
    private val testProduct by lazy { PRODUCT_SS }
    private val testPriceList by lazy { PRICE_LIST_SS.id }
    private val possibleDealManager by lazy { TEST_PARTNER_FOR_SASHA }
    private val possibleDealPartner by lazy { TEST_DEALER_12345 }

    @BeforeEach
    fun setUp() {
        "Подготовить тестовые данные" {
            testClientId = holdUser().id

            testPossibleDealId = ApiSupportsHelper.addTestPossibleDealSs(
                contactId = testClientId,
                partnerId = possibleDealPartner.id,
                systemUserId = possibleDealManager.id,
                endDate = OffsetDateTime.now(ZoneOffset.UTC).minusDays(1).toString(),
                isFixedDates = true
            )

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
        "Очистить тестовые данные" {
            if (::testPossibleDealId.isInitialized) {
                ApiSupportsHelper.deleteTestPossibleDealSs(
                    clientId = testClientId,
                    clientType = 2,
                    supportId = testPossibleDealId,
                )
            }

            if (::testOrderId.isInitialized) {
                ApiOrderHelper.deleteOrder(orderId = testOrderId, token = authToken)
            }
        }
    }

    @Sale_Supports
    @SupportsGetForOrder
    @Response_200_Ok
    @Requirements("REQCRM-1919")
    @DisplayName("/api/v1/supports_get-for-order -> 200 Ok: Получить сопровождения Свой ПК SS c endDate в прошлом")
    @Test
    @AllureId("242672")
    fun test() {
        supportsCrmClient.send(
            supportsGetForOrder(
                customerId = testClientId,
                customerType = 2,
                supportType = SUPPORT_TYPE_3.number,
                mainProductTypeId = testProduct.mainProduct.mainProductTypeId
            )
        ).apply {
            "Проверка что ответ Не пустой" {
                assertTrue(isNotEmpty())
            }

            "Проверка что endDate не null" {
                assertTrue(all { it.endDate.isNullOrBlank().not() })
            }

            "Проверка что в ответе есть supportType ${SUPPORT_TYPE_1.number}" {
                assertTrue(any { it.supportType == SUPPORT_TYPE_1.number })
            }

            "Проверка что в ответе есть status ${SUPPORT_STATUS_11.number}" {
                assertTrue(any { it.status == SUPPORT_STATUS_11.number })
            }
        }
    }
}
