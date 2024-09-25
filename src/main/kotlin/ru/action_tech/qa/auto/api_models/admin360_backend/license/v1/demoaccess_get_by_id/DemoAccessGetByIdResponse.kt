package ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.demoaccess_get_by_id

data class DemoAccessGetByIdResponse(
    val accountPin: String,
    val author: Author,
    val code: String,
    val dateFrom: String,
    val dateTo: String,
    val masterContactId: String,
    val product: Product,
    val block: List<Block>?
) {
    data class Author(val name: String, val partnerName: String)
    data class Product(val userAmount: String, val versionName: String?, val versionNumber: String?)

    data class Block(
        val accountPin: String?,
        val author: String?,
        val block: Block?,
        val code: String,
        val dateFrom: String,
        val dateTo: String,
        val masterContactId: String?,
        val product: Product
    )
}