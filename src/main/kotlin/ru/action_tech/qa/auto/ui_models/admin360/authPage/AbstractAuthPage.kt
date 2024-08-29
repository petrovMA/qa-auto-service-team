package ru.action_tech.qa.auto.ui_models.admin360.authPage

import ru.action_tech.qa.auto.core.browser.window
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.properties.ENV
import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.click
import ru.action_tech.qa.auto.data.Managers

interface AbstractAuthPage {
    val login: Element
    val loginByPortalButton: Element
    val password: Element
    val submit: Element

    fun authByUser(manager: Managers, authUrl: String? = null, clickLoginToActionHome: Boolean = true) {
        "Авторизуемся под логином: [$manager], Url: [$authUrl]" {
            authUrl?.let { window.url = it }
            AuthPlatform().apply {

                if (ENV.equals("prod", ignoreCase = true)) {
                    login.value = manager.login
                    password.value = manager.password
                    buttonLogin.click

                    loginByPortalButton.click
                } else {
                    loginByPortalButton.click

                    login.value = manager.login
                    password.value = manager.password
                    buttonLogin.click
                }
            }
        }
    }
}