package ru.action_tech.qa.auto.ui_models.erm.client_card_tabs

import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.selenide.elements.annotations.CanBeNotVisible
import ru.action_tech.qa.auto.core.selenide.elements.annotations.WithoutContext
import ru.action_tech.qa.auto.ui_models.common.DropdownWithXpathNew
import ru.action_tech.qa.auto.ui_models.common.selectFromList

class PersonalInfo : Element by xpath("//*[@data-test='persanal-info-cc']") {
    val adminLink by xpath("//*[contains(@class,'aui-mr-lg')]")
    val pin by xpath("//div[@class='inline-wrapper upper-grey']//div")
    val bitrtixId by xpath("//div[contains(text(), 'bitrix id')]")
    val position by xpath("//*[text()='Должность']/..//*[@data-test='customerPosition']")

    @CanBeNotVisible(scroll = true, alignToTop = false)
    val email by xpath("//*[text()='Почта']/..//input")
    val positionDropdown by dropdown("Должность")
    val phoneDropdown by dropdown("Телефоны")

    @CanBeNotVisible
    val suspendMailingsAndCalls by SuspendMailingsAndCalls()

    class SuspendMailingsAndCalls : Element by xpath("//div[@class='aui-pt-md']") {
        val suspendTitle by xpath("//h4[text()='Отписка от рассылок и звонков']")
        val doNotEmailCheckbox by xpath("//div[@data-test='unsubscribe-do-not-email']//div[@role='checkbox']")
        val doNotMarketingCheckbox by xpath("//div[@data-test='unsubscribe-do-not-marketing']//div[@role='checkbox']")
        val doNotPhoneCheckbox by xpath("//div[@data-test='unsubscribe-do-not-phone']//div[@role='checkbox']")
    }

    @CanBeNotVisible(scroll = true, alignToTop = false)
    val connectedUsers by ConnectedUsers()

    @CanBeNotVisible(scroll = true, alignToTop = false)
    val connectedOrganizations by ConnectedOrganizations()

    @WithoutContext
    val fullName by xpath("//*[@data-test='full-name']")

    @WithoutContext
    val fullNameEdit by xpath("//*[@data-test='full-name-input']//input")
    val countryFlag by xpath("//*[text()='Телефоны']/..//*[contains(@class,'action-ui-kit-icon_')]")
    val currentPhone by xpath("//*[@class='aui-phoneselect']//*[@class='aui-dropdown__field__value']")
    val addButton by xpath("//*[text()='Телефон']/..//..//*[contains(@class,'cross-vertical')]")
    val confirmButton by xpath("//*[text()='Телефон']/..//..//*[text()='OK']")
    val callBtn by xpath("//*[@data-test='callBtn']")

    private fun dropdown(title: String) =
        DropdownWithXpathNew("//*[text()='$title']//following-sibling::div[@data-test='aui-dropdown']")

    fun getListSizeNew(): Int {
        phoneDropdown.click
        if (!phoneDropdown.commonList.isDisplayed) click
        return phoneDropdown.commonList.all.size
    }
}

class ConnectedUsers : Element by xpath("//*[@data-test='relatedContacts']") {
    val header by xpath("//thead/*[@data-test='aui-table-row']")

    @CanBeNotVisible(scroll = true)
    val row by Row()
    val showBlocked by xpath("//*[@data-test='aui-checkbox']")

    @CanBeNotVisible(scroll = true)
    val addUserButton by xpath("//button[text()='Добавить контактное'] | //button[text()='Добавить связанное контактное'] | //button[text()='Добавить связанное контактное лицо']")

    class Row : Element by xpath("//tbody/*[@data-test='aui-table-row']") {
        val lockIcon by xpath("//*[contains(@class,'icon-lock aui-icon_color_red')]")
        val callButton by xpath("//*[contains(@class,'icon-phone-up aui-icon_color_green')]")
        val phoneNumber by xpath("//*[@data-test='aui-table-cell'][4]")
        val contactName by xpath("//*[@data-test='aui-table-cell'][5]//a")
        val contactBlocked by xpath("//*[@data-test='aui-table-cell'][5]//p")
        val pin by xpath("//*[@data-test='aui-table-cell'][6]")
        val email by xpath("//*[@data-test='aui-table-cell'][7]")
        val position by xpath("//*[@data-test='aui-table-cell'][8]")
        val connectedWithOrganization by xpath("//*[@data-test='aui-table-cell'][9]")
        val bonuses by xpath("//*[@data-test='aui-table-cell'][10]")
        val unlock by xpath("//*[text()='Разблокировать']")

        //toDo: сделал так потому что нет контеста когда делал val actions get() = Dropdown, а val actions get() by Dropdown("Действия") не работает
        @CanBeNotVisible
        val actions by xpath("//*[@data-test='aui-button']")

        @WithoutContext
        @CanBeNotVisible
        val list by xpath("//*[@class='aui-popper']//*[contains(@class,'item')]")

        fun selectAction(action: String) {
            selectFromList(textToChoose = action, list = this.list, openListButton = actions)
        }

    }
}

class ConnectedOrganizations : Element by xpath("//*[@data-test='relatedOrganizations']") {
    val row by Row()
    val addUserButton by xpath("//button[text()='Добавить организацию']")
    val showBlocked by xpath("//*[@data-test='aui-checkbox']")

    class Row : Element by xpath("//tbody/*[@data-test='aui-table-row']") {
        val callButton by xpath("//*[contains(@class,'icon-phone-up aui-icon_color_green')]")
        val hangupButton by xpath("//*[contains(@class,'icon-phone-up aui-icon_color_red')]")
        val orgName by xpath("//*[@data-test='aui-table-cell'][5]//a")
        val contactBlocked by xpath("//*[@data-test='aui-table-cell'][5]//p")
        val actions by xpath("//*[@data-test='aui-button']")
        val unlock by xpath("//*[text()='Разблокировать']")

        @WithoutContext
        @CanBeNotVisible
        val list by xpath("//*[@data-test='aui-popper']//*[contains(@class,'item')]")
        fun selectAction(action: String) {
            selectFromList(textToChoose = action, list = this.list, openListButton = actions)
        }
    }
}