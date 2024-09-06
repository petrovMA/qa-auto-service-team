package ru.action_tech.qa.auto.api_models.orders.master.v2.order_create

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import ru.action_tech.qa.auto.core.utils.format
import ru.action_tech.qa.auto.data.ContactPerson
import ru.action_tech.qa.auto.data.Department
import ru.action_tech.qa.auto.data.SCENARIO_ADVANCE
import java.util.*

@JsonInclude(NON_NULL)
data class CreateOrderRequest(
    val paymentScenarioId: String? = SCENARIO_ADVANCE.id!!,
    val currencyAccountId: String? = "bc0fe8f0-6754-e411-82a0-78e3b502da44",
    val items: List<Items>? = listOf(Items()),
    val customerId: String? = Department.WEB_PROJECT_DEVELOPMENT.id,
    val customerType: Int? = 1,
    val campaignId: String? = "71605897-8d41-4051-ac38-e9a2d27c594c",
    val contactId: String? = ContactPerson.STEPANOV.id,
    val phoneCallId: String? = "1064ab55-8c15-46ac-a5b2-af50fa74f1dc",
    val paymentPhoneCallDate: String? = "${DateTimeUtils.TOMORROW.format("yyyy-MM-dd")}T15:00:00+03:00",
    val contractType: ContractType = ContractType(),
    val realContactId: String? = null,
    val realCustomerId: String? = null,
    val paymentPlannedDate: String? = null,
    val contractPaymentDate: String? = null,
    val paymentSchedules: List<Schedule>? = null
) {
    data class Items(
        val groupId: String? = null,
        val priceId: String? = "b6f4b90d-0834-4a2a-96f1-4970c88dd6b6",
        val products: List<Products>? = listOf(Products()),
        val personalDiscount: PersonalDiscount? = null
    ) {
        data class Products(
            val productId: String? = "5b304213-6967-4636-97a4-616579e50da1",
            val dateStart: String? = "2022-05-01T00:00:00+03:00",
            val units: Int? = 1,
            val deliveryMethodId: String? = "2ad1cd58-ca0e-44dc-9cc9-2e354e7c53aa",
            val readerId: String? = null
        )

        data class PersonalDiscount(
            val previousSubscribeId: UUID? = null,
            val applyPersonalDiscount: Boolean,
            val discountSum: Int? = 1,
            val isOrderGenerator: Boolean
        )
    }

    data class ContractType(
        val contractTypeId: String? = "3f89e98f-e4f4-e611-bde7-78e3b502da44",
        val salesProcedureId: String? = "a7ac1931-3e09-e711-96ea-78e3b502da44"
    )

    data class Schedule(val date: String?, val sum: Int?)
}
