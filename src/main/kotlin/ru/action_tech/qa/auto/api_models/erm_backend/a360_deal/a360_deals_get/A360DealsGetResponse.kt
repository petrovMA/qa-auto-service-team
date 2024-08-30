package ru.action_tech.qa.auto.api_models.erm_backend.a360_deal.a360_deals_get

data class A360DealsGetResponse(
    val comment: Comment?,
    val customers: Array<Customer>,
    val dateFrom: String,
    val dateTo: String?,
    val dealType: Int,
    val id: String,
    val mainProductId: String,
    val mainProductName: String,
    val manager: Manager,
    val maxCustomerStopListsNumber: Int,
    val moderationState: Int,
    val number: String,
    val price: Double,
    val userCount: Int,
    val suggestedPrice: Double,
    val suggestedUsersAmount: Int
) {
    data class Customer(
        val holdCount: Int,
        val id: String,
        val inn: String?,
        val name: String,
        val pin: String,
        val recommendedPrice: Double,
        val recommendedUserCount: Int,
        val hasActiveUkd: Boolean,
        val analysisBushesCustomersCount: Int
    )

    data class Comment(
        val author: Author,
        val comment: String?,
        val commentDate: String,
        val id: String
    ) {
        data class Author(
            val avatar: String?,
            val fullName: String,
            val id: String
        )
    }

    data class Manager(
        val avatar: Any?,
        val id: String,
        val name: String
    )
}