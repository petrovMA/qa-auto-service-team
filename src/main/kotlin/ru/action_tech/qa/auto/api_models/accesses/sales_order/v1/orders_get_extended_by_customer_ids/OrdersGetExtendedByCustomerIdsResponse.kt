package ru.action_tech.qa.auto.api_models.accesses.sales_order.v1.orders_get_extended_by_customer_ids

data class OrdersGetExtendedByCustomerIdsResponse(
    val addressId: String?,
    val bankActionId: String?,
    val billBankActionId: String?,
    val contactSalesOrderId: String?,
    val customerId: String?,
    val customerType: Int?,
    val flSubmitDocsImmediately: Boolean?,
    val id: String?,
    val isCompletedOrderPartner: Boolean?,
    val lockDescription: Int?,
    val orderContents: List<OrderContent?>?,
    val orderSum: Int?,
    val shipmentIsAccepted: Boolean?,
    val state: Int?,
    val submitDocsDate: String?,
    val subscribes: List<Subscribe?>?
) {
    data class OrderContent(
        val amount: Int?,
        val byReturnId: String?,
        val id: String?,
        val licenseCount: Int?,
        val lockDescription: Int?,
        val ndsId: String?,
        val ndsSum: Int?,
        val productId: String?,
        val productTypeId: String?,
        val receiveCaseId: String?,
        val salesOrderId: String?,
        val shipmentStatus: Int?,
        val shippedAmount: Int?,
        val subscribeDateStart: String?,
        val subscribeId: String?,
        val totalSum: Int?,
        val totalSumSubscribe: Int?
    )

    data class Subscribe(
        val id: String?,
        val lockDescription: Int?,
        val receiveCaseId: String?,
        val salesOrderId: String?,
        val shipmentIsAccepted: Boolean?,
        val state: Int?,
        val subscribeSum: Int?
    )
}