package ru.action_tech.qa.auto.data

val organizationLesosibirsk by lazy {
    ParentOrganizations(
        customerId = "b093bbcd-a763-47a7-86a1-01d75971e1f4",
        customerName = "МКУ \"Управление образования администрации г. Лесосибирска\"",
        inn = "2454006568",
        kpp = "245401001",
        okpStatus = 100000004,
        okpStatusName = "04. Выход на ЛПР",
        estimatedNmtsk = 305507.0000,
        customerSizeCode = 100000002,
        customerSizeName = "От 31 до 50 сотрудников",
        parentAccountId = "b093bbcd-a763-47a7-86a1-01d75971e1f4",
        parentAccountName = "МКУ \"Управление образования администрации г. Лесосибирска\"",
        pin = "1165101701",
        isCorpClient = false
    )
}
val organizationTrans by lazy {
    ParentOrganizations(
        customerId = "83d40f79-ae60-4f57-a718-7cec857dfff5"
    )
}

val organizationCorporateUpdateCost by lazy {
    ParentOrganizations(
        customerId = "6fbb9425-82d0-4a70-837f-80577469ca56"
    )
}

val updateOkpStatusParentOrganization by lazy {
    ParentOrganizations(
        customerId = "e139f3b0-767b-4b18-9d8a-01d03ff68f9c"
    )
}

data class ParentOrganizations(
    val partnerId: String? = null,
    val customerId: String? = null,
    val customerName: String? = null,
    val inn: String? = null,
    val kpp: String? = null,
    val okpStatus: Int? = null,
    val okpStatusName: String? = null,
    val estimatedNmtsk: Double? = null,
    val refinedNmstk: String? = null,
    val customerSizeCode: Int? = null,
    val customerSizeName: String? = null,
    val parentAccountId: String? = null,
    val parentAccountName: String? = null,
    val pin: String? = null,
    val phone: List<String>? = null,
    val lprName: String? = null,
    val activityIdToAccount: String? = null,
    val activityIdToContact: String? = null,
    val isCorpClient: Boolean? = null
)
