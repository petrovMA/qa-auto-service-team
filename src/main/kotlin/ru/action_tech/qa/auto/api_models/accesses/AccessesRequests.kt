package ru.action_tech.qa.auto.api_models.accesses

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate.StorageAccessDeactivateRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate.StorageAccessDeactivateResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams
import ru.action_tech.qa.auto.utils.setBody

object AccessesRequests {

    private val accessRequestsToken: String? by lazy { null }

    fun licenseGetByTaskId(request: LicenseGetByTaskIdRequest, token: String? = accessRequestsToken) = TRequest(
        desc = "Лицензия по id задачи на ее создание",
        model = Model<LicenseGetByTaskIdResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request.taskId?.let { addQueryParam(QueryParams.TASK_ID, it) }
        },
        send = { get(licenseGetByTaskId) }
    )


    fun storageAccessDeactivate(
        request: StorageAccessDeactivateRequest?,
        token: String? = accessRequestsToken,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Отключить доступ",
        model = Model<StorageAccessDeactivateResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request?.let { setBody(it, isNonNull) }
        },
        send = { post(storageAccessDeactivate) }
    )
}