package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_request_for_access_get_by_id.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360RequestForAccessGetByIdV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.util.stream.Stream


class Test_Action360RequestForAccessGetByIdIncludeInactive {

    private fun prepareTestData(): Stream<Arguments?>? {
        return Stream.of(
            Arguments.arguments("true", true),
            Arguments.arguments("TrUe  ", true),
            Arguments.arguments("T r U e", false),
            Arguments.arguments("false", false),
            Arguments.arguments(null, false),
            Arguments.arguments("2123322", false)
        )
    }

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("prepareTestData")
    @Requirements("REQCRM-240")
    @Sale_Accesses
    @Aktion360RequestForAccessGetByIdV1
    @Response_200_Ok
    @DisplayName("/api/v1/aktion360-request-for-access_get-by-id -> 200 Ok: параметр includeInactive")
    @AllureId("145327")
    fun test(includeInactive: String?, hasInactive: Boolean) {
        accessesCrmClient.send(
            AccessesRequests.action360RequestForAccessGetById(
                "12765FE2-34FF-4AF2-B45E-0001FF02CA17", includeInactive
            )
        ).run {
            if (hasInactive) {
                "Проверка что не активные доступы ПРИСУТСТВУЮТ в ответе" {
                    assertTrue(demoAccessEntity?.isNotEmpty() == true)
                }
            } else {
                "Проверка что не активные доступы ОТСУТСТВУЮТ в ответе" {
                    assertTrue(demoAccessEntity?.isEmpty() == true)
                }
            }
        }
    }
}