package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.order_contents_get_by_ids.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.OrderContentsGetByIdsV1
import ru.action_tech.qa.auto.api_models.accesses.sales_order.v1.order_contents_get_by_ids.OrderContentsGetByIdsResponse
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_OrderContentsGetByIdsPositive {

    private val orderContentId = "818E075F-23C2-4DDB-9BCC-08D96FA92C11"

    private val expectedResult by lazy {
        OrderContentsGetByIdsResponse(
            id = "818e075f-23c2-4ddb-9bcc-08d96fa92c11",
            subscribeId = "00921268-c540-4201-aa1c-ae3768339c68",
            productId = "20fc2f66-9db3-e911-bba3-00155d627f03"
        )
    }

    private val request by lazy { AccessesRequests.orderContentsGetByIds(listOf(orderContentId)) }


    @Test
    @Requirements("REQCRM-1633")
    @Sale_Accesses
    @OrderContentsGetByIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/order-contents_get-by-ids -> 200 ok")
    @AllureId("155146")
    fun test_OrderContentsGetByIdsPositive() {
        assertThat(accessesCrmClient.send(request).toList()).isEqualTo(listOf(expectedResult))
    }
}