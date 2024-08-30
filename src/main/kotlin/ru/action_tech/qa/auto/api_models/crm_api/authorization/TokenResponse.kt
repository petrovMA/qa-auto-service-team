package ru.action_tech.qa.auto.api_models.crm_api.authorization

data class TokenResponse(val accessToken: String, val expiredOn: String?, val userName: String?)