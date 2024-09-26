package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.order_contents_get_by_ids.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrderContentsGetByIdsV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_OrderContentsGetByIdsWrongParamsNegative {

    @Test
    @Requirements("REQCRM-1633")
    @HistoryIssues("ARMAP-15150")
    @Sale_Accesses
    @OrderContentsGetByIdsV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/order-contents_get-by-ids -> 400 Bad Request: wrong params")
    @AllureId("155145")
    fun test_OrderContentsGetByIdsPositive() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.orderContentsGetByIds(listOf("123", "qwe")),
            expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }
}