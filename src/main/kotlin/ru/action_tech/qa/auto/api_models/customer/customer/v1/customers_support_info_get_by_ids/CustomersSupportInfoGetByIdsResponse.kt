package ru.action_tech.qa.auto.api_models.customer.customer.v1.customers_support_info_get_by_ids

data class CustomersSupportInfoGetByIdsResponse(
    val id: String,
    val supportXssTypeId: String?,
    val supportXssPartnerId: String?,
    val systemUserIdXss: String?,
    val statusXss: String?,
    val isOwnXss: Boolean?,
    val expectedSupportXssEndDate: String?,
    val supportJurTypeId: String?,
    val supportJurPartnerId: String?,
    val systemUserIdJurSrv: String?,
    val isOwnJur: Boolean?,
    val statusJur: String?,
    val supportA360TypeId: String?,
    val supportA360PartnerId: String?,
    val systemUserIdA360: String?,
    val statusA360: String?,
    val expectedSupportA360EndDate: String?,
    val isOwnA360: Boolean?
)