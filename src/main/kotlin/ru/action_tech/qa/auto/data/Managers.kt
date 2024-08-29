package ru.action_tech.qa.auto.data

//Общая очередь / Робот
val SYSTEM_S by lazy {
    Managers(
        login = "sdH@mcfr.ru",
        password = "",
        id = "003a5957-f3cd-4671-8201-0f477d1d3a08",
        name = "SYSTEM S"
    )
}

// Робот
val SERVICE_ROBOT by lazy {
    Managers(
        login = "actionservice@m-press.ru",
        crmLogin = "hq\\actionservice",
        password = "",
        id = "3f824e42-46bc-ee11-bbbf-b87905c9cf85",
        name = "Сервис Актион Актионович",
        portalId = 136245
    )
}

val AUTO_ACTIONUSKA by lazy {
    Managers(
        login = "erm-avto-test@action-press.ru",
        crmLogin = "action-crm\\Partner-706326",
        id = "21f53d04-7468-4c60-afcb-2917383f9856",
        erm_pass = "Nemezis180486",
        phone_ext = "5589",
        name = "Автотестовый Актионушка Бот",
        portalId = 80684
    )
}

val ACTIONUSKA by lazy {
    Managers(
        login = "erm-test@action-press.ru",
        crmLogin = "HQ\\Partner-701264",
        id = "2df6b60a-0e5b-4380-85dd-d8879b6c195c",
        erm_pass = "1DiDWv46",
        phone_ext = "14613",
        name = "Тестовый Актионушка ЕРМ",
        portalId = 70610
    )
}

val AUTO_CALL by lazy {
    Managers(
        login = "covid-erm-test@action-press.ru",
        id = "dbe81e39-125c-4d46-8aec-03384c61b347",
        name = "Короновирусный Актионушка Тестовый"
    )
}

val TOP_ACTIONUSKA by lazy {
    Managers(
        login = "top_actionushka@action-press.ru",
        crmLogin = "HQ\\Partner-714053",
        id = "52480467-4808-4f5e-b5bd-5548e181d605",
        erm_pass = "83heDrrN",
        name = "Топовый Актионушка Тестовый"
    )
}

val VTM_CALL by lazy {
    Managers(
        login = "meat_actionushka@action-press.ru",
        id = "83f0ab66-845a-4b63-9f5b-e0aca4438fbd"
    )
}

val VTM_CALL_DM by lazy {
    Managers(
        login = "vtmdirtymaster@action-autotest.ru",
        id = "6bc9c04e-ffe6-4bdd-be7e-96c2d9ab5709"
    )
}

val MANAGER by lazy {
    Managers(
        login = "pierluijicalina@action-autotest.ru",
        password = "Mc9%6(Bi",
        id = "b68de3f9-75b0-4899-974e-4a1b4358e091"
    )
}

val UKR_MANAGER by lazy {
    Managers(
        login = "ukraina-autotest25@action-autotest.ru",
        id = "2b6c82bc-3d3a-469b-8b65-dc65ce97670b"
    )
}

val TEST_PARTNER_THIRD_USER by lazy { //уволенный сотрудник
    Managers(
        id = "e26a6211-6ce3-4046-ad82-0e1162ac3207",
        login = "t31-partner-presale@action-autotest.ru",
        crmLogin = "action-crm\\Partner-728960",
        name = "Тестовый Партнер Третий",
        portalId = 122098
    )
}

val TEST_ROZENTAL_FOR_DISMISS by lazy { //ДляТестирования ЗадачиПоУвольнению Розенталь
    Managers(
        id = "6f85c4cb-0ec9-40f1-ae10-c8b96b2917e6",
        login = "t3-partner-presale@action-autotest.ru",
    )
}

val TEST_ASTERISK by lazy {
    Managers(
        login = "erm-test-asterisk@action-press.ru",
        id = "735b56b7-33cd-4ae7-b952-2d606a05336d",
        name = "[bot] Актионушка Астерисков",
        phone_ext = "5593"
    )
}

val TEST_GUCCIE_GABANA by lazy {
    Managers(
        id = "0782877c-8a9f-4859-997d-f9a642aad95b",
        login = "auto-guccie-test@action-press.ru",
        name = "Автотестов Гуччи Габана",
        portalId = 101695,
        phone_ext = "1274"
    )
}

val CHANGE_ROLE by lazy {
    Managers(
        login = "test-moz-1@action-media.ru",
        id = "a5908199-c27c-4bd7-a936-acd4b82844ba"
    )
}

val TEST_PARTNER_ONE by lazy {
    Managers(
        id = "017cee91-6654-4716-bfdc-4f3e7af4d227",
        login = "tttt1-partner-presale@action-press.ru",
        crmLogin = "action-crm\\Partner-728943",
        name = "111111 Партнер Первый"
    )
}

val TEST_PARTNER_FIRST_USER by lazy {
    Managers(
        id = "53bd3d70-fa4a-4a6f-a00a-b1d43b930e91",
        login = "t1-partner-presale@action-autotest.ru",
        crmLogin = "action-crm\\Partner-728963",
        name = "Тестовый Партнер Первый",
        portalId = 122103
    )
}

val TEST_PARTNER_SECOND_USER by lazy {
    Managers(
        id = "bdc96bcb-12b5-4089-bd7f-83dd8f53aed9",
        login = "t2-partner-presale@action-autotest.ru",
        crmLogin = "action-crm\\Partner-728958",
        name = "Тестовый Партнер Второй",
        portalId = 122094
    )
}

val TEST_PARTNER_TEST by lazy {
    Managers(
        id = "9407ab50-accd-4cf0-b3b6-5ac3dde85870",
        login = "mailtest@mail.ru",
        crmLogin = "action-crm\\Partner-727268",
        name = "тестов тест тестовичович"
    )
}

val TEST_PARTNER_FOR_SASHA by lazy {
    Managers(
        id = "1d3d0422-4b9c-4fec-80ad-664c17ccd336",
        login = "t4-partner-presale@action-autotest.ru",
        crmLogin = "action-crm\\Partner-725686",
        name = "Тестовый ДляСаши ОченьНадович",
        portalId = 116568
    )
}

val TEST_PARTNER_FIFTH_USER by lazy {
    Managers(
        id = "5f0cb28f-1e59-448d-b22a-b148c115d04f",
        login = "t5-partner-presale@action-autotest.ru",
        crmLogin = "action-crm\\Partner-725685",
        erm_pass = "Terminator2022",
        phone_ext = "23401",
        name = "Тестовый Пятый Партнер"
    )
}

val TEST_CHECK_CATEGORY by lazy {
    Managers(
        id = "739604e2-41e8-4781-876f-62804a069858",
        login = "test_check_category@action-autotest.ru",
        crmLogin = "action-crm\\Partner-730648",
        name = "Тестовый Проверка Категорович",
        portalId = 124903
    )
}

val TEST_PARTNER_SMOKE by lazy {
    Managers(
        id = "6baadd48-d29b-4ada-abd3-acd6b9c6b32b",
        login = "test-partner-smoke@action-autotest.ru",
        crmLogin = "action-crm\\Partner-730647",
        name = "Тестовый Партнер Смокович",
        portalId = 124902
    )
}

val TEST_PARTNER_BOT by lazy {
    Managers(
        id = "b3d2ab68-614f-477c-ac23-9d025731d1ae",
        login = "test-partnes-action@action-press.ru",
        crmLogin = "HQ\\Partner-707713",
        name = "Партнерский Тестовый Бот",
        portalId = 83551
    )
}

val TEST_REGRESSOVICH by lazy {
    Managers(
        id = "EC025722-43C0-472A-AB59-A00A96A2EE92",
        login = "test-regress@action-autotest.ru",
        crmLogin = "action-crm\\Partner-730646",
        name = "Тестовый Сотрудник Регрессович"
    )
}

val TEST_REGISTRATION_MANAGER by lazy {
    Managers(
        id = "b32280d0-762b-4c51-9d88-0002adfd7708",
        login = "valentina@kgermak.ru",
        crmLogin = "action-crm\\Partner-733118",
        password = "xvj83G3PdjS6WM54L12l7g==",
        name = "Валентина Анастасия Павловна"
    )
}

data class Managers(
    val login: String,
    val crmLogin: String? = null,
    val password: String = "q%K1a5R'",
    val id: String = FieldData.ZERO_ID,
    val erm_pass: String? = null,
    val phone_ext: String? = null,
    val name: String? = null,
    val portalId: Int? = null
)
