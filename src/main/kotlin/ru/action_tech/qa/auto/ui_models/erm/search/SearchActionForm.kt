package ru.action_tech.qa.auto.ui_models.erm.search

import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.annotations.WithoutContext
import ru.action_tech.qa.auto.core.selenide.elements.css
import ru.action_tech.qa.auto.core.selenide.elements.getValue
import ru.action_tech.qa.auto.core.selenide.elements.xpath

val searchForm by SearchActionForm()

class SearchActionForm :
    Element by xpath("//*[@class='erm-seller-worspace-search'] | //div[contains(@class, 'erm-view__content')]") {
    val filter by css("[class*='tabsMenuItem']")
    val searchMath: Element by css("[data-test=searchItem] .aui-back-yellow-05")
    val searchResultsTitle by css(".erm-extends-results__title")
    val noResultsMessage by css(".erm-extends-results div + div")
    val searchResult by SearchResult()
    val employeesTab by xpath("//text()[contains(., 'Сотрудники')]/..")
    val accountsTab by xpath("//text()[contains(., 'Юр. Лица')]/..")
    val contactsTab by xpath("//text()[contains(., 'Физ. Лица')]/..")
    val announcementTab by xpath("//text()[contains(., 'Анонсы')]/..")
    val tableFilter by xpath("//*[contains(@class,'__table-filters')]")

    @WithoutContext
    val close by xpath("//*[contains(@class,'erm-seller-worspace-search')]//*[contains(@class,'text-grey-5 cursor-pointer')]")
}

class SearchResult :
    Element by xpath("//*[@data-test='searchItem'] | //*[@data-test='extendedSearchItem'] | //*[contains(@class,'searchResult')]") {
    val searchResultTitle by css(".erm-extend-search-result-item__header__title")
    val searchResultDate by css(".erm-extend-search-result-item__header__date")
    val searchResultContentLabel by css(".erm-extend-search-result-item__content__item__label")
    val connectButton by xpath("//*[text()='Привязать']/..")
    val toWatchersButton by xpath("//button[contains(@class,'aui-button color-null size-small app-outline')]")
    val addButton by xpath("//*[contains(text(),'Добавить')]/..")
    val addToMyTasks by css("[data-test=a-button-loader-content]")
    val addStudent by xpath("//*[contains(text(),'Добавить участника')]")
}

