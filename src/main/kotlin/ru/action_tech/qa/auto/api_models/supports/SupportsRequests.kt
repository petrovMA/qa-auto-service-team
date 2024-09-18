package ru.action_tech.qa.auto.api_models.supports

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_add.request.BushAction360AddRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_get_by_incident.request.BushAction360GetByIncidentRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.bush_action360_get_by_incident.response.BushAction360GetByIncidentResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_add.request.FacadeA360BushAddRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_add.response.FacadeA360BushAddResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_detach.request.FacadeA360BushDetachRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_detach.response.FacadeA360BushDetachResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager.request.FacadeA360BushGetByManagerRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager.response.FacadeA360BushGetByManagerResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_by_manager_ids.response.FacadeA360BushGetByManagerIdsResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_regular_customers_by_manager_ids.request.FacadeA360BushGetRegularCustomersByManagerIdsRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_get_regular_customers_by_manager_ids.response.FacadeA360BushGetRegularCustomersByManagerIdsResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_managers_limits_get_by_ids.response.FacadeA360BushManagersLimitsGetByIdsResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_managers_limits_update.request.FacadeA360BushManagersLimitsUpdateRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_reattach.request.FacadeA360BushReattachRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_reattach.response.FacadeA360BushReattachResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update.request.FacadeA360BushUpdateRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update.response.FacadeA360BushUpdateResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_regular_customers.request.FacadeA360BushUpdateRegularCustomersRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_regular_customers.response.FacadeA360BushUpdateRegularCustomersResponse
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_support_manager.request.FacadeA360BushUpdateSupportManagerRequest
import ru.action_tech.qa.auto.api_models.supports.bush.v1.facade_a360_bush_update_support_manager.response.FacadeA360BushUpdateSupportManagerResponse
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind.StopListBindRequest
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind.StopListBindResponse
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind_new_customer.StopListBindNewCustomerRequest
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_list_bind_new_customer.StopListBindNewCustomerResponse
import ru.action_tech.qa.auto.api_models.supports.stoplist.v1.stop_lists_get_by_partnerid.response.StopListGetByPartnerIdResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.analysis_bush_customers_count_get_by_customer_ids.AnalysisBushCustomersCountGetByCustomerIdsResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.analysis_bush_customers_get_by_customer_ids.AnalysisBushCustomersGetByCustomerIdsResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_can_create.request.OpportunityA360CanCreateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_can_create.response.OpportunityA360CanCreateResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.request.OpportunityA360GetByBushAction360SupportStatusesRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_get_by_bush_action360_support_statuses.response.OpportunityA360GetByBushAction360SupportStatusesResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.opportunity_a360_get_by_customer.response.OpportunityA360GetByCustomerResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_add.request.SupportAddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_add.request.SupportOpportunityA360AddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_a360_update.request.SupportOpportunityA360UpdateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_add.request.SupportOpportunityAddRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_opportunity_update.request.SupportOpportunityUpdateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.support_update.request.SupportUpdateRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_change_manager.request.SupportsChangeManagerRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_customer.SupportsGetByCustomerResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_manager.request.SupportsGetByManagerRequest
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_by_manager.response.SupportsGetByManagerResponse
import ru.action_tech.qa.auto.api_models.supports.support.v1.supports_get_for_order.SupportsGetForOrderResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenActionushka
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.common_models.CommonUUID
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams
import ru.action_tech.qa.auto.utils.setBody
import ru.action_tech.qa.auto.utils.url_builder.X_PATH_KEY_SUPPORTS

object SupportsRequests {

    //region [Bush]
    fun bushAction360Add(request: BushAction360AddRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод создания куста Актион 360",
        model = Model<CommonUUID>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/bush-action360_add") }
    )

    fun facadeA360BushAdd(request: FacadeA360BushAddRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод создания куста Актион 360",
        model = Model<FacadeA360BushAddResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush_add") }
    )

    fun facadeA360BushUpdate(request: FacadeA360BushUpdateRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод обновления куста Актион 360",
        model = Model<FacadeA360BushUpdateResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush_update") }
    )

    fun facadeA360BushDetach(request: FacadeA360BushDetachRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод открепления куста Актион 360",
        model = Model<FacadeA360BushDetachResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush_detach") }
    )

    fun facadeA360BushReattach(request: FacadeA360BushReattachRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод перезакрепления куста Актион 360",
        model = Model<FacadeA360BushReattachResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush_reattach") }
    )

    fun bushAction360GetByIncident(request: BushAction360GetByIncidentRequest) = TRequest(
        desc = "Метод поиска куста Актион 360 по обращению",
        model = Model<Array<BushAction360GetByIncidentResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            request.incidentId?.let { addQueryParam(QueryParams.INCIDENT_ID, it) }
        },
        send = { get("/api/v1/bush-action360_get-by-incident") }
    )

    fun facadeA360BushGetByManager(request: FacadeA360BushGetByManagerRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод получения куста Актион 360",
        model = Model<Array<FacadeA360BushGetByManagerResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush_get-by-manager") }
    )

    fun facadeA360BushUpdateSupportManager(
        request: FacadeA360BushUpdateSupportManagerRequest,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Метод получения куста Актион 360",
        model = Model<Array<FacadeA360BushUpdateSupportManagerResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush_update-support-manager") }
    )

    fun facadeA360BushGetByManagerIds(request: List<String>? = null) = TRequest(
        desc = "Метод получения кустов Актион 360 по списку Id менеджеров",
        model = Model<Array<FacadeA360BushGetByManagerIdsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            request?.let {
                addQueryParam(
                    QueryParams.SYSTEM_USER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
        },
        send = { get("/api/v1/facade-a360-bush_get-by-manager-ids") }
    )

    fun facadeA360BushManagersLimitsGetByIds(systemUserIds: List<String>?) = TRequest(
        desc = "Лимиты пользователей для куста А360 по списку ids",
        model = Model<Array<FacadeA360BushManagersLimitsGetByIdsResponse>>(),
        spec = {
            systemUserIds?.let {
                addQueryParam(
                    QueryParams.SYSTEM_USER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
        },
        send = { get("/api/v1/facade-a360-bush-managers-limits_get-by-ids") }
    )

    fun facadeA360BushGetRegularCustomersByManagerIds(
        request: FacadeA360BushGetRegularCustomersByManagerIdsRequest
    ) = TRequest(
        desc = "Метод получения кустов Актион 360 с регулярными клиентами по списку Id менеджеров",
        model = Model<Array<FacadeA360BushGetRegularCustomersByManagerIdsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            request.systemUserIds?.let {
                addQueryParam(
                    QueryParams.SYSTEM_USER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
            request.customerIds?.let {
                addQueryParam(
                    QueryParams.CUSTOMER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
            request.number?.let { addQueryParam(QueryParams.NUMBER, it) }
        },
        send = { get("/api/v1/facade-a360-bush_get-regular-customers-by-manager-ids") }
    )

    fun facadeA360BushUpdateRegularCustomers(
        request: FacadeA360BushUpdateRegularCustomersRequest,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Метод обновления регулярных клиентов куста Актион 360",
        model = Model<FacadeA360BushUpdateRegularCustomersResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush_update-regular-customers") }
    )

    fun facadeA360BushManagersLimitsUpdate(
        request: FacadeA360BushManagersLimitsUpdateRequest,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Обновление лимитов пользователей для куста А360",
        model = Model<Boolean>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/facade-a360-bush-managers-limits_update") }
    )
    // endregion

    //region [Qa]
    fun supportDeleteTested(
        supportId: String? = null, xPathKey: String? = X_PATH_KEY_SUPPORTS, token: String? = tokenAutoActionushka
    ) = Request(
        desc = "Удалить тестовое сопровождение / расширение / возможную сделку из БД",
        spec = {
            xPathKey?.let { addHeader(Headers.X_PATH_KEY, it) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            supportId?.let { addQueryParam(QueryParams.SUPPORT_ID, it) }
        },
        send = { post("/api/v1/support_delete-tested") }
    )
    // endregion

    //region [StopList]
    fun stopListBind(request: StopListBindRequest, token: String? = tokenActionushka) = TRequest(
        desc = "Закрепить существующего свободного клиента в в стоп-лист",
        model = Model<StopListBindResponse>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post(stopListBind) }
    )

    fun stopListBindNewCustomer(request: StopListBindNewCustomerRequest? = null, token: String? = tokenActionushka) =
        TRequest(
            desc = "Закрепить нового клиента в в стоп-лист",
            model = Model<StopListBindNewCustomerResponse>(),
            spec = {
                token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
                setContentType(ContentType.JSON)
                request?.let { setBody(it) }
            },
            send = { post(stopListBindNewCustomer) }
        )

    fun stopListGetByPartnerId(partnerId: String?, token: String? = tokenActionushka) = TRequest(
        desc = "Получить стоплисты по id партнера",
        model = Model<Array<StopListGetByPartnerIdResponse>>(),
        spec = {
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            partnerId?.let { addQueryParam(QueryParams.PARTNER_ID, it) }
        },
        send = { get(stopListsGetByPartnerId) }
    )
    // endregion

    //region [Support]
    fun supportAdd(request: SupportAddRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод создания сопровождения клиента",
        model = Model<String>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/support-add") }
    )

    fun supportUpdate(request: SupportUpdateRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод обновления сопровождения клиента",
        model = Model<String>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/support-update") }
    )

    fun supportOpportunityAdd(request: SupportOpportunityAddRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод создания возможной сделки клиента",
        model = Model<String>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/support-opportunity_add") }
    )

    fun supportOpportunityUpdate(request: SupportOpportunityUpdateRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод обновления возможной сделки клиента",
        model = Model<String>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/support-opportunity_update") }
    )

    fun supportOpportunityA360Add(request: SupportOpportunityA360AddRequest, isNonNull: Boolean = true) = TRequest(
        desc = "Метод создания возможной сделки A360 клиента",
        model = Model<String>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/support-opportunitya360_add") }
    )

    fun supportOpportunityA360Update(
        request: SupportOpportunityA360UpdateRequest,
        isNonNull: Boolean = true
    ) = TRequest(
        desc = "Метод обновления возможной сделки A360 клиента",
        model = Model<String>(),
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/support-opportunitya360_update") }
    )

    fun opportunityA360CanCreate(request: OpportunityA360CanCreateRequest) = TRequest(
        desc = "Получить сопровождения с возможной сделкой Актион 360",
        model = Model<OpportunityA360CanCreateResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            request.accountId?.let { addQueryParam(QueryParams.ACCOUNT_ID, it) }
            request.contactId?.let { addQueryParam(QueryParams.CONTACT_ID, it) }
        },
        send = { get("/api/v1/opportunity-a360_can-create") }
    )

    fun opportunityA360GetByCustomer(accountId: String?) = TRequest(
        desc = "Получить сопровождения с возможной сделкой Актион 360",
        model = Model<Array<OpportunityA360GetByCustomerResponse>>(),
        spec = { accountId?.let { addQueryParam(QueryParams.ACCOUNT_ID, it) } },
        send = { get("/api/v1/opportunity-a360_get-by-customer") }
    )

    fun opportunityA360GetByBushAction360SupportStatuses(
        request: OpportunityA360GetByBushAction360SupportStatusesRequest
    ) = TRequest(
        desc = "Получить сопровождения с возможной сделкой Актион 360",
        model = Model<Array<OpportunityA360GetByBushAction360SupportStatusesResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            request.bushAction360Id?.let { addQueryParam(QueryParams.BUSH_ACTION_360_ID, it) }
            request.supportStatuses?.let {
                addQueryParam(
                    QueryParams.SUPPORT_STATUSES,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get("/api/v1/opportunity-a360_get-by-bush-action360-support-statuses") }
    )

    fun supportsGetByManager(request: SupportsGetByManagerRequest) = TRequest(
        desc = "Получить действующие сопровождения по менеджеру",
        model = Model<Array<SupportsGetByManagerResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            request.managerId?.let { addQueryParam(QueryParams.MANAGER_ID, it) }
        },
        send = { get("/api/v1/supports_get-by-manager") }
    )

    fun analysisBushCustomersGetByCustomerIds(customerIds: List<String>?) = TRequest(
        desc = "Клиенты кустов аналитиков связанные с запрашиваемыми Ids",
        model = Model<Array<AnalysisBushCustomersGetByCustomerIdsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            customerIds?.let {
                addQueryParam(
                    QueryParams.CUSTOMER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get("/api/v1/analysis-bush-customers_get-by-customer-ids") }
    )

    fun analysisBushCustomersCountGetByCustomerIds(customerIds: List<String?>?) = TRequest(
        desc = "Кол-во клиентов кустов аналитиков, связанных с запрашиваемыми Ids",
        model = Model<Array<AnalysisBushCustomersCountGetByCustomerIdsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            customerIds?.let {
                addQueryParam(
                    QueryParams.CUSTOMER_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get("/api/v1/analysis-bush-customers_get-by-customer-ids") }
    )


    fun supportsChangeManager(request: SupportsChangeManagerRequest, isNonNull: Boolean = true) = Request(
        desc = "Смена менеджера сопровождения",
        spec = {
            setContentType(ContentType.JSON)
            setBody(request, isNonNull)
        },
        send = { post("/api/v1/supports_change-manager") }
    )

    fun supportsGetByCustomer(customerId: String? = null, customerType: Int? = null) = TRequest(
        desc = "Получить сопровождения по клиенту",
        model = Model<Array<SupportsGetByCustomerResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
            customerType?.let { addQueryParam(QueryParams.CUSTOMER_TYPE, it) } // Тип клиента (1 - ЮЛ, 2 - ФЛ)
        },
        send = { get("/api/v1/supports_get-by-customer") }
    )

    fun supportsGetForOrder(
        customerId: Any? = null,
        customerType: Any? = null,
        supportType: Any? = null,
        mainProductTypeId: Any? = null
    ) = TRequest(
        desc = "Получить сопровождения по клиенту для регистрации нового заказа",
        model = Model<Array<SupportsGetForOrderResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
            customerType?.let { addQueryParam(QueryParams.CUSTOMER_TYPE, it) } // Тип клиента (1 - ЮЛ, 2 - ФЛ)
            supportType?.let { addQueryParam(QueryParams.SUPPORT_TYPE, it) }
            mainProductTypeId?.let { addQueryParam(QueryParams.MAIN_PRODUCT_TYPE_ID, it) }
        },
        send = { get("/api/v1/supports_get-for-order") }
    )
    // endregion
}