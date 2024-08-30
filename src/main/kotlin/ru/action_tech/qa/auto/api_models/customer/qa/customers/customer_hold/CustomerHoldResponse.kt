package ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold

import ru.action_tech.qa.auto.core.serialization.facade.Deserializable
import ru.action_tech.qa.auto.core.serialization.facade.Serializable

data class CustomerHoldResponse(
    val id: Int,
    val customer: Customer
) : Serializable {
    companion object : Deserializable<CustomerHoldResponse>

    override fun toString(): String = serialize.strict.toJson()

    data class Customer(
        val id: String,
        val customerType: Int,
        val pin: String?,
        val name: String?,
        val inn: String?,
        val kpp: String?,
        val countryId: String?
    ) : Serializable {
        companion object : Deserializable<Customer>

        override fun toString(): String = serialize.strict.toJson()
    }
}


