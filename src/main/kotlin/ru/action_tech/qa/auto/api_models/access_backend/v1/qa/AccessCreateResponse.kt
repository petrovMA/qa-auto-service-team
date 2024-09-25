package ru.action_tech.qa.auto.api_models.access_backend.v1.qa

import ru.action_tech.qa.auto.core.serialization.facade.Deserializable
import ru.action_tech.qa.auto.core.serialization.facade.Serializable

data class AccessCreateResponse(val access: Access) : Serializable {

    companion object : Deserializable<AccessCreateResponse>

    override fun toString(): String = serialize()

    data class Access(
        val accessType: String,
        val activation: Activation,
        val attributes: Attributes,
        val baseProduct: String,
        val codeValue: String,
        val commonId: String,
        val createDate: String,
        val dateEnd: String,
        val dateStart: String,
        val isActive: Boolean,
        val isSlave: Boolean,
        val paidAccessStatusId: Int?,
        val productVersion: Int,
        val productVersionId: String?,
        val simpleProduct: String,
        val slaveIds: List<Int>,
        val userId: Int?,
        val version: Version
    )

    data class Activation(
        val activationInterval: String?,
        val activationType: String?,
        val interval: Int?
    )

    data class Attributes(
        val ActivateDate: String?,
        val AttributeList: List<Attribute>,
        val DsgNumber: Int,
        val SalesDate: String?,
        val SalesDealer: String?,
        val SupportDealer: String?,
        val UserCount: Int,
        val source: String,
        val parentId: String?,
        val structureType: String?
    ) {
        data class Attribute(val key: String, val value: String?)
    }

    data class Version(val timestamp: String, val version: Int)
}
