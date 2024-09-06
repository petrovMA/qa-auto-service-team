package ru.action_tech.qa.auto.data

val OUTBOX_CAMPAIGN by lazy {
    Campaign(
        name = "Armsell_topguys_юридические лица",
        id = "0cfdc690-8f9a-4295-bc12-a30e72201a23",
        number = "2042987449"
    )
}

val CLOSE_CAMPAING by lazy {
    Campaign(
        name = "AutoTest_ClosePhoneCallFinaly",
        id = "13607e24-e0f4-4260-a1a6-1cca17515a1e"
    )
}


val FREE_CAMPAING by lazy {
    Campaign(
        name = "Тестовая кампания для свободных клиентов",
        id = "fe3e82e3-22af-4a7f-b1b0-ec31a40ca30c"
    )
}

val AUTO_CAMPAING by lazy {
    Campaign(
        name = "AUTO_TEST",
        id = "71605897-8d41-4051-ac38-e9a2d27c594c",
        number = "2042990489"
    )
}

val LIMITS_99_CAMPAING by lazy {
    Campaign(
        name = "AutoTest-99Limits",
        id = "f635d80a-f7c0-41f6-8b3e-2fe44f3289c0"
    )
}

val LIMITS_NULL_CAMPAING by lazy {
    Campaign(
        name = "AutoTest-LimitNull",
        id = "ff8cf61f-b9db-4387-b53a-8a38e55eeff5"
    )
}

val LIMITS_1_CAMPAING by lazy {
    Campaign(
        name = "AutoTest-LimitOneCantCall",
        id = "e2a69e5d-55ce-422d-8e38-95b2caa1ffd8"
    )
}

val LIMITS_0_CAMPAING by lazy {
    Campaign(
        name = "AutoTest-LimitZeroRecall",
        id = "41df73b9-56be-4548-9bec-64c0d553c303"
    )
}

val AUTOCALL_CAMPAIGN by lazy {
    Campaign(
        name = "Ерм. Автопрозвон AUTO кампания",
        id = "010cdef5-8839-4b1a-a558-ed24d6ed950c"
    )
}

val AUTOCALL_ASTERISK by lazy {
    Campaign(
        name = "Автопрозвон. Только для тестов Астериск 1",
        id = "916b2cd1-f33d-eb11-bba9-00155d627f03"
    )
}

val VTM_CAMPAIGN by lazy {
    Campaign(
        name = "ВТМ",
        id = "4c6f91a4-52b0-4ede-b08b-32fbfbc92262"
    )
}

val UZB_CAMPAIGN by lazy {
    Campaign(
        name = "Автотестовый узбекский партнер_Free",
        id = "112e2127-2a2e-4461-a8ed-7814b006de89"
    )
}

val STAGE_0_NEW_CUSTOMERS_OKP by lazy {
    Campaign(
        name = "Этап 0: Новые клиенты_ОКП",
        id = "0f3a2644-cea9-4dff-91a7-791f2a593961"
    )
}

val TEST_FOR_RESOLVE_PROBLEM_2 by lazy {
    Campaign(
        name = "Тест_для решения проблем_2",
        id = "14C8667F-4DC2-460A-A038-346DDE166DC1"
    )
}

val TEST_SEMINAR by lazy {
    Campaign(
        name = "Тестовый дилер_Семинары",
        id = "539b07f4-974b-46bf-8b18-db06990226aa",
    )
}

val TEST_IMPORT by lazy {
    Campaign(
        name = "ИП \"Тестовый дилер\"_залив",
        id = "5acd1745-86fb-4506-9af3-d5672009d885",
    )
}

val RUS_PARTNER_FREE_CAMPAIGN by lazy {
    Campaign(
        name = "Автотестовый партнер Российский обычный_Free",
        id = "0c592a7b-0746-4de4-b170-978b98d2bf7f",
    )
}

val UZ_PARTNER_FREE_CAMPAIGN by lazy {
    Campaign(
        name = "Автотестовый узбекский партнер_Free",
        id = "112e2127-2a2e-4461-a8ed-7814b006de89",
    )
}

val SCRIPT_IVANOVA by lazy {
    Campaign(
        name = "Тест_скрипт_Анастасия_Иванова",
        id = "ef248661-d5ec-48ec-aa9a-796707e5bb41"
    )
}

val AUTOCALL_ASTERISK_2 by lazy {
    Campaign(
        name = "Автопрозвон. Только для тестов Астериск 2",
        id = "5436f495-f6a0-eb11-bba9-00155d627f03"
    )
}

data class Campaign(
    val name: String,
    val id: String,
    val number: String? = null
)
