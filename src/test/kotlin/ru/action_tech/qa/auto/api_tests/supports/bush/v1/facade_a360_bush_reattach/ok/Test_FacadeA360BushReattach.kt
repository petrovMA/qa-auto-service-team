package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_reattach.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushReattach
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_add.request.FacadeA360BushAddRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_detach.request.FacadeA360BushDetachRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_reattach.request.FacadeA360BushReattachRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.VTM_CALL
import ru.action_tech.qa.auto.helpers.api.ClientHelper
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushReattach {
    private val systemUserId by lazy { VTM_CALL.id }
    private lateinit var bushId: String

    @BeforeEach
    fun createBush() {

        "Открепить перед тестом всех пользователей у systemUserId = $systemUserId" {
            supportsCrmClient.send(SupportsRequests.facadeA360BushGetByManagerIds(listOf(systemUserId)))
                .find { it.systemUserId.equals(systemUserId, true) }
                ?.bushesA360
                ?.forEach { supportsCrmClient.send(SupportsRequests.facadeA360BushDetach(FacadeA360BushDetachRequest(it.id, systemUserId))) }
        }

        val orgId = ClientHelper.getValidClient()

        bushId = supportsCrmClient.send(
            SupportsRequests.facadeA360BushAdd(
                FacadeA360BushAddRequest(
                    customerIds = listOf(orgId),
                    factPrice = 0,
                    factUsersAmount = 0,
                    mainProductId = "130dd49e-ecca-e811-bb9b-00155d627f03",
                    systemUserId = systemUserId
                )
            )
        ).id
    }


    @Test
    @Sale_Supports
    @FacadeA360BushReattach
    @Response_200_Ok
    @Requirements("REQCRM-787")
    @DisplayName("/api/v1/facade-a360-bush_reattach -> 200 Ok: Куст перезакреплён")
    @AllureId("177472")
    fun test() {
        supportsCrmClient.send(SupportsRequests.facadeA360BushReattach(FacadeA360BushReattachRequest(bushId, systemUserId)))
    }
}