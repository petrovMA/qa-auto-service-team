package ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_get_by_id

data class Activation(
    val activationInterval: String?,
    val activationType: String?,
    val interval: Int?
)