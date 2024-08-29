package ru.action_tech.qa.auto.ui_models.admin360.authPage

import ru.action_tech.qa.auto.core.selenide.elements.xpath

class AuthPage : AbstractAuthPage {
    override val login by xpath("(//*[@data-test='aui-input'])[1]")
    override val loginByPortalButton by xpath("(//*[@data-test='aui-button-loader'])[2]")
    override val password by xpath("(//*[@data-test='aui-input'])[2]")
    override val submit by xpath("//*[contains(text(),'Войти')][1]")
}