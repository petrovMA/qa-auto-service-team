package ru.action_tech.qa.auto.api_tests.accesses.qa.v1.qa_change_license_sales_on.bad_request

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.QaChangeLicenseSalesOnV1
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.Sale_Accesses


class Test_EmptySalesOn {

    @Sale_Accesses
    @QaChangeLicenseSalesOnV1
    @Response_400_Bad_Request
    @Requirements("REQCRM-1901")
    @Test
    @DisplayName("/api/v1/qa_change-license-sales-on -> 400 Bad Request: Пустое поле salesOn")
    @AllureId("230154")
    fun test() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.qaChangeLicenseSalesOn(DEFAULT_ID.uuid, ""),
            expected = setOf(BrokenRule(code = 100, message = "Неверные параметры или модель запроса"))
        )
    }
}