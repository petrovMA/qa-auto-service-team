package ru.action_tech.qa.auto.api_tests.accesses.license.v1.license_get_child_data

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.LicenseGetChildData
import ru.action_tech.qa.auto.api_models.accesses.licenseGetChildData
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.utils.accessesCrmClient
import java.time.LocalDate

class Test_CustomerHaveValidUkds {
    private val minEndDate by lazy { LocalDate.now().minusMonths(6) }
    private val maxStartDate by lazy { LocalDate.now() }
    private val expectedUkdAssessment = "Зачет"
    private val expectedUkdLearningProgram = "«1С:Бухгалтерия 8»: как подготовить отчетность, 20 часов"

    @Test
    @Requirements("REQCRM-2006")
    @Sale_Accesses
    @LicenseGetChildData
    @Response_200_Ok
    @DisplayName("$licenseGetChildData -> 200 ok - у клиента есть УКД подходящие под выборку")
    @AllureId("254194")
    fun test() {
        accessesCrmClient.send(
            AccessesRequests.licenseGetChildData(
                customerId = "E090B1D2-AF42-48F5-B4A9-7EE44593D0BD"
            )
        ).apply {
            "Ответ не пустой".assertTrue(isNotEmpty())
            "В ответе есть лицензия с документами".assertTrue(any { it.uploadedDocuments?.isNotEmpty()!! })

            "Минимальная дата начала = $minEndDate".assertTrue(all {
                val stringDate = it.learningDates?.startDate?.substring(0, 10)
                LocalDate.parse(stringDate!!) >= minEndDate
            })

            "Максимальная дата конца = $maxStartDate".assertTrue(all {
                val stringDate = it.learningDates?.startDate?.substring(0, 10)
                LocalDate.parse(stringDate!!) <= maxStartDate
            })

            "В ответе есть УКД с learningAssessment = $expectedUkdAssessment"
                .assertTrue { any { it.learningAssessment == expectedUkdAssessment } }
            "В ответе есть УКД с learningProgram = $expectedUkdLearningProgram"
                .assertTrue { any { it.learningProgram == expectedUkdLearningProgram } }
        }
    }
}