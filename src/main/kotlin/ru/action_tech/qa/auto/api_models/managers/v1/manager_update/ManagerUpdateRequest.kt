package ru.action_tech.qa.auto.api_models.managers.v1.manager_update

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ManagerUpdateRequest(
    val managerId: Any? = null,
    val businessUnitId: Any? = null,
    val categoryId: Any? = null,
    val directionId: Any? = null,
    val positionId: Any? = null,
    val productTypeId: Any? = null,
    @JsonProperty("isLockedCall")
    val lockedCallIs: Any? = null,
    @JsonProperty("isMultiCampaign")
    val multiCampaignIs: Any? = null,
)
