package ru.action_tech.qa.auto.api_models.public_api

// region [MasterOrder]
const val orderCreateByRobot = "/api/v1/order_create-by-robot"
// endregion

// region [Customer]
const val customerGetByPinV3 = "/api/v3/customer_get-by-pin"
// endregion

//region [Manager]
const val managerSetStopListLimit = "/api/v1/manager_set-stoplist-limit"
// endregion

// region [Documents]
const val documentSendMail = "/api/v1/document_send-mail"
const val contractTemplatesGetOrderById = "api/v2/contract-templates_get-by-order-id"
const val billsGetByOrdersIds = "/api/v1/bills_get-by-orders-ids"
// endregion

//region [StopList]
const val stopListsGetByPartnerId = "/api/v1/stop-lists_get-by-partner-id"
const val stopListBindPublicApi = "/api/v1/stop-list_bind"
const val stopListBindNewCustomerPublicApi = "/api/v1/stop-list_bind-new-customer"
// endregion