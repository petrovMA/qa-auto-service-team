package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.access_slave_remove.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessSlaveRemoveV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests.accessSlaveRemove
import ru.action_tech.qa.auto.api_models.accesses.accessSlaveRemove
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_bulk_update.AccessSlaveBulkUpdateRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_remove.AccessSlaveRemoveRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_AccessSlaveRemove {

    private val accessId = "c231969f-50ed-414c-a9e6-84c9a7b120c4"
    private val id1 = 2841275
    private val id2 = "2841276"

    @BeforeEach
    fun setUp() {
        "Добавить слейв-пользователей $id1 и $id2 перед тестом" {
            accessesCrmClient.send(
                AccessesRequests.accessSlaveBulkUpdate(
                    AccessSlaveBulkUpdateRequest(
                        accessId,
                        listOf(id1, id2)
                    )
                )
            )
                .run { "Не удалось добавить slaveIds перед тестом".assertTrue(slaveIds?.isNotEmpty() ?: true) }
        }
    }

    @Test
    @ResourceLock("Test slaves for accessId = \"c231969f-50ed-414c-a9e6-84c9a7b120c4\"")
    @Requirements("REQCRM-255")
    @Sale_Accesses
    @AccessSlaveRemoveV1
    @Response_200_Ok
    @DisplayName("$accessSlaveRemove -> 200 Ok: Удалить одного slave пользователя")
    @AllureId("145352")
    fun test() {

        accessesCrmClient.send(accessSlaveRemove(AccessSlaveRemoveRequest(accessId, listOf(id1))))

        "Проверка что в демодоступе остался пользователь $id2" {
            accessesCrmClient.send(AccessesRequests.storageAccessGetById(accessId))
                .run { assertTrue(slaveIds?.containsAll(listOf(id2.toInt())) ?: false) }
        }

        accessesCrmClient.send(accessSlaveRemove(AccessSlaveRemoveRequest(accessId, listOf(id2))))

        "Проверка что в демодоступе не осталось пользователей" {
            accessesCrmClient.send(AccessesRequests.storageAccessGetById(accessId))
                .run { assertTrue(slaveIds?.isEmpty() ?: true) }
        }
    }
}