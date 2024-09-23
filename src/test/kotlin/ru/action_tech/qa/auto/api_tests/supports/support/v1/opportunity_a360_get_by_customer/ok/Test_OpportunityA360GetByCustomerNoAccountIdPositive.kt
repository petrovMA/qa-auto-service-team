package ru.action_tech.qa.auto.api_tests.supports.support.v1.opportunity_a360_get_by_customer.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.OpportunityA360GetByCustomer
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360GetByCustomer
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_OpportunityA360GetByCustomerNoAccountIdPositive {


    @Test
    @Requirements("REQCRM-220")
    @Sale_Supports
    @OpportunityA360GetByCustomer
    @Response_200_Ok
    @DisplayName("/api/v1/opportunity-a360_get-by-customer -> 200 Ok: не передан accountId")
    @AllureId("145903")
    fun test() {
        val response = supportsCrmClient.send(opportunityA360GetByCustomer(null))

        "Проверяем, что ответ пустой" { Assertions.assertThat(response).isEmpty() }
    }
}