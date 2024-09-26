package ru.action_tech.qa.auto.api_models.customer

import com.fasterxml.jackson.databind.JsonNode
import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.customer.customer.v1.connect.ConnectOrgAndClientRequest
import ru.action_tech.qa.auto.api_models.customer.customer.v1.contacts.ContactsResponse
import ru.action_tech.qa.auto.api_models.customer.customer.v1.create.CreateOrganizationRequest
import ru.action_tech.qa.auto.api_models.customer.customer.v1.create.CreateOrganizationResponse
import ru.action_tech.qa.auto.api_models.customer.customer.v1.customer_get_by_pin.CustomerGetByPinResponse
import ru.action_tech.qa.auto.api_models.customer.customer.v1.info_get.InfoResponse
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customers_unhold_by_ids.CustomersUnholdByIdsRequest
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold.CustomerHoldRequest
import ru.action_tech.qa.auto.api_models.customer.search.v1.customers.search_customers.SearchCustomersRequest
import ru.action_tech.qa.auto.api_models.customer.search.v1.customers.search_customers.SearchCustomersResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.api_models.customer.qa.customer_set_support_partners.CustomerSetSupportPartnersRequest
import ru.action_tech.qa.auto.api_models.customer.qa.customer_set_support_type.CustomerSetSupportTypeRequest
import ru.action_tech.qa.auto.api_models.customer.customer.v1.info_bybitrix.InfoByBitrixRequest
import ru.action_tech.qa.auto.api_models.customer.customer.v1.info_bybitrix.InfoBybitrixResponse
import ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.create_user.CreateUserRequest
import ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.create_user.CreateUserResponse
import ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.organization_info.OrganizationInfoResponse
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.auth.tokenQA
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams


object CustomersRequests {

    fun customersUnholdByIds(
        request: CustomersUnholdByIdsRequest?, token: String? = tokenQA
    ) = Request(
        desc = "Unhold клиента по id",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/v1/customers_unhold-by-ids") }
    )

    fun customerHold(request: CustomerHoldRequest?, token: String? = tokenQA) = Request(
        desc = "Холдируем клиента",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/v1/customer_hold") }
    )

    fun createOrganization(
        request: CreateOrganizationRequest = CreateOrganizationRequest(),
        token: String? = tokenAutoActionushka
    ) = TRequest(
        model = Model<CreateOrganizationResponse>(),
        desc = "Создание юр.лица",
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post("/api/v1/create") }
    )

    fun search(
        request: SearchCustomersRequest?,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        model = Model<SearchCustomersResponse>(),
        desc = "Поиск клиентов",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request?.let { setBody(it) }
        },
        send = { post("/api/v1/search/customers") }
    )

    fun getInfo(customerId: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<InfoResponse>(),
        desc = "Получить информацию о клиенте",
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setUrlEncodingEnabled(true)
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
        },
        send = { get("/api/v1/info") }
    )

    fun customerSetSupportPartners(request: CustomerSetSupportPartnersRequest?, token: String? = tokenQA) = Request(
        desc = "Устанавливаем партнёра сопровождения для клиента",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/v1/customer-set-support-partners") }
    )

    fun customerSetSupportType(request: CustomerSetSupportTypeRequest?, token: String? = tokenQA) = Request(
        desc = "Устанавливаем тип сопровождения для клиента",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/v1/customer-set-support-type") }
    )

    fun connect(request: ConnectOrgAndClientRequest, token: String? = tokenAutoActionushka) = Request(
        desc = "Создание связи клиента с контактным лицом",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post("/api/v1/connect") }
    )

    fun connectionDeleteByPin(request: Any, token: String? = tokenQA) = Request(
        desc = "Удаляем связь клиента с контактным лицом",
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post("/api/qa/v1/connection_delete-by-pin") }
    )

    fun customersSupportInfoGetByIds(ids: Array<String?>? = null, token: String? = tokenAutoActionushka) = TRequest(
        desc = "Получить информацию о сопровождении клиентов по списку ИД",
        model = Model<JsonNode>(),
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            ids?.let { addQueryParam(QueryParams.IDS, ids) }
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/customers-support-info_get_by-ids") }
    )

    fun getContacts(customerId: String?, includeLocked: Boolean = false, token: String? = tokenAutoActionushka) =
        TRequest(
            model = Model<Array<ContactsResponse?>>(),
            desc = "Получить связанные контакты",
            spec = {
                addHeader(Headers.AUTHORIZATION, "Bearer $token")
                addQueryParam(QueryParams.CUSTOMER_ID, customerId)
                addQueryParam(QueryParams.INCLUDE_LOCKED, includeLocked)
            },
            send = { get("/api/v1/contacts") }
        )


    fun infoByBitrix(request: InfoByBitrixRequest?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<Array<InfoBybitrixResponse>>(),
        desc = "Возвращает список клиентов по bitrixid",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request?.let { setBody(it) }
        },
        send = { post("/api/v1/info/bybitrix") }
    )

    fun organizationInfo(customerId: String?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<OrganizationInfoResponse>(),
        desc = "Возврат информации о клиенте",
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            addQueryParam(QueryParams.CUSTOMER_ID, customerId)
        },
        send = { get("/api/v1/info") }
    )

    fun createUser(request: CreateUserRequest, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<CreateUserResponse>(),
        desc = "Создание физ.лица",
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post("/api/v1/create") }
    )

    fun getCustomerGetByPin(pin: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<CustomerGetByPinResponse>(),
        desc = "Возвращает информацию о клиенте по его PIN",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            pin?.let { addQueryParam(QueryParams.PIN, it) }
        },
        send = { get("/api/v1/customer_get-by-pin") }
    )
}