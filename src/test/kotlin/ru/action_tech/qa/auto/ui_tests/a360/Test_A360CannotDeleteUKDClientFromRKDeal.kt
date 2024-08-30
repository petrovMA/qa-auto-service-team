package ru.action_tech.qa.auto.ui_tests.a360

import com.codeborne.selenide.Condition
import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import ru.action_tech.qa.auto.core.annotations.HistoryIssues
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.click
import ru.action_tech.qa.auto.core.selenide.elements.get
import ru.action_tech.qa.auto.core.selenide.elements.hover
import ru.action_tech.qa.auto.core.selenide.elements.shouldBe
import ru.action_tech.qa.auto.data.ACTIONUSKA
import ru.action_tech.qa.auto.ui_models.erm.a360.a360Form
import ru.action_tech.qa.auto.ui_models.common.auth.openPageAndAuth
import ru.action_tech.qa.auto.ui_models.SaleUiERM
import ru.action_tech.qa.auto.ui_models.Sale_A360
import ru.action_tech.qa.auto.ui_models.erm.mainSideBar
import ru.action_tech.qa.auto.ui_models.erm.subSideBar
import ru.action_tech.qa.auto.ui_models.erm.tooltip


class Test_A360CannotDeleteUKDClientFromRKDeal {

    private val dealNum = "66802"

    @SaleUiERM
    @Sale_A360
    @ResourceLock("dealNum = 66802")
    @Issue("ARMAP-17105")
    @Requirements("REQCRM-881")
    @Test
    @DisplayName("Проверяем, что нельзя удалить клиента с УКД из РК сделки")
    @HistoryIssues("ARMAP-16732")
    @AllureId("146069")
    fun test() {
        openPageAndAuth(ACTIONUSKA)

        "Открываем подраздел А360 - Управление сделками" {
            mainSideBar.a360.click
            subSideBar.dealManagement.click
        }

        a360Form {
            "Переходим во вкладку Регулярные клиенты" { tab["Регулярные клиенты"].click }

            "Вводим номер сделки $dealNum" { dealSearch.value = dealNum }

            "Нажимаем кнопку Редактировать" { deal.editButton.click }

            dealEditor.company.deleteButton {
                "Проверяем, что кнопка удаления клиента не активна" { assertEqual(attr("disabled"), "true") }

                "Наводим на кнопку удаления" { hover }
            }
        }

        "Проверяем попап" {
            tooltip["Нельзя удалить организацию на которую зарегистрирован УКД"].shouldBe(Condition.visible)
        }
    }
}