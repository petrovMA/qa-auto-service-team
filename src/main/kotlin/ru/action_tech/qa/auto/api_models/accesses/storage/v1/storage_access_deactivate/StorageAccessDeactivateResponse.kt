package ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate

data class StorageAccessDeactivateResponse(
    val baseProduct: String?,
    val isActive: Boolean?,
    val isSlave: Boolean?,
    val slaveIds: List<Int?>?,
    val createDate: String?,
    val licenseStatus: Int?,
    val version: Version?,
    val commonId: String?,
    val userId: Int?,
    val codeValue: String?,
    val code: String?,
    val simpleProduct: String?,
    val productVersion: Int?,
    val accessType: String?,
    val productVersionId: String?,
    val paidAccessStatusId: Int?,
    val dateStart: String?,
    val dateEnd: String?,
    val attributes: Attributes?,
    val activation: Activation?
) {
    data class Version(
        val version: Int?,
        val timestamp: String?
    )

    data class Attributes(
        val activateDate: String?,
        val userCount: Int?,
        val dsgNumber: Int?,
        val supportDealer: String?,
        val salesDealer: String?,
        val salesDate: String?,
        val attributeList: List<Attribute?>?,
        val source: String?,
        val structureType: String?,
        val parentId: String?,
        val quality: String?,
        val buyerOrganizationId: String?
    ) {
        data class Attribute(
            val key: String?,
            val value: String?
        )
    }

    data class Activation(
        val activationType: String?,
        val activationInterval: String?,
        val interval: Int?
    )
}