package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_last_sum_by_customer.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetLastSumByCustomer
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.getRandomString
import ru.action_tech.qa.auto.data.*
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_ClientNotSpecified {

    @Test
    @Sale_Accesses
    @AccessGetLastSumByCustomer
    @Response_400_Bad_Request
    @Requirements("REQCRM-1800")
    @DisplayName("/api/v1/access_get-last-sum-by-customer -> 400 Bad Request: не указан клиент")
    @AllureId("207413")
    fun test_AccessIsNotInTheStatusActivated() {
        arrayOf(null, "", getRandomString(6)).forEach {
            "Проверяем на пустые значения mainProductIds = '$it'" {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.accessGetLastSumByCustomer(
                        customerId = it,
                        mainProductIds = arrayOf(
                            SYSTEM_EDUCATION.id,
                            SYSTEM_EDUCATION_PLUS.id,
                            ELECTRONIC_SYSTEM_EDUCATION_OPTIMAL.id,
                            ELECTRONIC_SYSTEM_EDUCATION_BASIC.id,
                            LICENSE_EDUCATION_BLOCK.id
                        )
                    ),
                    expected = setOf(
                        BrokenRule(
                            code = 85,
                            message = "Не указан клиент"
                        )
                    )
                )
            }
        }
    }
}