package ru.action_tech.qa.auto.data

data class User(val id: String, val name: String)

val USER_ACTIONUSKA by lazy {
    User(
        id = "2df6b60a-0e5b-4380-85dd-d8879b6c195c",
        name = "Тестовый Актионушка ЕРМ"
    )
}

val USER_AUTO_ACTIONUSKA by lazy {
    User(
        id = "21f53d04-7468-4c60-afcb-2917383f9856",
        name = "Автотестовый Актионушка Бот"
    )
}

val USER_SYSTEM_S by lazy {
    User(
        id = "003a5957-f3cd-4671-8201-0f477d1d3a08",
        name = "SYSTEM S"
    )
}

val USER_LVOV_TEST by lazy {
    User(
        id = "ff1dcfa0-5b95-43ba-836e-233012f830ca",
        name = "Львов Мккси Тест"
    )
}
