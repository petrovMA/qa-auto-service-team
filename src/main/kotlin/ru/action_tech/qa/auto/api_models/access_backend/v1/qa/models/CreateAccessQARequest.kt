package ru.action_tech.qa.auto.api_models.access_backend.v1.qa.models

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import ru.action_tech.qa.auto.api_models.access_backend.AccessSource
import ru.action_tech.qa.auto.api_models.access_backend.AccessType
import ru.action_tech.qa.auto.api_models.access_backend.ActivationInterval.DAY
import ru.action_tech.qa.auto.api_models.access_backend.ActivationType.FIXED_START_DATE_AFTER_ACTIVATION
import ru.action_tech.qa.auto.data.ProductData
import java.time.LocalDateTime

data class CreateAccessQARequest(
    val userId: Int? = null,
    val productVersion: Int? = ProductData.PRODUCT_VERSION,
    val simpleProduct: String? = ProductData.SIMPLE_PRODUCT,
    val accessType: String = AccessType.DEMO_ACCESS,
    val dateStart: String = LocalDateTime.now().minusDays(1).toString().substringBeforeLast("."),
    val dateEnd: String = LocalDateTime.now().plusDays(10).toString().substringBeforeLast("."),
    val attributes: Attributes = Attributes(),
    val activation: Activation = Activation(),
    val paidAccessStatusId: Int? = null,
    val slaveIds: List<Int?> = emptyList()
) {
    override fun toString() = jacksonObjectMapper().writeValueAsString(this)

    data class Attributes(
        val activateDate: String = LocalDateTime.now().toString().substringBeforeLast("."),
        val userCount: Int = 2,
        val dsgNumber: Int = 0,
        val supportDealer: String? = null,
        val salesDealer: String? = null,
        val salesDate: String? = null,
        val attributeList: List<Attribute> = emptyList(),
        val source: String? = AccessSource.QA,
        val parentId: String? = null,
        val structureType: String? = null
    ) {
        override fun toString() = jacksonObjectMapper().writeValueAsString(this)

        data class Attribute(
            val key: String? = null,
            val value: String? = null
        ) {
            override fun toString() = jacksonObjectMapper().writeValueAsString(this)
        }
    }

    data class Activation(
        val activationType: String = FIXED_START_DATE_AFTER_ACTIVATION,
        val activationInterval: String = DAY,
        val interval: Int = 10
    ) {
        override fun toString() = jacksonObjectMapper().writeValueAsString(this)
    }
}