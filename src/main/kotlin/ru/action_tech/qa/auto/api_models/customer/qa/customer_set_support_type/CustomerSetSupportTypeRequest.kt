package ru.action_tech.qa.auto.api_models.customer.qa.customer_set_support_type

import java.util.*

data class CustomerSetSupportTypeRequest(
    val customerId: UUID?,
    val supportTypeId: UUID? = null,
    val supportA360TypeId: UUID? = null,
)
