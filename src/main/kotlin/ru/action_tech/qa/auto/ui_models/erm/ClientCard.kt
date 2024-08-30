package ru.action_tech.qa.auto.ui_models.erm

import com.codeborne.selenide.Condition.cssClass
import com.codeborne.selenide.Selectors.byText
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.selenide.elements.annotations.CanBeNotVisible
import ru.action_tech.qa.auto.core.selenide.elements.annotations.WithoutContext
import ru.action_tech.qa.auto.ui_models.common.DropdownWithXpathNew
import ru.action_tech.qa.auto.ui_models.common.activeDropdown
import ru.action_tech.qa.auto.ui_models.erm.client_card_tabs.ConnectedUsers
import ru.action_tech.qa.auto.ui_models.erm.client_card_tabs.OrderTab
import ru.action_tech.qa.auto.ui_models.erm.client_card_tabs.PersonalInfo

val clientCard by ClientCard()
val tabPanel by TabPanel()

class ClientCard : Element by xpath("//*[@data-test='client-card-full']") {
    @WithoutContext
    val makeFullView by xpath("//*[contains(@class,'icon-arrow-left')]")
    val warning by xpath("//*[contains(@class,'notificationLine')]")
    val notificationA360 by css("[data-test=a360-notification]")
    val corpClientCheckbox by xpath("//*[@data-test='aui-checkbox']")
    val customerNameCaption by css("[data-test=customerNameCaption]")

    @CanBeNotVisible(scroll = true)
    val title by xpath("//*[@data-test='full-name']")
    val expandName by xpath("//*[@data-test='customerNameToggleIcon']")
    val tab: Element by xpath("//*[contains(@class,'aui-tabs__tab aui-cursor-pointer')]")
    val tabForCheck: Element by xpath("//*[contains(@class,'aui-tabs__tab aui-cursor-pointer')] | //*[contains(@class,'menu__item__main_single')]")
    val openDropDownMore by css(".basicAppearance.aui-dropdown .icon-arrow-down")
    val refreshPage by xpath("//*[contains(text(),'ОБНОВИТЬ КАРТОЧКУ')]")
    val pinNumber by xpath("//*[contains(text(),'пин')]//following-sibling::span")
    val customerIcon by css("[data-test=customerIcon] .aui-icon")
    val partnerWordIcon by css(".aui-text-orange-06")

    @CanBeNotVisible(scroll = true)
    val editButton by xpath("//*[@data-test='customerNameEditIcon']")

    @WithoutContext
    val makeSmallView by xpath("//*[contains(@class,'icon-arrow-left')]")
    val dropDown by DropDownMoreTabs()
    val enterpriseTab by EnterpriseTab()
    val orderTab by OrderTab()
    val personalInfo by PersonalInfo()

    @CanBeNotVisible(scroll = true)
    val demoAccess by DemoAccess()
    //val ukd by Ukd()
    val subscription by Subscription()
    //val actions by Actions()

    @WithoutContext
    val listenSoundBlock by ListenSoundBlock()

    @CanBeNotVisible(scroll = true)
    val addressBlock by AddressBlock()
    val departures by Departures()
    val requisites by Requisites()
    val contacts by Contacts()
    val infoBlock by InfoBlock()

    val errorMassage by xpath("//*[contains(@class,'error-msg')]")
    val tabOther by css(".aui-tabs__tab_other")
    val tabOtherDropdown by css(".aui-tabs__tab_other [data-test=aui-dropdown]")

    fun selectOtherTab(tabName: String) {
        "Открываем список" {
            tabOtherDropdown.click
        }
        "Проверяем, что список открыт" {
            tabOtherDropdown.shouldBe(activeDropdown)
        }
        "Выбираем в списке '$tabName'" {
            tabOtherDropdown.find(byText(tabName)).click
        }
        "Проверяем, что список закрыт" {
            tabOtherDropdown.shouldNotBe(activeDropdown)
        }
        "Проверяем, что вкладка 'Ещё' активна" {
            tabOther.shouldHave(cssClass("aui-tabs__tab_active"))
        }
    }
}

val appContentTab get() = AppContentTab

class AppContentTab(number: Int) : Element by css("[data-test=appContentTabs] > div:nth-of-type($number)") {
    @CanBeNotVisible
    val closeButton by css("button")

    companion object {
        operator fun get(number: Int) = AppContentTab(number)
    }
}

fun customerCardTab(content: String) = css("[data-test=customerCardTabs] [content=$content]")

class InfoBlock : Element by xpath("//*[contains(@class,'erm-client-info-inline')]") {
    val pin by xpath("//*[contains(text(),'пин')]/..")
    val a360 by xpath("//*[contains(text(),'A360:')]//following-sibling::span[1]")
    val assistant by xpath("//*[contains(text(),'Ассистент:')]/..")
    val system by xpath("//span[contains(text(), 'системы:')]/../span[2]")
    val bonusLevel by css(".aui-badge-new[data-test=clientInfoItemValue]")
}

class EnterpriseTab : Element by xpath("//*[@data-test='about-company-cc']") {
    val adminLink by xpath("//*[contains(@class,'aui-mr-lg')]")
    val inn by xpath("//input[@placeholder='ИНН']")
    val kpp by xpath("//input[@placeholder='КПП']")

    @CanBeNotVisible
    val opf by xpath("//*[@data-test='legalFormsDisplay']/..//*[@class='aui-dropdown__field__value__text']")
    val taxes by xpath("//*[contains(text(),'Система налогообложения')]/..//input")
    val organizationSize by xpath("//*[contains(text(),'Размер организации')]/..//input")
    val sphere by xpath("//*[contains(text(),'Сфера деятельности')]/..//input")
    val edrpou: Element by xpath("//*[contains(text(),'ЕДРПОУ')]/following-sibling::*//input")
    val innUkr by xpath("//*[contains(text(),'ИНН Украина')]/following-sibling::*//input")
    val errorMessage by xpath("//*[@data-test='innErrorMessage']")

    @CanBeNotVisible(scroll = true)
    val connectedUsers by ConnectedUsers()

    @CanBeNotVisible(scroll = true)
    val stopListBlock by StopListBlock()
    val phoneManagement by PhoneManagement()
    val stir by xpath("//input[@placeholder='СТИР']")
    val clientTime by xpath("//*[contains(text(),'Время клиента')]/..")
    val currentPhone by xpath("//*[@class='aui-phoneselect']//*[@class='aui-dropdown__field__value']")
    val phoneDropdown by dropdown("Телефоны")
    val sphereDropdown by dropdown("Сфера деятельности")
    val taxSystemDropdown by dropdown("Система налогообложения")
    val organizationSizeDropdown by dropdown("Размер организации")
    val phoneCommentIcon by xpath("//*[contains(@class,'icon-message2')]")
    val editPhoneButton by xpath("//*[contains(@class,'aui-phoneinput')]")
    val addButton by xpath("//*[contains(text(), 'Телефон')]/..//..//*[contains(@class,'cross-vertical')]")
    val phoneCallButton by xpath("//*[contains(@class,'icon-phone-up')]")
    val confirmButton by xpath("//*[contains(text(), 'Телефон')]/..//..//*[contains(text(), 'OK')]")

    private fun dropdown(title: String) =
        DropdownWithXpathNew("//*[text()='$title']/..//following-sibling::div[@data-test='aui-dropdown']")

    fun getListSizeNew(): Int {
        phoneDropdown.click
        if (!phoneDropdown.commonList.isDisplayed) click
        return phoneDropdown.commonList.all.size
    }
}

class PhoneManagement : Element by xpath("//*[text()='Управление телефонами']/..") {
    val row by Row()

    class Row : Element by xpath("//*[contains(@class,'aui-items-start')]") {
        val menuButton by xpath("//*[contains(@class, 'menuButton')]")
        val phoneNumberInput by xpath("//*[contains(@class,'field__phone')]//input")
        val phoneNumberCountry by xpath("//*[@data-test='aui-phone-input-country']//div[contains(@class,'aui-dropdown__field__value')]")
        val extensionInput by xpath("//*[contains(@class,'extension')]//input")
        val commentInput by xpath("//*[contains(@class,'comment')]//input")
        val errorMessage by xpath("//*[contains(@class,'error-msg')]")


        fun countryDropdown(rowNum: Int) =
            DropdownWithXpathNew("//*[contains(@class,'aui-items-start')][${rowNum + 1}]//*[@data-test='aui-phone-input-country']")

    }
}

class StopListBlock : Element by xpath("//*[@data-test='customerStopList']") {
    val reserveButton by xpath("//*[@data-test='attach']")
    val reserveAgainButton by xpath("//*[@data-test='reattach']")

    @CanBeNotVisible
    val unreserveButton by xpath("//*[@data-test='detach']")
    val checkStatusButton by xpath("//*[@data-test='checkStatusBtn']")
}

class DemoAccess : Element by xpath("//*[@data-test='aui-table']") {
    @CanBeNotVisible
    val row by TabCheckRow()

    @CanBeNotVisible
    val headerLabel by xpath("//*[@data-test='headerCellLabel']")

    class TabCheckRow : Element by xpath("//*[@data-test='aui-table-row']") {
        @CanBeNotVisible
        val cell by tag("td")
    }
}

class ListenSoundBlock : Element by xpath("//*[@data-test = 'player']") {
    val playButton by xpath("//*[contains(@data-icon-name,'sound-play')]")
    val stopButton by xpath("//*[contains(@data-icon-name,'sound-pause')]")
    val volumeIcon by xpath("//*[contains(@data-icon-name,'volume-fill-on')]")
    val speedValue by css("[data-test=a-audio-player-value]")
    val speedUpButton by css("[data-test=a-audio-player-speed-up]")
    val speedDownButton by css("[data-test=a-audio-player-speed-down]")
    val timeTrackingLine by xpath("//*[contains(@class, 'erm-client-actions-tapping__tapping__operator')]")
    val volumeHandler by xpath("//*[contains(@class,'q-slider-handle-container')]")
}

class AddressBlock : Element by xpath("//*[@data-test='addressesContent']") {
    val adressRow by xpath("//input")
    val flat by xpath("//*[contains(@class,'flat-office-value')]//input")
    val flatInput by xpath("//*[contains(@class,'flat-office-input')]")
    val option by xpath("//*[@data-test='a-menu-label']")
    val comment by xpath("//*[contains(@placeholder,'Введите комментарий')]")
    val note by xpath("//div[text()='Примечание']/..//input[@data-test='mailInfo']")
    val row by AddressRow()
    val home by xpath("//*[contains(@placeholder,'Дом')]")
    val zipcode by xpath("//*[contains(@placeholder,'Индекс')]")
}

class AddressRow : Element by xpath("//*[@data-test='addressWrapper']") {
    val editButton by xpath("//*[@data-test='editBtn']")
    val addressType by className("label")
    val address by xpath("//*[@data-test='fullAddress']")
    val commentText by xpath("//*[@data-test='mailInfo']")

    @WithoutContext
    val editAddressBlock by EditAddress()
}

class EditAddress : Element by xpath("//*[contains(@class,'edit-progress')]") {
    @WithoutContext
    val buttonsBlock by EditAddressBottomButtonsBlock()
    val field get() = Field
    val flatOfficeField by xpath("//*[contains(@class,'flat-office-value')]//input")
    val checkboxContainsAddress by css("input[type=\"checkbox\"]")

    class Field(title: String) :
        Element by xpath("//*[contains(@class,'title') and contains(.,'$title')]//following-sibling::div//input") {
        companion object {
            operator fun get(name: String) = Field(name)
        }
    }
}

class EditAddressBottomButtonsBlock :
    Element by xpath("//*[@class='float-bottom-panel-wrapper' and not(contains(@style,'none'))]") {
    val button by xpath("//button")
}


class DropDownMoreTabs : Element by xpath("//*[contains(@class, 'menu_downward basicAppearance')]") {
    val row by xpath("//*[@class='aui-dropdown__menu__item']")
}

class Subscription : Element by xpath("//*[@data-test='subscriptions-cc']") {
    val header by xpath("//*[@data-test='aui-table-header']")
    val row by SubscriptionRow()
    val productFilter by filter("Продукт")

    private fun filter(title: String) = DropdownWithXpathNew(
        xpath = "//*[contains(text(),'$title')]/..//following-sibling::*[@data-test='aui-table-header-filter']//i"
    )
}

class SubscriptionRow : Element by xpath("//tbody/*[@data-test='aui-table-row']") {
    val cell by xpath("//td")
    val order by xpath("//td[5]//i")
    val ukd by xpath("//td[4]//i")
}

class Departures : Element by xpath("//*[@data-test='sendings-cc']") {
    val createButton by xpath("//button//span[contains(text(),'Создать досыл')]")
    val checkBox by xpath("//*[contains(text(),'Отправления за последние 12 месяцев')]")
    val searchField by xpath("//input[@placeholder='Поиск отправлений']")

    @CanBeNotVisible
    val tableColumnLabel by xpath("//thead//th[@data-test='aui-table-header']//div[@data-id='headerLabel']")

    @CanBeNotVisible
    val rowBody by DeparturesRow()

    class DeparturesRow : Element by xpath("//tbody//tr[@data-test='aui-table-row']") {
        @CanBeNotVisible
        val cell by xpath("//td[@data-test='aui-table-cell']")

        @CanBeNotVisible
        val menuButton by xpath("//td[@data-test='aui-table-cell']//div[@class='aui-flex justify-center aui-mr-xs aui-cursor-pointer full-width']")

        @WithoutContext
        @CanBeNotVisible
        val listOfActions by xpath("//div[@id='popupMenuContainer']//*")
    }
}

class Requisites : Element by xpath("//*[@id='erm-requisites']") {

    @CanBeNotVisible
    val newRequisites by xpath("//*[text()='Новые реквизиты']")

    @CanBeNotVisible
    val requisitesItem by xpath("//*[@data-test='navigationItem']")

    @CanBeNotVisible(scroll = true)
    val requisitesContent
        get() = RequisitesContent

    @CanBeNotVisible
    val requisitesInput
        get() = RequisitesInput

    @CanBeNotVisible
    val edit by xpath("//*[@data-test='editBtn']")
    val makeBasic by xpath("//*[@role='checkbox'] | //*[contains(@class,'checkbox-single-line')]")
    val flagBasic by xpath("//*[contains(text(),'Основные')]/parent::div")


    class RequisitesInput(name: String) :
        Element by xpath("//*[contains(text(),'$name')]/following-sibling::div//input") {
        companion object {
            operator fun get(name: String) = RequisitesInput(name)
        }
    }

    class RequisitesContent(title: String) :
        Element by xpath("//*[contains(text(),'$title')]/following-sibling::div") {
        companion object {
            operator fun get(name: String) = RequisitesContent(name)
        }
    }
}

class Contacts : Element by xpath("//*[@data-test='contacts-cc']") {

    @CanBeNotVisible
    val clientInfo by ClientInfo()

    @CanBeNotVisible
    val contactCompany by ContactCompany()

    @CanBeNotVisible
    val contactPerson by ContactPerson()

    @CanBeNotVisible
    val clientContacts by ClientContacts()

    @WithoutContext
    val contactTabs by xpath("//*[@data-test='tabName']")

    @CanBeNotVisible(scroll = true)
    val searchInput: Element by xpath("//input[@placeholder='Поиск по телефону, имени клиента, должности или названию организации']")

    class ContactPerson : Element by xpath("//*[@data-test='contact-item']") {
        @CanBeNotVisible
        val contactName by xpath("//*[@data-test='name']")

        @CanBeNotVisible
        val position by xpath("//*[@data-test='position']")
    }

    class ClientContacts : Element by xpath("//*[@data-test='client-info']") {
        @CanBeNotVisible
        val contactName by css(".client-card-contact-item__info__content__name a")

        @CanBeNotVisible
        val position by xpath("//*[contains(@class,'content__position')]")
    }

    class ContactCompany : Element by xpath("//*[@data-test='org-item']") {
        val avatar by css(".client-card-contact-item__info__avatar__company")
        val showMore by css(".client-card-contact-item__phones__show-more-btn")
        val companyName by xpath("//*[@data-test='name']")
        val connectDate by xpath("//*[@data-test='boundTime']")
        val phoneNumber get() = PhoneItem

        class PhoneItem(val number: String) :
            Element by xpath("//*[@data-test='phone']") {

            val greenPhone by xpath("//*[contains(@class,'icon-phone-up aui-icon_color_green')]")
            val redPhone by xpath("//*[contains(@class,'icon-phone-up aui-icon_color_red')]")

            companion object {
                operator fun get(number: String) = PhoneItem(number)
            }
        }

        val ss by css(".client-card-contact-item__phones__list__item")
    }

    class ClientInfo : Element by xpath("//*[@data-test='client-info']") {
        val avatar by css(".client-card-contact-item__info__avatar")
    }
}

class TabPanel : Element by xpath("//*[@data-test='appContentTabs']") {
    val tabs by xpath("//*[@data-test='tabName']")
    val closeTabButton by xpath("//*[@data-test='aui-button']")
    val closeIcon by css(".icon-cross")
}

