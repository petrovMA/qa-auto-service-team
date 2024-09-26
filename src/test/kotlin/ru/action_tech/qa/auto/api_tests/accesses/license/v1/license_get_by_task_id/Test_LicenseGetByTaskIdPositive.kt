package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_by_task_id

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests.licenseGetByTaskId
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetByTaskIdV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_LicenseGetByTaskIdPositive {


    @Test
    @Requirements("REQCRM-232")
    @Sale_Accesses
    @LicenseGetByTaskIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/license_get-by-task-id -> 200 ok")
    @AllureId("145338")
    fun test() {
        accessesCrmClient.send(licenseGetByTaskId(LicenseGetByTaskIdRequest("34f0c227-9d03-4251-ae01-746ae8ec956b")))
    }
}