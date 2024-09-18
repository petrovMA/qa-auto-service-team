package ru.action_tech.qa.auto.api_models.customer.search.v1.customers.search_customers

data class SearchOrdersResponse(
    val totalAccounts: Int,
    val totalContacts: Int,
    val items: List<SearchOrdersResponseItem?>
) {
    data class SearchOrdersResponseItem(
        val canCreateManualPhoneCall: Boolean,
        val customerType: Int,
        val email: String?,
        val entityInfo: EntityInfo,
        val existInMyWork: Boolean,
        val existInPartnerWork: Boolean,
        val id: String,
        val inn: String?,
        val kpp: String?,
        val name: String,
        val ownerName: String?,
        val pin: String,
        val resubForecast: Any?,
        val salesForecast: Any?,
        val service: String,
        val supportStatusA360: String,
        val system: String
    ) {
        data class EntityInfo(
            val authorName: String,
            val createDate: String,
            val id: String,
            val number: String,
            val properties: List<Any?>,
            val type: String
        )
    }
}