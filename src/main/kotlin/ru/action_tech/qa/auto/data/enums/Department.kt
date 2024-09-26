package ru.action_tech.qa.auto.data.enums

enum class Department(val title: String, val id: String, val pin: String? = null) {
    WEB_PROJECT_DEVELOPMENT("Отдел развития веб проектов", "22310905-603f-454c-a0d4-91b15deffd94"),
    ORDER_EDIT("ЕРМ НЕ ТРОГАТЬ редактирование заказа", "88ec45a4-c6fb-44bd-a125-000bba5176b4"),
    TEST_CREATE_ORDER("Тестируем создание заказа(Не трогать)", "c678da93-2d1a-479b-961a-00382474e000", "5357619701")
}