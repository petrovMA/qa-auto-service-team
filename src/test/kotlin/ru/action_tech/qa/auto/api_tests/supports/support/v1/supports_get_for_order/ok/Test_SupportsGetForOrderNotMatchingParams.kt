package ru.action_tech.qa.auto.api_tests.supports.support.v1.supports_get_for_order.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests
import ru.action_tech.qa.auto.api_models.erm_backend.license.v1.license_create_for_partner.LicenseCreateForPartnerRequest
import ru.action_tech.qa.auto.api_models.supports.SupportsGetForOrder
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.supportsGetForOrder
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.helpers.api.ApiOrderHelper
import ru.action_tech.qa.auto.utils.ermBackendArmSellerClient
import ru.action_tech.qa.auto.api_models.erm_backend.order.v1.order_get_license_preview.OrderGetLicensePreviewResponse
import ru.action_tech.qa.auto.utils.auth.tokenFirstPartnerTestUser
import ru.action_tech.qa.auto.data.PRICE_LIST_E
import ru.action_tech.qa.auto.data.SupportStatus.SUPPORT_STATUS_44
import ru.action_tech.qa.auto.data.SupportType.SUPPORT_TYPE_3
import ru.action_tech.qa.auto.data.SupportType.SUPPORT_TYPE_4
import ru.action_tech.qa.auto.data.TEST_DEALER_12345_CHILD
import ru.action_tech.qa.auto.data.TEST_PARTNER_FOR_SASHA
import ru.action_tech.qa.auto.helpers.api.ApiAccessesHelper
import ru.action_tech.qa.auto.helpers.api.ApiErmBackendHelper
import ru.action_tech.qa.auto.helpers.api.ApiSupportsHelper
import ru.action_tech.qa.auto.helpers.api.HoldUserHelper.holdUser
import ru.action_tech.qa.auto.utils.uuid
import ru.action_tech.qa.auto.data.ACTION_GLAVBUH
import ru.action_tech.qa.auto.data.PRODUCT_E
import ru.action_tech.qa.auto.utils.supportsCrmClient
import java.util.*


class Test_SupportsGetForOrderNotMatchingParams {

    private lateinit var clientId: String
    private lateinit var supportId: String
    private lateinit var orderId: UUID
    private lateinit var licensePreview: OrderGetLicensePreviewResponse
    private lateinit var taskId: String

    private val product by lazy { PRODUCT_E }
    private val manager by lazy { TEST_PARTNER_FOR_SASHA.id }
    private val partner by lazy { TEST_DEALER_12345_CHILD.id }
    private val authToken by lazy { tokenFirstPartnerTestUser }
    private val priceList by lazy { PRICE_LIST_E.id }

    private val testData by lazy {
        listOf(
            "Запрос с Не совпадающим customerId" to supportsGetForOrder(
                customerId = UUID.randomUUID(),
                customerType = 2,
                supportType = SUPPORT_TYPE_4.number,
                mainProductTypeId = product.mainProduct.mainProductTypeId
            ),
            "Запрос с Не совпадающим supportType" to supportsGetForOrder(
                customerId = clientId,
                customerType = 2,
                supportType = SUPPORT_TYPE_3.number,
                mainProductTypeId = product.mainProduct.mainProductTypeId
            ), "Запрос с Не совпадающим customerType" to supportsGetForOrder(
                customerId = clientId,
                customerType = 1,
                supportType = SUPPORT_TYPE_4.number,
                mainProductTypeId = product.mainProduct.mainProductTypeId
            ), "Запрос с Не совпадающим mainProductTypeId" to supportsGetForOrder(
                customerId = clientId,
                customerType = 2,
                supportType = SUPPORT_TYPE_4.number,
                mainProductTypeId = ACTION_GLAVBUH.mainProductTypeId
            )
        )
    }

    @BeforeEach
    fun setUp() {
        "Подготовить тестовые данные" {
            clientId = holdUser().id

            orderId = ApiErmBackendHelper.generateAndAddTestOrder(
                token = authToken,
                realContactId = clientId.uuid,
                customerId = clientId.uuid,
                contactId = clientId.uuid,
                items = listOf(
                    ApiErmBackendHelper.generateTestItem(
                        priceId = priceList, products = listOf(
                            ApiErmBackendHelper.generateTestProduct(
                                productId = product.id, readerId = clientId.uuid
                            )
                        )
                    )
                )
            ).id

            licensePreview = ApiErmBackendHelper.getLicensePreview(orderId = orderId.toString(), token = authToken)

            taskId = "Регистрация лицензии для партнёра: $partner" {
                ermBackendArmSellerClient.send(
                    ErmBackendRequests.licenseCreateForPartner(
                        token = authToken, request = LicenseCreateForPartnerRequest(
                            orderId = orderId,
                            saleSysUserId = manager,
                            salePartnerId = partner,
                            extensionSysUserId = licensePreview.extensionSysUserId,
                            supportSysUserId = licensePreview.supportSysUserId,
                            supportPartnerId = licensePreview.supportPartnerId
                        )
                    )
                )
            }.first()

            val licence = ApiAccessesHelper.getLicenseByTask(taskId)

            supportId = "Создать тестовое сопровождение Е" {
                ApiSupportsHelper.addTestEscort(
                    mainProductId = product.mainProduct.id,
                    contactId = clientId,
                    partnerId = partner,
                    systemUserId = manager,
                    supportType = SUPPORT_TYPE_4.number,
                    supportStatus = SUPPORT_STATUS_44.number,
                    licenseId = licence.id
                )
            }
        }
    }

    @AfterEach
    fun cleanUp() {
        "Очистить тестовые данные" {
            if (::taskId.isInitialized) {
                ApiAccessesHelper.deactivateLicense(taskId = taskId, token = authToken)
            }

            if (::clientId.isInitialized && ::supportId.isInitialized) {
                ApiSupportsHelper.deleteTestEscortE(
                    clientId = clientId, clientType = 2, supportId = supportId
                )
            }

            if (::orderId.isInitialized) {
                ApiOrderHelper.deleteOrder(orderId = orderId.toString(), authToken)
            }
        }
    }


    @Test
    @Sale_Supports
    @SupportsGetForOrder
    @Response_200_Ok
    @Requirements("REQCRM-1919")
    @DisplayName("/api/v1/supports_get-for-order -> 200 Ok: Получить сопровождения по клиенту с не совпадающими данными в параметрах")
    @AllureId("242632")
    fun test() {
        testData.forEach { (testName, requestData) ->
            testName {
                supportsCrmClient.send(requestData).apply {
                    "Проверка что ответ пустой".assertTrue(isEmpty())
                }
            }
        }
    }
}