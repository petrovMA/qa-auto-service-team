package ru.action_tech.qa.auto.ui_models.common.auth

import com.codeborne.selenide.Condition.appear
import com.codeborne.selenide.Condition.disappear
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.uikit.button
import ru.action_tech.qa.auto.ui_models.common.loader

val ErmAuthPage by AuthPage()

//todo завести задача и добавить статичный локатор data-qa-locator=auth-form
class AuthPage : Element by css("._card_hsa75_1") {
    val loginButton by button["Войти через Актион хоум"]
}

fun authOnErmThroughPortal() {
    "Авторизоваться в ЕРМ" {
        ErmAuthPage.loginButton.should(appear, 300_000).click
        loader.shouldBe(disappear, 300_000)
    }
}