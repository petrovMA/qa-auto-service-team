package ru.action_tech.qa.auto.api_models.identity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserInfoResponse(
    @JsonProperty("apc_login")
    val apcLogin: String?,
    @JsonProperty("apc_password")
    val apcPassword: String?,
    @JsonProperty("apc_worklist")
    val apcWorkList: String?,
    @JsonProperty("avaya_extension")
    val avayaExtension: String?,
    @JsonProperty("bitrixid")
    val bitrixId: String,
    @JsonProperty("bonverreq")
    val bonVerReq: String,
    @JsonProperty("bunitid")
    val bUnitId: String,
    @JsonProperty("cityid")
    val cityId: String,
    @JsonProperty("cityname")
    val cityName: String,
    @JsonProperty("dcaid")
    val dcaId: String?,
    @JsonProperty("dcaname")
    val dcaName: String?,
    @JsonProperty("domainname")
    val domainName: String,
    val email: String,
    @JsonProperty("ermlogging")
    val ermLogging: String?,
    @JsonProperty("filialid")
    val filialId: String,
    val firstname: String,
    @JsonProperty("hide_actions_client")
    val hideActionsClient: String,
    @JsonProperty("incoming_monitor")
    val incomingMonitor: String,
    @JsonProperty("isavaya")
    val isAvaya: String?,
    @JsonProperty("issip")
    val isSip: String,
    @JsonProperty("isukdrequire")
    val isUkdRequire: String,
    @JsonProperty("mo_isproringdate")
    val moIsProRingDate: String,
    val name: String,
    @JsonProperty("partner_country")
    val partnerCountry: String,
    @JsonProperty("partnerid")
    val partnerId: String,
    val photo: String?,
    val role: List<String>,
    @JsonProperty("saleschannel")
    val salesChannel: String,
    @JsonProperty("salesmainchid")
    val salesMainChId: String,
    @JsonProperty("salesproducttype")
    val salesProductType: String?,
    val sub: String,
    @JsonProperty("timeend")
    val timeEnd: String?,
    @JsonProperty("timestart")
    val timeStart: String?,
    @JsonProperty("vtm_campaignid")
    val VtmCampaignId: String,
)
