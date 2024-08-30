package ru.action_tech.qa.auto.ui_models.common.auth

import com.codeborne.selenide.Condition.disappear
import ru.action_tech.qa.auto.api_models.managers.v2.manager_get.ManagerGetV2Response
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.data.Managers
import ru.action_tech.qa.auto.ui_models.common.loader

val homePortalAuthForm by HomePortalAuthForm()

class HomePortalHeader : Element by xpath("//body/header") {
    val userName by id("user-name")
}

class HomePortalAuthForm : Element by css("[class='form-center']") {
    val loginButton by css(".button-submit")
    val login by id("USER_LOGIN")
    val password by id("USER_PASSWORD")
    val submit by id("button-login")

    val rateIncidentPopup by id("sd-review-popup-id")
    val rateIncidentPopupClose by xpath("//span[@class='popup-window-close-icon']")
}

fun authOnHomePortal(manager: Managers) {
    authOnHomePortal(manager.login, manager.password)
}

fun authOnHomePortal(manager: ManagerGetV2Response) {
    authOnHomePortal(manager.email.toString(), "1qaz@WSX")
}

fun authOnHomePortal(login: String, password: String) {
    homePortalAuthForm {
        "Авторизоваться в 'Актион Хоум' под логином $login" {
            "Ввести логин $login" {
                this.login.value = login
            }
            "Ввести пароль $password" {
                this.password.value = password
            }
            "Нажать 'Войти'" {
                submit.click
                loader.shouldBe(disappear, 30_000)
            }

            if (rateIncidentPopup.isDisplayed) {
                rateIncidentPopupClose.click
            }
        }
    }
}