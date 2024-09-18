package ru.action_tech.qa.auto.api_tests.supports.stoplist.v1.stop_list_bind_new_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.public_api.PublicApiRequests
import ru.action_tech.qa.auto.api_models.supports.StopListBindNewCustomer
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.stopListBindNewCustomer
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind_new_customer.StopListBindNewCustomerRequest
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.Country
import ru.action_tech.qa.auto.data.TEST_PARTNER
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.getRandomNumberToString
import ru.action_tech.qa.auto.utils.getRandomString
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_StopListBindNewCustomer {
    private val customerTypes by lazy {
        listOf(
            "Юр лицо" to Pair(1, getRandomNumberToString()),
            "Физ лицо" to Pair(2, "12${getRandomNumberToString()}"),
        )
    }

    @Test
    @Sale_Supports
    @StopListBindNewCustomer
    @Response_200_Ok
    @Requirements("REQCRM-2000")
    @DisplayName("$stopListBindNewCustomer -> 200 OK: Закрепить нового не существующего клиента в стоп-лист")
    @AllureId("246989")
    fun test() {
        customerTypes
            .forEach { (name, data) ->
                val (type, inn) = data

                "Закрепление $name" {
                    supportsCrmClient.send(
                        SupportsRequests.stopListBindNewCustomer(
                            StopListBindNewCustomerRequest(
                                partnerId = TEST_PARTNER.id,
                                name = getRandomString(10),
                                inn = inn,
                                kpp = getRandomNumberToString().substring(0, 9),
                                customerType = type,
                                phoneNumber = getRandomNumberToString(100000000, 200000000),
                                email = "${getRandomString(10)}@test.test",
                                middleName = getRandomString(10),
                                firstName = getRandomString(10),
                                lastName = getRandomString(10),
                                extension = getRandomNumberToString(10000000, 20000000),
                                comment = getRandomString(10),
                                countryId = Country.UZ.id
                            )
                        )
                    ).apply {
                        verifyCustomerIsBound(id)
                    }
                }
            }
    }

    private fun verifyCustomerIsBound(id: String?) {
        supportsCrmClient.send(PublicApiRequests.stopListsGetByPartnerId(TEST_PARTNER.id, token = tokenAutoActionushka))
            .apply { "Запись с id $id не найдена в стоп листе".assertTrue(any { it.id.toString() == id }) }
    }
}
