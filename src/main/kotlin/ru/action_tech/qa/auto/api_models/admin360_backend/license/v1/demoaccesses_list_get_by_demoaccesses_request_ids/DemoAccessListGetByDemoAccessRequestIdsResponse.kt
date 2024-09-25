package ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.demoaccesses_list_get_by_demoaccesses_request_ids

import com.fasterxml.jackson.databind.JsonNode

data class DemoAccessListGetByDemoAccessRequestIdsResponse(
    val accessId: String,
    val accountInn: String,
    val accountName: String,
    val accountPin: String,
    val createdOn: String,
    val lastEntryOn: JsonNode?,
    val partnerName: String,
    val versionName: String
)