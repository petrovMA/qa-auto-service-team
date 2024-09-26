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
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_MainProductsIdsNotExists {

    @Test
    @Sale_Accesses
    @AccessGetLastSumByCustomer
    @Response_400_Bad_Request
    @Requirements("REQCRM-1800")
    @DisplayName("/api/v1/access_get-last-sum-by-customer -> 400 Bad Request: mainProductIds not exist")
    @AllureId("207415")
    fun test_AccessIsNotInTheStatusActivated() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.accessGetLastSumByCustomer(
                customerId = ACTIONUSKA.id,
                mainProductIds = arrayOf(DEFAULT_ID, ZERO_ID)
            ),
            expected = setOf(
                BrokenRule(
                    code = 107,
                    message = "Не найдено ни одного продукта по идентификаторам из списка"
                )
            )
        )
    }
}