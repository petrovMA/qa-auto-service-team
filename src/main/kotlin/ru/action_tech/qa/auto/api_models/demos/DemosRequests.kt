package ru.action_tech.qa.auto.api_models.demos

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demo.CreateDemoRequest
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demo.CreateDemoResponse
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demo.GetDemoResponse
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.demoAccess_get_list_by_contacts.DemoAccessGetListByContactsResponse
import ru.action_tech.qa.auto.api_models.demos.demoaccess.v1.info.DemoInfoResponse
import ru.action_tech.qa.auto.api_models.demos.license.v1.forcustomer.ForCustomerResponse
import ru.action_tech.qa.auto.api_models.demos.license.v1.license.ResponseLicense
import ru.action_tech.qa.auto.api_models.demos.license.v1.license_get_by_subscribe.LicenseGetBySubscribeResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams

object DemosRequests {

    fun createDemo(request: CreateDemoRequest, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<CreateDemoResponse>(),
        desc = "Создание демодоступа",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post(demoV1) }
    )

    fun getDemo(id: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<GetDemoResponse>(),
        desc = "Получить демо-доступ по идентификатору",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            id?.let { addQueryParam(QueryParams.ID, it) }
        },
        send = { get(demoV1) }
    )

    fun getInfo(authCode: String?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<DemoInfoResponse>(),
        desc = "Возвращает информацию об УКД демодоступа",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            authCode?.let { addQueryParam(QueryParams.AUTH_CODE, it) }
        },
        send = { get(demoAccessInfoV1) }
    )

    fun jobTitles(token: String? = tokenAutoActionushka) = TRequest(
        model = Model<Array<CommonDtoNameNullable>>(),
        desc = "Возвращает список должностей",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { get(jobTitlesV1) }
    )

    fun deactivateDemoAccess(demoaccessId: String?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<Boolean>(),
        desc = "Деактивация УКД демодоступа",
        spec = {
            setContentType(ContentType.JSON)
            demoaccessId?.let { addQueryParam(QueryParams.DEMO_ACCESS_ID, it) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/v1/demoaccess/deactivate") }
    )

    fun getDemoAccessGetListByContacts(ids: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<Array<DemoAccessGetListByContactsResponse>>(),
        desc = "Возвращает список демо доступов по списку контактов",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            ids?.let { addQueryParam(QueryParams.IDS, ids) }
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/demo-access_get-list-by-contacts") }
    )

    fun licenseGetBySubscribe(subscribeId: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<LicenseGetBySubscribeResponse>(),
        desc = "Возвращает УКД c датой начала активации по ид содержимого заказа",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            subscribeId?.let { addQueryParam(QueryParams.SUBSCRIBE_ID, it) }
            setUrlEncodingEnabled(true)
        },
        send = { get(licenseGetBySubscribeV1) }
    )

    fun getLicenseV1(id: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<ResponseLicense>(),
        desc = "Возвращает УКД",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            id?.let { addQueryParam(QueryParams.ID, it) }
            setUrlEncodingEnabled(true)
        },
        send = { get(licenseV1) }
    )

    fun getLicenseV2(id: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<ResponseLicense>(),
        desc = "Возвращает УКД c датой начала активации",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            id?.let { addQueryParam(QueryParams.ID, it) }
            setUrlEncodingEnabled(true)
        },
        send = { get(licenseV2) }
    )

    fun getLicenseForCustomer(
        customerId: String? = null,
        dateStart: String? = null,
        dateEnd: String? = null,
        includeLocked: Any? = null,
        onlyWithPrice: Any? = null,
        systemUserId: Any? = null,
        licenseId: Any? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        model = Model<Array<ForCustomerResponse>>(),
        desc = "Получить список УКД по клиенту за указанный период",
        spec = {
            addHeader(Headers.CONTENT_TYPE, "application/json")
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
            dateStart?.let { addQueryParam(QueryParams.DATE_START, it) }
            dateEnd?.let { addQueryParam(QueryParams.DATE_END, it) }
            includeLocked?.let { addQueryParam(QueryParams.INCLUDE_LOCKED, it) }
            onlyWithPrice?.let { addQueryParam(QueryParams.ONLY_WITH_PRICE, it) }
            systemUserId?.let { addQueryParam(QueryParams.SYSTEM_USER_ID, it) }
            licenseId?.let { addQueryParam(QueryParams.LICENSE_ID, it) }
        },
        send = { get(licensesForCustomerV1) }
    )
}