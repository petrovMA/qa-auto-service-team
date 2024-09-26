package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_task_add.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseTaskAddV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_task_add.LicenseTaskAddRequest
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.net.HttpURLConnection


class Test_LicenseTaskAddPositive {

    private val request by lazy {
        AccessesRequests.licenseTaskAdd(
            LicenseTaskAddRequest(
                accountId = "41e2293b-e5c3-454e-bb26-000e45f024b7",
                contactId = "aa96be24-09d9-4710-b52f-ae6b0d86f369",
                instantAccess = false,
                isPastPeriod = false,
                licenseTypeCode = 1,
                partnerAmount = 0,
                priceLevelId = "B3B92F99-2CA3-491D-ADCA-318F67AFFE9C",
                productId = "d919ac85-25e4-4fba-aa12-93022af47861",
                productProgram = 6,
                salesBizUnitId = "9F8DCB68-F386-E511-8E6E-78E3B502DA44",
                salesContactId = "b10696bd-bec7-4d9a-b5fa-6f0d55e64f6d",
                salesOn = getStringTime(),
                salesPartnerId = "B89FF32C-5F0B-DF11-809E-001CC45E3D96",
                salesSysUserId = "21F53D04-7468-4C60-AFCB-2917383F9856",
                status = 5
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16571
    @Requirements("REQCRM-231")
    @Sale_Accesses
    @LicenseTaskAddV1
    @Response_200_Ok
    @DisplayName("/api/v1/license-task_add -> 200 ok")
    @AllureId("145340")
    fun test() {
        accessesCrmClient.send(request).deserialize<String>()
    }
}