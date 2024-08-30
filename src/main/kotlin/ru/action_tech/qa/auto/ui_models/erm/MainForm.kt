package ru.action_tech.qa.auto.ui_models.erm

import ru.action_tech.qa.auto.core.invocation.Dsl
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.click
import ru.action_tech.qa.auto.core.selenide.elements.css
import ru.action_tech.qa.auto.core.selenide.elements.get
import ru.action_tech.qa.auto.core.selenide.elements.xpath
import ru.action_tech.qa.auto.core.uikit.button
import ru.action_tech.qa.auto.ui_models.common.selectByExactText

val ermMainForm get() = ErmMainForm()

class ErmMainForm : Dsl {
    val search by xpath("//input[@placeholder='ИНН, ПИН, УКД, email, ФИО, организация']")
    val findButton by xpath("//div[contains(@class,'erm-search-input__search-sec__action')]/button/span[text()='Найти']")
    val closeSearch by xpath("//*[contains(@class,'items-center')]//i[contains(@class,'icon-cross')]")
    val searchUkraine by xpath("//input[@placeholder='ЕДРПОУ, ПИН, УКД, email, ФИО, организация']")
    val extensiveSearch by xpath("//*[contains(@class,'icon-settings')]")
    val closeExtensiveSearch by xpath("//*[contains(@class,'icon-cross-small')]")
    val lastClients by xpath("//*[contains(@class,'icon-users-b')]")
    val campaignType by css("#campaign-type-selector [data-test=aui-dropdown]")
    val campaignName by css("#campaign-name-selector [data-test=aui-dropdown]")
}

fun selectCampaign(type: String, name: String, buttonName: String = "Начать работу") {
    ermMainForm {
        "Нажимаем 'Выбрать кампанию'" {
            button["Выбрать кампанию"].click
        }
        selectCampaignWithoutStartButtonClick(type = type, name = name, buttonName = buttonName)
    }
}

fun selectCampaignWithoutStartButtonClick(type: String, name: String, buttonName: String = "Начать работу") {
    ermMainForm {
        "Выбираем тип кампании '$type'" {
            campaignType.selectByExactText(type)
        }
        "Выбираем название кампании '$name'" {
            campaignName.selectByExactText(name)
        }
        "Нажимаем '$buttonName'" {
            button[buttonName].click
        }
    }
}
