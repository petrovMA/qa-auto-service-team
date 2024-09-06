package ru.action_tech.qa.auto.data

enum class ContactPerson(
    val title: String,
    val id: String,
    val pin: Long? = null,
    val email: String = "",
    val position: String = "",
    val phone: String = "",
    val bitrixId: Int? = null,
    val bonusLevel: Int = 1
) {
    CUSTOMER(title = "", id = "9de9e1b1-9671-4a8e-ad0d-2c41bb1e9b1e"),
    STEPANOV("Степанов", "a6f516b4-a876-4d0f-88a1-702d109a9958"),
    MAIN_USER_FOR_ACCESS(
        title = "Выдача Автотест Демодоступа",
        id = "4189FA7D-AFAE-4B72-93F5-666A879C22B7",
        pin = 6791081501,
        email = "main_user_for_ui_test_demo_access@action-autotest.ru",
        position = "Buyer",
        phone = "9111111111",
        bitrixId = 18510218
    ),
    TEST_USER_FOR_DEMO_ACCESS("Добавить Автотест К_Демодоступу", "ABE23466-EF75-426B-963B-A4F31D27B20E"),
    TEST_USER_FOR_INCIDENT(
        title = "Тест Тест Тествоич",
        id = "3f1b3da0-e7b4-4fa1-b775-484b8fc2a722",
        pin = 3023783401,
        email = "aktiontest10@action-autotest.ru",
        position = "",
        phone = "79167346211",
        bitrixId = 3159099
    ),
    AUTOTESTOV_AUTOTEST(
        "Автотестов Автотест Автотестович",
        "73E41EF4-B4EC-4404-878E-F9D1B0D455F7",
        6067273701,
        "testautotest@action-autotest.ru"
    ),
    ERMAPI(
        title = "Ермапи ERM api",
        id = "da7d4035-c2fe-43e1-a671-df8cee37d934",
        email = "autotest63791560@action-autotest.ru",
        pin = 5765412301,
        phone = "9111111111"
    ),
    KARITSKIY("Карицкий", "acd535c8-da2a-e511-bf0a-78e3b502da44"),
    TEST_YATSENKO("Яценко Тест", "B2851FEB-B628-43B9-8BE7-5D5B3EE1576B", 4999253101),
    ERM_TEST_NOT_TOUCH("Ерм Тест Тест", "e3d2e4e5-cd05-406c-8eea-1d3006ff9f93", 6295765501),
    TESTER_TESTEROVICH(
        title = "тестовый тестер тестович",
        id = "C8F8DA95-08C5-443F-9B9F-2A058493822B",
        pin = 6909692001
    ),
    USER_FOR_ACCESS_TREE(
        title = "Выдача Автотест Демодоступа",
        id = "50c8d586-4c7e-4577-9b93-abe2eae33dbe",
        pin = 6846335701,
        email = "aktion360-access-tree_get-by-access-account@action-autotest.ru",
        position = "Buyer",
        phone = "9111111112",
        bitrixId = 18753605
    ),
    AUTOTESTOV(
        title = "Автотестов",
        id = "73e41ef4-b4ec-4404-878e-f9d1b0d455f7",
        pin = 6067273701,
        email = "7fc2bc0e-da0b-422c-a272-479ad1a80aa0-qa-auto-opgl@action-autotest.ru",
        position = "Сотрудник",
        phone = "",
        bitrixId = 15005167
    ),
    CONTACT_FOR_UZBEKISTAN_5916483119(
        title = "Клиент Демодоступа Тестовый",
        id = "d62466e9-2981-4b4f-aacc-bc4d2f13af75",
        pin = 7001449101,
        email = "2d6b1fae-c7f0-4f17-93ae-293c30f08e70-qa-auto-erm-ssr@action-autotest.ru",
        position = "HR директор",
        phone = "79111111111",
        bitrixId = 19571385
    ),
    AUTOTEST_AUTOTESTOV_WITH_ACCESS(
        title = "Автотестов Автотест Автотестович",
        id = "39AF8FD9-AC6C-49B0-BEDD-B9E1AC50C601",
        pin = 4902976501,
        email = "6a569544-fadc-465c-99ea-d8bd82c4c328@action-autotest.ru",
        position = "Сотрудник",
        phone = "",
        bitrixId = 10279364
    ),
    TEST_SALES_REGISTRATION(
        title = "Тестовый Регистрация Продаж",
        id = "97ad3aba-c26b-4d8d-93b3-938306133805",
        pin = 7081580001,
        email = "regProdajTest@action-autotest.ru",
        position = "Декан",
        phone = "9058811111"
    ),
    PARTNER_KOSORUKOVA_MARINA(
        title = "КОСОРУКОВА МАРИНА ВЯЧЕСЛАВОВНА",
        id = "6eafdfb5-1133-43f7-a957-a0e1d1ed152d",
        pin = 1234199901,
        email = "kosorukova@action-media.ru",
        position = "Специалист по закупкам",
        bitrixId = 661550
    ),
    ACTION_SVOI(
        title = "актион свои",
        id = "29d801da-6698-4f1a-a24e-a50cecd606e6",
        pin = 7059236001,
        email = "juliava.demo.vshg@mail.ru",
        position = "Агроном",
        bitrixId = 20142779
    ),
    A_ZASOBA(
        title = "Засоба Александр Владимирович",
        id = "662e4f3b-a97b-4066-b806-f2aa230f8843",
        pin = 2989063801,
        email = "azasoba@action.tech",
        position = "Сотрудник",
        bitrixId = 2952207
    )
}