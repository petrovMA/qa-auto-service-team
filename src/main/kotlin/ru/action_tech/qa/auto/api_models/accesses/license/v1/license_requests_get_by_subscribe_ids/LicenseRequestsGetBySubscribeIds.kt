package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_requests_get_by_subscribe_ids

import java.util.*

data class LicenseRequestsGetBySubscribeIds(
    val authCode: String?,
    val commonId: UUID?,
    val id: UUID,
    val result: String?,
    val saleSubscribeId: UUID?
)