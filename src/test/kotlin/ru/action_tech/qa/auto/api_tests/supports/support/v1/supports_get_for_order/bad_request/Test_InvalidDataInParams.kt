package ru.action_tech.qa.auto.api_tests.supports.support.v1.supports_get_for_order.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsGetForOrder
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportsGetForOrder
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.CUSTOMER_WITH_SUBSCRIPTION
import ru.action_tech.qa.auto.data.PRODUCT_E
import ru.action_tech.qa.auto.data.enums.SupportType
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_InvalidDataInParams {

    private val testsData by lazy {
        listOf(
            "Не передан customerId" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = null,
                        customerType = 2,
                        supportType = SupportType.SUPPORT_TYPE_4.number,
                        mainProductTypeId = PRODUCT_E.mainProduct.id
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "customerId = пустая строка" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = "",
                        customerType = 2,
                        supportType = SupportType.SUPPORT_TYPE_4.number,
                        mainProductTypeId = PRODUCT_E.mainProduct.id
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "Не корректный supportType" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = CUSTOMER_WITH_SUBSCRIPTION.customerId,
                        customerType = 2,
                        supportType = 1,
                        mainProductTypeId = PRODUCT_E.mainProduct.id
                    ),
                    expected = setOf(BrokenRule(code = 6, message = "Неверный тип сопровождения."))
                )
            },
            "supportType = null" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = CUSTOMER_WITH_SUBSCRIPTION.customerId,
                        customerType = 2,
                        supportType = null,
                        mainProductTypeId = PRODUCT_E.mainProduct.id
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "Не корректный customerType" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = CUSTOMER_WITH_SUBSCRIPTION.customerId,
                        customerType = 0,
                        supportType = SupportType.SUPPORT_TYPE_4.number,
                        mainProductTypeId = emptyArray<String>()
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "customerType = null" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = CUSTOMER_WITH_SUBSCRIPTION.customerId,
                        customerType = null,
                        supportType = SupportType.SUPPORT_TYPE_4.number,
                        mainProductTypeId = emptyArray<String>()
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "вместо mainProductTypeId пустой массив" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = CUSTOMER_WITH_SUBSCRIPTION.customerId,
                        customerType = 2,
                        supportType = SupportType.SUPPORT_TYPE_4.number,
                        mainProductTypeId = emptyArray<String>()
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            },
            "mainProductTypeId = null" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = supportsGetForOrder(
                        customerId = CUSTOMER_WITH_SUBSCRIPTION.customerId,
                        customerType = 2,
                        supportType = SupportType.SUPPORT_TYPE_4.number,
                        mainProductTypeId = null
                    ),
                    expected = setOf(BrokenRule(code = 34, message = "Неверные параметры или модель запроса"))
                )
            }
        )
    }

    @Test
    @Sale_Supports
    @SupportsGetForOrder
    @Response_400_Bad_Request
    @Requirements("REQCRM-1919")
    @DisplayName("/api/v1/supports_get-for-order -> 400 Bad Request")
    @AllureId("242625")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}