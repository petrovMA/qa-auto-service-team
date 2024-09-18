package ru.action_tech.qa.auto.data

val PRODUCT_SS by lazy {
    Product(
        id = "8f262155-ddd1-e811-bb9b-00155d627f03",
        name = "БСС \"Система Главбух\". Вип-версия. Без НДС. 1 пользователь. 12 мес.",
        number = "БССВБ12",
        mainProduct = SYSTEM_GLAVBUKH,
        mainProductType = MAIN_PRODUCT_TYPE_SS
    )
}
val PRODUCT_SS_CHANGED by lazy {
    Product(
        id = "8f262155-ddd1-e811-bb9b-00155d627f03",
        name = "БСС \"Система Главбух\". Вип-версия. Простая неисключительная лицензия на использование Базы данных. 1 пользователь. 12 мес.",
        number = "БССВБ12",
        mainProduct = SYSTEM_GLAVBUKH,
        mainProductType = MAIN_PRODUCT_TYPE_SS
    )
}
val PRODUCT_E by lazy {
    Product(
        id = "5b304213-6967-4636-97a4-616579e50da1",
        name = "Журнал \"Главбух\".",
        number = "11",
        mainProduct = JOURNAL_GLAVBUH,
        mainProductType = MAIN_PRODUCT_TYPE_PERIODIC
    )
}
val PRODUCT_US by lazy {
    Product(
        id = "0793018f-a886-e811-a239-00155dfb5103",
        name = "УНП: Проверка контрагентов. Тариф Базовый. 1 пользователь. 12 мес.",
        number = "ПКУНП12",
        mainProduct = COUNTERPART_CHECK,
        mainProductType = MAIN_PRODUCT_TYPE_SPK
    )
}
val PRODUCT_A360_WITH_SUB by lazy {
    Product(
        id = "2253fa1c-426c-4c81-b7f7-b18f45a5e389",
        name = "Актион 360 для коммерческих корпораций. Блочный. Бухгалтерия, Финансы, Кадры, Право, Госзакупки, Охрана труда, Промбезопасность, Экология. 12 мес.",
        number = "А360КПРЭ12Б",
        mainProduct = ACTION_360_BLOCK,
        mainProductType = MAIN_PRODUCT_TYPE_A360
    )
}
val PRODUCT_A360 by lazy {
    Product(
        id = "1da71852-c600-4aae-9f65-b5271df6603a",
        name = "Актион 360 Охрана труда. 12 месяцев",
        number = "А360БОХ",
        mainProduct = ACTION_360_BLOCK,
        mainProductType = MAIN_PRODUCT_TYPE_A360
    )
}
val PRODUCT_A360_2 by lazy {
    Product(
        id = "d9d618ed-5197-4be2-8b34-63c8281cf894",
        name = "Актион 360 для коммерческих корпораций. Блочный. Бухгалтерия, Финансы, Кадры, Право, Госзакупки, Охрана труда. 12 мес.",
        number = "А360БФКПГОТ12Б",
        mainProduct = ACTION_360_BLOCK,
        mainProductType = MAIN_PRODUCT_TYPE_A360
    )
}

data class Product(
    val id: String,
    val name: String,
    val number: String?,
    val mainProduct: MainProduct,
    val mainProductType: MainProductType
)