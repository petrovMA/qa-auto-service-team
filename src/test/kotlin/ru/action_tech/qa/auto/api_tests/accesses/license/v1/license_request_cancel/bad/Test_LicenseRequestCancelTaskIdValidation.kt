package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_request_cancel.bad

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_400_Bad_Request
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseRequestCancelV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.data.broken_rules.AccessesBR
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR

class Test_LicenseRequestCancelTaskIdValidation {

    @Test
    @Requirements("REQCRM-1951")
    @Sale_Accesses
    @LicenseRequestCancelV1
    @Response_400_Bad_Request
    @DisplayName("/api/v1/license-request_cancel -> 400 Bad Request: taskId validation")
    @AllureId("238220")
    fun test() {
        setOf(
            null to setOf(AccessesBR.BR_100),
            "" to setOf(AccessesBR.BR_100),
            FieldData.INVALID_ID to setOf(AccessesBR.BR_100),
            FieldData.LAST_ID to setOf(AccessesBR.BR_122),
            "6d8213a9-2666-4831-beb6-deca0fb3b15c" to setOf(AccessesBR.BR_124)
        ).forEach { (data, br) ->
            "taskId = $data" {
                checkBR(
                    apiClient = accessesCrmClient,
                    request = AccessesRequests.licenseRequestCancel(
                        taskId = data
                    ),
                    expected = br
                )
            }
        }
    }
}