package ru.action_tech.qa.auto.api_models.customer.qa.customer_set_support_partners

import java.util.*

data class CustomerSetSupportPartnersRequest(
    val customerId: UUID?,
    val supportPartnerId: UUID? = null,
    val supportA360PartnerId: UUID? = null,
)
