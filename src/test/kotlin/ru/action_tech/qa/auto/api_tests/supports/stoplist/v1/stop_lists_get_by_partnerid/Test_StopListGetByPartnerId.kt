package ru.action_tech.qa.auto.api_tests.supports.stoplist.v1.stop_lists_get_by_partnerid

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.StopListsGetByPartnerId
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.stopListGetByPartnerId
import ru.action_tech.qa.auto.api_models.supports.stopListsGetByPartnerId
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_StopListGetByPartnerId {

    @Test
    @StopListsGetByPartnerId
    @Sale_Supports
    @Response_200_Ok
    @Requirements("REQCRM-1943")
    @DisplayName("$stopListsGetByPartnerId -> 200 Ok: Получить стоплисты по id партнера")
    @AllureId("236902")
    fun test(){
        assertTrue(supportsCrmClient.send(stopListGetByPartnerId("E0B33DC9-F48E-DD11-92C8-001CC45E3D96")).isNotEmpty())
    }
}