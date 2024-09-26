package ru.action_tech.qa.auto.data.enums

enum class Products(val id: String, val nameProducts: String = "", val mainProductTypeId: String = "") {
    JOURNAL_GLAVBUH_01_22(
        "2668E56F-8330-EB11-BBA9-00155D627F03",
        "Журнал \"Главбух\" №01/2022"
    ),
    GLAVBUH_ASSISTENT_IT_1_MONTH(
        "E4E22F1D-5D40-4899-8DD2-1A132AFCDB68",
        "Главбух Ассистент. ИТ услуги 1 мес.",
        "9202c93a-1682-4d34-b57d-426bca313d48"
    ),
    BSS_SYSTEM_GLAVBUH_VIP_6_MONTH(
        "5A695983-F1D1-E811-BB9B-00155D627F03",
        "БСС \"Система Главбух\". Вип-версия. Без НДС. 2 пользователя. 6 мес."
    ),
    GLAVBUH_ASSISTENT_TARIFF_EXPERT_30_1(
        id = "1FCD9F23-9A01-4FA8-90FD-716F4590D253",
        nameProducts = "Главбух Ассистент. Тариф Эксперт. ИП. Патент. до 30 сотрудников. 1 мес.",
        mainProductTypeId = "9202C93A-1682-4D34-B57D-426BCA313D48"
    )
}
