package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_id.response

data class Base(
    val createdBy: String?,
    val createdOn: String?,
    val currencyId: String?,
    val id: String?,
    val modifiedBy: String?,
    val modifiedOn: String?,
    val organizationId: String?,
    val ownerBusinessUnitId: String?,
    val ownerId: String?,
    val ownerType: Int?,
    val statecode: Int?,
    val statuscode: Int?
)