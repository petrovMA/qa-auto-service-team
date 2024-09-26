package ru.action_tech.qa.auto.api_models.accesses.license.v1.access_get_subscription_by_block_id.response

data class BaseResponse(
    val createdBy: String,
    val createdOn: String,
    val currencyId: String,
    val id: String,
    val modifiedBy: String,
    val modifiedOn: String,
    val organizationId: String?,
    val ownerBusinessUnitId: String?,
    val ownerId: String?,
    val ownerType: Int,
    val stateCode: Int,
    val statusCode: Int
)