package ru.action_tech.qa.auto.api_models.accesses

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_access_validate.Action360AccessValidateResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_demo_validate.Action360DemoValidateResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Action360RequestForAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_add.Action360RequestForAccessAddResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_access_id.Action360RequestForAccessGetByAccessIdRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_id.response.Action360RequestForAccessGetByIdResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_period.Action360RequestForAccessGetByPeriodRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_period.response.Action360RequestForAccessGetByPeriodResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_get_by_user.Action360RequestForAccessGetByUserResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_moderate.request.Action360RequestForAccessModerateRequest
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.action360_request_for_access_moderate.response.Action360RequestForAccessModerateResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_check_by_customer.Aktion360AccessCheckByCustomersRequests
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_check_by_customer.Aktion360AccessCheckByCustomerResponse
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_get_by_account.Action360AccessGetByAccountResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_requests_get_by_subscribe_ids.LicenseRequestsGetBySubscribeIds
import ru.action_tech.qa.auto.api_models.accesses.a360.v1.aktion360_access_tree_get_by_access_account.Action360AccessTreeGetByAccessAccountResponse
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.access_slave_task_add.AccessSlaveTaskAddRequest
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_autologin_send.Action360AutologinSendRequest
import ru.action_tech.qa.auto.api_models.accesses.customer.v1.action360_welcome_letter_send.Action360WelcomeLetterRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.access_change_master_user.AccessChangeMasterUserRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.access_get_by_ids.AccessGetByIdsResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.access_get_last_sum_by_customer.AccessGetLastSumByCustomerResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.access_get_subscription_by_block_id.response.AccessGetSubscriptionByBlockIdResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.accesses_get_previous_access_id.AccessesGetPreviousAccessIdResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.expensive_licenses_get_by_order_ids.ExpensiveLicensesGetByOrderIdsRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.expensive_licenses_get_by_order_ids.ExpensiveLicensesGetByOrderIdsResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.get_child_data.GetChildDataResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.lic_upsert.LicUpsertRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_create_manually.LicenseCreateManuallyRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_parent.LicenseGetParentResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_promocode_add.LicensePromoCodeAddRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_replace_license_member.LicenseReplaceLicenseMemberRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_states_get_by_subscribe_ids.LicenseStatesGetBySubscribeIdsResponse
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_task_add.LicenseTaskAddRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade.LicenseUpgradeRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_upgrade_by_product_id.request.LicenseUpgradeByProductIdRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.multi_access_statistic_get_by_access_id.MultiAccessStatisticGetByAccessIdRequest
import ru.action_tech.qa.auto.api_models.accesses.sales_order.v1.order_contents_get_by_ids.OrderContentsGetByIdsResponse
import ru.action_tech.qa.auto.api_models.accesses.sales_order.v1.orders_get_extended_by_customer_ids.OrdersGetExtendedByCustomerIdsResponse
import ru.action_tech.qa.auto.api_models.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_batch_id.OrdersGetToCreateLogentriesBatchByBatchIdResponse
import ru.action_tech.qa.auto.api_models.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_product_ids.OrdersGetToCreateLogentriesBatchByProductIdsResponse
import ru.action_tech.qa.auto.api_models.accesses.sales_order.v1.orders_get_to_create_logentries_batch_by_product_ids_by_customer_id.OrdersGetToCreateLogentriesBatchByProductIdsByCustomerIdResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_cancel.AccessCancelRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_cancel.AccessCancelResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_add.AccessSlaveAddRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_add.AccessSlaveAddResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_bulk_update.AccessSlaveBulkUpdateRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_bulk_update.AccessSlaveBulkUpdateResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_remove.AccessSlaveRemoveRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.access_slave_remove.response.AccessSlaveRemoveResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_add.StorageAccessAddRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_add.StorageAccessAddResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate.StorageAccessDeactivateRequest
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate.StorageAccessDeactivateResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_get_by_code.response.StorageAccessGetByCodeResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_get_by_id.StorageAccessGetByIdResponse
import ru.action_tech.qa.auto.api_models.erm_backend.license.v1.license_get_susbcribe_info.LicenseGetSubscribeInfoResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.getAuthToken
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams
import ru.action_tech.qa.auto.utils.nonNullMapper
import ru.action_tech.qa.auto.utils.setBody
import ru.action_tech.qa.auto.utils.url_builder.X_PATH_KEY_ACCESSES
import java.util.*

object AccessesRequests {

    //region [A360]
    fun getAction360Departments(token: String? = null) = Request(
        desc = "Список отделов для заявки на А360",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
        },
        send = { get("/api/v1/aktion360-departments_get") }
    )

    fun action360RequestForAccessAdd(
        request: Action360RequestForAccessAddRequest,
        token: String? = null,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Метод создания заявки на выдачу ДД360",
        model = Model<Action360RequestForAccessAddResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setUrlEncodingEnabled(true)
            if (isNonNull) {
                setBody(nonNullMapper.writeValueAsString(request))
            } else {
                setBody(request)
            }
        },
        send = { post("/api/v1/aktion360-request-for-access_add") }
    )

    fun action360AccessValidate(request: Array<String>, token: String? = null) = TRequest(
        desc = "Метод проверки на наличие доступа А360",
        model = Model<Array<Action360AccessValidateResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            addQueryParam(QueryParams.EMAILS, request)
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/aktion360-access_validate") }
    )

    fun action360DemoValidate(request: List<String>?, token: String? = null) = TRequest(
        desc = "Проверка на наличие качественных ДД по А360",
        model = Model<Array<Action360DemoValidateResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request?.let {
                addQueryParam(QueryParams.IDS, it.joinToString(separator = ",", prefix = "[", postfix = "]"))
            }
        },
        send = { get("/api/v1/aktion360-demo_validate") }
    )

    fun action360RequestForAccessGetByUser(
        userIds: List<String>?,
        dateFrom: String? = null,
        dateTo: String? = null,
        pageNumber: Int? = null,
        pageSize: Int? = null,
        token: String? = null
    ) = TRequest(
        desc = "Метод получения списка заявок на ДД А360 по пользователям",
        model = Model<Array<Action360RequestForAccessGetByUserResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            userIds?.let {
                addQueryParam(
                    QueryParams.USER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
            dateFrom?.let { addQueryParam(QueryParams.DATE_FROM, it) }
            dateTo?.let { addQueryParam(QueryParams.DATE_TO, it) }
            pageNumber?.let { addQueryParam(QueryParams.PAGE_NUMBER, it) }
            pageSize?.let { addQueryParam(QueryParams.PAGE_SIZE, it) }
        },
        send = { get("/api/v1/aktion360-request-for-access_get-by-user") }
    )

    fun action360RequestForAccessGetById(
        id: String?,
        includeInactive: String? = null, token: String? = null
    ) = TRequest(
        desc = "Метод получения расширенной заявки на ДД 360 по id заявки",
        model = Model<Action360RequestForAccessGetByIdResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            id?.let { addQueryParam(QueryParams.ID, it) }
            includeInactive?.let { addQueryParam(QueryParams.INCLUDE_INACTIVE, it) }
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/aktion360-request-for-access_get-by-id") }
    )

    fun action360RequestForAccessModerate(
        request: Action360RequestForAccessModerateRequest,
        token: String? = null,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Метод модерации заявки на выдачу ДД360",
        model = Model<Action360RequestForAccessModerateResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            if (isNonNull) {
                setBody(nonNullMapper.writeValueAsString(request))
            } else {
                setBody(request)
            }
        },
        send = { post("/api/v1/aktion360-request-for-access_moderate") }
    )

    fun action360RequestForAccessGetByAccessId(
        request: Action360RequestForAccessGetByAccessIdRequest,
        token: String? = null
    ) = Request(
        desc = "Метод получения расширенной заявки на ДД 360 по id ДД",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request.id?.let { addQueryParam(QueryParams.ID, it) }
        },
        send = { get("/api/v1/aktion360-request-for-access_get-by-accessid") }
    )

    fun action360RequestForAccessGetByPeriod(
        request: Action360RequestForAccessGetByPeriodRequest,
        token: String? = null
    ) = TRequest(
        desc = "Метод получения списка успешно обработанных заявок на ДД А360 по периоду",
        model = Model<Array<Action360RequestForAccessGetByPeriodResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request.dateFrom?.let { addQueryParam(QueryParams.DATE_FROM, it) }
            request.dateTo?.let { addQueryParam(QueryParams.DATE_TO, it) }
        },
        send = { get("/api/v1/aktion360-request-for-access_get-by-period") }
    )

    fun action360AccessForAccountValidate(
        accountId: String? = null,
        token: String? = null
    ) = TRequest(
        desc = "Проверка на наличие действующего ДД по А360 у юр.лица",
        model = Model<Boolean>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            accountId?.let { addQueryParam(QueryParams.ACCOUNT_ID, it) }
        },
        send = { get("/api/v1/aktion360-access-for-account_validate") }
    )

    fun action360AccessTreeGetByAccessAccount(
        accessId: String? = null,
        accountId: String? = null,
        token: String? = null
    ) = TRequest(
        desc = "Получение дерева доступов подписка-блок по доступу или демо-доступа",
        model = Model<Action360AccessTreeGetByAccessAccountResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            accountId?.let { addQueryParam(QueryParams.ACCOUNT_ID, it) }
            accessId?.let { addQueryParam(QueryParams.ACCESS_ID, it) }
        },
        send = { get("/api/v1/aktion360-access-tree_get-by-access-account") }
    )

    fun aktion360AccessGetByAccount(accountId: String? = null, token: String? = null) = TRequest(
        desc = "Получение оплаченной подписки А360 для юр.лица",
        model = Model<Action360AccessGetByAccountResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            accountId?.let { addQueryParam(QueryParams.ACCOUNT_ID, it) }
        },
        send = { get("/api/v1/aktion360-access_get-by-account") }
    )

    fun aktion360AccessCheckByCustomer(
        request: Aktion360AccessCheckByCustomersRequests, token: String? = null
    ) = TRequest(
        desc = "Проверяем, что у пользователя имеется подписка А360 в определенный момент времени.",
        model = Model<Aktion360AccessCheckByCustomerResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request.customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
            request.checkDateTime?.let { addQueryParam(QueryParams.CHECK_DATE_TIME, it) }
        },
        send = { get("/api/v1/aktion360-access_check-by-customer") }
    )
    //endregion

    //region [Customer]
    fun action360WelcomeLetterSend(
        request: Action360WelcomeLetterRequest,
        token: String? = null,
        isNonNull: Boolean = true
    ) = TRequest(
        model = Model<Boolean>(),
        desc = "Метод отправки приглашения",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/aktion360-welcome-letter_send") }
    )

    fun action360AutologinSend(
        request: Action360AutologinSendRequest,
        token: String? = null,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Метод отправки письма с автологином",
        model = Model<Boolean>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/aktion360-autologin_send") }
    )

    fun accessSlaveTaskAdd(
        request: AccessSlaveTaskAddRequest,
        token: String? = null,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Метод создание задачи на добавление слейв-пользователя",
        model = Model<Boolean>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/access-slave-task_add") }
    )
    //endregion

    //region [Licence]
    fun licenseGetParent(blockProductId: Any?, customerId: Any?) = TRequest(
        desc = "Получение родительской лицензии",
        model = Model<LicenseGetParentResponse>(),
        spec = {
            blockProductId?.let { addQueryParam(QueryParams.BLOCK_PRODUCT_ID, it) }
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
        },
        send = { get(licenseGetParent) }
    )

    fun expensiveLicensesGetByOrderIds(request: ExpensiveLicensesGetByOrderIdsRequest?) = TRequest(
        desc = "Получить список УКД с самой высокой ценой по идентификаторам заказов",
        model = Model<Array<ExpensiveLicensesGetByOrderIdsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            request?.let { setBody(it) }
        },
        send = { post(expensiveLicensesGetByOrderIds) }
    )

    fun licenseCreateManually(request: LicenseCreateManuallyRequest) = TRequest(
        model = Model<Boolean>(),
        desc = "Ручное создание лицензии",
        spec = {
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post(licenseCreateManually) }
    )

    fun licenseGetSubscribeInfo(orderDetailId: Any?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<LicenseGetSubscribeInfoResponse>(),
        desc = "Получение информации о контакте в лицензии",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setUrlEncodingEnabled(true)
            orderDetailId?.let { addQueryParam(QueryParams.ORDER_DETAIL_ID, it) }
        },
        send = { get(licenseGetSubscribeInfo) }
    )

    fun licenseReplaceLicenseMember(request: LicenseReplaceLicenseMemberRequest?) = TRequest(
        model = Model<Boolean>(),
        desc = "Замена пользователя в лицензии",
        spec = {
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post(licenseReplaceLicenseMember) }
    )

    fun licUpsert(
        request: LicUpsertRequest,
        token: String? = null, isNonNull: Boolean = true
    ) = Request(
        desc = "Создание или обновление УКД",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/lic-upsert") }
    )

    fun licenseTaskAdd(
        request: LicenseTaskAddRequest,
        token: String? = null, isNonNull: Boolean = true
    ) = Request(
        desc = "Создание заявки на лицензию",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/license-task_add") }
    )

    fun licenseGetByTaskId(request: LicenseGetByTaskIdRequest, token: String? = null) = TRequest(
        desc = "Лицензия по id задачи на ее создание",
        model = Model<LicenseGetByTaskIdResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request.taskId?.let { addQueryParam(QueryParams.TASK_ID, it) }
        },
        send = { get("/api/v1/license_get-by-task-id") }
    )

    fun licensePromoCodeAdd(
        request: LicensePromoCodeAddRequest,
        token: String? = null,
        isNonNull: Boolean = true
    ) = Request(
        desc = "Добавление промокода к заявке",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/license-promocode_add") }
    )

    fun licenseUpgrade(
        request: LicenseUpgradeRequest,
        token: String? = null, isNonNull: Boolean = true
    ) = Request(
        desc = "Повышение версии лицензии",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/license_upgrade") }
    )

    fun taskQueueGetGroupedByProgram(token: String? = null) = Request(
        desc = "Метод возвращает количество необработанных заявок, сгруппированных по продуктовой программе",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
        },
        send = { get("/api/v1/task-queue_get-grouped-by-program") }
    )

    fun multiAccessStatisticGetByAccessId(
        request: MultiAccessStatisticGetByAccessIdRequest,
        token: String? = null
    ) = Request(
        desc = "Метод получения статистики по Id ДД",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            request.accessId?.let { addQueryParam(QueryParams.ACCESS_ID, it) }
        },
        send = { get("/api/v1/multiaccess-statistic_get-by-accessid") }
    )

    fun licenseUpgradeByProductId(
        request: LicenseUpgradeByProductIdRequest,
        token: String? = null,
        isNonNull: Boolean = true
    ) = Request(
        desc = "Повышение версии лицензии по продукту",
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/license_upgrade–by-productid") }
    )

    fun accessesGetPreviousAccessId(
        accessId: String?, userId: Int?,
        token: String? = null
    ) = TRequest(
        desc = "Рассчитывающая для доступа id предыдущего доступа",
        model = Model<AccessesGetPreviousAccessIdResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            accessId?.let { addQueryParam(QueryParams.ACCESS_ID, it) }
            userId?.let { addQueryParam(QueryParams.USER_ID, it) }
        },
        send = { get("/api/v1/access_get-previous-access-id") }
    )

    fun accessGetSubscriptionByBlockId(
        blockAccessId: String? = null,
        token: String? = null
    ) = TRequest(
        desc = "Получить подписку по идентификатору блока",
        model = Model<AccessGetSubscriptionByBlockIdResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            blockAccessId?.let { addQueryParam(QueryParams.BLOCK_ACCESS_ID, it) }
        },
        send = { get("/api/v1/access_get-subscription-by-block-id") }
    )

    fun accessChangeMasterUser(request: AccessChangeMasterUserRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Сменить пользователя на лицензии",
        model = Model<Boolean>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/access_change-master-user") }
    )

    fun accessIdsGetBySubscribeIds(subscribeIds: Any?) = TRequest(
        desc = "Получаем ids доступов по ids содержимого заказа",
        model = Model<Array<UUID>>(),
        spec = {
            setContentType(ContentType.JSON)
            addQueryParam(QueryParams.SUBSCRIBE_IDS, subscribeIds)
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/access-ids_get-by-subscribe-ids") }
    )

    fun accessGetLastSumByCustomer(customerId: String?, mainProductIds: Any?) = TRequest(
        desc = "Получаем ids доступов по ids содержимого заказа",
        model = Model<AccessGetLastSumByCustomerResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addQueryParam(QueryParams.CUSTOMER_ID, customerId)
            addQueryParam(QueryParams.MAIN_PRODUCT_IDS, mainProductIds)
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/access_get-last-sum-by-customer") }
    )

    fun accessGetByIds(accessIds: Any?) = TRequest(
        desc = "Получаем список доступов по Ids",
        model = Model<AccessGetByIdsResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addQueryParam(QueryParams.ACCESS_IDS, accessIds)
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/access_get-by-ids") }
    )

    fun licenseStatesGetBySubscribeIds(subscribeIds: Any?) = TRequest(
        desc = "Получаем список статусов лицензий по списку идентификаторов содержимых заказа",
        model = Model<LicenseStatesGetBySubscribeIdsResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addQueryParam(QueryParams.SUBSCRIBE_IDS, subscribeIds)
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/license-states_get-by-subscribe-ids") }
    )

    fun licenseRequestsGetBySubscribeIds(subscribeIds: Any?) = TRequest(
        desc = "Возвращает заявки на регистрацию УКД по идентификаторам содержимых заказа",
        model = Model<Array<LicenseRequestsGetBySubscribeIds>>(),
        spec = {
            setContentType(ContentType.JSON)
            addQueryParam(QueryParams.SUBSCRIBE_IDS, subscribeIds)
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/license-requests_get-by-subcribeids") }
    )

    fun licenseGetSubscribeInfo(orderDetailId: Any?) = TRequest(
        desc = "Получение информации о контакте в лицензии",
        model = Model<LicenseGetSubscribeInfoResponse>(),
        spec = {
            orderDetailId?.let { addQueryParam(QueryParams.ORDER_DETAIL_ID, orderDetailId) }
            setUrlEncodingEnabled(true)
        },
        send = { get("/api/v1/license_get-subscribe-info") }
    )

    fun licenseRequestCancel(taskId: String?, isNonNull: Boolean = true) = Request(
        desc = "Отменить заявку на регистрацию лицензции",
        spec = {
            setContentType(ContentType.JSON)
            taskId?.let { setBody(taskId, isNonNull) }
        },
        send = { post("/api/v1/license-request_cancel") }
    )
    //endregion

    // region [Qa]
    fun qaChangeLicenseSalesOn(
        licenseId: UUID?,
        salesOn: String?,
        xPathKey: String? = X_PATH_KEY_ACCESSES,
        token: String? = getAuthToken()
    ) = Request(
        desc = "[QA-API] Обновляет дату регистрации на тестовой лицензии",
        spec = {
            xPathKey?.let { addHeader(Headers.X_PATH_KEY, it) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            licenseId?.let { addQueryParam(QueryParams.LICENSE_ID, licenseId) }
            salesOn?.let { addQueryParam(QueryParams.SALES_ON, salesOn) }
        },
        send = { post("/api/v1/qa_change-license-sales-on") }
    )

    fun qaSendOrderToShipment(orderId: String, xPathKey: String? = X_PATH_KEY_ACCESSES) = Request(
        desc = "Ручное создание лицензии",
        spec = {
            xPathKey?.let { addHeader(Headers.X_PATH_KEY, it) }
            addQueryParam(QueryParams.ORDER_ID, orderId)
            setContentType(ContentType.JSON)
            setUrlEncodingEnabled(true)
        },
        send = { post("/api/v1/qa_send-order-to-shipment") }
    )

    fun qaDeleteDemoAccessReq(id: String, xPathKey: String? = X_PATH_KEY_ACCESSES) = Request(
        desc = "Удалить заявки на демо доступы юр. лица в а360",
        spec = {
            xPathKey?.let { addHeader(Headers.X_PATH_KEY, it) }
            setContentType(ContentType.JSON)
            setBody("\"$id\"")
        },
        send = { post(qaDeleteDemoAccessReq) }
    )
    // endregion

    //region [SalesOrder]
    fun orderContentsGetByIds(orderContentIds: List<String>? = null) = TRequest(
        desc = "Позиции заказов по Ids",
        model = Model<Array<OrderContentsGetByIdsResponse>>(),
        spec = {
            orderContentIds?.let {
                addQueryParam(
                    QueryParams.ORDER_CONTENT_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get("/api/v1/order-contents_get-by-ids") }
    )

    fun ordersGetToCreateLogentriesBatchByBatchId(batchId: String? = null) = TRequest(
        desc = "Дерево доступов подписка-блок по доступу или демо-доступу",
        model = Model<Array<OrdersGetToCreateLogentriesBatchByBatchIdResponse>>(),
        spec = { batchId?.let { addQueryParam(QueryParams.BATCH_ID, it) } },
        send = { get("/api/v1/orders_get-to-create-logentries-batch-by-batch-id") }
    )

    fun subscribeGetIdsCountByParams(
        productIds: List<String?>?,
        isCheckStock: String?,
        receiveCaseId: String? = null,
        checkPayment: String?,
        isPostPaymentShipment: String?,
        from: String?,
        to: String?
    ) = TRequest(
        model = Model<Long>(),
        desc = "Кол-во Ids содержимых заказов для формирования записей журнала батчей по параметрам",
        spec = {
            productIds?.let {
                addQueryParam(
                    QueryParams.PRODUCT_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id ->
                        if (id != null) {
                            "'$id'"
                        } else {
                            "null"
                        }
                    })
            }
            isCheckStock?.let { addQueryParam(QueryParams.IS_CHECK_STOCK, it) }
            receiveCaseId?.let { addQueryParam(QueryParams.RECEIVE_CASE_ID, it) }
            checkPayment?.let { addQueryParam(QueryParams.CHECK_PAYMENT, it) }
            isPostPaymentShipment?.let { addQueryParam(QueryParams.IS_POST_PAYMENT_SHIPMENT, it) }
            from?.let { addQueryParam(QueryParams.FROM, it) }
            to?.let { addQueryParam(QueryParams.TO, it) }
        },
        send = { get("/api/v1/subscribe_get-ids-count-by-params") }
    )

    fun ordersGetToCreateLogentriesBatchByProductIdsByCustomerId(
        productIds: List<String?>? = null,
        customerId: String?,
        receiveCaseId: String? = null
    ) = TRequest(
        model = Model<Array<OrdersGetToCreateLogentriesBatchByProductIdsByCustomerIdResponse>>(),
        desc = "Ids заказов для формирования записей журнала батчей по заказам для клиента",
        spec = {
            productIds?.let {
                addQueryParam(
                    QueryParams.PRODUCT_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
            addQueryParam(QueryParams.CUSTOMER_ID, customerId)
            receiveCaseId?.let { addQueryParam(QueryParams.RECEIVE_CASE_ID, it) }
        },
        send = { get("/api/v1/orders_get-to-create-logentries-batch-by-product-ids-by-customer-id") }
    )

    fun ordersGetToCreateLogentriesBatchByProductIds(
        productIds: List<String?>? = null,
        isCheckStock: Boolean? = null,
        receiveCaseId: String? = null,
        checkPayment: Boolean? = null,
        isPostPaymentShipment: Boolean? = null,
        from: String? = null,
        to: String? = null
    ) = TRequest(
        model = Model<Array<OrdersGetToCreateLogentriesBatchByProductIdsResponse>>(),
        desc = "Ids заказов для формирования записей журнала батчей по заказам",
        spec = {
            productIds?.let {
                addQueryParam(
                    QueryParams.PRODUCT_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
            isCheckStock?.let { addQueryParam(QueryParams.IS_CHECK_STOCK, it) }
            receiveCaseId?.let { addQueryParam(QueryParams.RECEIVE_CASE_ID, it) }
            checkPayment?.let { addQueryParam(QueryParams.CHECK_PAYMENT, it) }
            isPostPaymentShipment?.let { addQueryParam(QueryParams.IS_POST_PAYMENT_SHIPMENT, it) }
            from?.let { addQueryParam(QueryParams.FROM, it) }
            to?.let { addQueryParam(QueryParams.TO, it) }
        },
        send = { get("/api/v1/orders_get-to-create-logentries-batch-by-product-ids") }
    )

    fun licenseGetChildData(
        customerId: String?,
        customerType: String? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        desc = "Получение ученических лицензий",
        model = Model<Array<GetChildDataResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
            customerType?.let { addQueryParam(QueryParams.CUSTOMER_TYPE, it) }
        },
        send = { get(licenseGetChildData) }
    )

    fun ordersGetExtendedByCustomerIds(
        customerIds: List<String?>? = null,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        desc = "Получение расширенной информации о заказах клиентов",
        model = Model<Array<OrdersGetExtendedByCustomerIdsResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            customerIds?.let {
                addQueryParam(
                    QueryParams.CUSTOMER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get(ordersGetExtendedByCustomerIds) }
    )
    //endregion

    //region [Storage]
    fun storageAccessGetById(id: Any?, token: String? = null) = TRequest(
        desc = "Доступ по Id",
        model = Model<StorageAccessGetByIdResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            id?.let { addQueryParam(QueryParams.ID, it) }
        },
        send = { get(storageAccessGetById) }
    )

    fun storageAccessGetByCode(code: Any?, token: String? = null) = TRequest(
        desc = "Получить данные доступа по коду",
        model = Model<StorageAccessGetByCodeResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            code?.let { addQueryParam(QueryParams.CODE, it) }
        },
        send = { get(storageAccessGetByCode) }
    )

    fun storageAccessAdd(
        request: StorageAccessAddRequest, token: String? = null, isNonNull: Boolean = true
    ) = TRequest(
        desc = "Создание доступа",
        model = Model<StorageAccessAddResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post(storageAccessAdd) }
    )

    fun storageAccessUpdate(
        request: StorageAccessAddRequest, token: String? = null, isNonNull: Boolean = true
    ) = TRequest(
        desc = "Обновление доступа",
        model = Model<StorageAccessAddResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post(storageAccessUpdate) }
    )

    fun storageAccessDeactivate(
        request: StorageAccessDeactivateRequest?,
        token: String? = null,
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

    fun accessSlaveAdd(
        request: AccessSlaveAddRequest, token: String? = null, isNonNull: Boolean = true
    ) = TRequest(
        desc = "Добавить одного slave пользователя",
        model = Model<AccessSlaveAddResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post(accessSlaveAdd) }
    )

    fun accessSlaveRemove(
        request: AccessSlaveRemoveRequest, token: String? = null, isNonNull: Boolean = true
    ) = TRequest(
        desc = "Удалить одного slave пользователя",
        model = Model<AccessSlaveRemoveResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post(accessSlaveRemove) }
    )

    fun accessSlaveBulkUpdate(request: AccessSlaveBulkUpdateRequest, token: String? = null, isNonNull: Boolean = true) =
        TRequest(
            desc = "Полная перезапись slave пользователей",
            model = Model<AccessSlaveBulkUpdateResponse>(),
            spec = {
                token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
                setContentType(ContentType.JSON)
                setBody(request, isNonNull)
            },
            send = { post("/api/v1/access-slave_bulk-update") }
        )

    fun accessCancel(request: AccessCancelRequest, token: String? = null, isNonNull: Boolean = true) =
        TRequest(
            desc = "Отмена доступа",
            model = Model<AccessCancelResponse>(),
            spec = {
                token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
                setContentType(ContentType.JSON)
                setBody(request, isNonNull)
            },
            send = { post(accessCancel) }
        )
//endregion
}