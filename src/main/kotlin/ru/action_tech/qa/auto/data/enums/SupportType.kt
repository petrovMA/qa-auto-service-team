package ru.action_tech.qa.auto.data.enums

@Suppress("UNUSED_PARAMETER")
enum class SupportType(val number: Int, name: String) {
    SUPPORT_TYPE_1(number = 1, name = "ВЗ Возможная сделка"),
    SUPPORT_TYPE_2(number = 2, name = "СЛ Стоп-лист по изданиям"),
    SUPPORT_TYPE_3(number = 3, name = "СС Сопровождение клиента по СС"),
    SUPPORT_TYPE_4(number = 4, name = "Е Сопровождения УКД по Е, ПГБ"),
    SUPPORT_TYPE_5(number = 5, name = "РС Расширение"),
    SUPPORT_TYPE_6(number = 6, name = "ПЕЧ Сопровождение УКД по печатке"),
    SUPPORT_TYPE_7(number = 7, name = "ЮС Сопровождение"),
    SUPPORT_TYPE_10(number = 10, name = "ВЗ (Возможна сделка) ГБА"),
    SUPPORT_TYPE_11(number = 11, name = "Сопровождение ГБА"),
    SUPPORT_TYPE_12(number = 12, name = "ВЗ Актион-360"),
    SUPPORT_TYPE_13(number = 13, name = "СА Сопровождение клиента Актион-360")
}