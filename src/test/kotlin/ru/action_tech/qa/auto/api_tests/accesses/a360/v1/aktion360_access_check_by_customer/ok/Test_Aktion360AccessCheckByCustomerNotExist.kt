package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.aktion360_access_check_by_customer.ok

import io.qameta.allure.AllureId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessCheckByCustomerV1
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_check_by_customer.Aktion360AccessCheckByCustomersRequests
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.data.person
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Aktion360AccessCheckByCustomerNotExist {

    private val request by lazy {
        AccessesRequests.aktion360AccessCheckByCustomer(
            Aktion360AccessCheckByCustomersRequests(
                customerId = person.customerId,
                checkDateTime = "2023-02-17"
            )
        )
    }

    @Test
    @Requirements("REQCRM-1706")
    @Sale_Accesses
    @Aktion360AccessCheckByCustomerV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-access_check-by-customer -> 200 ok: isExist = false")
    @AllureId("160825")
    fun test() {
        assertThat(accessesCrmClient.send(request).apply {
            "Проверяем, что параметр isExist равен false" {
                assertFalse(this.isExist)
            }

            "Проверяем, что параметр serviceExpiresOn = null'" {
                assertEqual(this.serviceExpiresOn, null)
            }

            "Проверяем, что параметр licenseId = null'" {
                assertEqual(this.licenseId, null)
            }

            "Проверяем, что параметр productId = null'" {
                assertEqual(this.productId, null)
            }

            "Проверяем, что параметр customerId = null'" {
                assertEqual(this.customerId, null)
            }

            "Проверяем, что параметр serviceActivateOn = null'" {
                assertEqual(this.serviceActivateOn, null)
            }
        })
    }
}