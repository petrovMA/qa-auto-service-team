package ru.action_tech.qa.auto.data.enums

import ru.action_tech.qa.auto.utils.uuid
import java.util.*

enum class CustomerSupportType(val id: UUID, val title: String, val description: String) {
    SK(id = "e09020eb-5621-e811-a21c-00155dfbf212".uuid, "СК", "Свободный клиент"),
    PK(id = "2e9e7df4-5621-e811-a21c-00155dfbf212".uuid, "ПК", "Потенциальный клиент СС"),
    RK(id = "0ded5d05-5721-e811-a21c-00155dfbf212".uuid, "РК", "Регулярный клиент СС"),
    RK_US(id = "6507da18-85ed-e811-bb9d-00155d627f03".uuid, "РК ЮС", "Регулярный клиент ЮС"),
    PK_A360(id = "9f41ef9d-7a3f-eb11-bba9-00155d627f03".uuid, "ПК А360", "Потенциальный клиент А360"),
    RK_A360(id = "6ddd85c0-7a3f-eb11-bba9-00155d627f03".uuid, "РК А360", "Регулярный клиент А360"),
}