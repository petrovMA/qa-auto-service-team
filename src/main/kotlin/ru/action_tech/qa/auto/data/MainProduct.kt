package ru.action_tech.qa.auto.data

val ACTION_GLAVBUH by lazy {
    MainProduct(
        name = "ACTION: Главбух",
        id = "99bd69b0-3134-e911-bb9e-00155d627f03",
        number = 405,
        mainProductTypeId = MAIN_PRODUCT_TYPE_SS.typeId,
        mainProductTypeName = MAIN_PRODUCT_TYPE_SS.typeName,
        mainProductTypeNumber = MAIN_PRODUCT_TYPE_SS.typeNumber,
        region = "Санкт-Петербург"
    )
}
val TEST_PRODUCT by lazy {
    MainProduct(
        name = "Тестовый продукт",
        id = "8f262155-ddd1-e811-bb9b-00155d627f03"
    )
}
val PRODUCT_SUBSCRIPTION by lazy {
    MainProduct(
        name = "Тест Родитель",
        id = "AA553F7B-F35E-E211-8760-78E3B502DA44"
    )
}
val PRODUCT_BLOCK by lazy {
    MainProduct(
        name = "Тест дочь",
        id = "8a658fef-f35e-e211-8760-78e3b502da44"
    )
}
val JOURNAL_GLAVBUH by lazy {
    MainProduct(
        name = "Журнал \"Главбух\"",
        id = "8ac1c017-76e1-e311-9f4b-78e3b502da44",
        productNumber = 11,
        mainProductTypeId = MAIN_PRODUCT_TYPE_PERIODIC.typeId,
        mainProductTypeName = MAIN_PRODUCT_TYPE_PERIODIC.typeName,
        mainProductTypeNumber = MAIN_PRODUCT_TYPE_PERIODIC.typeNumber,
    )
}
val ACTION_360 by lazy {
    MainProduct(
        name = "Актион 360",
        id = "130dd49e-ecca-e811-bb9b-00155d627f03",
        productNumber = 360,
        mainProductTypeId = MAIN_PRODUCT_TYPE_A360.typeId,
        mainProductTypeName = MAIN_PRODUCT_TYPE_A360.typeName,
        mainProductTypeNumber = MAIN_PRODUCT_TYPE_A360.typeNumber,
    )
}
val SYSTEM_EDUCATION by lazy {
    MainProduct(
        name = "Система Образование",
        id = "ee7eba78-0cfd-409d-bfc2-a98556460c4b",
        productNumber = 1040,
        mainProductTypeId = MAIN_PRODUCT_TYPE_SS.typeId,
        mainProductTypeName = MAIN_PRODUCT_TYPE_SS.typeName,
        mainProductTypeNumber = MAIN_PRODUCT_TYPE_SS.typeNumber,
    )
}
val SYSTEM_EDUCATION_PLUS by lazy {
    MainProduct(
        name = "Система Образование Плюс",
        id = "94AE04C8-8DBF-EA11-BBA7-00155D627F03",
        productNumber = 772
    )
}
val ELECTRONIC_SYSTEM_EDUCATION_OPTIMAL by lazy {
    MainProduct(
        name = "Электронная система \"Образование\". Тариф Оптимальный",
        id = "D67E6399-C00D-4533-A872-25570A67838B",
        productNumber = 1120
    )
}
val ELECTRONIC_SYSTEM_EDUCATION_BASIC by lazy {
    MainProduct(
        name = "Электронная система \"Образование\". Тариф Базовый",
        id = "305495F2-D60C-4859-92EF-F23BB2B58949",
        productNumber = 1003
    )
}
val LICENSE_EDUCATION_BLOCK by lazy {
    MainProduct(
        name = "Лицензия \"Образование\". Блок \"Базовый Плюс\"",
        id = "C7FAF58B-752C-E611-86CF-78E3B502DA44",
        productNumber = 6690
    )
}
val ACTION_ADVERTISING by lazy {
    MainProduct(
        name = "Актион-Реклама",
        id = "00c51385-c6a1-e611-a879-78e3b502da44",
        productNumber = 3267,
        mainProductTypeId = MAIN_PRODUCT_TYPE_OTHER.typeId,
        mainProductTypeName = MAIN_PRODUCT_TYPE_OTHER.typeName,
        mainProductTypeNumber = MAIN_PRODUCT_TYPE_OTHER.typeNumber,
    )
}
val SYSTEM_GLAVBUKH by lazy {
    MainProduct(
        name = "Система Главбух",
        id = "9F8D71FB-B45D-E411-8727-95D2E1FE6A1C",
        mainProductType = MAIN_PRODUCT_TYPE_SS,
        mainProductTypeId = MAIN_PRODUCT_TYPE_SS.typeId
    )
}
val COUNTERPART_CHECK by lazy {
    MainProduct(
        name = "УНП: Проверка контрагентов",
        id = "1A219B22-A886-E811-A239-00155DFB5103",
        mainProductType = MAIN_PRODUCT_TYPE_SPK,
        mainProductTypeId = MAIN_PRODUCT_TYPE_SPK.typeId
    )
}
val ACTION_360_BLOCK by lazy {
    MainProduct(
        name = "Актион 360 Блочный",
        id = "6D0368A9-A2C4-EC11-BBBC-BCDA0251696C",
        mainProductType = MAIN_PRODUCT_TYPE_A360,
        mainProductTypeId = MAIN_PRODUCT_TYPE_A360.typeId
    )
}
val ACCOUNTING_GROUP_ACTIVITIES = MainProduct(
    name = "Мероприятия Группы Бухгалтерия",
    id = "cddf6b08-24ec-e911-bba4-00155d627f03",
    productNumber = null,
    mainProductType = null
)

data class MainProduct(
    val name: String,
    val id: String,
    val productNumber: Int? = null,
    val number: Int? = null,
    val mainProductTypeId: String? = null,
    val mainProductTypeName: String? = null,
    val mainProductTypeNumber: Int? = null,
    val mainProductType: MainProductType? = null,
    val region: String? = null
)