package ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_add

data class StorageAccessAddRequest(
    val accessType: String?,
    val activation: Activation? = null,
    val attributes: Attributes?,
    val codeValue: String? = null,
    val commonId: String? = null,
    val dateEnd: String?,
    val dateStart: String?,
    val paidAccessStatusId: Int? = null,
    val productVersion: Int? = null,
    val productVersionId: String?,
    val simpleProduct: String? = null,
    val userId: Int? = null
) {
    data class Activation(
        val activationInterval: String?,
        val activationType: String?,
        val interval: Int?
    )

    data class Attributes(
        val activateDate: String?,
        val attributeList: List<Attribute>? = null,
        val dsgNumber: Int? = null,
        val salesDate: String? = null,
        val salesDealer: String? = null,
        val source: String? = null,
        val supportDealer: String? = null,
        val userCount: Long?
    ) {
        data class Attribute(
            val key: String?,
            val value: String?
        )
    }
}