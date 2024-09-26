package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_slave_bulk_update.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveBulkUpdateV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.accessSlaveBulkUpdate
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_bulk_update.AccessSlaveBulkUpdateRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessSlaveBulkUpdate {

    private val accessId = "c231969f-50ed-414c-a9e6-84c9a7b120c4"
    private val id1 = 2841275
    private val id2 = "2841276"

    @Test
    @ResourceLock("Test slaves for accessId = \"c231969f-50ed-414c-a9e6-84c9a7b120c4\"")
    @Requirements("REQCRM-256")
    @Sale_Accesses
    @AccessSlaveBulkUpdateV1
    @Response_200_Ok
    @DisplayName("$accessSlaveBulkUpdate -> 200 Ok: Полная перезапись slave пользователей")
    @AllureId("145351")
    fun test() {
        "Добавление слейв-пользователей" {
            accessesCrmClient.send(
                AccessesRequests.accessSlaveBulkUpdate(AccessSlaveBulkUpdateRequest(accessId, listOf(id1, id2)))
            )
        }

        "Проверка что в демодоступ добавились новые слейв-пользователи" {
            accessesCrmClient.send(AccessesRequests.storageAccessGetById(accessId))
                .run { assertTrue(slaveIds?.containsAll(listOf(id1, id2.toInt())) ?: false) }
        }
    }
}