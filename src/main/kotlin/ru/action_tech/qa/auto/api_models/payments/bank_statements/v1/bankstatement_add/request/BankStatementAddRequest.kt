package ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_add.request

data class BankStatementAddRequest(
    val actionAccountId: ActionAccountId?,
    val author: Author? = null,
    val bankStatementDate: String?,
    val benefAccount: String?,
    val bicBankCustomer: String?,
    val corrAccountBankCustomer: String?,
    val createdOn: String? = null,
    val customer: Customer? = null,
    val customerAccountNt: String?,
    val datedischargebankclient: String?,
    val file: File?,
    val id: String? = null,
    val isDistributed: Boolean?,
    val nameBankCustomer: String?,
    val number: String? = null,
    val owner: Owner?,
    val payerInn: String?,
    val payerKPP: String?,
    val payerName: String?,
    val payerPaymentAccount: String?,
    val payment: Payment? = null,
    val paymentAccount: PaymentAccount? = null,
    val paymentOrderNumber: String?,
    val paymentPeriod: String? = null,
    val paymentPurpose: String?,
    val priority: Int?,
    val recipientPaymentAccount: String?,
    val stringorderowner: Stringorderowner?,
    val sum: Int?,
    val supposedOrderNumber: String?
)