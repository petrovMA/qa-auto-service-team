package ru.action_tech.qa.auto.api_models.erm_backend.order.v1.order_create

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import java.util.*

@JsonInclude(NON_NULL)
data class OrderCreateRequest(
    val paymentPhoneCallDate: String?,
    val realContactId: UUID?,
    val realCustomerId: UUID?,
    val orderId: UUID?,
    val items: List<Item?>?,
    val discount: Discount?,
    val customerId: UUID?,
    val campaignId: UUID?,
    val paymentScenarioId: UUID?,
    val phoneCallId: UUID?,
    val contactId: UUID?,
    var paymentPlannedDate: String?,
    val contractPaymentDate: String?,
    val contractType: ContractType?,
    val currencyAccountId: UUID?,
    val paymentSchedules: List<PaymentSchedules?>?,
    val customerType: String? = null,
    val grSalefalse: Boolean? = null,
    val selectPhone: String? = null,
    val timeShift: String? = null,
    val noCustomerIdForContact: String? = null,
) {
    @JsonInclude(NON_NULL)
    data class Item(
        val personalDiscount: PersonalDiscount,
        val groupId: UUID?,
        val priceId: UUID?,
        val products: List<Product>?,
    ) {
        data class PersonalDiscount(
            val previousSubscribeId: UUID?,
            val applyPersonalDiscount: Boolean?,
            val discountSum: Int?,
            val isResubscribe: Boolean? = null,
        )

        @JsonInclude(NON_NULL)
        data class Product(
            val itemId: UUID?,
            val productId: UUID?,
            val dateStart: String?,
            val dateEnd: String? = null,
            val units: Int?,
            val deliveryMethodId: UUID?,
            val readerId: UUID?,
            val productTypeId: UUID? = null,
            val priceId: UUID? = null,
            val isComplect: Boolean? = null,
            val canUseAktionBonus: Boolean? = null,
            val mainProductName: String? = null,
            val productName: String? = null,
            val productNumber: String? = null,
            val productTypeName: String? = null,
            val commandmentNumber: String? = null,
            val costName: String? = null,
            val tarifName: String? = null,
            val usersCount: Int? = null,
            val priceBase: Int? = null,
            val sum: Int? = null,
            val personalDiscount: Int? = null,
            val ndsId: UUID? = null,
            val typeMainProductId: UUID? = null,
            val intervalId: UUID? = null,
            val nds: Int? = null,
            val scenario: Int? = null,
            val intervalUnitType: Int? = null,
            val intervalUnitAmount: Int? = null,
            val extrachargeSum: Int? = null,
            val discountBonusSum: Int? = null,
            val discountCertificateSum: Int? = null,
            val discountPersonalSum: Int? = null,
            val maxPaymentDate: String? = null,
            val intervalName: String? = null,
            val previousSubscribe: String? = null,
        )
    }

    data class Discount(
        val bonusPoints: Int?,
        val smsCode: String?,
        val emailCode: String?,
        val certificateId: UUID?,
        val orderOfApply: List<Int>?,
    )

    @JsonInclude(NON_NULL)
    data class ContractType(
        val contractTypeId: UUID?,
        val salesProcedureId: UUID?,
    )

    data class PaymentSchedules(
        val date: String?,
        val sum: Int?,
    )
}
