package ru.action_tech.qa.auto.ui_models.common.auth

import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.css
import ru.action_tech.qa.auto.core.selenide.elements.getValue
import ru.action_tech.qa.auto.core.selenide.elements.xpath

val authStraightForm by AuthStraightErm()

class AuthStraightErm : Element by css("[class*='login-main']") {

    val login by xpath("//input[@placeholder='Почта']")
    val password by xpath("//input[@placeholder='Пароль']")
}

val mainForm by MainForm()

class MainForm : Element by css("[class*='erm-view__content']") {
    val userGreeting by xpath("//h1")
}

