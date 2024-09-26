package ru.action_tech.qa.auto.api_tests.accesses.license.v1.access_get_by_ids.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessGetLastSumByCustomer
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_NotPatnersAccess {

    @Test
    @Sale_Accesses
    @AccessGetLastSumByCustomer
    @Response_200_Ok
    @Requirements("REQCRM-1876")
    @DisplayName("/api/v1/access_get-by-ids -> 200 ok: Не партнерский доступ")
    @AllureId("220367")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.accessGetByIds(
                //пока используем захардкоженные данные, обсудим вопрос генерации либо выдачу лицензии тестовому пользователю
                accessIds = arrayOf(
                    "75570BE0-648A-42FF-BDEA-0156B255332C"
                )
            )
        ).first().apply {
            "Проверяем, что параметр supportPartnerId не null" soft {
                assertThat(this.supportPartnerId).isNotNull()
            }

            "Проверяем, что параметр salesPartnerId не null" soft {
                assertThat(this.salesPartnerId).isNotNull()
            }

            "Проверяем, что параметр partnerSubscribeId пустой" {
                assertThat(this.partnerSubscribeId).isNull()
            }
        }
    }
}