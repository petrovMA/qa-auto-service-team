package ru.action_tech.qa.auto.ui_models.erm

import com.codeborne.selenide.Condition
import ru.action_tech.qa.auto.core.selenide.elements.*

val tooltip by Tooltip()

class Tooltip : Element by xpath("//*[contains(@class,'tooltip')]")

fun checkHoverTooltip(hoverOn: Element, expectedTooltipText: String) {
    hoverOn.hover
    tooltip[expectedTooltipText].should(Condition.visible)
}