package ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_list_by_customer

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable


data class PaymentsGetListByCustomerResponse(
    val author: CommonDtoNameNullable?,
    val bankStatementLine: CommonDtoNameNullable?,
    val createdOn: String?,
    val customer: Customer?,
    val id: String?,
    val modifier: CommonDtoNameNullable?,
    val modifiedOn: String?,
    val number: String?,
    val paymentAccount: CommonDtoNameNullable?,
    val paymentDate: String?,
    val paymentOrderNumber: String?,
    val sum: Int?,
    val type: CommonDtoNameNullable?
) {
    data class Customer(
        val id: String?,
        val name: String?,
        val type: Int?
    )
}