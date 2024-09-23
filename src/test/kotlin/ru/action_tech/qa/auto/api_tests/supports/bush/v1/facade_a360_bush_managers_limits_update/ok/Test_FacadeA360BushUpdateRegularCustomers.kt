package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_managers_limits_update.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushManagersLimitsUpdate
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_managers_limits_update.request.FacadeA360BushManagersLimitsUpdateRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateRegularCustomers {

    private val bushAction360Id = "DDEFEB88-E25E-4D94-B3CD-2827E61E3023"

    @Test
    @Sale_Supports
    @FacadeA360BushManagersLimitsUpdate
    @Response_200_Ok
    @Requirements("REQCRM-971")
    @DisplayName("/api/v1/facade-a360-bush-managers-limits_update -> 200 Ok: Обновление лимитов пользователей для куста А360")
    @AllureId("198103")
    fun test() {

        "Обновление лимитов пользователей для куста А360" {
            supportsCrmClient.send(
                SupportsRequests.facadeA360BushManagersLimitsUpdate(
                    FacadeA360BushManagersLimitsUpdateRequest(
                        authorId = AUTO_ACTIONUSKA.id,
                        limits = listOf(
                            FacadeA360BushManagersLimitsUpdateRequest.Limit(
                                id = bushAction360Id,
                                limitCustomersInDealA360 = 102,
                                limitDealsA360 = 101
                            )
                        )
                    )
                )
            )
        }

        var limits = "Запрос лимитов пользователей для куста А360" {
            supportsCrmClient.send(SupportsRequests.facadeA360BushManagersLimitsGetByIds(listOf("DDEFEB88-E25E-4D94-B3CD-2827E61E3023")))
        }

        "Проверка, что лимиты пользователей для куста А360 обновились" {
            assertEqual(limits.first().limitCustomersInDealA360, 102)
            assertEqual(limits.first().limitDealsA360, 101)
        }

        "Возвращение лимитов пользователей для куста А360 в исходное значение" {
            supportsCrmClient.send(
                SupportsRequests.facadeA360BushManagersLimitsUpdate(
                    FacadeA360BushManagersLimitsUpdateRequest(
                        authorId = AUTO_ACTIONUSKA.id,
                        limits = listOf(
                            FacadeA360BushManagersLimitsUpdateRequest.Limit(
                                id = bushAction360Id,
                                limitCustomersInDealA360 = 100,
                                limitDealsA360 = 100
                            )
                        )
                    )
                )
            )
        }

        limits = "Запрос лимитов пользователей для куста А360" {
            supportsCrmClient.send(SupportsRequests.facadeA360BushManagersLimitsGetByIds(listOf("DDEFEB88-E25E-4D94-B3CD-2827E61E3023")))
        }

        "Проверка, что лимиты пользователей для куста А360 вернулись в исходное значение" {
            assertEqual(limits.first().limitCustomersInDealA360, 100)
            assertEqual(limits.first().limitDealsA360, 100)
        }
    }
}