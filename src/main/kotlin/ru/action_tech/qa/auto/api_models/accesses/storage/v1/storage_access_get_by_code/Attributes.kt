package ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_get_by_code

data class Attributes(
    val activateDate: String?,
    val attributeList: List<Attribute>?,
    val dsgNumber: Int?,
    val salesDate: String?,
    val salesDealer: String?,
    val source: String?,
    val supportDealer: String?,
    val userCount: Int?
)