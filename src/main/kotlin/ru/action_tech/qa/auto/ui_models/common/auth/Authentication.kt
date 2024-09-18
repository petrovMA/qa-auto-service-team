package ru.action_tech.qa.auto.ui_models.common.auth

import com.codeborne.selenide.Condition.disappear
import com.codeborne.selenide.Condition.visible
import ru.action_tech.qa.auto.api_models.managers.v2.manager_get.ManagerGetV2Response
import ru.action_tech.qa.auto.core.browser.Window
import ru.action_tech.qa.auto.core.browser.window
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.uikit.button
import ru.action_tech.qa.auto.data.Managers
import ru.action_tech.qa.auto.ui_models.common.classMatching
import ru.action_tech.qa.auto.ui_models.erm.employerCard
import ru.action_tech.qa.auto.ui_models.erm.ermMainForm
import ru.action_tech.qa.auto.ui_models.erm.search.searchForm
import ru.action_tech.qa.auto.utils.HOME_PORTAL_URL
import ru.action_tech.qa.auto.utils.Manager
import ru.action_tech.qa.auto.utils.url_builder.ERM_FRONTEND_URL

fun openPageAndAuth(manager: Managers, url: String = ERM_FRONTEND_URL) {
    "Авторизоваться в ЕРМ под пользователем ${manager.login}" {
        window.url = url
        authOnHomePortal(manager)
        authOnErmThroughPortal()
    }
}

fun openPageAndAuth(manager: ManagerGetV2Response, url: String = ERM_FRONTEND_URL) {
    "Авторизоваться в ЕРМ под пользователем ${manager.email}" {
        window.url = url
        authOnHomePortal(manager)
        authOnErmThroughPortal()
    }
}

fun openPageAndAuth(heldManager: Manager, url: String = ERM_FRONTEND_URL) {
    "Авторизоваться в ЕРМ под пользователем ${heldManager.login}" {
        window.url = url
        authOnHomePortal(heldManager.login!!, heldManager.password!!)
        authOnErmThroughPortal()
    }
}

fun openPageAndAuth(currentWindow: Window = window, manager: Manager, url: String = ERM_FRONTEND_URL) {
    "Авторизоваться в ЕРМ" {
        currentWindow.url = url
        authOnHomePortal(manager.login.toString(), manager.password.toString())
        authOnErmThroughPortal()
    }
}

fun openPortalAndAuth(manager: Managers, url: String = HOME_PORTAL_URL) {
    window.url = url
    authOnHomePortal(manager)
}

fun clickReadyToWork() {
    button["Готов работать"].shouldBe(visible, 80000).click
}

fun authUnderUser(email: String) {

    "В строке поиска ввести $email" { ermMainForm.search.value = email }

    "Нажать 'Найти'" {
        ermMainForm.findButton.click
    }

    "Перейти во вкладку 'Сотрудники'" {
        searchForm.employeesTab.shouldNotHave(classMatching(".*disabled_.*")).click
    }

    "Открыть результат поиска" { searchForm.searchResult.click }

    "Нажать 'Войти под пользователем'" { employerCard.employerAuth.click }

    "Проверить, что вход под пользователем выполнен" { searchForm.searchResult.should(disappear) }
}
