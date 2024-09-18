package ru.action_tech.qa.auto.data

//Автотестовый филиал Узбекистан
val filialUzb by lazy {
    BusinessUnit(
        filialId = "1a20de33-4de5-eb11-bbb6-f54d679fc4d6",
        businessUnitName = "Автотестовый узбекский партнер",
        businessUnitId = "86a819f2-68cb-4eaa-b2c7-3710704fefef",
        partnerId = "61fbefd0-3be5-eb11-bbb6-f54d679fc4d6"
    )
}
//Автотестовый филиал Российский обычный
val filialRus by lazy {
    BusinessUnit(
        filialId = "dcd11cce-6ee5-eb11-bbbc-bcda0251696c",
        businessUnitName = "Автотестовый партнер Российский обычный",
        businessUnitId = "27fa0600-163f-44a5-92fa-c6844c8bd7ee",
        partnerId = "20c0a770-68e5-eb11-bbbc-bcda0251696c"
    )
}
val bonusDealer by lazy {
    BusinessUnit(
        filialId = "4c1aed52-c247-e811-a233-00155dfb5103",
        businessUnitName = "Бонусный дилер",
        businessUnitId = "9f8dcb68-f386-e511-8e6e-78e3b502da44",
        partnerId = "b89ff32c-5f0b-df11-809e-001cc45e3d96"
    )
}
val adminDealerSS by lazy {
    BusinessUnit(
        filialId = "4c1aed52-c247-e811-a233-00155dfb5103",
        businessUnitName = "Админ Дилер_СС",
        businessUnitId = "be992684-c247-e811-a233-00155dfb5103"
    )
}
val subsidiaryTestDealerForPartners by lazy {
    BusinessUnit(
        filialId = "8f9a4d65-c012-431c-8ba3-26e29ab66f33",
        businessUnitName = "Дочерний тестовый дилер для партнеров 12345",
        businessUnitId = "9b1de323-bdc2-4959-a996-57fcce2bc8a4",
        partnerId = "db854db4-9745-ee11-bbbe-e4b749ae09c7"
    )
}
val partnerFirstTestBizUnit by lazy {
    BusinessUnit(
        filialId = "8f9a4d65-c012-431c-8ba3-26e29ab66f33",
        businessUnitName = "хПартнер_Первый_Тестовый_Общий",
        businessUnitId = "fe798566-d73c-e511-bf0a-78e3b502da44",
        partnerId = "15d82e96-9c3d-e511-bf0a-78e3b502da44"
    )
}
val specialProjectsManagement by lazy {
    BusinessUnit(
        filialId = "f1179a8a-d45c-e811-a235-00155dfb5103",
        businessUnitName = "Управление специальных проектов (тестовое подразд)",
        businessUnitId = "c936f0de-ae47-e811-a233-00155dfb5103",
        partnerId = "09c2d5a1-3f46-e911-bb9e-00155d627f03"
    )
}

data class BusinessUnit(
    val filialId: String? = null,
    val businessUnitName: String? = null,
    val businessUnitId: String? = null,
    val partnerId: String? = null
)