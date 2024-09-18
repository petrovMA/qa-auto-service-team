package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_update_support_manager.ok

import io.qameta.allure.AllureId
import io.qameta.allure.Feature
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.bushAction360Add
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushUpdateSupportManager
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_add.request.BushAction360AddRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_support_manager.request.FacadeA360BushUpdateSupportManagerRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateSupportManagerPositive {

    private val userId = "94f431ce-2fec-ea11-bba7-00155d627f03"

    @Test
    @HistoryIssues("ARMAP-13618")
    @Sale_Supports
    @Feature("/api/v1/bush-action360_add /api/v1/facade-a360-bush_update-support-manager")
    @Response_200_Ok
    @Requirements("REQCRM-783", "REQCRM-790")
    @DisplayName("/api/v1/bush-action360_add /api/v1/facade-a360-bush_update-support-manager -> 200 Ok: Метод создания и смены сопровождающего на сделках куста Актион 360")
    @AllureId("145891")
    fun test_FacadeA360BushUpdateSupportManagerPositive() {
        val requestBushAction = bushAction360Add(
            BushAction360AddRequest(
                authorId = userId,
                bushAction360ChangesCount = 0,
                suggestedPrice = 0,
                suggestedUsersAmount = 0,
                factPrice = 0,
                factUsersAmount = 0,
                mainProductId = "130dd49e-ecca-e811-bb9b-00155d627f03"
            )
        )

        val bushId = "создание и получение куста Актион 360" { supportsCrmClient.send(requestBushAction).id }

        val resp = supportsCrmClient.send(
            facadeA360BushUpdateSupportManager(
                FacadeA360BushUpdateSupportManagerRequest(
                    authorId = userId,
                    bushA360Ids = listOf(bushId),
                    supportSystemUserId = userId
                )
            )
        )

        "Проверка что вернулся bushId = $bushId, и result = Ok" {
            assertThat(resp.first().bushId).isEqualTo(bushId)
            assertThat(resp.first().result).isEqualTo("Ok")
        }
    }
}