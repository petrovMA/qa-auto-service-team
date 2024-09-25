package ru.action_tech.qa.auto.api_models.access_backend

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.api_models.access_backend.access.v1.access_deactivate.AccessDeactivateRequest
import ru.action_tech.qa.auto.api_models.access_backend.access.v1.access_deactivate.AccessDeactivateResponse
import ru.action_tech.qa.auto.api_models.access_backend.access.v1.access_update.AccessUpdateRequest
import ru.action_tech.qa.auto.api_models.access_backend.access.v1.access_update.AccessUpdateResponse
import ru.action_tech.qa.auto.api_models.access_backend.access.v2.user_get_active.response.UserGetActiveResponse
import ru.action_tech.qa.auto.api_models.access_backend.v1.qa.AccessCreateResponse
import ru.action_tech.qa.auto.api_models.access_backend.v1.qa.models.CreateAccessQARequest
import ru.action_tech.qa.auto.utils.http.QueryParams


object AccessBackendRequests {

    fun accessUserGetActive(userId: Int? = null) = TRequest(
        desc = "Получить активные доступы пользователя",
        model = Model<UserGetActiveResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            userId?.let { addQueryParam(QueryParams.USER_ID, it) }
        },
        send = { get("/api/v2/access/user_get-active") }
    )

    fun accessUpdate(request: AccessUpdateRequest? = null) = TRequest(
        desc = "Отредактировать доступ",
        model = Model<AccessUpdateResponse>(),
        spec = { setBody(request) },
        send = { post("/api/v1/access_update") }
    )

    fun accessDeactivate(request: AccessDeactivateRequest? = null) = TRequest(
        desc = "Отключить доступ",
        model = Model<AccessDeactivateResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            request?.accessId?.let { addQueryParam(QueryParams.ACCESS_ID, it) }
        },
        send = { post("/api/v1/access_deactivate") }
    )

    fun qaAccessCreate(data: CreateAccessQARequest) = TRequest(
        desc = "[QA-API]: Создать доступ",
        model = Model<AccessCreateResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(data.toString())
        },
        send = { post("/api/qa/v1/access_create") }
    )

    fun accessCreate(data: CreateAccessQARequest) = TRequest(
        desc = "Запрос на создание доступа",
        model = Model<AccessCreateResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(data.toString())
        },
        send = { post("/api/v1/access_create") }
    )
}