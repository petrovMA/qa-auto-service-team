package ru.action_tech.qa.auto.data

val MAIN_PRODUCT_TYPE_A360 by lazy {
    MainProductType(
        typeId = "b6ebd9ea-68e0-e911-bba4-00155d627f03",
        typeName = "Актион360",
        typeNumber = 7
    )
}
val MAIN_PRODUCT_TYPE_SS by lazy {
    MainProductType(
        typeId = "56402115-8563-43a0-bf52-8ca0518086dc",
        typeName = "Справочная система",
        typeNumber = 2
    )
}
val MAIN_PRODUCT_TYPE_SPK by lazy {
    MainProductType(
        typeId = "9202c93a-1682-4d34-b57d-426bca313d48",
        typeName = "Электронный сервис", //СПК
        typeNumber = 100000001
    )
}
val MAIN_PRODUCT_TYPE_PERIODIC by lazy {
    MainProductType(
        typeId = "2d606041-20a1-e611-a879-78e3b502da44",
        typeName = "Периодика",
        typeNumber = 1
    )
}
val MAIN_PRODUCT_TYPE_OTHER by lazy {
    MainProductType(
        typeId = "1ba11977-f596-498c-9fbf-fab81f48a6d5",
        typeName = "Другое",
        typeNumber = 4
    )
}

data class MainProductType(
    val typeId: String,
    val typeName: String,
    val typeNumber: Int
)