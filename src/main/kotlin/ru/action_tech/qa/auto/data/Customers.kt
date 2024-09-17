package ru.action_tech.qa.auto.data

//Актионушка тестовый ЕРМ
val person by lazy {
    Customer(
        customerId = "b74f97a0-7e6e-4050-9321-5d84330be574",
        email = "erm-test@action-press.ru",
        pin = "4326066501",
        bitrixId = "8428970",
        phoneNumber = "9772805547",
        name = "Тестовый Актионушка ЕРМ",
        customerType = 2
    )
}

//Рыбстрой
val organization by lazy {
    Customer(
        customerId = "58e336fd-b0e5-4efd-aa54-458c1e170bed",
        pin = "528184301",
        phoneNumber = "9039664848",
        customerType = 1,
        inn = "7702513905",
        kpp = "770201001",
        name = "РЫБСТРОЙ"
    )
}

val commentsPerson by lazy {
    Customer(
        customerId = "b61580d3-e78a-46e1-9b3b-89d753b88719",
        email = "test-aa@action-media.ru",
        pin = "6834241101",
        phoneNumber = "9157770711",
        bitrixId = "20159347",
        name = "- TRXeVoxRet -",
        customerType = 2
    )
}

val notActivePerson by lazy {
    Customer(
        customerId = "7d383416-5582-e711-a20a-00155dfbf212",
        email = "vista-irk@mail.ru",
        phoneNumber = "1955829976",
        bitrixId = "10516654",
        name = "vista-irk@mail.ru",
        customerType = 0
    )
}

val seminarPerson by lazy {
    Customer(
        customerId = "c4873d93-9d03-4ca5-a063-2813d8bcedae",
        email = "autotest5889845@action-autotest.ru",
        pin = "5675948201"
    )
}

// "Тестируем количество сотрудников организации (НЕ ТРОГАТЬ !)"
val corporateEmployees by lazy {
    Customer(
        customerId = "44a69be9-f87e-4c3f-a9be-bfdf88d02f18"
    )
}

// "Тестируем изменение стоимости организации (НЕ ТРОГАТЬ !)"
val corporateUpdateCost by lazy {
    Customer(
        customerId = "10C5F0B0-6D6C-4166-A31B-2214779F4367"
    )
}


val updateOkpStatusOrganization by lazy {
    ParentOrganizations(
        customerId = "011e6c5b-b17f-48c7-9069-d23e5d3cdfc4"
    )
}

val CUSTOMER_TEST by lazy { Customer(customerId = "a12e8520-7707-4498-8c5f-e8ff274ebed3") }

val CUSTOMER_WITH_ORDER by lazy { Customer(customerId = "275205bd-3ce2-4977-bb4e-10f999804325") }

// У данного кастомера подписка оканчивается 2023-02-28T20:59:59.000
val CUSTOMER_WITH_SUBSCRIPTION by lazy { Customer(customerId = "9B39BA13-E279-4C50-B582-6589CBE9C63E") }

val CUSTOMER_WITH_REGION by lazy {
    Customer(
        customerId = "07315ea6-5608-4624-b93d-69ae8becbc27",
        region = "Татарстан Республика",
        city = "Самара"
    )
}

data class Customer(
    val customerId: String?,
    var email: String? = null,
    val pin: String? = null,
    val bitrixId: String? = null,
    val phoneNumber: String? = null,
    val region: String? = null,
    val city: String? = null,
    val name: String? = null,
    val customerType: Int? = null,
    val inn: String? = null,
    val kpp: String? = null
)
