package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_add.request.SupportAddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_add.request.SupportOpportunityA360AddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_update.request.SupportOpportunityA360UpdateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_add.request.SupportOpportunityAddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_update.request.SupportOpportunityUpdateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_update.request.SupportUpdateRequest
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.enums.SupportStatus
import ru.action_tech.qa.auto.data.TEST_DEALER_12345
import ru.action_tech.qa.auto.data.TEST_PARTNER_FIRST_USER
import ru.action_tech.qa.auto.utils.supportsCrmClient
import java.time.LocalDateTime

object ApiSupportsHelper {

    /** добавление сопровождения:
     * - А360: тип 13, статус 133
     * - СС: тип 3, статус 33
     * - ЮС: тип 7, статус 71
     */
    fun addTestEscort(
        mainProductId: String,
        supportType: Int,
        supportStatus: Int,
        accountId: String? = null,
        contactId: String? = null,
        partnerId: String? = TEST_DEALER_12345.id,
        systemUserId: String? = TEST_PARTNER_FIRST_USER.id,
        startDate: String? = LocalDateTime.now().minusMinutes(5).toString(),
        endDate: String? = LocalDateTime.now().plusMinutes(5).toString(),
        licenseId: String? = null,
        supportChangeReasonId: String? = null
    ): String {
        val lazyValue by lazy {
            supportsCrmClient.send(
                SupportsRequests.supportAdd(
                    SupportAddRequest(
                        supportType = supportType,
                        mainProductId = mainProductId,
                        startDate = startDate,
                        endDate = endDate,
                        accountId = accountId,
                        contactId = contactId,
                        partnerId = partnerId,
                        systemUserId = systemUserId,
                        status = supportStatus,
                        licenseId = licenseId,
                        supportChangeReasonId = supportChangeReasonId
                    )
                )
            )
        }
        lazyValue.apply { assertFalse(this.isBlank()) }
        return lazyValue
    }


    /** деактивация сопровождения:
     * - А360: статус 134
     * - СС: статус 34
     * - ЮС: статус 72
     */
    fun deleteTestEscort(
        key: String,
        clientId: String,
        clientType: Int,
        supportId: String,
        supportStatus: Int,
        endDate: String? = LocalDateTime.now().minusMinutes(5).toString()
    ) {
        val lazyValue by lazy {
            supportsCrmClient.send(
                SupportsRequests.supportUpdate(
                    SupportUpdateRequest(
                        id = supportId,
                        status = supportStatus,
                        endDate = endDate
                    )
                )
            )
        }
        lazyValue.apply { assertFalse(this.isBlank()) }

        ApiCustomerServiceHelper.waitSupportInfoUpdating(clientId = clientId, key = key)

        deleteTestSupport(supportId = supportId, clientId = clientId, clientType = clientType)
    }

    fun deleteTestEscortE(
        clientId: String,
        clientType: Int,
        supportId: String,
        endDate: String? = LocalDateTime.now().minusMinutes(5).toString()
    ) {
        "Деактивировать и удалить тестовое сопровождение Е" {
            val lazyValue by lazy {
                supportsCrmClient.send(
                    SupportsRequests.supportUpdate(
                        SupportUpdateRequest(
                            id = supportId,
                            status = SupportStatus.SUPPORT_STATUS_42.number,
                            endDate = endDate
                        )
                    )
                )
            }
            lazyValue.apply { assertFalse(this.isBlank()) }

            deleteTestSupport(supportId = supportId, clientId = clientId, clientType = clientType)
        }
    }

    fun deleteTestExtension(
        clientId: String,
        clientType: Int,
        supportId: String,
        endDate: String? = LocalDateTime.now().minusMinutes(5).toString()
    ) {
        "Деактивировать и удалить тестовое расширение" {
            val lazyValue by lazy {
                supportsCrmClient.send(
                    SupportsRequests.supportUpdate(
                        SupportUpdateRequest(
                            id = supportId,
                            status = SupportStatus.SUPPORT_STATUS_52.number,
                            endDate = endDate
                        )
                    )
                )
            }
            lazyValue.apply { assertFalse(this.isBlank()) }

            deleteTestSupport(supportId = supportId, clientId = clientId, clientType = clientType)
        }
    }

    fun addTestPossibleDealSs(
        accountId: String? = null,
        contactId: String? = null,
        partnerId: String? = TEST_DEALER_12345.id,
        systemUserId: String? = TEST_PARTNER_FIRST_USER.id,
        startDate: String? = LocalDateTime.now().minusMinutes(5).toString(),
        endDate: String? = LocalDateTime.now().plusMinutes(5).toString(),
        isFixedDates: Boolean? = null,
    ): String {
        val lazyValue by lazy {
            "Создать тестовую возможную сделку СС" {
                supportsCrmClient.send(
                    SupportsRequests.supportOpportunityAdd(
                        SupportOpportunityAddRequest(
                            startDate = startDate,
                            endDate = endDate,
                            accountId = accountId,
                            contactId = contactId,
                            status = SupportStatus.SUPPORT_STATUS_11.number,
                            partnerId = partnerId,
                            systemUserId = systemUserId,
                            isFixedDates = isFixedDates
                        )
                    )
                )
            }
        }
        lazyValue.apply { assertFalse(this.isBlank()) }
        return lazyValue
    }


    fun deleteTestPossibleDealSs(
        clientId: String,
        clientType: Int,
        supportId: String,
        endDate: String? = LocalDateTime.now().minusMinutes(5).toString(),
        rejectedOn: String? = null
    ) {
        "Деактивировать и удалить тестовую возможную сделку СС" {
            val lazyValue by lazy {
                supportsCrmClient.send(
                    SupportsRequests.supportOpportunityUpdate(
                        SupportOpportunityUpdateRequest(
                            id = supportId,
                            status = SupportStatus.SUPPORT_STATUS_14.number,
                            endDate = endDate,
                            rejectedOn = rejectedOn
                        )
                    )
                )
            }
            lazyValue.apply { assertFalse(this.isBlank()) }

            ApiCustomerServiceHelper.waitSupportInfoUpdating(clientId = clientId, key = "statusXss")

            deleteTestSupport(supportId = supportId, clientId = clientId, clientType = clientType)
        }
    }

    fun addTestPossibleDealA360(
        accountId: String? = null,
        contactId: String? = null,
        partnerId: String? = TEST_DEALER_12345.id,
        systemUserId: String? = TEST_PARTNER_FIRST_USER.id,
        startDate: String? = LocalDateTime.now().minusMinutes(5).toString(),
        endDate: String? = LocalDateTime.now().plusMinutes(5).toString(),
        isFixedDates: Boolean? = null
    ): String {
        val lazyValue by lazy {
            "Создать тестовую возможную сделку А360" {
                supportsCrmClient.send(
                    SupportsRequests.supportOpportunityA360Add(
                        SupportOpportunityA360AddRequest(
                            startDate = startDate,
                            endDate = endDate,
                            accountId = accountId,
                            contactId = contactId,
                            status = SupportStatus.SUPPORT_STATUS_121.number,
                            partnerId = partnerId,
                            systemUserId = systemUserId,
                            isFixedDates = isFixedDates
                        )
                    )
                )
            }
        }
        lazyValue.apply { assertFalse(this.isBlank()) }
        return lazyValue
    }

    fun deleteTestPossibleDealA360(
        clientId: String,
        clientType: Int,
        supportId: String,
        endDate: String? = LocalDateTime.now().minusMinutes(5).toString(),
        rejectedOn: String? = null
    ) {
        "Деактивировать и удалить тестовую возможную сделку А360" {
            val lazyValue by lazy {
                supportsCrmClient.send(
                    SupportsRequests.supportOpportunityA360Update(
                        SupportOpportunityA360UpdateRequest(
                            id = supportId,
                            status = SupportStatus.SUPPORT_STATUS_124.number,
                            endDate = endDate,
                            rejectedOn = rejectedOn
                        )
                    )
                )
            }
            lazyValue.apply { assertFalse(this.isBlank()) }

            ApiCustomerServiceHelper.waitSupportInfoUpdating(clientId = clientId, key = "statusA360")

            deleteTestSupport(supportId = supportId, clientId = clientId, clientType = clientType)
        }
    }

    private fun deleteTestSupport(supportId: String, clientId: String, clientType: Int) {
        supportsCrmClient.send(
            SupportsRequests.supportDeleteTested(
                supportId = supportId
            )
        )

        "Проверить, что тестовое сопровождение / расширение / возможная сделка удалены" {
            supportsCrmClient.send(
                SupportsRequests.supportsGetByCustomer(
                    customerId = clientId,
                    customerType = clientType // Тип клиента (1 - ЮЛ, 2 - ФЛ)
                )
            ).map { it.id }.toSet().apply {
                assertFalse(this.contains(supportId))
            }
        }
    }

}