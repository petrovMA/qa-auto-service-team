package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_extended_by_customer_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetExtendedByCustomerIds
import ru.action_tech.qa.auto.api_models.accesses.ordersGetExtendedByCustomerIds
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.data.enums.Company
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.utils.dateOfFirstDayOfMonth
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE

class Test_Positive {
    private lateinit var orderId: String
    private val customerId by lazy { Company.PAID_DEMO_ACCESS_COMPANY.id!! }

    @BeforeEach
    fun precondition() {
        orderId = ApiOrderHelper.orderCreate(
            customerId = customerId,
            contactId = ContactPerson.TESTER_TESTEROVICH.id,
            priceId = "b6f4b90d-0834-4a2a-96f1-4970c88dd6b6",
            productId = "5b304213-6967-4636-97a4-616579e50da1",
            dateStart = getStringTime(dateOfFirstDayOfMonth(), ISO_LOCAL_DATE)
        ).id
    }

    @AfterEach
    fun tearDown() {
        ApiOrderHelper.qaDeleteOrder(orderId)
    }

    @Test
    @Sale_Accesses
    @OrdersGetExtendedByCustomerIds
    @Response_200_Ok
    @Requirements("REQCRM-1634")
    @DisplayName("$ordersGetExtendedByCustomerIds -> 200 ok : получение расширенной информации о заказах")
    @AllureId("257105")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.ordersGetExtendedByCustomerIds(listOf(customerId))
        ).apply {
            "Все customerId = $customerId".assertTrue(all { it.customerId == customerId })
            "В ответе есть заказ $orderId".assertTrue(any { it.id == orderId })
        }
    }
}