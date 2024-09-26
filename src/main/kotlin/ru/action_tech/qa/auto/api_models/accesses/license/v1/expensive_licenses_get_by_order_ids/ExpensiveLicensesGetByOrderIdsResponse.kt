package ru.action_tech.qa.auto.api_models.accesses.license.v1.expensive_licenses_get_by_order_ids

import java.util.*

data class ExpensiveLicensesGetByOrderIdsResponse(val authCode: String, val licenseId: UUID, val orderId: UUID)