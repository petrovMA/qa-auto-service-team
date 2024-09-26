package ru.action_tech.qa.auto.api_tests.accesses.sales_order.v1.subscribe_get_ids_count_by_params.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.SubscribeGetIdsCountByParamsV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.enums.Products
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_SubscribeGetIdsCountByParams {

    @Test
    @Sale_Accesses
    @SubscribeGetIdsCountByParamsV1
    @Response_200_Ok
    @Requirements("REQCRM-1647")
    @DisplayName("/api/v1/subscribe_get-ids-count-by-params -> 200 Ok")
    @AllureId("177381")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.subscribeGetIdsCountByParams(
                productIds = listOf(Products.JOURNAL_GLAVBUH_01_22.id),
                checkPayment = "false",
                isCheckStock = "true",
                isPostPaymentShipment = "true",
                from = "2021-06-12",
                to = "2022-06-13"
            )
        ).let { "Проверяем что в ответе посчитались заказы" { assertTrue(it > 0) } }
    }
}
