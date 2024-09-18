package ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager_ids.response

data class BushesA360(
    val activeFrom: String?,
    val activeTo: String?,
    val bushAction360ChangesCount: Int?,
    val customers: List<Customer>?,
    val factPrice: Int?,
    val factUsersAmount: Int?,
    val id: String,
    val mainProductId: String?,
    val maxCustomerStopListsNumber: Int?,
    val name: String?,
    val status: Int?,
    val suggestedPrice: Int?,
    val suggestedUsersAmount: Int?
)