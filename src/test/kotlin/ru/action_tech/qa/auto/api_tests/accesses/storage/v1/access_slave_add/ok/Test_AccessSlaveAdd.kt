package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_slave_add.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveAddV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.accessSlaveBulkUpdate
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_add.AccessSlaveAddRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_bulk_update.AccessSlaveBulkUpdateRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessSlaveAdd {

    private val accessId = "c231969f-50ed-414c-a9e6-84c9a7b120c4"
    private val userId1 = 2841275
    private val userId2 = "2841276"

    @BeforeEach
    fun setUp() {
        "Удалить всех слейв-пользователей перед тестом" {
            accessesCrmClient.send(AccessesRequests.accessSlaveBulkUpdate(AccessSlaveBulkUpdateRequest(accessId, emptyList())))
                .run { "Не удалось удалить slaveIds перед тестом".assertTrue(slaveIds?.isEmpty() ?: true) }

        }
    }

    @Test
    @ResourceLock("Test slaves for accessId = \"c231969f-50ed-414c-a9e6-84c9a7b120c4\"")
    @Requirements("REQCRM-254")
    @Sale_Accesses
    @AccessSlaveAddV1
    @Response_200_Ok
    @DisplayName("$accessSlaveBulkUpdate -> 200 Ok: Добавить одного slave пользователя")
    @AllureId("145350")
    fun test() {
        "Добавление слейв-пользователей (userId в формате Int)" {
            accessesCrmClient.send(AccessesRequests.accessSlaveAdd(AccessSlaveAddRequest(accessId, slaveIds = listOf(userId1))))
        }
        "Добавление слейв-пользователей (userId в формате String)" {
            accessesCrmClient.send(AccessesRequests.accessSlaveAdd(AccessSlaveAddRequest(accessId, slaveIds = listOf(userId2))))
        }

        "Проверка что в демодоступ добавились новые слейв-пользователи" {
            accessesCrmClient.send(AccessesRequests.storageAccessGetById(accessId)).run {
                assertTrue(slaveIds?.containsAll(listOf(userId1, userId2.toInt())) ?: false)
            }
        }
    }
}