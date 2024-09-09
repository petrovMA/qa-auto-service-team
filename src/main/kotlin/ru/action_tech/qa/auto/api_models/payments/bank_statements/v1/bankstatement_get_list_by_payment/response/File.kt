package ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_get_list_by_payment.response

data class File(
    val createdOn: String?,
    val id: String?,
    val name: String?,
    val path: String?,
    val transactioncurrency: Transactioncurrency?
)