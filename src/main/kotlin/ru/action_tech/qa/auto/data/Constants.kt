package ru.action_tech.qa.auto.data

import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_accept.Action360RequestForAccessAcceptRequest.Aktion360RequestForAccess.Account
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable

object Constants {
    val JOB_TITLE_BUYER = CommonDtoNameNullable(id = "f90e86fd-8a33-4883-ad30-8a3a97e183dd", name = "Buyer")

    val TEST_ORGANIZATION_DEMO_ACCESS = Account(
        id = "71b6818d-d667-49b8-a655-641dbf749920",
        inn = "4261993739",
        kpp = "426199373",
        name = "Автотест на выдачу демодоступа в А360"
    )

    val TEST_ORGANIZATION_DEMO_BLOCK_ACCESS = Account(
        id = "271b92b1-3881-4552-a8f2-e8ea053c8a3b",
        inn = "1667006358",
        kpp = "1366664058",
        name = "Проверка выдачи блочного УКД"
    )

    val TEST_ACCESS_TREE_GET_BY_ACCESS_ACCOUNT = Account(
        id = "3205f797-2554-4668-a0ad-f130c5a53ba5",
        inn = "4261993740",
        kpp = "426199374",
        name = "Автотест для /api/v1/aktion360-access-tree_get-by-access-account"
    )

    val TEST_ORGANIZATION_ADD_USER_TO_DEMO_ACCESS = Account(
        id = "32471dd5-fc9f-44c8-8e0f-29de214e6d61",
        inn = "4261993774",
        kpp = "426199387",
        name = "Автотест для добавления пользователей в уже выданный демо-доступ"
    )

    val TEST_ORGANIZATION_FOR_ACCESS_CANCEL = Account(
        id = "2bdb1868-b1f6-4283-9aa0-ecc79b793ff4",
        inn = "1667006338",
        kpp = "1366664037",
        name = "Автотест компания для проверки отмены доступа /api/v1/access-cancel"
    )

    val TEST_ORGANIZATION_CHECK_MESSAGE_A360 = Account(
        id = "d5961969-3a92-435a-be9d-368e80ed669a",
        inn = "1667006337",
        kpp = "1366664036",
        name = "Проверка сообщения что уже есть оплаченные блоки Актион 360"
    )

    val TEST_ORGANIZATION_CHANGE_MASTER_USER = Account(
        id = "79c5904b-a627-4a8c-a096-965f922c693e",
        inn = "4261993747",
        kpp = "426199381",
        name = "Автотест: Смена мастер-пользователя и проверка отображения пользователей в демо-доступен"
    )

    val TEST_A360_BLOCK_ORGANIZATION_USER = Account(
        id = "97f81047-84f7-4614-8edb-fac3603b0d67",
        inn = "6546040959",
        kpp = "3381366990",
        name = ""
    )

    val PRODUCT_VERSION_A360_DIGITAL_FOR_BUDGET = CommonDtoNameNullable(
        id = "10ecbde5-6f24-ed11-bbbc-bcda0251696c",
        name = "Актион 360 Цифровая бюджетная организация"
    )

    val PRODUCT_VERSION_A360_BLOCK_FOR_BUDGET = CommonDtoNameNullable(
        id = "2F2AFFBC-ECCA-E811-BB9B-00155D627F03",
        name = "Актион 360 для бюджетников"
    )

    val PRODUCT_VERSION_A360_BLOCK = CommonDtoNameNullable(
        id = "308cd722-64b1-4ef0-8f44-70d395881574",
        name = "Актион 360 Блочный"
    )

    val PRODUCT_VERSION_A360_COUNTERPARTY = CommonDtoNameNullable(
        id = "a12f83bb-04e0-ec11-bbbc-bcda0251696c",
        name = "Актион 360 Право. Контрагенты"
    )

    val PRODUCT_VERSION_A360_BLOCK_SUBSCRIBE = CommonDtoNameNullable(
        id = "eed270e4-0b46-ed11-bbbc-bcda0251696c",
        name = "Актион 360 Блочный. Актион 360 Подписка для коммерческих организаций с Контрагентами и Промбезопасностью"
    )

    val PRODUCT_VERSION_A360_BLOCK_FOR_DASHBOARD = CommonDtoNameNullable(
        id = "49662a9f-0461-ed11-bbbc-bcda0251696c",
        name = "Актион 360 Блочный. Дашборд рисков для бухгалтерии"
    )

    val A360_BLOCK_FOR_DEMO = CommonDtoNameNullable(
        id = "49662a9f-0461-ed11-bbbc-bcda0251696c",
        name = "Актион 360 для направлений. Блочный для демо. Бухгалтерия. Монитор рисков. Контрагенты"
    )

    val ACTION_A360_EDUCATION = CommonDtoNameNullable(
        id = "2dcb9492-0342-4ccd-a5ac-8b93b553d123",
        name = "Актион 360 Образование"
    )

    val ACTION_A360_COUNTERPARTIES_FINANCE = CommonDtoNameNullable(
        id = "0e9feb50-bf07-4e7c-9512-fcf07605b749",
        name = "Актион 360 Контрагенты Финансы"
    )

    val ACTION_A360_COUNTERPARTIES_ACCOUNTING = CommonDtoNameNullable(
        id = "26998e7b-de56-4750-aca0-d48df5e60528",
        name = "Актион 360 Контрагенты Бухгалтерия"
    )

    val ACTION_A360_COUNTERPARTIES_RIGHT = CommonDtoNameNullable(
        id = "37e5b7d1-8a7d-45ed-b232-77a3e7315f67",
        name = "Актион 360 Контрагенты Право"
    )

    val ACTION_A360_DIGITAL_BUSINESS_CORPORATION = CommonDtoNameNullable(
        id = "8be1df5e-e335-4b3a-b0d8-51515a201812",
        name = "Актион 360 Коммерческая корпорация"
    )

    val ACTION_A360_MEDICINE = CommonDtoNameNullable(
        id = "0856f168-14b4-4372-9c23-7bade320c54d",
        name = "Актион 360 Медицина. Сестринская служба"
    )

    val ACTION_A360_HR = CommonDtoNameNullable(
        id = "c92c1c7e-6d80-4acc-8fb5-af9d63c42fbe",
        name = "Актион 360 Кадры и HR, бюджет"
    )

    val ACTION_A360_LABOR_PROTECTION = CommonDtoNameNullable(
        id = "75753cf2-98fe-4ec1-8c99-bfdd6d6edfc6",
        name = "Актион 360 Охрана труда"
    )

    val ACTION_A360_MEDICINE_MANAGEMENT_OF_A_MEDICAL_ORGANIZATION = CommonDtoNameNullable(
        id = "43c82e80-91fa-4f78-9e5b-1bf61feb5663",
        name = "Актион 360 Медицина. Управление медорганизацией"
    )

    val ACTION_A360_LAW_BUDGET = CommonDtoNameNullable(
        id = "0e3a5af1-70bd-4925-8fb2-71adc7783d08",
        name = "Актион 360 Право, бюджет"
    )

    val ACTION_A360_MEDICINE_THERAPEUTIC_WORK = CommonDtoNameNullable(
        id = "bcb4ced6-ffe0-471c-8911-d8e7719680c3",
        name = "Актион 360 Медицина. Лечебная работа"
    )

    val ACTION_A360_MEDICINE_ECONOMICS_OF_A_MEDICAL_ORGANIZATION = CommonDtoNameNullable(
        id = "cb95c7f0-144d-4306-a772-f067e74e9b01",
        name = "Актион 360 Медицина. Экономика медорганизации"
    )

    val ACTION_A360_STATE_FINANCE = CommonDtoNameNullable(
        id = "76f69fdc-fe42-4d8d-86c2-382e6dfb53da",
        name = "Актион 360 Госфинансы"
    )
    val ACTION_A360_GOVERNMENT_PROCUREMENT = CommonDtoNameNullable(
        id = "20d714f8-d36d-4d86-a4c3-99d227e1d38c",
        name = "Актион 360 Госзакупки"
    )
}