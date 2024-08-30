package ru.action_tech.qa.auto.ui_tests.admin360

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.invocation.soft.soft
import ru.action_tech.qa.auto.core.selenide.elements.all
import ru.action_tech.qa.auto.core.selenide.elements.click
import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.ui_models.Admin360
import ru.action_tech.qa.auto.ui_models.DemoAccesses
import ru.action_tech.qa.auto.ui_models.admin360.A360Pages.authPage
import ru.action_tech.qa.auto.ui_models.admin360.A360Pages.taskPage
import ru.action_tech.qa.auto.utils.url_builder.ADMIN_360_URL


class Test_AccessSearchHelpAndBlockA360Filter {

    private val inn = "2312049140"
    private val kpp = "231201001"
    private val emailMaster = "autotest@api99735702.ru"
    private val productNumber = 0
    private val positionSearchText = "pr"

    @Test
    @Requirements("REQCRM-1086")
    @HistoryIssues("ARMAP-15235")
    @Admin360
    @DemoAccesses
    @DisplayName("Проверка поиска по сотрудникам")
    @AllureId("145294")
    fun test() {

        authPage.authByUser(AUTO_ACTIONUSKA, ADMIN_360_URL)

        taskPage.createTask {

            "Заполняем поле ИНН: $inn" { innInput.value = inn }

            "Заполняем поле КПП: $kpp" { kppInput.value = kpp }

            "Нажимаем кнопку 'Найти'" { searchByInnOrKppButton.click }

            "Выбираем продукт" { selectProduct(productNumber) }

            "Вводим Email для поиска" { emailToAddInput.value = emailMaster }

            "Нажимаем на кнопку 'Найти' по Email" { findByEmailButton.click }

            "В поле должность вводим для поиска '$positionSearchText'" {
                positionSelectDropdown.waitIsDisplayed
                positionSelectDropdown.click

                positionSearchInput.value = positionSearchText
            }

            "Проверяем, что элементы списка содержат значение = 'pr'" soft {
                positionSearchResultList.all.forEach {
                    assertTrue(it.text.contains(positionSearchText, true))
                }
            }
        }
    }
}
