package ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_get_by_code.response

data class StorageAccessGetByCodeResponse(
    val accessType: String?,
    val activation: Activation?,
    val attributes: Attributes?,
    val baseProduct: String?,
    val code: String?,
    val codeValue: String?,
    val commonId: String?,
    val createDate: String?,
    val dateEnd: String?,
    val dateStart: String?,
    val isActive: Boolean?,
    val isSlave: Boolean?,
    val licenseStatus: Int?,
    val paidAccessStatusId: Int?,
    val productVersion: Int?,
    val productVersionId: String?,
    val simpleProduct: String?,
    val slaveIds: List<Int>?,
    val userId: Int?,
    val version: Version?
)