package ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demoAccess_get_list_by_contacts

data class DemoAccessGetListByContactsResponse(
    val contactId: String,
    val contactName: String?,
    val date: String,
    val mainProductId: String,
    val productName: String?,
    val activeStart: String?,
    val activeEnd: String?,
    val contactEmail: String?,
    val authorId: String,
    val authorName: String?,
    val authorUnitName: String?,
    val jobTitleName: String?,
    val countVisits: Int,
    val timeOnSite: Int,
    val countRequestUser: Int,
    val countVisitUser: Int,
    val countDays: Int,
    val flagsUnsubmitted: Boolean
)