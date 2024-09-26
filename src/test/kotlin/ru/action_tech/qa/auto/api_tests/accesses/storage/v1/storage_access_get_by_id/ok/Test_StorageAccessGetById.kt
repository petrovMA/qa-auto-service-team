package ru.action_tech.qa.auto.api_tests.accesses.storage.v1.storage_access_get_by_id.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.StorageAccessGetByIdV1
import ru.action_tech.qa.auto.api_models.accesses.storageAccessGetById
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_StorageAccessGetById {

    private val id = "7aef0507-25e7-472e-ab80-33d260d17fec"

    private val request by lazy { AccessesRequests.storageAccessGetById(id) }


    @Test
    @Requirements("REQCRM-248")
    @Sale_Accesses
    @StorageAccessGetByIdV1
    @Response_200_Ok
    @DisplayName("$storageAccessGetById -> 200 ok")
    @AllureId("145359")
    fun test() {
        assertThat(accessesCrmClient.send(request).commonId).isEqualTo(id)
    }
}