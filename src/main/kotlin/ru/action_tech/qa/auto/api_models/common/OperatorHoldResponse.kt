package ru.action_tech.qa.auto.api_models.common

import com.fasterxml.jackson.annotation.JsonProperty
import ru.action_tech.qa.auto.core.serialization.facade.Deserializable
import ru.action_tech.qa.auto.core.serialization.facade.Serializable
import java.util.*

data class OperatorHoldResponse(
    val operatorId: Int,
    val operatorType: Int,
    val manager: Manager
) : Serializable {
    companion object : Deserializable<OperatorHoldResponse>

    override fun toString(): String = serialize.strict.toJson()
    data class Manager(
        val fullName: String?,
        val systemUserId: String,
        val email: String?,
        val partnerId: UUID?,
        val unitId: UUID?,
        val positionsProductTypeId: UUID?,
        val partnerEmail: String?,
        val countryId: UUID?,
        val maxSecondsInWrapupStatus: Int?,
        val unitName: String?,
        val isService: Boolean?,
        val positionsPortal: String?,
        val positionsPositionName: String?,
        val photo: String?,
        val birthday: String?,
        val mobilePhone: String?,
        val domainName: String?,
        val filialName: String?,
        val filialId: UUID?,
        val positionsPositionId: String?,
        val positionsDirectionName: String?,
        val positionsDirectionId: UUID?,
        val positionsProductTypeName: String?,
        val positionsCategoryName: String?,
        val positionsCategoryId: UUID?,
        val avayaExtension: String?,
        val portalId: Int?,
        val vacationFrom: String?,
        val vacationTo: String?,
        val vacation: String?,
        @JsonProperty("?isVacation") val vacationIs: Boolean?,
        val chiefId: UUID?,
        val chiefName: String?,
        val chiefEmail: String?,
        val chiefAvaya: String?,
        val chiefDirectionId: UUID?,
        val chiefDirectionName: String?,
        val chiefDirectionEmail: String?,
        val chiefDirectionAvaya: String?,
        val diagnosis: String?,
        val isLockedCall: Boolean?,
        val isMultiCampaign: Boolean?,
        val salesChannelId: UUID?,
        val mainChannelOfSalesId: UUID?,
        val dismissal: Boolean?
    ) : Serializable {
        companion object : Deserializable<Manager>

        override fun toString(): String = serialize.strict.toJson()
    }
}
