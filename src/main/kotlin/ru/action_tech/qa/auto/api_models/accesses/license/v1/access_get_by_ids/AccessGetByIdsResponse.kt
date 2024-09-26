package ru.action_tech.qa.auto.api_models.accesses.license.v1.access_get_by_ids

class AccessGetByIdsResponse : ArrayList<AccessGetByIdsResponse.AccessGetByIdsResponseItem>() {
    data class AccessGetByIdsResponseItem(
        val accessType: Int?,
        val activateOn: String?,
        val authCode: String?,
        val id: String,
        val partnerSubscribeId: String?,
        val salesPartnerId: String?,
        val supportPartnerId: String?
    )
}