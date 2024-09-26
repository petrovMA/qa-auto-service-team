package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_user.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByUserV1
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.d
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter.ofPattern


class Test_Action360RequestForAccessGetByUserPositive {

    private val request by lazy {
        AccessesRequests.action360RequestForAccessGetByUser(
            userIds = null,
            dateFrom = getStringTime(
                Instant.now() - 30.d(),
                ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())
            ),
            dateTo = getStringTime(Instant.now(), ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())),
            pageNumber = 0,
            pageSize = 10
        )
    }

    @Test
    @Requirements("REQCRM-239")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByUserV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-user -> 200 ok")
    @AllureId("145333")
    fun test() {
        assertThat(accessesCrmClient.send(request)).hasSizeLessThan(11)
    }
}