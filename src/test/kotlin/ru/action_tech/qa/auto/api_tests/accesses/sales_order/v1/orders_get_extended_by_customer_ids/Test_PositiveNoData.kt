package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.orders_get_extended_by_customer_ids

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrdersGetExtendedByCustomerIds
import ru.action_tech.qa.auto.api_models.accesses.ordersGetExtendedByCustomerIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.accessesCrmClient

class Test_PositiveNoData {

    @Test
    @Sale_Accesses
    @OrdersGetExtendedByCustomerIds
    @Response_200_Ok
    @Requirements("REQCRM-1634")
    @DisplayName("$ordersGetExtendedByCustomerIds -> 200 ok : получение информации о несуществующих заказах")
    @AllureId("257106")
    fun test() {
        setOf(listOf(), listOf(FieldData.FIRST_ID))
            .forEach {
                accessesCrmClient.send(
                    AccessesRequests.ordersGetExtendedByCustomerIds(it)
                ).apply {
                    "Ответ пустой".assertTrue(isEmpty())
                }
            }
    }
}