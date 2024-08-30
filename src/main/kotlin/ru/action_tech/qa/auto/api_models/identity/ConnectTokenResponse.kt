package ru.action_tech.qa.auto.api_models.identity

import com.fasterxml.jackson.annotation.JsonProperty

data class ConnectTokenResponse(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("expires_in")
    val expiresIn: Long,
    @JsonProperty("token_type")
    val tokenType: String,
)
