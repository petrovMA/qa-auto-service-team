package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.customer.CustomersRequests
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.waiting.Wait.untilTrue
import ru.action_tech.qa.auto.data.enums.Company
import ru.action_tech.qa.auto.api_models.customer.customer.v1.connect.ConnectOrgAndClientRequest
import ru.action_tech.qa.auto.api_models.customer.customer.v1.connection_delete_by_pin.ConnectionDeleteByPinRequest
import ru.action_tech.qa.auto.api_models.customer.customer.v1.customers_support_info_get_by_ids.CustomersSupportInfoGetByIdsResponse
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.customerServiceArmSellerClient
import ru.action_tech.qa.auto.utils.deserialize
import ru.action_tech.qa.auto.utils.s
import ru.action_tech.qa.auto.utils.untilTrue
import kotlin.reflect.full.memberProperties

object ApiCustomerServiceHelper {

    /** холдирование (start) */
    fun connectCompanyAndContact(
        companyId: String? = Company.UZBEKISTAN_5916483119.id,
        userId: String
    ) {
        "Создать связь компании с контактным лицом" {
            customerServiceArmSellerClient.send(
                CustomersRequests.connect(
                    ConnectOrgAndClientRequest(
                        customerId = companyId,
                        contactPersonId = userId
                    )
                )
            )
        }

        "Проверить, что связь компании с контактным лицом создана" {
            untilTrue(
                timeoutInMs = 30_000,
                pollingIntervalInMs = 1_000,
                suppressException = true
            ) {
                customerServiceArmSellerClient.send(
                    CustomersRequests.getContacts(
                        customerId = companyId
                    )
                ).any { it!!.id == userId }
            }
        }
    }

    fun disconnectCompanyAndContact(
        companyId: String? = Company.UZBEKISTAN_5916483119.id,
        companyPin: String? = Company.UZBEKISTAN_5916483119.pin,
        userId: String,
        userPin: String
    ) {
        "Удалить связь компании с контактным лицом" {
            customerServiceArmSellerClient.send(
                CustomersRequests.connectionDeleteByPin(
                    request = ConnectionDeleteByPinRequest(
                        pin1 = companyPin!!,
                        pin2 = userPin
                    )
                )
            )
        }

        "Проверить, что связь компании с контактным лицом удалена" {
            customerServiceArmSellerClient.send(
                CustomersRequests.getContacts(
                    customerId = companyId
                )
            ).apply {
                assertFalse(any { it!!.id == userId })
            }
        }
    }
    /** холдирование (end) */

    /** сопровождение / расширение / возможная сделка (start) */
    fun waitSupportInfoUpdating(
        token: String? = tokenAutoActionushka,
        clientId: String,
        key: String,
        value: String? = "СК"
    ) {
        untilTrue(120.s(), 2.s(), suppressException = true) {
            customerServiceArmSellerClient.send(
                CustomersRequests.customersSupportInfoGetByIds(
                    token = token,
                    ids = arrayOf(clientId)
                )
            ).get(clientId).deserialize<CustomersSupportInfoGetByIdsResponse>().run {
                val field = CustomersSupportInfoGetByIdsResponse::class.memberProperties.first { it.name == key }
                field.invoke(this) == value
            }
        }
    }
    /** сопровождение / расширение / возможная сделка (end) */
}