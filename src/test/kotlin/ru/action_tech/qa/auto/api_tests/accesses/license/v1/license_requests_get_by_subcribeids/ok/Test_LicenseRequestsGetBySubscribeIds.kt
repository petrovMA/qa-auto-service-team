package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_requests_get_by_subcribeids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseRequestsGetBySubscribeIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_LicenseRequestsGetBySubscribeIds {

    private val subscribeIds by lazy {
        listOf(
            "08a0ed6a-94b1-46ee-94d2-e96b8e215838",
            "5fac026d-603d-42ac-918b-a50f1bc3e5e6",
            "27ecfcf0-21f8-4fed-95a7-f3f8a061788b",
            "ab310a3f-9a8e-4efc-9bb8-3320cf10322f",
            "b02365e9-3105-40a0-87f4-ff05bde01231",
            "744cd43b-4df9-4090-9521-64e57e124c1e",
            "693db10e-711c-4953-ba16-eb680b1612f9",
            "d57a2f3a-76fc-4457-b4f8-5444d4ff1f02",
            "26d642a8-8014-459d-ade5-93cfecf5e409",
            "951ec700-a119-48f6-9e9b-7c52065a86e2",
            "b8e8e56c-5f18-4185-bd65-47a8bb3ab275",
            "f4b5c309-9113-4c75-b727-1b306c9aaf20",
            "49482a30-a4b7-4274-a741-87a542a12946",
            "05ebfba4-150f-441b-a1f7-a06a0460bed1",
            "0e0a54e0-e36a-4384-91a0-1ddf8e43da2e",
            "9ef3550d-639c-434e-b70f-2c3721828073",
            "824c21c8-84e2-4440-a5c1-e16fa629449b",
            "ce398c40-c64c-463a-a309-7bf2ebef958a",
            "9828d52f-27c6-429a-8788-255dda92eba0",
            "552cb988-a2ba-41c8-abae-77978cc678b0"
        )
    }

    @Test
    @Requirements("REQCRM-1899")
    @Sale_Accesses
    @LicenseRequestsGetBySubscribeIds
    @Response_200_Ok
    @DisplayName("/api/v1/license-requests_get-by-subcribeids -> 200 Ok: Возвращает заявки на регистрацию УКД по идентификаторам содержимых заказа")
    @AllureId("229724")
    fun test() {
        val resp = accessesCrmClient.send(AccessesRequests.licenseRequestsGetBySubscribeIds(subscribeIds = subscribeIds))

        "Проверка, что возвращается список заявок".assertTrue(resp.isNotEmpty())
    }
}