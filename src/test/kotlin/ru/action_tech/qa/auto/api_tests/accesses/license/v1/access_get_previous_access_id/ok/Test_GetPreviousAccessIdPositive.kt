package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_previous_access_id.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetPreviousAccessIdV1
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_GetPreviousAccessIdPositive {

    val accessId = "EAAAC3C3-ADCA-491B-8AC1-D81164F385DB"

    //    val expectedPreviousId = "efcdfcef-176c-4bf5-af35-e08c05c6a177"
    val bitrixId = 437344

    val request by lazy {
        AccessesRequests.accessesGetPreviousAccessId(
            accessId = accessId,
            userId = bitrixId
        )
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16562
    @Sale_Accesses
    @AccessGetPreviousAccessIdV1
    @Response_200_Ok
    @Requirements("REQCRM-1065")
    @DisplayName("/api/v1/access_get-previous-access-id -> 200 ok (Лицензия)")
    @AllureId("145311")
    fun test() {
        accessesCrmClient.send(request).apply {

            "Проверка параметра accessId" { assertEqual(this.accessId, accessId) }

            //TODO нужно проработать подготовку тестовых данных
//            "Проверка параметра previousAccessId" {
//                assertEqual(this.previousAccessId, expectedPreviousId)
//            }
        }
    }
}