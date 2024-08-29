package ru.action_tech.qa.auto.ui_models.common.page_actions

import com.codeborne.selenide.Condition.disappear
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.ui_models.common.loader
import ru.action_tech.qa.auto.ui_models.erm.clientCard


fun chooseTab(tabName: String) {
    clientCard.title.scrollTo
    val tab = clientCard.tab[tabName]
    loader.shouldBe(disappear, 30000)
    when {
        tab.isDisplayed -> tab.click
        else -> {
            clientCard.openDropDownMore.click
            clientCard.dropDown.row[tabName].click
        }
    }
}

fun getAllTabsNamesOnClientCards(): List<String> = clientCard.tabForCheck.all.map { it.text }
