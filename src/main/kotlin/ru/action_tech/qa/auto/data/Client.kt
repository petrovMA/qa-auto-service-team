package ru.action_tech.qa.auto.data

import ru.action_tech.qa.auto.utils.getPhoneNumber
import ru.action_tech.qa.auto.utils.getRandom

val lashkhia
    get() = Client(
        pin = "2974385501",
        bitrixId = "2816997",
        fio = FIO("Дмитрий", secondName = "Темурович", lastName = "Лашхиа"),
        email = "Dlashkhia@yandex.ru",
        position = "Агроном",
        phone = "9998221804"
    )

val actionushka
    get() = Client(
        pin = "4326066501",
        bitrixId = "8428970",
        fio = FIO("Актионушка", "Тестовый", "ЕРМ"),
        email = "erm-test@action-press.ru",
        position = "IT директор",
        inn = "985457126",
        phone = "9772805547"
    )

val karitsky
    get() = Client(
        pin = "2973532301",
        bitrixId = "2822981",
        fio = FIO(
            firstName = "Алексей",
            secondName = "Николаевич",
            lastName = "Карицкий"
        ),
        position = "Account director",
        email = "karitsky@action-press.ru",
        phone = "79169684825",
        uuid = "acd535c8-da2a-e511-bf0a-78e3b502da44"
    )

val stepanov
    get() = Client(
        pin = "4742581001",
        bitrixId = "9503899",
        fio = FIO("Сергей", secondName = "", lastName = "Степанов"),
        email = "showtime25st@action-autotest.ru",
        position = "Младший инженер по качеству",
        phone = "9104241786",
        uuid = "a6f516b4-a876-4d0f-88a1-702d109a9958"
    )

val tabTest
    get() = Client(
        pin = "6093128201",
        bitrixId = "15145025",
        fio = FIO("Тестируем", secondName = "Вкладки", lastName = "Нетрогать"),
        email = "testTabsStepanov@action-autotest.ru",
        position = "Младший инженер по качеству",
        phone = "9111111111"
    )

val baranova
    get() = Client(
        pin = "2248794601",
        bitrixId = "3657113",
        fio = FIO("Любовь", secondName = "Валерьевна", lastName = "Баранова"),
        email = "finupr@tchaik.ru",
        position = "Бухгалтер",
        phone = "73424135570"
    )

val sadova
    get() = Client(
        pin = "3956798401",
        bitrixId = "9201137",
        fio = FIO("Валерия", secondName = "Олеговна", lastName = "Садова"),
        email = "V.Sadova@sistema.ru",
        position = "Buyer",
        phone = ""
    )

val karavaykin
    get() = Client(
        pin = "4139555601",
        bitrixId = "14720887",
        fio = FIO("Евгений", secondName = "Олегович", lastName = "Каравайкин"),
        email = "karavaykin@action-press.ru",
        position = "Buyer",
        phone = ""
    )

val ermApiTestUser
    get() = Client(
        pin = "5375644501",
        uuid = "B49E8B22-A96A-4B4C-8406-17D5DA75031F",
        fio = FIO("ERM", "Ермапи", "1000768255"),
        email = "autotest@api73824423.ru",
        phone = "6023384422",
        position = "Креативный директор"
    )

val testUserForIncident
    get() = Client(
        pin = "3023783401",
        bitrixId = "3159099",
        fio = FIO(
            "Тест",
            "Тествоич",
            "Тест"
        ),
        email = "aktiontest10@mail.ru",
        position = "",
        phone = "9167346211"
    )

val ermApiUser
    get() = Client(
        pin = "5836996301",
        fio = FIO(
            "ERM",
            "api",
            "Ермапи"
        ),
        email = "autotest40676330@action-autotest.ru",
        position = "Агроном",
        phone = "6251578598"
    )

val clientForDemo
    get() = Client(
        pin = "7001449101",
        bitrixId = "19571385",
        fio = FIO(
            firstName = "Демодоступа",
            secondName = "Тестовый",
            lastName = "Клиент"
        ),
        position = "HR директор",
        email = "2d6b1fae-c7f0-4f17-93ae-293c30f08e70-qa-auto-erm-ssr@action-autotest.ru",
        phone = "9111111111"
    )

val mainUserForAccess
    get() = Client(
        pin = "6791081501",
        bitrixId = "18510218",
        fio = FIO(
            firstName = "Автотест",
            secondName = "Демодоступа",
            lastName = "Выдача"
        ),
        position = "Buyer",
        email = "main_user_for_ui_test_demo_access@action-autotest.ru",
        phone = "9111111111"
    )

data class Client(
    var pin: String = "",
    var bitrixId: String = "",
    var fio: FIO,
    var position: String = "Директор салона",
    var email: String = "autotest${getRandom()}@action-autotest.ru",
    var phone: String = getPhoneNumber().toString(),
    var inn: String = "",
    var uuid: String = ""
)

class FIO(var firstName: String = "Автотест", var secondName: String = "Auto", var lastName: String = "Ермов") {
    override fun toString() = """$lastName $firstName $secondName"""
}

val userWithBonus
    get() = Client(
        pin = "4431879401",
        bitrixId = "8913968",
        fio = FIO(
            firstName = "ERM",
            secondName = "api",
            lastName = "Ермапи"
        ),
        position = "Сотрудник",
        email = "autotest505439412@action-autotest.ru",
        phone = "79165591865",
        uuid = "20c8da5a-9888-4370-a1a1-d9b3f572e47e"
    )
