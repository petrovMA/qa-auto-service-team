package ru.action_tech.qa.auto.api_models.customer.customer.v1.connect

data class ConnectOrgAndClientRequest(
    val customerId: String?,
    val contactPersonId: String?
)