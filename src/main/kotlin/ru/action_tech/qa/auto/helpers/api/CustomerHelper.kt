package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.customer.CustomersRequests.customerHold
import ru.action_tech.qa.auto.api_models.customer.CustomersRequests.customerSetSupportPartners
import ru.action_tech.qa.auto.api_models.customer.CustomersRequests.customerSetSupportType
import ru.action_tech.qa.auto.api_models.customer.CustomersRequests.getInfo
import ru.action_tech.qa.auto.api_models.customer.qa.customer_set_support_type.CustomerSetSupportTypeRequest
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold.CustomerHoldRequest
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold.CustomerHoldResponse
import ru.action_tech.qa.auto.api_models.erm_backend.ErmBackendRequests.customerGetById
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_update.request.SupportOpportunityUpdateRequest
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.serialization.facade.deserialize
import ru.action_tech.qa.auto.core.utils.waiting.Wait
import ru.action_tech.qa.auto.data.Country
import ru.action_tech.qa.auto.data.CustomerSupportType.SK
import ru.action_tech.qa.auto.erm.api.requests.erm.customer.qa.v1.customer_set_support_partners.CustomerSetSupportPartnersRequest
import ru.action_tech.qa.auto.utils.*
import ru.action_tech.qa.auto.utils.http.Headers.DATE
import ru.action_tech.qa.auto.utils.http.Headers.X_OPERATION_ID
import ru.action_tech.qa.auto.utils.junit.threadLocalCustomer
import java.net.HttpURLConnection.HTTP_OK
import java.util.*
import kotlin.collections.ArrayList

object CustomerHelper {
    private const val supportChangeReasonId = "5b32055e-6ac7-4cbd-a123-d477a7885e3d" // Тестовая причина изменения сопровождения
    private val threadCustomersCSVObject by lazy { ThreadLocal.withInitial { CustomerCSVObject() } }

    @Volatile
    var indicator = true

    class CustomerCSVObject(
        var testClass: String = "",
        var customerId: ArrayList<String> = arrayListOf(),
        var startHoldTime: ArrayList<String> = arrayListOf(),
        var startXOperationId: ArrayList<String> = arrayListOf(),
        var endHoldTime: String = "",
        var endXOperationId: String = ""
    )


    fun holdCustomerForTest(
        countryId: String = Country.UZ.id, //Страна - Узбекистан
        holdingTimeInSeconds: String = HOLD_ENTITY_TIME_SECONDS,
        meta: String? = null,
    ) = "Получить клиента (юр. лицо) для теста" {
        Wait.until(
            timeoutInMs = HOLD_ENTITY_TIME_SECONDS.toLong() * 1000,
            pollingIntervalInMs = 1000,
            test = { statusCode == HTTP_OK },
            script = {
                customerServiceArmSellerClient.send(
                    customerHold(CustomerHoldRequest(countryId, meta, holdingTimeInSeconds)).apply {
                        verify = {}
                    }
                )
            }
        ).let {
            it.headers.let { headers ->
                if (COLLECT_DATA_FOR_CUSTOMER_CSV) {
                    threadCustomersCSVObject.get().startHoldTime.add(headers[DATE].value)
                    threadCustomersCSVObject.get().startXOperationId.add(headers[X_OPERATION_ID].value)
                }
            }
            val customer = CustomerHoldResponse.deserialize(it.asString())
            if (COLLECT_DATA_FOR_CUSTOMER_CSV) {
                threadCustomersCSVObject.get().customerId.add(customer.id.toString())
            }
            customer.apply {
                threadLocalCustomer.get().add(this)
            }
        }
    }

    fun dropStopListCountForCustomer(customerId: UUID) {
        val customerType = customerServiceArmSellerClient.send(getInfo(customerId)).customerType

        supportsCrmClient.send(
            SupportsRequests.supportsGetByCustomer(
                customerId = customerId.toString(),
                customerType = customerType
            )
        ).filter {
            (it.supportType == 1) and (it.status != 15)
        }.forEach {
            supportsCrmClient.send(
                SupportsRequests.supportOpportunityUpdate(
                    SupportOpportunityUpdateRequest(
                        id = it.id,
                        status = 15,
                        supportChangeReasonId = supportChangeReasonId
                    )
                )
            )
        }

        val supports =
            supportsCrmClient.send(
                SupportsRequests.supportsGetByCustomer(
                    customerId = customerId.toString(),
                    customerType = customerType
                )
            )
        "Проверяем, что для всех сопровождений с supportType=1 в ответе status=15" {
            supports.filter { it.supportType == 1 }.forEach {
                "Проверяем, что для сопровождения с id=${it.id} в ответе status=15" {
                    "status сопровождений в ответе отличается от ожидаемого".assertEqual(it.status, 15)
                }
            }
        }

        setCustomerSupportType(customerId = customerId, supportTypeId = null, supportA360TypeId = null)
        setCustomerSupportPartner(customerId = customerId, supportPartnerId = null, supportA360PartnerId = null)

        ermBackendArmSellerClient.send(customerGetById(customerId = customerId.toString())).apply {
            "Проверяем, что в ответе supportStatus='СК'" {
                "supportStatus в ответе отличается от ожидаемого".assertEqual(supportStatus, SK.title)
            }
            "Проверяем, что в ответе supportStatusA360='СК'" {
                "supportStatusA360 в ответе отличается от ожидаемого".assertEqual(supportStatusA360, SK.title)
            }
            "Проверяем, что в ответе supportUSStatus='СК'" {
                "supportUSStatus в ответе отличается от ожидаемого".assertEqual(supportUSStatus, SK.title)
            }
        }
    }


    /**
     * Устанавливает сопровождение на сущности клиента (только на сущности клиента, не создаёт само сопровождение как отдельную сущность, как и стоп-лист).
     * @param customerId идентификатор клиента,
     * @param supportTypeId идентификатор статуса клиента, если null, то очистка статуса,
     * @param supportA360TypeId идентификатор статуса клиента A360, если null, то очистка статуса A360.
     */
    fun setCustomerSupportType(customerId: UUID, supportTypeId: UUID? = null, supportA360TypeId: UUID? = null) {
        customerServiceArmSellerClient.send(
            customerSetSupportType(
                CustomerSetSupportTypeRequest(
                    customerId = customerId,
                    supportTypeId = supportTypeId,
                    supportA360TypeId = supportA360TypeId
                )
            )
        )
    }

    /**
     * Устанавливает партнёра сопровождения на сущности клиента (только на сущности клиента, не меняет сами сопровождения как отдельные сущности).
     * @param customerId идентификатор клиента,
     * @param supportPartnerId идентификатор партнёра сопровождения клиента, если null, то очистка партнёра,
     * @param supportA360PartnerId идентификатор партнёра сопровождения клиента A360, если null, то очистка партнёра A360.
     */
    fun setCustomerSupportPartner(customerId: UUID, supportPartnerId: UUID? = null, supportA360PartnerId: UUID? = null) {
        customerServiceArmSellerClient.send(
            customerSetSupportPartners(
                CustomerSetSupportPartnersRequest(
                    customerId = customerId,
                    supportPartnerId = supportPartnerId,
                    supportA360PartnerId = supportA360PartnerId
                )
            )
        )
    }
}