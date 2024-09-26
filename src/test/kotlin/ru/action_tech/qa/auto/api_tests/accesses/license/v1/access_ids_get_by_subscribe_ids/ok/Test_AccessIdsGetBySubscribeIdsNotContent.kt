package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_ids_get_by_subscribe_ids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_204_No_Content
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessIdsGetBySubscribeIdsV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.utils.ordersCrmClient
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkNoContent
import ru.action_tech.qa.auto.api_models.orders.OrdersRequests
import ru.action_tech.qa.auto.api_models.orders.qa.delete_order.DeleteOrderRequest
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class Test_AccessIdsGetBySubscribeIdsNotContent {
    lateinit var orderId: String

    @BeforeEach
    fun precondition() {
        orderId = ApiOrderHelper.orderCreate(
            customerId = ContactPerson.AUTOTESTOV_AUTOTEST.id,
            contactId = ContactPerson.AUTOTESTOV_AUTOTEST.id,
            priceId = "b6f4b90d-0834-4a2a-96f1-4970c88dd6b6",
            productId = "5b304213-6967-4636-97a4-616579e50da1",
            dateStart = LocalDate.now().withDayOfMonth(1)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        ).id
    }

    @AfterEach
    fun deleteOrder() {
        "Полностью удаляем заказ" {
            ordersCrmClient.send(OrdersRequests.qaOrderDelete(DeleteOrderRequest(orderId)))
                .apply { assertTrue(this) }
        }

        "Проверяем, что по удаленному заказу нет данных" {
            checkNoContent(ordersCrmClient, OrdersRequests.getOrder(orderId))
        }
    }


    @Test
    @Requirements("REQCRM-1778")
    @Sale_Accesses
    @AccessIdsGetBySubscribeIdsV1
    @Response_204_No_Content
    @DisplayName("/api/v1/access-ids_get-by-subscribe-ids -> 200 ok: пустой ответ")
    @AllureId("200507")
    fun test() {
        val subscribeId = ApiOrderHelper.getInfoOrder(orderId).items!!.first().id

        accessesCrmClient.send(AccessesRequests.accessIdsGetBySubscribeIds(listOf<Any>(subscribeId)))
            .apply { "Проверяем, что ответ пустой" { assertTrue(this.isEmpty()) } }
    }
}