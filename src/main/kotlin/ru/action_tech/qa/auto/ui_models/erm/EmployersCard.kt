package ru.action_tech.qa.auto.ui_models.erm

import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.annotations.WithoutContext
import ru.action_tech.qa.auto.core.selenide.elements.css
import ru.action_tech.qa.auto.core.selenide.elements.getValue
import ru.action_tech.qa.auto.core.selenide.elements.xpath
import ru.action_tech.qa.auto.ui_models.common.dropdownWithTitleNew

val employerCard by EmployersCard()
val rightSideContainer by css("[class^=rightSideContainer_]")

class EmployersCard : Element by xpath("//*[@class='erm-employer-card']") {
    val employerAuth by xpath("//*[contains(text(), 'Войти под пользователем')]")
    val closeButton by xpath("//*[contains(@class, 'action-ui-kit-icon close')]")
    val phoneExtension by css("[data-test='phoneExtension']")
    val phoneExtensionGiveButton by css("[data-test=phoneExtensionGiveBtn]")

    @WithoutContext
    val makeFullView by xpath("//*[contains(@class,'icon-arrow-left')]")

    val personalData by PersonalData()
    val personalSetting by PersonalSetting()
}

class PersonalData : Element by xpath("//*[contains(@class,'columnLeft')]") {
    val dismissedBadge by css("[data-test='aui-badge']")
}

class PersonalSetting : Element by xpath("//*[contains(@class,'aui-pa-lg aui-flex')]") {
    val tab: Element by xpath("//*[contains(@class,'aui-tabs__tab aui-cursor-pointer')]")
    val filialBranch = dropdownWithTitleNew["//div[text()='Филиал']/..//div[2]"]
    val subdivision = dropdownWithTitleNew["//div[text()='Подразделение']/..//div[2]"]
    val position = dropdownWithTitleNew["//div[text()='Должность']/..//div[2]"]
    val direction = dropdownWithTitleNew["//div[text()='Направление']/..//div[2]"]
    val productType = dropdownWithTitleNew["//div[text()='Тип продукта']/..//div[2]"]
    val postCallBlock by xpath("//div[contains(text(),'Блокировка поствызова')]/..//*[@role='checkbox']")
    val userRole by UserRole()
    val selectManager by css("button[data-test='selectManagerBtn']")
    val selectManagerPopup by SelectManagerPopup()
    val dismissBtn by css("button[data-test='dismissBtn']")
    val dismisForm by DismissForm()

    fun dropdown(title: String) =
        xpath("//*[@class='aui-dropdown__label' and text()='$title']/../*[@data-test='aui-dropdown']")
}

class DismissForm : Element by css("[data-test='dismissForm']") {
    val dismissBtn by css("button[data-test='dismissBtn']")
    val confirmPopup by css("[data-test='dismissConfirm']")
    val continueButton by xpath("//*[@data-test='dismissConfirm']//*[text()='Продолжить']/parent::button")
    val cancelButton by xpath("//*[@data-test='dismissConfirm']//*[text()='Отмена']/parent::button")
}

class UserRole : Element by xpath("//*[contains(@class,'item')]") {
    val checkBoxTrue by xpath("//*[contains(@data-test,'aui-toggle')]/*[contains(@aria-checked,'true')]")
    val changeRole by xpath("//*[contains(@data-test,'aui-toggle')]")
}

class SelectManagerPopup : Element by css("[data-test='selectManagerPopup'] [data-test='aui-popup']") {
    val managersByUnit by ManagersByUnit()
}

class ManagersByUnit : Element by css("[data-test='managersByUnit']") {
    val firstGeneralPartnerForTest by css("[data-test='a-tree-list-form-item-root']")
    val firstPartnerTest by xpath("//*[text() = 'Тестовый Партнер Первый']")
}
