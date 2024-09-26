package ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_period.response

data class Action360RequestForAccessGetByPeriodResponse(
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
)