package ru.action_tech.qa.auto.api_models.managers

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.managers.v1.role.user_roles_add.UserRolesAddRequest
import ru.action_tech.qa.auto.api_models.managers.v2.manager_get.ManagerGetV2Response
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.api_models.managers.qa.operators_unhold_by_ids.OperatorsUnholdByIdsRequest
import ru.action_tech.qa.auto.api_models.managers.qa.user_roles_delete.UserRolesDeleteRequest
import ru.action_tech.qa.auto.api_models.managers.qa.operator_hold.OperatorHoldRequest
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.auth.tokenQA
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.Headers.AUTHORIZATION
import ru.action_tech.qa.auto.utils.http.QueryParams


object ManagersRequests {

    fun postUserRolesAdd(request: UserRolesAddRequest?, token: Any? = tokenAutoActionushka) = Request(
        desc = "Добавление ролей",
        spec = {
            token?.let { addHeader(AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request?.let { setBody(it) }
        },
        send = { post("/api/v1/user-roles_add") }
    )

    fun managerGetV2(userId: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<ManagerGetV2Response>(),
        desc = "Получаем информацию по менеджеру (версия 2)",
        spec = {
            token?.let { addHeader(AUTHORIZATION, "Bearer $token") }
            userId?.let { addQueryParam(QueryParams.USER_ID, it) }
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v2/manager_get") }
    )

    fun operatorsUnholdByIds(request: OperatorsUnholdByIdsRequest?, token: String? = tokenQA) = Request(
        desc = "Unhold менеджера по id",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/operators_unhold-by-ids") }
    )

    fun managerUpdate(request: Any?, token: String? = tokenAutoActionushka) = Request(
        desc = "Обновляем сущность менеджера (подразделение, направление, должность, тип продукта, категория)",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $token") }
            setContentType(ContentType.JSON)
            request?.let { setBody(it) }
        },
        send = { post("/api/v1/manager_update") }
    )

    fun userRolesDelete(request: UserRolesDeleteRequest?, token: String? = tokenQA) = Request(
        desc = "Удалить все роли ЕРМ пользователя",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/v1/user-roles_delete") }
    )

    fun operatorHold(request: OperatorHoldRequest?, token: String? = tokenQA) = Request(
        desc = "Холдируем менеджера",
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(request) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { post("/api/qa/operator_hold") }
    )
}