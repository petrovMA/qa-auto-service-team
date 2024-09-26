package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_ids_get_by_subscribe_ids.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessIdsGetBySubscribeIdsV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessIdsGetBySubscribeIdsPositive {

    @Test
    @Requirements("REQCRM-1778")
    @Sale_Accesses
    @AccessIdsGetBySubscribeIdsV1
    @Response_200_Ok
    @DisplayName("/api/v1/access-ids_get-by-subscribe-ids -> 200 ok")
    @AllureId("200508")
    fun test() {
        accessesCrmClient.send(AccessesRequests.accessIdsGetBySubscribeIds(listOf<Any>("F3A90B9F-1954-4AE5-BDDA-AE404020B3F0")))
    }
}