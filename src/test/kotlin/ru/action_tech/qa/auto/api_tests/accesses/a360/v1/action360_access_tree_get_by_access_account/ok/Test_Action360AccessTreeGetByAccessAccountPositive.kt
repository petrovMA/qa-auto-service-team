package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_tree_get_by_access_account.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessTreeGetByAccessAccountV1
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.api_models.access_backend.access.v2.user_get_active.response.UserGetActiveResponse
import ru.action_tech.qa.auto.data.ProductDataSubscription.SIMPLE_PRODUCT_UUID
import ru.action_tech.qa.auto.data.ContactPerson.USER_FOR_ACCESS_TREE
import ru.action_tech.qa.auto.data.Constants.TEST_ACCESS_TREE_GET_BY_ACCESS_ACCOUNT
import ru.action_tech.qa.auto.helpers.api.UserHelper.getActiveUserAccess
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360AccessTreeGetByAccessAccountPositive {
    private lateinit var access: UserGetActiveResponse
    private lateinit var accessId: String

    private val request by lazy {
        AccessesRequests.action360AccessTreeGetByAccessAccount(
            accountId = TEST_ACCESS_TREE_GET_BY_ACCESS_ACCOUNT.id,
            accessId = accessId
        )
    }

    @BeforeEach
    fun setUp() {
        access = getActiveUserAccess(USER_FOR_ACCESS_TREE.bitrixId!!)

        accessId = access.entities?.find {
            it.data!!.any { data ->
                data!!.value == "5500-6375-4448-8573-3203"
            }
        }!!.core!!.id
    }

    @Test
    @Requirements("REQCRM-1577")
    @HistoryIssues("ARMAP-17376")
    @Sale_Accesses
    @Aktion360AccessTreeGetByAccessAccountV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-access-tree_get-by-access-account -> 200 Ok")
    @AllureId("154449")
    fun test() {
        accessesCrmClient.send(request).apply {

            "Проверяем uuid доступа" { assertEqual(this.id, accessId) }

            "Проверяем, uuid продукта соответствует продукту 'Актион 360 Подписка'" {
                assertEqual(this.productId, SIMPLE_PRODUCT_UUID)
            }

            "Проверяем Код доступа" { assertEqual(this.authCode, "5500-6375-4448-8573-3203") }
        }
    }
}