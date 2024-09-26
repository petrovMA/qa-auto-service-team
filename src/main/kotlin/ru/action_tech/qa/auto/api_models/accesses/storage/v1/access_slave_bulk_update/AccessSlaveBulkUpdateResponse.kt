package ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_bulk_update

data class AccessSlaveBulkUpdateResponse(
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
) {
    data class Activation(
        val activationInterval: String?,
        val activationType: String?,
        val interval: Int?
    )

    data class Attributes(
        val activateDate: String?,
        val attributeList: List<Attribute>?,
        val dsgNumber: Int?,
        val salesDate: String?,
        val salesDealer: String?,
        val source: String?,
        val supportDealer: String?,
        val userCount: Int?
    ) {
        data class Attribute(val key: String?, val value: String?)
    }

    data class Version(val timestamp: String?, val version: Int?)
}