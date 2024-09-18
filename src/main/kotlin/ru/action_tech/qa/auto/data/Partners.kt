package ru.action_tech.qa.auto.data

val TEST_DEALER by lazy {
    Partner(
        name = "Тестовый дилер для внутренних каналов",
        id = "b89ff32c-5f0b-df11-809e-001cc45e3d96",
        fullName = "ИП \"Тестовый дилер\"",
        webSite = "ИП «Тестовый дилер»",
        phone = "8 (800) 333 00 65",
        type = 1,
        nameV1 = "45906",
        organizationId = "f09330a9-aee2-4e58-bf1e-02136f63c77d"
    )
}

val TEST_DEALER_12345 by lazy {
    Partner(
        name = "Тестовый дилер для партнеров 12345",
        id = "15d82e96-9c3d-e511-bf0a-78e3b502da44",
        fullName = "Партнер_Первый_Тестовый_АП",
        webSite = "Тестовый партнер",
        phone = "8 (926) 903-21-16",
        nameV1 = "986725",
        organizationId = "ced01ba1-9ea5-4600-8942-a78c7abaca85"
    )
}

val TEST_DEALER_12345_CHILD by lazy {
    Partner(
        name = "Дочерний тестовый дилер для партнеров 12345",
        id = "db854db4-9745-ee11-bbbe-e4b749ae09c7",
        fullName = "Дочерний_Тестовый_Дилер_АП",
        webSite = "",
        phone = "",
        nameV1 = "987539",
        organizationId = ""
    )
}

val TEST_PARTNER by lazy {
    Partner(
        name = "Тестовый партнёр для регистрации продаж (не меняйте Дистрибуцию)",
        id = "559eb102-4ef8-e611-bde7-78e3b502da44",
        fullName = "ООО Тестовый партнёр для регистрации продаж",
        webSite = "Test_21_2_4_web",
        phone = "8 (191) 919 19 19",
        type = 1,
        nameV1 = "986823",
        organizationId = "ebff5cbd-79f8-49e7-aabe-a77decb5002f"
    )
}

val TEST_1421 by lazy {
    Partner(
        name = "testtestesttest333333update11022020_1421",
        id = "207f335c-1948-ea11-bba4-00155d627f03",
        nameV1 = "987171"
    )
}

val TEST_21_02_3 by lazy {
    Partner(
        name = "Test_21_02_3",
        id = "B58CB985-47F8-E611-BDE7-78E3B502DA44".lowercase(),
        nameV1 = "986823"
    )
}

data class Partner(
    val name: String,
    val id: String,
    val fullName: String? = null,
    val webSite: String? = null,
    val phone: String? = null,
    val type: Int? = null,
    val nameV1: String? = null, //идентификатор
    val organizationId: String? = null
)