package ru.action_tech.qa.auto.api_tests.supports.bush.v1

import io.qameta.allure.AllureId
import io.qameta.allure.Feature
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushAdd
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushDetach
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetByManager
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushGetByManagerIds
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360GetByBushAction360SupportStatuses
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_add.request.FacadeA360BushAddRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_detach.request.FacadeA360BushDetachRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager.request.FacadeA360BushGetByManagerRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update.request.FacadeA360BushUpdateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.request.OpportunityA360GetByBushAction360SupportStatusesRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.commons.tags.NotAutomated
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.data.USER_ACTIONUSKA
import ru.action_tech.qa.auto.data.USER_AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.helpers.api.ClientHelper
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_BushAddGetUpdateDetachPositive {
    private lateinit var customerId1: String
    private lateinit var customerId2: String
    private val systemUserId1 by lazy { USER_ACTIONUSKA.id }
    private val systemUserId2 by lazy { USER_AUTO_ACTIONUSKA.id }
    private val mainProductId = "130dd49e-ecca-e811-bb9b-00155d627f03"

    private lateinit var newBushId: String

    @BeforeEach
    fun createBush() {
        customerId1 = ClientHelper.getValidClient()
        customerId2 = ClientHelper.getValidClient(excludeClients = listOf(customerId1))
        newBushId =
            supportsCrmClient.send(
                facadeA360BushAdd(
                    FacadeA360BushAddRequest(
                        customerIds = listOf(customerId1),
                        factPrice = 0,
                        factUsersAmount = 0,
                        mainProductId = mainProductId,
                        systemUserId = systemUserId1
                    )
                )
            ).id
    }

    @Test
    @NotAutomated // todo Need test data :: ARMAP-16555
    @Sale_Supports
    @Feature("/api/v1/facade-a360-bush_update /api/v1/facade-a360-bush_detach")
    @Response_200_Ok
    @Requirements(
        "REQCRM-221",
        "REQCRM-785",
        "REQCRM-786",
        "REQCRM-789",
        "REQCRM-791"
    )
    @DisplayName("Проверка обновления и открепления куста")
    @AllureId("145861")
    fun test() {
        "Проверка support-status куста /api/v1/opportunity-a360_get-by-bush-action360-support-statuses '125 - ВЗ А360 На согласовании добавления'" {
            val requestSupportStatuses = opportunityA360GetByBushAction360SupportStatuses(
                OpportunityA360GetByBushAction360SupportStatusesRequest(newBushId, listOf(125))
            )
            val supportResponse = supportsCrmClient.send(requestSupportStatuses)

            assertTrue(supportResponse.isNotEmpty())
        }

        "Запрашиваем список кустов" {
            val responseBushList = supportsCrmClient.send(facadeA360BushGetByManagerIds(listOf(systemUserId1)))

            "Проверяем что в ответе есть новый куст id=$newBushId" {
                val bush = responseBushList.find { it.systemUserId == systemUserId1 }
                    ?.bushesA360
                    ?.find { it.id == newBushId }

                assertTrue(bush != null)
                assertEqual(bush?.mainProductId?.lowercase(), mainProductId.lowercase())
                assertEqual(bush?.customers?.first()?.id?.lowercase(), customerId1.lowercase())
            }
        }

        val (number, updatedBushId) = "Обновление куста" {
            supportsCrmClient.send(
                facadeA360BushUpdate(
                    FacadeA360BushUpdateRequest(
                        bushAction360Id = newBushId,
                        customerIds = listOf(customerId2),
                        factPrice = 0,
                        factUsersAmount = 0,
                        systemUserId = systemUserId2
                    )
                )
            ).run { name to id }
        }

        "Проверка обновления куста" {
            val resp = supportsCrmClient.send(
                facadeA360BushGetByManager(
                    FacadeA360BushGetByManagerRequest(systemUserId1, number, listOf(customerId1, customerId2))
                )
            )

            assertEqual(resp.size, 1)
            assertEqual(resp.first().name, number)
            assertEqual(resp.first().id?.lowercase(), updatedBushId?.lowercase())
            assertEqual(resp.first().mainProductId?.lowercase(), mainProductId.lowercase())
            resp.first().customers?.map { it.id?.lowercase() }.let {
                assertTrue(it?.contains(customerId1.lowercase()) ?: false)
                assertTrue(it?.contains(customerId2.lowercase()) ?: false)
                assertEqual(it?.size, 2)
            }
        }

        "Проверка support-status куста /api/v1/opportunity-a360_get-by-bush-action360-support-statuses '124 - ВЗ А360 Отменено'" {
            val supportResponse = supportsCrmClient.send(
                opportunityA360GetByBushAction360SupportStatuses(
                    OpportunityA360GetByBushAction360SupportStatusesRequest(
                        bushAction360Id = newBushId,
                        supportStatuses = listOf(124)
                    )
                )
            )

            assertTrue(supportResponse.isNotEmpty())
        }

        "Детач куста" {
            val detachId = supportsCrmClient
                .send(facadeA360BushDetach(FacadeA360BushDetachRequest(updatedBushId, systemUserId1))).id

            assertTrue(detachId?.matches(FieldData.PATTERN_FOR_ID) ?: false)
        }
    }
}
