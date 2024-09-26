package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_last_sum_by_customer.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetLastSumByCustomer
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.*
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_GetLastSumNotNull {

    @Test
    @Sale_Accesses
    @AccessGetLastSumByCustomer
    @Response_200_Ok
    @Requirements("REQCRM-1800")
    @DisplayName("/api/v1/access_get-last-sum-by-customer -> 200 ok")
    @AllureId("207543")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.accessGetLastSumByCustomer(
                //пока используем захардкоженные данные, обсудим вопрос генерации либо выдачу лицензии тестовому пользователю
                customerId = "9ABA8DEF-AF30-4C2C-8FE2-3E7C7F400D01",
                mainProductIds = arrayOf(
                    SYSTEM_EDUCATION.id,
                    SYSTEM_EDUCATION_PLUS.id,
                    ELECTRONIC_SYSTEM_EDUCATION_OPTIMAL.id,
                    ELECTRONIC_SYSTEM_EDUCATION_BASIC.id,
                    LICENSE_EDUCATION_BLOCK.id
                )
            )
        ).apply {
            "Проверяем цену подписки" {
                assertEqual(this.lastSum, 78852.0)
            }
        }
    }
}