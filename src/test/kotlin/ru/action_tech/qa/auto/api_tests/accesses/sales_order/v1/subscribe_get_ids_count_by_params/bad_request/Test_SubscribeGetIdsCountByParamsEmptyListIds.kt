package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.subscribe_get_ids_count_by_params.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.SubscribeGetIdsCountByParamsV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_SubscribeGetIdsCountByParamsEmptyListIds {

    @Test
    @Sale_Accesses
    @SubscribeGetIdsCountByParamsV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1647")
    @DisplayName("/api/v1/subscribe_get-ids-count-by-params -> 400 Bad Request: productIds = empty list")
    @AllureId("177461")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.subscribeGetIdsCountByParams(
                productIds = emptyList(),
                checkPayment = "false",
                isCheckStock = "true",
                isPostPaymentShipment = "true",
                from = "2021-06-12",
                to = "2022-06-13"
            ),
            expected = setOf(BrokenRule(code = 25, message = "Список запрашиваемых продуктов пустой"))
        )
    }
}