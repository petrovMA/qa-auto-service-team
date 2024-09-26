package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_user.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByUserV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.data.FieldData.ZERO_ID
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360RequestForAccessGetByUserNotFound {

    private val request by lazy { AccessesRequests.action360RequestForAccessGetByUser(userIds = listOf(DEFAULT_ID, ZERO_ID)) }

    @Test
    @Requirements("REQCRM-239")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByUserV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-user -> 200 ok: ничего не найдено по userIds")
    @AllureId("145331")
    fun test() {
        assertThat(accessesCrmClient.send(request).isEmpty())
    }
}