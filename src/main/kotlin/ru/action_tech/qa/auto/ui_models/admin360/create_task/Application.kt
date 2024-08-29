package ru.action_tech.qa.auto.ui_models.admin360.create_task

import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.getValue
import ru.action_tech.qa.auto.core.selenide.elements.xpath
import ru.action_tech.qa.auto.ui_models.common.dropdownWithTitleNew

class Application : Element by xpath("(//*[contains(@class,'action-admin360-task')])[1]") {

    val companyNameText by xpath("//*[@data-test='aui-h3']")
    val approveButton by xpath("(//*[@data-test='aui-button-loader'])[1]")
    val denyButton by xpath("(//*[@data-test='aui-button-loader'])[2]")
    val innText by xpath("//*[contains(text(), 'ИНН')]/..//*[@class='action-admin360-accountinfo__info']")
    val kppText by xpath("//*[contains(text(), 'КПП')]/..//*[@class='action-admin360-accountinfo__info']")
    val addUserOpenFormButton by xpath("//button[@data-test='aui-button' and contains(text(), 'Добавить пользователя')]")
    val addFromFileButton by xpath("(//*[@data-test='aui-button'])[contains(text(), 'Добавить из файла')]")
    val removeAllButton by xpath("(//*[@data-test='aui-button'])[contains(text(), 'Удалить всех')]")
    val removeInvalidButton by xpath("(//*[@data-test='aui-button'])[contains(text(), 'Удалить только невалидных')]")
    val firstNameInput by xpath("(//*[@placeholder='Имя' and @data-test='aui-input'])")
    val lastNameInput by xpath("(//*[@placeholder='Фамилия' and @data-test='aui-input'])")
    val middleNameInput by xpath("(//*[@placeholder='Отчество' and @data-test='aui-input'])")
    val userTable by UserTableForAdd()

    val findByEmailButton by xpath("//*[contains(text(),'Эл. почта')]/..//button[@data-test='aui-button']")
    val emailToAddInput by xpath("//*[contains(text(),'Эл. почта')]/..//input[@data-test='aui-input']")
    val phoneInput by xpath("//*[@data-test='aui-phone-input-phone']//input")
    val phoneExtInput by xpath("//*[@data-test='aui-phone-input-ext']//input")
    val addUserButton by xpath("//button[@data-test='aui-button' and contains(@class,'color-blue') and contains(text(), 'Добавить пользователя')]")
    val closeTab by xpath("//div[@class='action-admin360-task__close-icon']/div/i[@data-test='aui-icon']")

    fun selectPosition(positionName: String) {
        dropdownWithTitleNew["//*[contains(text(),'Должность')]/..//div[@data-test='aui-dropdown']"] select positionName
    }

    fun selectPosition(positionNumber: Int) {
        dropdownWithTitleNew["//*[contains(text(),'Должность')]/..//div[@data-test='aui-dropdown']"] select positionNumber
    }
    class UserTableForAdd : Element by xpath("//*[@data-test='aui-table']") {
        val header by xpath("//thead/tr[@data-test='aui-table-row']")
        val userTableRow by UserTableRow()
    }

    class UserTableRow : Element by xpath("//tbody/tr[@data-test='aui-table-row']") {
        val nameCell by xpath("//td[@data-test='aui-table-cell'][1]")
        val emailCell by xpath("//td[@data-test='aui-table-cell'][2]")
        val positionCell by xpath("//td[@data-test='aui-table-cell'][3]")
        val phoneCell by xpath("//td[@data-test='aui-table-cell'][4]")
        val makeMasterToggle by xpath("//div[@data-test='aui-toggle']")
        val commentCell by xpath("//td[@data-test='aui-table-cell'][6]")
        val deleteButton by xpath("//td[@data-test='aui-table-cell']/..//i[contains(@class,'icon-delete')]")

        fun choosePhone(phoneNumber: String) = dropdownWithTitleNew["//*[@data-test='aui-phone-input']"] select phoneNumber
    }
}