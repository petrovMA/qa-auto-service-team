package ru.action_tech.qa.auto.api_models.access_backend.access.v1.access_update

data class AccessUpdateRequest(
    val commonId: String,
    val userId: Int? = null,
    val productVersion: Int,
    val simpleProduct: String? = null,
    val accessType: String,
    val dateStart: String,
    val dateEnd: String,
    val attributes: Attributes,
    val productVersionId: String? = null,
    val paidAccessStatusId: Int? = null,
    val activation: Activation?
) {
    data class Attributes(
        val activateDate: String? = null,
        val userCount: Int,
        val dsgNumber: Int,
        val supportDealer: String? = null,
        val salesDealer: String? = null,
        val salesDate: String? = null,
        val logChangedBy: String? = null,
        val logDescription: String? = null,
        val logNote: String? = null,
        val logOperator: String? = null,
        val attributeList: List<Attribute>? = null,
        val source: String,
        val structureType: String,
        val parentId: String? = null,
        val quality: String,
        val buyerOrganizationId: String? = null
    ) {
        data class Attribute(
            val key: String? = null,
            val value: String? = null
        )
    }

    data class Activation(
        val activationType: String,
        val activationInterval: String,
        val interval: Int? = null
    )
}