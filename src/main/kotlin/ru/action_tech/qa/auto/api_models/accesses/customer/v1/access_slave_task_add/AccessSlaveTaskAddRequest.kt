package ru.action_tech.qa.auto.api_models.accesses.customer.v1.access_slave_task_add

data class AccessSlaveTaskAddRequest(val accessId: String?, val contactModels: List<ContactModel>?) {
    data class ContactModel(
        val additionalPhone: String?,
        val email: String?,
        val firstName: String?,
        val jobtitleId: String?,
        val lastName: String?,
        val middleName: String?,
        val phone: String?
    )
}