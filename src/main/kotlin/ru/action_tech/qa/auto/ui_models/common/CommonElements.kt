package ru.action_tech.qa.auto.ui_models.common

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.sleep
import org.openqa.selenium.By
import ru.action_tech.qa.auto.core.browser.window
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.selenide.elements.annotations.CanBeNotVisible
import ru.action_tech.qa.auto.core.selenide.elements.annotations.Timeout
import ru.action_tech.qa.auto.core.selenide.elements.annotations.WithoutContext
import ru.action_tech.qa.auto.data.Country
import ru.action_tech.qa.auto.utils.dataTest

val dropdown get() = Dropdown
val dropdownWithTitle get() = DropdownWithXpath
val dropdownWithTitleNew get() = DropdownWithXpathNew
val titleWithSort get() = TitleWithSort
val loader by xpath("//*[contains(@class,'action-spinner') or contains(@class,'loading') or contains(@class,'q-spinner-mat') or contains(@class,'aui-loader')]")

@Timeout(10000)
val alert by css(".q-alert-content")

open class Dropdown(name: String) :
    Element by xpath("//*[@role='alert' and text()='$name']/.. ") {

    companion object {
        operator fun get(name: String) = Dropdown(name)
    }

    @WithoutContext
    val list by xpath("//*[@class = 'menu visible active transition']//*[@class='item']")
    val newList by xpath("//*[@class='aui-dropdown__menu__item']")

    infix fun selectAndCheck(text: String) {
        select(text)
        sleep(300)
        if (!dropdown[text].isDisplayed) list[Condition.matchText(text)].click
    }

    infix fun selectAndCheckNew(text: String) {
        selectNew(text = text)
        sleep(300)
        if (!dropdown[text].isDisplayed) newList[Condition.matchText(text)].click
    }

    infix fun selectNew(text: String) {
        selectFromList(textToChoose = text, list = this.newList, openListButton = this)
    }

    infix fun select(text: String) {
        selectFromList(textToChoose = text, list = this.list, openListButton = this)
    }

    infix fun select(number: Int) {
        selectFromList(numberToChoose = number, list = this.list, openListButton = this)
    }
}

val inputWithTitle get() = InputWithTitle

class InputWithTitle(title: String) :
    Element by xpath("//div[contains(text(),'$title')]/..//input") {

    companion object {
        operator fun get(name: String) = InputWithTitle(name)
    }
}

val inputWithLabel get() = InputWithLabel

class InputWithLabel(label: String) :
    Element by xpath("//label[contains(text(),'$label')]/..//input") {

    companion object {
        operator fun get(name: String) = InputWithLabel(name)
    }
}

class PhoneWithCodeField :
    Element by xpath("//*[contains(text(), 'Телефон')]/..") {

    val input by xpath("//input")

    fun choosePhone(number: String, country: String = Country.RUS.countryName) {
        dropdownWithTitleNew["//*[@data-test='aui-phone-input']"] select country
        input.value = number
    }
}

open class DropdownWithXpath(xpath: String, inputXpath: String = "//input") :
    Element by xpath(xpath) {

    val field by xpath(".//*[@class='aui-dropdown__field__value'] | .//div[@role='alert']")
    val input by xpath(inputXpath)

    override fun getText(): String {
        return field.text
    }

    companion object {
        operator fun get(xpath: String) =
            DropdownWithXpath(xpath)
    }

    fun getListSize(): Int {
        if (!list.isDisplayed) click
        return list.all.size
    }


    @WithoutContext
    @CanBeNotVisible
    val list by xpath("//*[@class='menu visible active transition']/div")


    infix fun select(text: String) {
        selectFromList(textToChoose = text, list = this.list, openListButton = this)
    }

    infix fun select(number: Int) {
        selectFromList(numberToChoose = number, list = this.list, openListButton = this)
    }
}

open class DropdownWithXpathNew(val xpath: String, val inputXpath: String = "//*[@class='aui-dropdown__field']") :
    Element by xpath(xpath) {

    val input by xpath(inputXpath)
    val search by xpath("//input")
    val dropdownArrow by css("[data-icon-name='arrow-up']")

    companion object {
        operator fun get(xpath: String) =
            DropdownWithXpathNew(xpath)
    }


    @WithoutContext
    val commonList by CommonList()

    @WithoutContext
    @CanBeNotVisible
    val newList by xpath("//*[contains(@class,'aui-dropdown__menu aui-dropdown__menu_downward')]/div")

    @WithoutContext
    @CanBeNotVisible
    val newListWithCheckBox by xpath("//*[@class='aui-dropdown__menu__item' or @class='aui-dropdown__menu__item is-active']/div")

    @WithoutContext
    @CanBeNotVisible
    val listOfReasons by xpath("//*[contains(@class,'aui-popup-menu-item')]")

    @WithoutContext
    @CanBeNotVisible
    val oldList by css(".menu.visible.active.transition .item")

    infix fun selectInPhonecallCard(text: String) {
        selectFromList(textToChoose = text, list = this.commonList, openListButton = this)
    }

    infix fun selectDownloadReason(text: String) {
        selectFromList(textToChoose = text, list = this.listOfReasons, openListButton = this)
    }

    infix fun selectOld(text: String) {
        selectFromList(textToChoose = text, list = this.oldList, openListButton = this)
    }

    infix fun select(text: String) {
        selectFromList(textToChoose = text, list = this.commonList, openListButton = this)
    }

    infix fun select(int: Int) {
        selectFromList(numberToChoose = int, list = this.newListWithCheckBox, openListButton = this)
    }

    infix fun setAndSelect(text: String) {
        this.click
        search.value = text
        selectFromList(textToChoose = text, list = this.commonList, openListButton = this)
    }

    infix fun setAndSelectCheckBox(text: String) {
        this.click
        search.value = text
        this.commonList[text].checkBox.click
    }

    infix fun setAndSelectTableFilter(text: String) {
        click
        if (commonList.search.isEnabled.not()) {
            window.refresh
            window.alert.accept
            click
        }
        commonList {
            search.click
            checkBox {
                if (!attr("class").contains("is-active")) {
                    click
                }
                click
            }
            search.click.value = text
            checkBox[1].click
            confirmButton.click
        }
    }

    infix fun setAndSelectTableFilterWithText(text: String) {
        click
        if (commonList.search.isEnabled.not()) {
            window.refresh
            window.alert.accept
            click
        }
        commonList {
            search.click
            checkBox {
                if (!attr("class").contains("is-active")) {
                    click
                }
                click
            }
            search.click.value = text
            checkBoxName[text].click
            confirmButton.click
        }
    }
}

class CommonList :
    Element by xpath("//*[@data-test='aui-dropdown-item' or contains(@class, 'aui-popup-menu-item') or @data-test='aui-popper' or @data-test='a-menu-item']") {
    val checkBox by xpath("//*[@data-test='aui-checkbox' or @data-test='a-menu-checkbox']")
    val checkBoxName get() = CheckBoxWithTitle
    val search by xpath("//*[@data-test='aui-input']")
    val confirmButton by xpath("//button[normalize-space(.)='Применить']")
}

class TitleWithSort(name: String) : Element by xpath("//*[contains(text(), '$name')]//following-sibling::*//i") {
    companion object {
        operator fun get(name: String) = TitleWithSort(name)
    }
}


class CheckBoxWithTitle(title: String) : Element by xpath("//*[text()='$title']/../*[@data-test=\"aui-checkbox\"]") {

    companion object {
        operator fun get(name: String) =
            CheckBoxWithTitle(name)
    }
}

fun selectFromList(textToChoose: String, list: Element, openListButton: Element, useSearch: Boolean = false) {
    var i = 0
    sleep(1000)
    openListButton.click
    sleep(2000)
    while (!list.isDisplayed && i < 5) {
        i++
        openListButton.shouldBe(Condition.exist)
        openListButton.click
    }
    if (useSearch) {
        openListButton.xpath("//input").value = textToChoose
    }
    list.all.shouldHave(CollectionCondition.sizeGreaterThan(0))
    list[textToChoose].click
}

fun selectFromList(numberToChoose: Int, list: Element, openListButton: Element) {
    var i = 0
    openListButton.click
    while (!list.isDisplayed && i <= 5) {
        i++
        sleep(2000)
        openListButton.click
    }
    list.all.shouldHave(CollectionCondition.sizeGreaterThan(0))
    list[numberToChoose].click
}

/**
 * Выбор значения из выпадающего списка по подстроке.
 */
fun Element.select(substring: String) = select(substring) { withText(this) }

/**
 * Выбор значения из выпадающего списка по точному совпадению текста.
 */
fun Element.selectByExactText(exactText: String) = select(exactText) { byText(this) }

/**
 * Выбор значения из выпадающего списка по точному совпадению текста без учёта регистра.
 */
fun Element.selectByExactTextCaseInsensitive(exactText: String) = select(exactText) { byTextCaseInsensitive(this) }

/**
 * Выбор значения из выпадающего списка по тексту и функции преобразования текста в значение типа [By].
 */
fun Element.select(text: String, toSelector: String.() -> By) {
    "Ожидаем, пока выпадающий список станет активным" {
        shouldNotBe(disabledDropdown)
    }
    "Открываем список" {
        click
    }
    "Проверяем, что список открыт" {
        shouldBe(activeDropdown)
    }
    "Выбираем в списке '$text'" {
        find(text.toSelector()).click
    }
    "Проверяем, что список закрыт и выбрано: '$text'" {
        should(not(be(activeDropdown)), have(text(text)))
    }
}

/**
 * Выбор чекбокса из выпадающего списка по тексту и функции преобразования текста в значение типа [By] с последующей проверкой текста в поле выпадающего списка.
 */
fun Element.selectCheckboxAndCheckInputText(text: String) {
    selectCheckbox(text = text)
    "Проверяем, что выбрано: '$text'" {
        shouldHave(text(text))
    }
}

/**
 * Выбор чекбокса из выпадающего списка по тексту и функции преобразования текста в значение типа [By].
 */
fun Element.selectCheckbox(text: String) {
    openDropdownList()

    "Проверяем, что пункт списка '$text' не выбран" {
        find(byText(text)).shouldHave(cssClass("aui-checkbox-wrapper__label"), not(cssClass("is-active")))
    }

    selectCheckboxInOpenDropdown(text)
}

/**
 * Открытие выпадающего списка
 */
fun Element.openDropdownList() {
    "Ожидаем, пока выпадающий список станет активным" {
        shouldNotBe(disabledDropdown)
    }
    "Открываем список" {
        click
    }
    "Проверяем, что список открыт" {
        shouldBe(activeDropdown)
    }
}

/**
 * Выбор чекбокса в открытом выпадающем списке.
 */
fun Element.selectCheckboxInOpenDropdown(text: String) {
    "Выбираем в списке '$text'" {
        find(byText(text)).click
    }
    "Проверяем, что '$text' выбран" {
        find(byText(text)).shouldHave(cssClass("is-active"))
    }
    "Закрываем список" {
        css(".aui-dropdown__field__arrow").click
    }
    "Проверяем, что список закрыт" {
        shouldNotBe(activeDropdown)
    }
}

/**
 * Выбор значения из выпадающего списка по индексу, нумерация начинается с единицы.
 */
fun Element.select(index: Int) {
    "Ожидаем, пока выпадающий список станет активным" {
        shouldNotBe(disabledDropdown)
    }
    "Открываем список" {
        click
    }
    "Проверяем, что список открыт" {
        shouldBe(activeDropdown)
    }
    "Выбираем элемент с индексом $index" {
        css("[data-test=aui-dropdown-item]:nth-of-type($index)").click
    }
    "Проверяем, что список закрыт" {
        should(not(be(activeDropdown)))
    }
}

/**
 * Выбор страны из выпадающего списка рядом с полем ввода номера телефона в карточке создания физ. лица и в карточке выдачи ДД.
 */
fun Element.selectPhoneCountry(country: Country) {
    "Открываем список" {
        click
    }
    "Проверяем, что список открыт" {
        shouldBe(activeDropdown)
    }
    "Выбираем в списке страну ${country.countryName}" {
        phonePopUpMenu.find(withText(country.countryName)).click
    }
    "Проверяем, что список закрыт и выбрана страна ${country.countryName}" {
        shouldHave(not(cssClass("popup-menu-opened")), text(country.code))
    }
}

/**
 * Выбор значения из выпадающего списка с типом aui-popup-menu.
 */
fun Element.selectInPopUpMenu(exactText: String) {
    "Открываем список" {
        click
    }
    "Проверяем, что список открыт" {
        shouldBe(activeDropdown)
    }
    "Выбираем в списке значение '$exactText'" {
        phonePopUpMenu.find(byText(exactText)).click
    }
    "Проверяем, что список закрыт и выбрано значение '$exactText'" {
        shouldHave(not(cssClass("popup-menu-opened")), text(exactText))
    }
}

@WithoutContext
val phonePopUpMenu by dataTest("aui-popup-menu")

val activeDropdown get() = cssClass("aui-dropdown_active")

val disabledDropdown get() = cssClass("aui-dropdown_disabled")
