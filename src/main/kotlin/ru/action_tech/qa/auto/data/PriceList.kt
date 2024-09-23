package ru.action_tech.qa.auto.data


val PRICE_LIST_SS by lazy {
    PriceList(
        id = "6af9af32-90e6-4b37-a030-9045edf17bce",
        name = "БСС \"Система Главбух\". Вип-версия. Без НДС. 1 пользователь. 12 мес._тест",
        number = "БССВБ12ТЕСТ",
        direction = Direction.fullName
    )
}

val PRICE_LIST_SS_2 by lazy {
    PriceList(
        id = "b0a96de9-944f-4398-bb31-fc97465f2676",
        name = "ЮСС \"Система Юрист\". Для коммерческих организаций. Простая неисключительная лицензия на использование Базы данных." +
                " 1 пользователь. 12 мес.",
        number = "",
        direction = Direction.fullName
    )
}

val PRICE_LIST_E by lazy {
    PriceList(
        id = "b6f4b90d-0834-4a2a-96f1-4970c88dd6b6",
        name = "Журнал \"Главбух\" 12 мес. _Октябрь 2019 г. Тест",
        number = "11ТЕСТ",
        direction = Direction.fullName
    )
}

val PRICE_LIST_US by lazy {
    PriceList(
        id = "5fe728e0-2313-4dd5-b0eb-2d296051c9d7",
        name = "УНП: Проверка контрагентов. Тариф Базовый. 1 пользователь. 12 мес. тест",
        number = "ПКУНП12ТЕСТ",
        direction = Direction.fullName
    )
}

val PRICE_LIST_A360_WITH_SUB by lazy {
    PriceList(
        id = "3b860ade-3105-4e28-88f3-f7f302b4ed10",
        name = "Актион 360 для коммерческих корпораций. Блочный. Бухгалтерия, Финансы, Кадры, Право, Госзакупки, Охрана труда, Промбезопасность, Экология. 12 мес._55650_1",
        number = "1012Д23ППР55650",
        direction = "2023-04_55650/С"
    )
}

val PRICE_LIST_A360 by lazy {
    PriceList(
        id = "66BE84A9-5CF5-ED11-BBBE-E4B749AE09C7",
        name = "Актион 360 охрана труда. 12 месяцев_18052023ТЕСТ",
        number = "А360ОТ18052023ТЕСТ",
        direction = Direction.fullName
    )
}

val PRICE_LIST_A360_2 by lazy {
    PriceList(
        id = "E8862CE5-3538-EE11-BBBE-E4B749AE09C7",
        name = "ТЕСТ_Актион 360 для коммерческих корпораций. Блочный. Бухгалтерия, Финансы, Кадры, Право, Госзакупки, Охрана труда. 12 мес.",
        number = "А360БФКПГОТ12Б012МТЕСТ",
        direction = Direction.fullName
    )
}

class PriceList(
    val id: String,
    val name: String,
    val number: String,
    val direction: String
)