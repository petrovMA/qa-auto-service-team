package ru.action_tech.qa.auto.api_models.supports

import io.qameta.allure.Feature

// region [Bush]
@Feature("/api/v1/bush-action360_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BushAction360Add

@Feature("/api/v1/bush-action360_get-by-incident")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BushAction360GetByIncident

@Feature("/api/v1/facade-a360-bush_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushAdd

@Feature("/api/v1/facade-a360-bush_detach")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushDetach

@Feature("/api/v1/facade-a360-bush_get-by-manager")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushGetByManager

@Feature("/api/v1/facade-a360-bush_get-by-manager-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushGetByManagerIds

@Feature("/api/v1/facade-a360-bush_get-regular-customers-by-manager-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushGetRegularCustomersByManagerIds

@Feature("/api/v1/facade-a360-bush-managers-limits_get-by-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushManagersLimitsGetByIds

@Feature("/api/v1/facade-a360-bush_reattach")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushReattach

@Feature("/api/v1/facade-a360-bush_update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushUpdate

@Feature("/api/v1/facade-a360-bush_update-regular-customers")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushUpdateRegularCustomers

@Feature("/api/v1/facade-a360-bush_update-support-manager")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushUpdateSupportManager

@Feature("/api/v1/facade-a360-bush-managers-limits_update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FacadeA360BushManagersLimitsUpdate
// endregion

// region [Stoplist]
@Feature(stopListBind)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListBind

@Feature(stopListBindNewCustomer)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListBindNewCustomer

@Feature(stopListsGetByPartnerId)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListsGetByPartnerId
// endregion

// region [Support]
@Feature("/api/v1/opportunity-a360_can-create")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OpportunityA360CanCreate

@Feature("/api/v1/opportunity-a360_get-by-bush-action360-support-statuses")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OpportunityA360GetByBushAction360SupportStatuses

@Feature("/api/v1/opportunity-a360_get-by-customer")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OpportunityA360GetByCustomer

@Feature("/api/v1/support-add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportAdd

@Feature("/api/v1/support-opportunitya360_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportOpportunityA360Add

@Feature("/api/v1/support-opportunitya360_update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportOpportunityA360Update

@Feature("/api/v1/support-opportunity_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportOpportunityAdd

@Feature("/api/v1/support-opportunity_update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportOpportunityUpdate

@Feature("/api/v1/support-update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportUpdate

@Feature("/api/v1/supports_change-manager")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsChangeManager

@Feature("/api/v1/supports_get-by-manager")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsGetByManager

@Feature("/api/v1/analysis-bush-customers_get-by-customer-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AnalysisBushCustomersGetByCustomerIdsV1

@Feature("/api/v1/analysis-bush-customers-count_get-by-customer-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AnalysisBushCustomersCountGetByCustomerIdV1

@Feature("/api/v1/supports_get-by-customer")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsGetByCustomer

@Feature("/api/v1/supports_get-for-order")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsGetForOrder
// endregion