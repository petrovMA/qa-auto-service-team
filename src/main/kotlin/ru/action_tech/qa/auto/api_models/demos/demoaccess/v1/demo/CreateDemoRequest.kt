package ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demo

data class CreateDemoRequest(
    val contactId: String,
    val mainProductNumber: Int,
    val phoneCallId: String?,
    val isRescue: Boolean?,
    val isPremium: Boolean?,
    val demoAccessId: String? = null
)