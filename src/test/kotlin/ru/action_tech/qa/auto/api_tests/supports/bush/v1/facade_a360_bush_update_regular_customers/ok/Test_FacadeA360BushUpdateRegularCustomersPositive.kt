package ru.action_tech.qa.auto.api_tests.supports.bush.v1.facade_a360_bush_update_regular_customers.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.FacadeA360BushUpdateRegularCustomers
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.facadeA360BushUpdateRegularCustomers
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_regular_customers.request.FacadeA360BushUpdateRegularCustomersRequest
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_FacadeA360BushUpdateRegularCustomersPositive {

    private val bushAction360Id = "221ae45a-4e2e-4965-a8cb-50593e604b3a"

    @Test
    @Sale_Supports
    @FacadeA360BushUpdateRegularCustomers
    @Response_200_Ok
    @Requirements("REQCRM-969")
    @HistoryIssues("ARMAP-16719", "ARMAP-17778")
    @DisplayName("/api/v1/facade-a360-bush_update-regular-customers -> 200 Ok: Метод обновления регулярных клиентов куста Актион 360")
    @AllureId("145888")
    fun test() {

        supportsCrmClient.send(
            facadeA360BushUpdateRegularCustomers(
                FacadeA360BushUpdateRegularCustomersRequest(
                    bushAction360Id = bushAction360Id,
                    customerIds = listOf("d539792c-dcd6-42b5-a764-01355a5c7240", "8bc43185-7a9b-49a0-a20c-3636c054491a"),
                    factPrice = 0,
                    factUsersAmount = 0,
                    systemUserId = ACTIONUSKA.id
                )
            )
        ).apply {
            "Проверка что в ответе bushAction360Id = $bushAction360Id" {
                assertEqual(this.id!!.uppercase(), bushAction360Id.uppercase())
            }

            "Проверяем, что имя куста = 66802" {
                assertEqual(this.name, "66802")
            }
        }
    }
}