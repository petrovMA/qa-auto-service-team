package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_user

data class Action360RequestForAccessGetByUserResponse(
    val a360DepartmentId: Int?,
    val accountid: String?,
    val base: Base?,
    val body: String?,
    val demoAccessEntity: List<DemoAccessEntity>?,
    val departmentId: Int?,
    val errorMessage: String?,
    val id: String?,
    val partnerId: String?,
    val requestContactId: String?,
    val requestSourceId: Int?,
    val status: Int?
) {
    data class DemoAccessEntity(
        val activateOn: String?,
        val authCode: String?,
        val base: Base?,
        val condition: Int?,
        val contactId: String?,
        val endOn: String?,
        val id: String?,
        val isPremium: Boolean?,
        val isRescue: Boolean?,
        val partnerId: String?,
        val productId: String?,
        val productVersionId: String?,
        val requestOn: String?,
        val requestsForDemoAccessId: String?,
        val sourceOfAccess: Int?,
        val sourceOrigin: Int?,
        val startOn: String?,
        val status: Int?,
        val systemUserId: String?,
        val utmCampaign: String?,
        val utmMedium: String?,
        val utmSource: String?,
        val version: Int?,
        val versionOn: String?
    )

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
}