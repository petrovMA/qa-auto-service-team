package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_states_get_by_subscribe_ids

class LicenseStatesGetBySubscribeIdsResponse :
    ArrayList<LicenseStatesGetBySubscribeIdsResponse.LicenseStatesGetBySubscribeIdsResponseItem>() {
    data class LicenseStatesGetBySubscribeIdsResponseItem(
        val licenseId: String,
        val licenseStatus: Int,
        val modifiedOn: String,
        val subscribeId: String
    )
}