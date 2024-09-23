package ru.action_tech.qa.auto.api_tests.supports.stoplist.v1.stop_list_bind_new_customer

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.NegativeScenario
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.api_models.supports.StopListBindNewCustomer
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.stopListBindNewCustomer
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind_new_customer.StopListBindNewCustomerRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.testBRUnauthorized
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.auth.tokenHomePortalApp
import ru.action_tech.qa.auto.data.Country
import ru.action_tech.qa.auto.utils.getRandomNumberToString
import ru.action_tech.qa.auto.data.FieldData.DEFAULT_ID
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.utils.supportsCrmClient


class Test_StopListBindNewCustomerNegativeScenario {

    private val testsData by lazy {
        mapOf(
            "Wrong phoneNumber" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBindNewCustomer(
                        StopListBindNewCustomerRequest(
                            partnerId = DEFAULT_ID,
                            name = "test",
                            inn = "1667006447",
                            kpp = "136666415",
                            customerType = 1,
                            phoneNumber = "312345936",
                            email = "testtesttesttest@test.test",
                            middleName = "string",
                            firstName = "string",
                            lastName = "string",
                            extension = getRandomNumberToString(10000000, 20000000),
                            comment = "string"
                        )
                    ),
                    expected = setOf(
                        BrokenRule(
                            0,
                            """[{"message":"Телефон 312345936 должен быть 10 цифр","code":5004}]"""
                        )
                    )
                )
            },
            "Email already exist" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBindNewCustomer(
                        StopListBindNewCustomerRequest(
                            partnerId = DEFAULT_ID,
                            name = "test",
                            inn = "12356",
                            kpp = "12356",
                            customerType = 1,
                            phoneNumber = "9312345936",
                            email = "test@test.test",
                            middleName = "string",
                            firstName = "string",
                            lastName = "string",
                            extension = getRandomNumberToString(10000000, 20000000),
                            comment = "string",
                            countryId = Country.RUS.id
                        )
                    ),
                    expected = setOf(
                        BrokenRule(
                            0,
                            """[{"message":"Клиент с таким Email уже существует - test@test.test","code":5007}]"""
                        )
                    )
                )
            },
            "No partnerId" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBindNewCustomer(
                        StopListBindNewCustomerRequest(
                            partnerId = null,
                            name = "test",
                            inn = "1667006447",
                            kpp = "136666415",
                            customerType = 1,
                            phoneNumber = "9312345936",
                            email = "test@test.test",
                            middleName = "string",
                            firstName = "string",
                            lastName = "string",
                            extension = getRandomNumberToString(10000000, 20000000),
                            comment = "string"
                        )
                    ),
                    expected = setOf(BrokenRule(46, "Не указан партнер для стоп-листа"))
                )
            },
            "Некорректный ИНН или КПП" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBindNewCustomer(
                        StopListBindNewCustomerRequest(
                            partnerId = DEFAULT_ID,
                            name = "test",
                            inn = "QWE",
                            kpp = "RET",
                            customerType = 1,
                            phoneNumber = "9312345936",
                            email = "${System.currentTimeMillis()}testtest@test.test",
                            middleName = "string",
                            firstName = "string",
                            lastName = "string",
                            extension = getRandomNumberToString(10000000, 20000000),
                            comment = "string"
                        )
                    ),
                    expected = setOf(
                        BrokenRule(
                            0,
                            """[{"message":"Некорректный ИНН или КПП","code":6000}]"""
                        )
                    )
                )
            },
            "Клиент с таким ИНН и КПП уже существует" to {
                checkBR(
                    apiClient = supportsCrmClient,
                    request = SupportsRequests.stopListBindNewCustomer(
                        StopListBindNewCustomerRequest(
                            partnerId = DEFAULT_ID,
                            name = "test",
                            inn = "5404514917",
                            kpp = "540401001",
                            customerType = 1,
                            phoneNumber = "9312345936",
                            email = "${System.currentTimeMillis()}testtest@test.test",
                            middleName = "string",
                            firstName = "string",
                            lastName = "string",
                            extension = getRandomNumberToString(10000000, 20000000),
                            comment = "string"
                        )
                    ),
                    expected = setOf(
                        BrokenRule(
                            0,
                            """[{"message":"Клиент с таким ИНН и КПП уже существует","code":1005}]"""
                        )
                    )
                )
            },
            "Токен = null" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    SupportsRequests.stopListBindNewCustomer(null, null)
                )
            },
            "Пустой токен" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    SupportsRequests.stopListBindNewCustomer(null, "")
                )
            },
            "Невалидный токен" to {
                testBRUnauthorized(
                    supportsCrmClient,
                    SupportsRequests.stopListBindNewCustomer(null, tokenHomePortalApp)
                )
            }
        )
    }

    @Test
    @Sale_Supports
    @StopListBindNewCustomer
    @NegativeScenario
    @Requirements("REQCRM-2000")
    @DisplayName("$stopListBindNewCustomer -> Negative Scenario")
    @AllureId("246990")
    fun test() {
        testsData.forEach { (testName, case) -> testName { case.invoke() } }
    }
}
