package ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_regular_customers.request

data class FacadeA360BushUpdateRegularCustomersRequest(
    val bushAction360Id: String?,
    val customerIds: List<String?>?,
    val factPrice: Int?,
    val factUsersAmount: Int?,
    val systemUserId: String?
)