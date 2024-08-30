package ru.action_tech.qa.auto.api_models.crm_api.authorization

data class TokenRequest(val appId: String, val secretKey: String? = null, val login: String? = null)