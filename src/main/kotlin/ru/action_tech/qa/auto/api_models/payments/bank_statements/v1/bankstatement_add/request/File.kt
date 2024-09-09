package ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_add.request

data class File(
    val createdOn: String? = null,
    val id: String?,
    val name: String? = null,
    val path: String? = null,
    val transactioncurrency: Transactioncurrency?
)