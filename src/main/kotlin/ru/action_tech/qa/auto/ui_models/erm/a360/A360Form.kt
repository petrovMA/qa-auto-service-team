package ru.action_tech.qa.auto.ui_models.erm.a360

import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.getValue
import ru.action_tech.qa.auto.core.selenide.elements.xpath
import ru.action_tech.qa.auto.ui_models.common.DropdownWithXpathNew

val a360Form by A360Form()

class A360Form : Element by xpath("//*[@class='flex-column dynamic-height erm-view__content']") {
    val branchDropdown by dropdown("Филиал")
    val managerDropdown by dropdown("Менеджер")
    val departmentDropdown by dropdown("Подразделение")
    val newButton by xpath("//*[contains(text(),'Новая сделка')]")
    val tab: Element by xpath("//*[contains(@class,'aui-tabs__tab aui-cursor-pointer')]")
    val dealSearch by xpath("//input[@placeholder='Поиск по стоп-листу']")
    val deal by Deal()
    val dealEditor by DealEditor()
    val search by xpath("//input[@placeholder='Поиск по стоп-листу']")
    val searchResult by SearchResult()
    val sortCreateDate by xpath("//*[contains(text(),'Дата создания')]")
    val sortEndDate by xpath("//*[contains(text(),'Дата окончания')]")

    class SearchResult : Element by xpath("//*[contains(@class,'searchResult')]") {
        val infoIcon by xpath("//*[contains(@class,'icon-info-20')]")
    }

    private fun dropdown(title: String) =
        DropdownWithXpathNew("//*[contains(text(),'$title')]//following-sibling::div/*[@data-test='aui-dropdown']")
}

class Deal : Element by xpath("//*[contains(@class,'wrapperTop')]/..") {
    val reConnectButton by xpath("//*[@data-test='reattachBtn']")
    val disconnectButton by xpath("//*[@data-test='detouchBtn']")
    val editButton by xpath("//*[@data-test='editBtn']")
    val viewCompany by xpath("//*[contains(text(),'Компании в сделке')]")
    val selectDeal by xpath("//*[@data-test='aui-checkbox']")
    val dealNumber by xpath("//*[@data-test='aui-h4']")
    val createDate by xpath("//*[@data-test='aui-h4'][2]")
    val endDate by xpath("//*[@data-test='aui-h4'][4]")
    val manager by xpath("//*[contains(@class, 'flex items-center')]/div[not(@data-test='aui-avatar')]")
    val tableRow by xpath("//tbody/*[@data-test='aui-table-row']")
    val tableHeader by xpath("//thead/*[@data-test='aui-table-row']")
    val status by xpath("//*[contains(@class, 'aui-text-small aui-text-caption')]")
    val comment by xpath("//*[contains(@class, 'comments_')]")
    val companyInDeal by xpath("//*[contains(@class,'rowTitle') and contains(.,'Компаний в сделке')]//following-sibling::*[2]")
    val mainProduct by xpath("//*[contains(@class,'rowTitle') and contains(.,'Головной продукт')]//following-sibling::*[2]")
    val recommendedPrice by xpath("//*[contains(@class,'rowTitle') and contains(.,'Рекомендуемая цена')]//following-sibling::*[2]")
    val actualPrice by xpath("//*[contains(@class,'rowTitle') and contains(.,'Актуальная цена')]//following-sibling::*[2]")
    val recommendedUsers by xpath("//*[contains(@class,'rowTitle') and contains(.,'Рекомендуемые пользов.')]//following-sibling::*[2]")
    val actualUsers by xpath("//*[contains(@class,'rowTitle') and contains(.,'Актуальные пользов.')]//following-sibling::*[2]")
}

class DealEditor : Element by xpath("//*[contains(@class,'dealEditor')]") {
    val continueButton by xpath("//*[contains(text(),'Дальше')]")
    val productDropdown by DropdownWithXpathNew["//*[@data-test='aui-dropdown']"]
    val createButton by xpath("//*[contains(text(),'Создать сделку')]")
    val price by xpath("//*[contains(@data-test,'aui-money-input')]")
    val usersCount by xpath("//*[contains(@data-test,'aui-input')]")
    val company by Company()

    class Company : Element by xpath("//*[contains(@class,'aui-my-md')]") {
        val deleteButton by xpath("//*[contains(@class,'icon-delete')]/..")
    }
}
