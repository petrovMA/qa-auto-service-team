package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_get_by_account.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessGetByAccountV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.Constants
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360AccessGetByAccount {

    // todo:: добавить предусловия с подготовкой данных на захолдированном клиенте после реализации ARMAP-18854

    private val expectedProducts by lazy {
        listOf(
            Constants.ACTION_A360_MEDICINE,
            Constants.ACTION_A360_HR,
            Constants.ACTION_A360_LABOR_PROTECTION,
            Constants.ACTION_A360_MEDICINE_MANAGEMENT_OF_A_MEDICAL_ORGANIZATION,
            Constants.ACTION_A360_MEDICINE_ECONOMICS_OF_A_MEDICAL_ORGANIZATION,
            Constants.ACTION_A360_LAW_BUDGET,
            Constants.ACTION_A360_MEDICINE_THERAPEUTIC_WORK,
            Constants.ACTION_A360_STATE_FINANCE,
            Constants.ACTION_A360_GOVERNMENT_PROCUREMENT
        )
    }

    @Test
    @Requirements("REQCRM-1576")
    @Sale_Accesses
    @Aktion360AccessGetByAccountV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-access_get-by-account -> 200 Ok: Response Not Empty")
    @AllureId("154446")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.aktion360AccessGetByAccount(accountId = "575a6659-b4a2-4bf3-8533-d132923875b4")
        ).apply {
            "Проверяем, что blockVersion содержит идентификаторы из expectedIds"("expectedIds" to expectedProducts) {
                assertTrue(blockVersion?.map { it.id }?.containsAll(expectedProducts.map { it.id }) ?: false)
            }
        }
    }
}