package ru.action_tech.qa.auto.ui_models.admin360.authPage

import ru.action_tech.qa.auto.core.selenide.elements.xpath

class AuthPlatform {
    val login by xpath("//*[@id=\"USER_LOGIN\"]")
    val password by xpath("//*[@id=\"USER_PASSWORD\"]")
    val buttonLogin by xpath("//*[@id=\"button-login\"]")
}