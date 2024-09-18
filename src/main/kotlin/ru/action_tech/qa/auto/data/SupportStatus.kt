package ru.action_tech.qa.auto.data

@Suppress("UNUSED_PARAMETER")
enum class SupportStatus(val number: Int, name: String) {
    SUPPORT_STATUS_13(number = 13, name = "ВЗ Выигрыш [Возможная сделка]"),
    SUPPORT_STATUS_11(number = 11, name = "ВЗ Выполняется [Возможная сделка]"),
    SUPPORT_STATUS_15(number = 15, name = "ВЗ Нарушитель Стоп-листа [Возможная сделка]"),
    SUPPORT_STATUS_12(number = 12, name = "ВЗ Отложенный [Возможная сделка]"),
    SUPPORT_STATUS_14(number = 14, name = "ВЗ Отменено [Возможная сделка]"),
    SUPPORT_STATUS_121(number = 121, name = "ВЗ А360 Выполняется"),
    SUPPORT_STATUS_123(number = 123, name = "ВЗ А360 Выигрыш"),
    SUPPORT_STATUS_124(number = 124, name = "ВЗ А360 Отменено"),
    SUPPORT_STATUS_125(number = 125, name = "ВЗ А360 На согласовании добавления"),
    SUPPORT_STATUS_126(number = 126, name = "ВЗ А360 На согласовании исключения"),
    SUPPORT_STATUS_127(number = 127, name = "ВЗ А360 Отклонено"),
    SUPPORT_STATUS_128(number = 128, name = "ВЗ А360 Исключена"),
    SUPPORT_STATUS_45(number = 45, name = "Е Не активно [Сопровождения УКД по Е, ПГБ]"),
    SUPPORT_STATUS_41(number = 41, name = "Е Новое [Сопровождения УКД по Е, ПГБ]"),
    SUPPORT_STATUS_42(number = 42, name = "Е Отменено [Сопровождения УКД по Е, ПГБ]"),
    SUPPORT_STATUS_44(number = 44, name = "Е Сопровождение [Сопровождения УКД по Е, ПГБ]"),
    SUPPORT_STATUS_62(number = 62, name = "ПЕЧ Отменено"),
    SUPPORT_STATUS_61(number = 61, name = "ПЕЧ Сопровождение"),
    SUPPORT_STATUS_51(number = 51, name = "РС Активный"),
    SUPPORT_STATUS_52(number = 52, name = "РС Отменено"),
    SUPPORT_STATUS_21(number = 21, name = "СЛ Активный [Стоп-лист по изданиям]"),
    SUPPORT_STATUS_22(number = 22, name = "СЛ Неактивные [Стоп-лист по изданиям]"),
    SUPPORT_STATUS_34(number = 34, name = "СС Не активно [Сопровождение клиента по СС]"),
    SUPPORT_STATUS_32(number = 32, name = "СС Неактивные [Сопровождение клиента по СС]"),
    SUPPORT_STATUS_31(number = 31, name = "СС Новое [Сопровождение клиента по СС]"),
    SUPPORT_STATUS_33(number = 33, name = "СС Сопровождение [Сопровождение клиента по СС]"),
    SUPPORT_STATUS_133(number = 133, name = "СА 360 Сопровождение"),
    SUPPORT_STATUS_134(number = 134, name = "СА 360 Отменено"),
    SUPPORT_STATUS_71(number = 71, name = "ЮС Сопровождение"),
    SUPPORT_STATUS_72(number = 72, name = "ЮС Отменено")
}

