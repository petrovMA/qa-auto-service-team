package ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.info

data class DemoInfoResponse(
    val bitrixId: String?,
    val id: String,
    val mainProductName: String?,
    val slaveUsers: Int
)