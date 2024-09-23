package ru.action_tech.qa.auto.api_tests.supports.support.v1.opportunity_a360_get_by_customer.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.OpportunityA360GetByCustomer
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.opportunityA360GetByCustomer
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_OpportunityA360GetByCustomerPositive {


    @Test
    @Requirements("REQCRM-220")
    @Sale_Supports
    @OpportunityA360GetByCustomer
    @HistoryIssues("ARMAP-16721")
    @Response_200_Ok
    @DisplayName("/api/v1/opportunity-a360_get-by-customer -> 200 Ok: Получить сопровождения с возможной сделкой Актион 360")
    @AllureId("145904")
    fun test() {
        // параметр "accountId" -> "customers[].id" в А360, таб Потенциальные сделки
        val response = supportsCrmClient.send(opportunityA360GetByCustomer("2cf89cff-9e40-46e7-838c-7a68d58d3509"))

        "Проверка что ответ не пустой" { assertThat(response).isNotEmpty }
    }
}