package ru.action_tech.qa.auto.api_models.erm_backend

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.erm_backend.a360_deal.a360_deals_get.A360DealsGetResponse
import ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.customer_get_by_id.CustomerGetByIdResponse
import ru.action_tech.qa.auto.api_models.erm_backend.license.v1.license_create_for_partner.LicenseCreateForPartnerRequest
import ru.action_tech.qa.auto.api_models.erm_backend.order.v1.order_get_license_preview.OrderGetLicensePreviewResponse
import ru.action_tech.qa.auto.api_models.erm_backend.shipment.v1.sendings_get_by_customer_id.SendingsGetByCustomerIdResponse
import ru.action_tech.qa.auto.api_models.erm_backend.support.v1.supports_get_by_manager.SupportsGetByManagerResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenActionushka
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams


object ErmBackendRequests {

    fun a360DealGet(token: String? = tokenAutoActionushka) = TRequest(
        model = Model<Array<A360DealsGetResponse>>(),
        desc = "Получение списка сделок A360",
        spec = { token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") } },
        send = { get(a360DealsGet) }
    )

    fun sendingsGetByCustomerId(
        id: String? = null,
        limitSendingData: Boolean? = null,
        limit: String? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        model = Model<Array<SendingsGetByCustomerIdResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            id?.let { addQueryParam(QueryParams.ID, it) }
            limitSendingData?.let { addQueryParam(QueryParams.LIMIT_SENDING_DATA, it) }
            limit?.let { addQueryParam(QueryParams.LIMIT, it) }
        },
        desc = "Получения списка отправлений по ID клиента",
        send = { get("/api/v1/sendings_get-by-customer-id") }
    )

    fun customerGetById(customerId: String? = null, token: String? = tokenActionushka) = TRequest(
        desc = "Получить информацию о клиенте по идентификатору",
        model = Model<CustomerGetByIdResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
        },
        send = { get(customerGetById) }
    )

    fun supportsGetByManager(
        managerId: String,
        supportType: Int,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        model = Model<Array<SupportsGetByManagerResponse>>(),
        desc = "Получить список сопровождений менеджера",
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            addQueryParam(QueryParams.MANAGER_ID, managerId)
            addQueryParam(QueryParams.SUPPORT_TYPE, supportType)
        },
        send = { get("/api/v1/supports_get-by-manager") }
    )

    fun orderGetLicensePreview(orderId: String? = null, token: String? = tokenAutoActionushka) = TRequest(
        desc = "Получить модель заказа для просмотра перед регистрацией УКД",
        model = Model<OrderGetLicensePreviewResponse>(),
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            orderId?.let { addQueryParam(QueryParams.ORDER_ID, it) }
        },
        send = { get("/api/v1/order_get-license-preview") }
    )

    fun licenseCreateForPartner(
        request: LicenseCreateForPartnerRequest? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        desc = "Создать заявку на регистрацию УКД",
        model = Model<Array<String>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            request?.let { setBody(it) }
        },
        send = { post("/api/v1/license_create-for-partner") }
    )
}