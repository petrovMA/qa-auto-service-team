package ru.action_tech.qa.auto.api_models.admin360_backend.customer.v1.contact_search

data class ContactSearchResponse(
    val additionalPhone: String?,
    val email: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val middleName: String,
    val phone: String?,
    val post: Post
) {
    data class Post(val id: String?, val name: String?)
}