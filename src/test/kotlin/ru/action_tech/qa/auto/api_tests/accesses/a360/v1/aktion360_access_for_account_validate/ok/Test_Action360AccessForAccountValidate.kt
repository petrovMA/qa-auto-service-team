package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.aktion360_access_for_account_validate.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessForAccountValidateV1
import ru.action_tech.qa.auto.api_models.admin360_backend.Admin360BackendRequests
import ru.action_tech.qa.auto.api_models.customer.CustomersRequests.getCustomerGetByPin
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.helpers.api.ApiDemoAccessHelper
import ru.action_tech.qa.auto.utils.customerServiceArmSellerClient
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.admin360BackendCrmClient


class Test_Action360AccessForAccountValidate {

    private lateinit var accountId: String

    @BeforeEach
    fun findCompanyWithDemoAccess() {
        val accessesIds = "Поиск демодоступов в определённой дате" {
            ApiDemoAccessHelper.getDemoAccessIds(
                dateFrom = DateTimeUtils.YESTERDAY.minusDays(30),
                dateTo = DateTimeUtils.TOMORROW
            )
                .map { it.id }
                .chunked(10) // разбиваем на массивы по 10 штук и берём первые 10 штук (если закинуть весь массив то запрос упадёт по таймауту)
                .first()
                .toTypedArray()
        }

        val pin = "Запрос информации о компании имеющей демодоступ и получение ПИНа" {
            admin360BackendCrmClient.send(Admin360BackendRequests.demoAccessListGetByDemoAccessRequestIds(*accessesIds))
                .first().accountPin
        }

        accountId = "Получение идентификатора пользователя с ПИН = $pin" {
            customerServiceArmSellerClient.send(getCustomerGetByPin(pin)).id
        }
    }

    @Test
    @Requirements("REQCRM-1575")
    @Sale_Accesses
    @Aktion360AccessForAccountValidateV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-access-for-account_validate -> 200 ok: есть действующий ДД по A360")
    @AllureId("154456")
    fun test() {
        "Проверяем, что у организации есть действующий ДД по A360" {
            assertTrue(accessesCrmClient.send(AccessesRequests.action360AccessForAccountValidate(accountId)))
        }
    }
}