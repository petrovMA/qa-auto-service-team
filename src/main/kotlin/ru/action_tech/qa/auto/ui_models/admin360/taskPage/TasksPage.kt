package ru.action_tech.qa.auto.ui_models.admin360.taskPage


import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.selenide.elements.annotations.CanBeNotVisible
import ru.action_tech.qa.auto.ui_models.admin360.create_task.ApplicationsList
import ru.action_tech.qa.auto.ui_models.common.dropdownWithTitleNew


class TasksPage : Element by xpath("(//div[contains(@class,'action-admin360')])[1]") {

    val createTask by CreateTask()
    val applicationsList by ApplicationsList()
    val demoAccesses by DemoAccesses()
    val demoAccessDetails by DemoAccessDetails()

    val loaderButton by xpath("//div[@data-test='aui-loader-spinner']")
    val loaderLogo by xpath("//div[@data-test='aui-loader-logo']")
    fun chooseTab(tabName: String) = xpath("(//*[contains(text(), '$tabName')])").click

    class DemoAccesses : Element by xpath("(//*[contains(@class,'action-admin360-demos')])[1]") {
        val calendarDateInput by css(".action-admin360-demos__calendar")
        val searchInput by xpath("//input[contains(@placeholder, 'Поиск по')]")
        val searchButton by xpath("//*[@data-test='aui-button-loader']")
        val notFoundText by xpath("//div[contains(text(), 'Нет демо-доступов')]")
        val demoAccessesTable by DemoAccessesTable()
    }

    class DemoAccessesTable : Element by xpath("//div[@data-test='aui-table']") {
        val header by xpath("//thead/tr[@data-test='aui-table-row']")
        val demoAccessesTableRow by DemoAccessesTableRow()
    }

    class DemoAccessesTableRow : Element by xpath("//tbody/tr[@data-test='aui-table-row']") {
        val partnerCell by xpath("//td[@data-test='aui-table-cell'][1]")
        val clientCell by xpath("//td[@data-test='aui-table-cell'][2]")
        val versionCell by xpath("//td[@data-test='aui-table-cell'][3]")
        val dateCell by xpath("//td[@data-test='aui-table-cell'][4]")
        val statisticCell by xpath("//td[@data-test='aui-table-cell'][5]")
        val pinCell by xpath("//td[@data-test='aui-table-cell'][6]")
        val innCell by xpath("//td[@data-test='aui-table-cell'][7]")

        fun choosePhone(phoneNumber: String) {
            dropdownWithTitleNew["//*[@data-test='aui-phone-input']"] select phoneNumber
        }
    }

    class CreateTask : Element by xpath("(//*[contains(@class,'action-admin360-createtask')])[1]") {

        val innInput by xpath("//*[contains(text(), 'ИНН')]/..//input")
        val kppInput by xpath("//*[contains(text(), 'КПП')]/..//input")
        val searchByInnOrKppButton by xpath("(//*[contains(text(), 'Найти')])[1]")
        val nameTextArea by xpath("//*[contains(text(), 'Название')]/..//*[@data-test='aui-text-area']")

        @CanBeNotVisible
        val uploadFile by css("input[type=file]")

        val emailToAddInput by xpath("//div[contains(text(),'Эл. почта')]/..//input[@data-test='aui-input']")
        val findByEmailButton by xpath("(//*[text()='Найти'])[2]")
        val deleteAllButton by xpath("//*[contains(text(), 'Удалить всех')]")
        val deleteInvalidOnlyButton by xpath("//*[contains(text(), 'Удалить только невалидных')]")
        val userTable by UserTableForAdd()
        val addUserButton by xpath("(//*[contains(text(), 'Добавить пользователя')])")
        val createApplicationButton by xpath("(//*[contains(text(), 'Оформить заявку')])")
        val errorMessageText by xpath("//div/div/div/b[contains(text(),'Заявка на демодоступ недоступна')]")
        val subscribedA360Text by xpath("//div/b[contains(text(),'Пользователь подписан на Актион 360')]")
        val subscribedA360DateText by xpath("//div/b[contains(text(),'Пользователь подписан на Актион 360')]/../div")
        val connectedBlocksText by xpath("//span[contains(text(),'Подключенные блоки:')]/../ul/li")
        val subscribedA360ExpireText by xpath("//div/b[contains(text(),'Новый демодоступ закончится раньше либо одновременно с')]")
        val firstNameInput by xpath("(//*[@placeholder='Имя' and @data-test='aui-input'])")
        val lastNameInput by xpath("(//*[@placeholder='Фамилия' and @data-test='aui-input'])")
        val middleNameInput by xpath("(//*[@placeholder='Отчество' and @data-test='aui-input'])")

        val applicationCreatedText by xpath("//*[contains(text(), 'Заявка создана')]")
        val newApplicationButton by xpath("//*[@data-test='aui-button']")
        val phoneInput by xpath("//div[@data-test='aui-phone-input-phone']//input")
        val phoneExtInput by xpath("//div[@data-test='aui-phone-input-ext']//input")
        val positionSelectDropdown by xpath("//*[contains(text(), ' Должность ')]/..")
        val positionSearchInput by xpath("//div[contains(text(), 'Должность ')]/..//input")
        val positionSearchResultList by xpath("//*[@class='aui-dropdown__menu__item']")
        val checkboxBlockProduct by xpath("//div[contains(@class, 'aui-checkbox-wrapper__label')]")

        fun getBlockActionProductCheckBox(text: String) =
            xpath("//div[contains(text(), '$text')]/../div[@data-test='aui-checkbox']")

        fun selectProduct(productNumber: Int) =
            dropdownWithTitleNew["//*[contains(text(), ' Продукт ')]/..//*[@data-test='aui-dropdown']"] select productNumber

        fun selectProduct(productName: String) =
            dropdownWithTitleNew["//*[contains(text(), ' Продукт ')]/..//*[@data-test='aui-dropdown']"] select productName

        fun selectSubscriptionProduct(productName: String) =
            dropdownWithTitleNew["(//*[contains(text(), ' Продукт ')]/../../..//*[@data-test='aui-dropdown'])[2]"] select productName

        fun selectSubscriptionProduct(subProductNumber: Int) =
            dropdownWithTitleNew["(//*[contains(text(), ' Продукт ')]/../../..//*[@data-test='aui-dropdown'])[2]"] select subProductNumber

        fun selectPosition(positionName: String) =
            dropdownWithTitleNew["//div[contains(text(), ' Должность ')]/../div[@data-test='aui-dropdown']"] select positionName

        fun fillName(
            name: String = "autotest Name",
            surName: String = "autotest surName",
            middleName: String = "autotest middleName"
        ) {
            xpath("(//div[contains(text(), 'Клиент')]/..//input[@data-test='aui-input'])[1]").run {
                if (text.isBlank()) {
                    value = name
                }
            }
            xpath("(//div[contains(text(), 'Клиент')]/..//input[@data-test='aui-input'])[2]").run {
                if (text.isBlank()) {
                    value = surName
                }
            }
            xpath("(//div[contains(text(), 'Клиент')]/..//input[@data-test='aui-input'])[3]").run {
                if (text.isBlank()) {
                    value = middleName
                }
            }
        }
    }

    class DemoAccessDetails : Element by xpath("//div[@class='action-admin360-demo__mainpanel']") {

        val usersInDemoAccess by UsersAdded()

        val usersForAddInAccesses by UserTableForAdd()

        val emailToAddInput by xpath("//div[contains(text(),'Эл. почта')]/..//input[@data-test='aui-input']")
        val phoneInput by xpath("//div[@data-test='aui-phone-input-phone']//input")
        val phoneExtInput by xpath("//div[@data-test='aui-phone-input-ext']//input")

        @CanBeNotVisible
        val uploadFile by css("input[type=file]")

        // Основная информация
        val clientPinText by xpath("//div[contains(text(), 'ПИН КЛИЕНТА')]/../div[@class='baseinfo-section__data']")
        val ukdText by xpath("//div[contains(text(), 'УКД ПОДПИСКИ')]/../div[@class='baseinfo-section__data']")
        val ukdBlocksText by xpath("//div[contains(text(), 'УКД БЛОКОВ')]/..//div[@class='action-admin360-baseinfo__block__code']")
        val partnerText by xpath("//div[contains(text(), 'ПАРТНЁР')]/../div[@class='baseinfo-section__data']")
        val managerText by xpath("//div[contains(text(), 'МЕНЕДЖЕР')]/../div[@class='baseinfo-section__data']")
        val versionA360Text by xpath("//div[contains(text(), 'ВЕРСИЯ А360')]/../div[@class='baseinfo-section__data']")
        val ukdBlockInfo by UkdBlockInfo()

        // Мастер-пользователь
        val mainUserText by xpath("//div[contains(text(), 'МАСТЕР-ПОЛЬЗОВАТЕЛЬ')]/../div[@class='action-admin360-mainuser__data']")
        val pinText by xpath("//div[contains(text(), 'ПИН')]/../div[@class='action-admin360-mainuser__data']")
        val bitrixIdText by xpath("//div[contains(text(), 'BITRIX ID')]/../div[@class='action-admin360-mainuser__data']")
        val positionText by xpath("//div[contains(text(), 'ДОЛЖНОСТЬ')]/../div[@class='action-admin360-mainuser__data']")
        val emailText by xpath("//div[contains(text(), 'ПОЧТА')]/../div[@class='action-admin360-mainuser__data']")

        // Статистика по пользователям
        val usersAmountText by xpath("//div[contains(text(), 'КОЛИЧЕСТВО ПОЛЬЗОВАТЕЛЕЙ')]/../div[@class='action-admin360-usersstat__data']")
        val usersAmountInProductText by xpath("//div[contains(text(), 'КОЛИЧЕСТВО ПОЛЬЗОВАТЕЛЕЙ, ЗАШЕДШИХ В ПРОДУКТ')]/../div[@class='action-admin360-usersstat__data']")
        val usersPercentInProductText by xpath("//div[contains(text(), 'ПРОЦЕНТ ПОЛЬЗОВАТЕЛЕЙ, ЗАШЕДШИХ В ПРОДУКТ')]/../div[@class='action-admin360-usersstat__data']")

        // Срок действия ДД
        val startDateText by xpath("//div[contains(text(), 'ДАТА ВЫДАЧИ')]/../div[@class='action-admin360-demodates__data']")
        val endDateText by xpath("//div[contains(text(), 'ДАТА ОКОНЧАНИЯ')]/../div[@class='action-admin360-demodates__data']")

        fun chooseTab(tabName: String) = xpath("//div[contains(text(), '$tabName')]").click

        fun selectPosition(positionName: String) {
            dropdownWithTitleNew["//div[contains(text(), ' Должность ')]/../div[@data-test='aui-dropdown']"] select positionName
        }

        class UsersAdded :
            Element by xpath("//h4[contains(text(), 'Пользователи демо-доступа')]/../div[@data-test='aui-table']") {
            val header by xpath("//thead/tr[@data-test='aui-table-row']")
            val userTableRow by UserTableRow()
        }

        class UkdBlockInfo :
            Element by xpath("//div[@class='baseinfo-section__infoblock']/div[contains(text(), 'УКД БЛОКОВ')]/../div[@class='baseinfo-section__data']") {
            val ukdInfo by xpath("//div[@class='action-admin360-baseinfo__block']")
        }

        class UserTableRow : Element by xpath("//tbody/tr[@data-test='aui-table-row']") {
            val userNameCell by xpath("//td[@data-test='aui-table-cell'][1]")
            val pinCell by xpath("//td[@data-test='aui-table-cell'][2]")
            val bitrixIdCell by xpath("//td[@data-test='aui-table-cell'][3]")
            val partnerCell by xpath("//td[@data-test='aui-table-cell'][4]")
            val applicationDateCell by xpath("//td[@data-test='aui-table-cell'][5]")
            val emailCell by xpath("//td[@data-test='aui-table-cell'][6]")
        }
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