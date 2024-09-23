package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.customer.CustomersRequests.infoByBitrix
import ru.action_tech.qa.auto.core.commons.generator.entity.user.User
import ru.action_tech.qa.auto.core.commons.generator.getHeldUser
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.utils.waiting.Wait
import ru.action_tech.qa.auto.api_models.customer.customer.v1.info_bybitrix.InfoByBitrixRequest
import ru.action_tech.qa.auto.api_models.customer.customer.v1.info_bybitrix.InfoBybitrixResponse
import ru.action_tech.qa.auto.utils.customerServiceArmSellerClient


object HoldUserHelper {
    fun holdUser(): InfoBybitrixResponse {
        val customer = "Получить клиента (физ. лицо) из пула" {
            getHeldUser(entity = User())
        }.let {
            "Получить данные холдированного клиента из CRM" {
                Wait.until(
                    timeoutInMs = 30000,
                    suppressException = true,
                    test = { this.email!! == it.email }
                ) {
                    customerServiceArmSellerClient.send(
                        infoByBitrix(
                            InfoByBitrixRequest(
                                listOf(it.id)
                            )
                        )
                    ).first()
                }
            }
        }

        return customer
    }

    fun getHeldUserInfo(user: User = User()): InfoBybitrixResponse = getHeldUser(user).run {
        "Для пользователя с bitrixId=${user.id} ожидаем синхронизации в CRM email $email" {
            Wait.until(timeoutInMs = 30000, test = { size == 1 && email == first().email }) {
                customerServiceArmSellerClient.send(infoByBitrix(InfoByBitrixRequest(listOf(user.id))))
            }
        }

        "Для пользователя с bitrixId=${user.id} ожидаем синхронизации в CRM ФИО '$fio'" {
            Wait.until(timeoutInMs = 10000, test = { size == 1 && fio.toString() == first().name }) {
                customerServiceArmSellerClient.send(infoByBitrix(InfoByBitrixRequest(listOf(user.id))))
            }
        }
    }.first()
}
