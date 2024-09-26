package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_by_task_id

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetByTaskIdV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR


class Test_LicenseGetByTaskIdWrongRequest {

    @Test
    @Requirements("REQCRM-232")
    @Sale_Accesses
    @LicenseGetByTaskIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/license_get-by-task-id -> 400 Bad Request: ничего не найдено по taskId")
    @AllureId("145336")
    fun testNotFound() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.licenseGetByTaskId(LicenseGetByTaskIdRequest(DEFAULT_ID)),
            expected = setOf(BrokenRule(code = -100, message = "заявка с таким Id $$DEFAULT_ID не найдена"))
        )
    }

    @Test
    @Requirements("REQCRM-232")
    @Sale_Accesses
    @LicenseGetByTaskIdV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/license_get-by-task-id -> 400 Bad Request: некорректный taskId")
    @AllureId("145337")
    fun testWrongTaskId() {
        checkBR(
            apiClient = accessesCrmClient,
            request = AccessesRequests.licenseGetByTaskId(LicenseGetByTaskIdRequest("123123123")),
            expected = setOf(BrokenRule(code = 1, message = "Ошибка: \$Nullable object must have a value."))
        )
    }
}
