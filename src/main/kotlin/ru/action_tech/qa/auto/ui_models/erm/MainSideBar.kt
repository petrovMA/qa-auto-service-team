package ru.action_tech.qa.auto.ui_models.erm

import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.selenide.elements.annotations.WithoutContext

//todo рефакторинг ARMSEL-13908

val mainSideBar by MainSideBar()
val subSideBar by SubSideBar()

class MainSideBar : Element by xpath("//*[contains(@data-test,'aui-main-menu')]") {
    @WithoutContext
    val avatar by xpath("//*[contains(@class,'aui-avatar')]")
    val userId by xpath("//*[contains(@class,'user-id')]")
    val backToMain by xpath("//*[contains(@class,'icon-home')]")
    val calls by xpath("//*[contains(@class,'icon-rollback')]")
    val exitButton by xpath("//*[contains(@class,'icon-log-out')]")
    val itm by xpath("//*[contains(@class,'icon-telephone-out')]")
    val vtm by xpath("//*[contains(@class,'icon-telephone-in')]")
    val tasksAndLeads by xpath("//*[contains(@class,'icon-tasks')]/ancestor::*[contains(@class,'aui-main-menu__item_top-level')]")
    val mySent by xpath("//*[contains(@class,'icon-dispatch')]")
    val a360 by xpath("//*[contains(@class,'icon-a360')]")
    val management by xpath("//*[contains(@class,'icon-managment')]")
    val monitoring by xpath("//*[contains(@class,'icon-monitoring')]")
    val staffDevelopment by xpath("//*[contains(@class,'icon-notes')]")
    val staff by xpath("//*[contains(@class,'icon-users-20')]")

    val email by xpath("//*[contains(@class,'icon-mail-24')]")
    val sendError by xpath("//i[contains(@class,'icon-warning-24')]")
    val serviceDesk by xpath("//a[@data-test='/erm/ServiceDesk']")
    val schools by xpath("//a[@data-test='/erm/Schools']")
}

class SubSideBar : Element by xpath("//*[contains(@class,'show-child-items')]//*[@class='aui-main-menu__child-menu']") {
    @WithoutContext
    val actionQueue by xpath("//*[contains(text(),'Очередь действий')]")
    val myTasks by xpath("//*[contains(text(),'Мои дела')]")
    val personalSales by xpath("//*[contains(text(),'Личные продажи')]")
    val meetings by xpath("//*[contains(text(),'Встречи')]")
    val orders by xpath("//*[contains(text(),'Заказы')]")
    val freeClients by xpath("//*[contains(text(),'Свободные клиенты')]")
    val seminars by xpath("//*[contains(text(),'Семинары')]")
    val commercialOffers by xpath("//*[contains(text(),'Коммерческие предложения')]")
    val mailSent by xpath("//*[contains(text(),'Отправленная почта')]")
    val delayedPrint by xpath("//*[contains(text(),'Отложенная печать')]")
    val demoAccess by xpath("//*[contains(text(),'Демодоступы')]")
    val dealManagement by xpath("//*[contains(text(),'Управление сделками')]")
    val myStopList by xpath("//*[contains(text(),'Мой стоп-лист')]")
    val multicompanies by xpath("//*[contains(text(),'Мультикампании')]")
    val stopListManagement by xpath("//*[contains(text(),'Управление стоп-листом')]")
    val uploadingClients by xpath("//*[text()='Загрузка своих клиентов']")
    val changeManager by xpath("//*[contains(text(),'Смена ответственных на звонках')]")
    val maintainedClients by xpath("//*[contains(text(),'Сопровождаемые клиенты')]")
    val managerMonitor by xpath("//*[contains(text(),'Монитор руководителя')]")
    val tvMonitor by xpath("//*[contains(text(),'Телевизионный монитор')]")
    val laborDiscipline by xpath("//*[contains(text(),'Трудовая дисциплина)]")
    val listeningRecording by xpath("//*[contains(text(),'Прослушивание записи разговоров')]")
    val indepthWork by xpath("//*[contains(text(),'Углубленная работа')]")
    val wiretappingMonitor by xpath("//*[contains(text(),'Прослушка')]")
    val userName by xpath("//*[contains(@class,'user-name')]")
    val userMail by xpath("//*[contains(@class,'user-mail')]")
    val userMailInput by xpath("//input[@placeholder='Укажите email']")
    val helper by xpath("//*[contains(@data-test,'/erm/Helper')]")
    val changeUserButton by css("[data-test=relogin] button")
}

fun openMyTask() {
    mainSideBar.tasksAndLeads.click
    subSideBar.myTasks.click
}

fun openOrders() {
    mainSideBar.tasksAndLeads.click
    subSideBar.orders.click
}

fun openPersonalSales() {
    mainSideBar.tasksAndLeads.click
    subSideBar.personalSales.click
}
