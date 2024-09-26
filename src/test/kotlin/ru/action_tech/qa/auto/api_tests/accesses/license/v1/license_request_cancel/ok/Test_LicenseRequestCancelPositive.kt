package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_request_cancel.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseRequestCancelV1
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdRequest
import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.commons.tags.SkipForProd
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.data.*
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.data.PRODUCT_E
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkBR
import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests
import ru.action_tech.qa.auto.api_models.erm_backend.license.v1.license_create_for_partner.LicenseCreateForPartnerRequest
import ru.action_tech.qa.auto.helpers.api.ApiErmBackendHelper
import ru.action_tech.qa.auto.helpers.api.HoldUserHelper.holdUser
import ru.action_tech.qa.auto.utils.auth.tokenFirstPartnerTestUser
import ru.action_tech.qa.auto.utils.ermBackendArmSellerClient

class Test_LicenseRequestCancelPositive {
    private lateinit var testClientId: String
    private lateinit var testOrderId: String
    private lateinit var testTaskId: String

    private val testProduct by lazy { PRODUCT_E.id }
    private val testPriceList by lazy { PRICE_LIST_E.id }
    private val authToken by lazy { tokenFirstPartnerTestUser }
    private val manager by lazy { TEST_PARTNER_FIRST_USER.id }
    private val partner by lazy { TEST_DEALER_12345.id }
    private val escortManager by lazy { TEST_PARTNER_FIFTH_USER.id }
    private val escortPartner by lazy { TEST_DEALER_12345_CHILD.id }
    private val extensionManager by lazy { TEST_CHECK_CATEGORY.id }

    @BeforeEach
    fun setUp() {
        "Подготовить тестовые данные" {
            testClientId = holdUser().id

            testOrderId = ApiErmBackendHelper.generateAndAddTestOrder(
                token = authToken,
                realContactId = testClientId.uuid,
                customerId = testClientId.uuid,
                contactId = testClientId.uuid,
                items = listOf(
                    ApiErmBackendHelper.generateTestItem(
                        priceId = testPriceList,
                        products = listOf(
                            ApiErmBackendHelper.generateTestProduct(
                                productId = testProduct,
                                readerId = testClientId.uuid
                            )
                        )
                    )
                )
            ).id.toString()

            testTaskId = ermBackendArmSellerClient.send(
                ErmBackendRequests.licenseCreateForPartner(
                    token = authToken,
                    request = LicenseCreateForPartnerRequest(
                        orderId = testOrderId,
                        saleSysUserId = manager,
                        salePartnerId = partner,
                        extensionSysUserId = extensionManager,
                        supportSysUserId = escortManager,
                        supportPartnerId = escortPartner
                    )
                )
            ).first()
        }
    }

    @AfterEach
    fun cleanUp() {
        "Очистить тестовые данные" {
            if (::testOrderId.isInitialized) {
                ApiOrderHelper.deleteOrder(orderId = testOrderId, token = authToken)
            }
        }
    }

    @Test
    @Requirements("REQCRM-1951")
    @Sale_Accesses
    @SkipForProd
    @LicenseRequestCancelV1
    @Response_200_Ok
    @DisplayName("/api/v1/license-request_cancel -> 200 ok: Отмена заявки на формирование лицензии")
    @AllureId("238221")
    fun test() {
        accessesCrmClient.send(AccessesRequests.licenseRequestCancel(testTaskId))
        "Проверка, что заявка отменена" {
            checkBR(
                apiClient = accessesCrmClient,
                request = AccessesRequests.licenseGetByTaskId(LicenseGetByTaskIdRequest(testTaskId)),
                expected = setOf(
                    BrokenRule(
                        code = 1,
                        message = "Ошибка: \$Заявка отменена"
                    )
                )
            )
        }
    }
}