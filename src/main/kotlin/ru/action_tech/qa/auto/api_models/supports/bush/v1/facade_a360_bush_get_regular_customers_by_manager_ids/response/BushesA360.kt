package ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_regular_customers_by_manager_ids.response

data class BushesA360(
    val activeFrom: String?,
    val activeTo: Any?,
    val bushAction360ChangesCount: Int?,
    val customers: List<Customer>?,
    val factPrice: Double?,
    val factUsersAmount: Int?,
    val id: String?,
    val mainProductId: String?,
    val maxCustomerStopListsNumber: Int?,
    val name: String?,
    val status: Int?,
    val suggestedPrice: Double?,
    val suggestedUsersAmount: Int?
)