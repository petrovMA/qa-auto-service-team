package ru.action_tech.qa.auto.ui_models.common

import com.codeborne.selenide.Condition.enabled
import ru.action_tech.qa.auto.core.selenide.elements.*

class DropdownFilter(xpath: String) : Element by xpath(xpath) {
    val dropdown by css("[data-test=a-input-wrapper]")
    val item by css("[data-test=a-menu-item]")
    val valueInput by css("[data-test=a-input]")
    val input by xpath("//input")

    companion object {
        operator fun get(xpath: String) =
            DropdownFilter(xpath)
    }

    fun setAndSelect(text: String) {
        input.shouldBe(enabled)
        dropdown.click
        input.value = text
        item[text].click
        dropdown.click
    }

    fun select(text: String) {
        input.shouldBe(enabled)
        dropdown.click
        item[text].click
    }
}