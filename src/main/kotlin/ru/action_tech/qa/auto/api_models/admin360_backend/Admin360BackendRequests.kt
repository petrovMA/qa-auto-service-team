package ru.action_tech.qa.auto.api_models.admin360_backend

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.admin360_backend.customer.v1.contact_get_by_id.ContactGetByIdResponse
import ru.action_tech.qa.auto.api_models.admin360_backend.customer.v1.contact_search.ContactSearchResponse
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_accept.Action360RequestForAccessAcceptRequest
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_add.Action360RequestForAccessAddRequest
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_add.Action360RequestForAccessAddResponse
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.action360_request_for_access_get_by_user.Action360RequestForAccessGetByUserResponse
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.demoaccess_get_by_id.DemoAccessGetByIdResponse
import ru.action_tech.qa.auto.api_models.admin360_backend.license.v1.demoaccesses_list_get_by_demoaccesses_request_ids.DemoAccessListGetByDemoAccessRequestIdsResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams
import ru.action_tech.qa.auto.utils.urlEncode


object Admin360BackendRequests {

    fun contactSearch(email: String? = null) = TRequest(
        desc = "Поиск клиента по email",
        model = Model<ContactSearchResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $tokenAutoActionushka")
            email?.let { addQueryParam(QueryParams.EMAIL, it) }
        },
        send = { get("/api/v1/contact_search") }
    )

    fun contactGetById(customerId: String? = null) = TRequest(
        desc = "Метод получения данных физ. лица по его Id: customerId = $customerId",
        model = Model<ContactGetByIdResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $tokenAutoActionushka")
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
        },
        send = { get("/api/v1/contact_get-by-id") }
    )

    fun jobTitlesGet(token: String? = tokenAutoActionushka) = TRequest(
        desc = "Должности клиента",
        model = Model<Array<CommonDtoNameNullable>>(),
        spec = {
            setContentType(ContentType.JSON)
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { get("/api/v1/jobtitles_get") }
    )

    fun demoAccessListGetByDemoAccessRequestIds(
        vararg items: String, includeInactive: Boolean? = null, token: String = tokenAutoActionushka
    ) = TRequest(
        desc = "Метод возвращающий список ДД по массиву id заявок на ДД",
        model = Model<Array<DemoAccessListGetByDemoAccessRequestIdsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            includeInactive?.let { addQueryParam(QueryParams.INCLUDE_INACTIVE, it) }
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setBody(items)
        },
        send = { post("/api/v1/demoaccess-list_get-by-demoaccess-request-ids") }
    )

    fun demoAccessGetById(id: String? = null, token: String = tokenAutoActionushka) = TRequest(
        desc = "Метод получения детальных данных по Id ДД: id = $id",
        model = Model<DemoAccessGetByIdResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            id?.let { addQueryParam(QueryParams.ID, it) }
        },
        send = { get("/api/v1/demoaccess_get-by-id") }
    )

    fun action360RequestsFind(
        searchExpression: String? = null,
        dateFrom: String? = null,
        dateTo: String? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        desc = "Метод поиска id заявок на ДД по фильтрам",
        model = Model<Array<CommonDtoNameNullable>>(),
        spec = {
            setContentType(ContentType.JSON)
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            searchExpression?.let { addQueryParam(QueryParams.SEARCH_EXPRESSION, it.urlEncode()) }
            dateFrom?.let { addQueryParam(QueryParams.DATE_FROM, it) }
            dateTo?.let { addQueryParam(QueryParams.DATE_TO, it) }
        },
        send = { get("/api/v1/aktion360-requests_find") }
    )

    fun action360RequestForAccessAdd(
        request: Action360RequestForAccessAddRequest,
        token: String = tokenAutoActionushka
    ) = TRequest(
        desc = "Создания заявки на выдачу А360",
        model = Model<Action360RequestForAccessAddResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setBody(request)
        },
        send = { post("/api/v1/aktion360-request-for-access_add") }
    )

    fun action360RequestForAccessGetByUser(
        dateFrom: String? = null,
        dateTo: String? = null,
        pageNumber: Int? = null,
        pageSize: Int? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        desc = "Метод получения списка заявок на ДД А360 по пользователям",
        model = Model<Array<Action360RequestForAccessGetByUserResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            dateFrom?.let { addQueryParam(QueryParams.DATE_FROM, it) }
            dateTo?.let { addQueryParam(QueryParams.DATE_TO, it) }
            pageNumber?.let { addQueryParam(QueryParams.PAGE_NUMBER, it) }
            pageSize?.let { addQueryParam(QueryParams.PAGE_SIZE, it) }
        },
        send = { get("/api/v1/aktion360-request-for-access_get-by-user") }
    )

    fun action360RequestForAccessAccept(
        request: Action360RequestForAccessAcceptRequest,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        desc = "Одобрение заявки на выдачу А360",
        model = Model<Boolean>(),
        spec = {
            setContentType(ContentType.JSON)
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setBody(request)
        },
        send = { post("/api/v1/aktion360-request-for-access_accept") }
    )
}
