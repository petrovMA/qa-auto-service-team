package ru.action_tech.qa.auto.api_models.customer.search.v1.customers.search_customers

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class SearchCustomersResponse(
    val totalAccounts: Int,
    val totalContacts: Int,
    val items: List<SearchCustomerResponseItem?>
) {
    data class SearchCustomerResponseItem(
        @JsonProperty("jobtitle")
        val jobTitle: String?,
        val id: String,
        val customerType: Int,
        val name: String,
        val pin: String,
        val service: String,
        val system: String,
        val supportStatusA360: String,
        val inn: String?,
        val kpp: String?,
        val existInMyWork: Boolean,
        val existInPartnerWork: Boolean,
        val canCreateManualPhoneCall: Boolean,
        val ownerName: String?,
        val entityInfo: EntityInfo?,
        var email: String?,
        val orderId: UUID?,
        val totalSum: String?,
        val salesForecast: String?,
        val resubForecast: String?,
    ) {
        data class EntityInfo(
            val id: UUID,
            val type: String,
            val number: String,
            val authorName: String?,
            val createDate: String,
            val properties: List<Property>
        ) {
            data class Property(
                val key: String,
                val value: String,
            )
        }
    }
}