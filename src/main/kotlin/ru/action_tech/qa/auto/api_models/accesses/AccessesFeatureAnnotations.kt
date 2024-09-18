package ru.action_tech.qa.auto.api_models.accesses

import io.qameta.allure.Feature

// region [A360]
@Feature("/api/v1/aktion360-departments_get")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360DepartmentsGetV1

@Feature("/api/v1/aktion360-request-for-access_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360RequestForAccessAddV1

@Feature("/api/v1/aktion360-access_validate")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360AccessValidateV1

@Feature("/api/v1/aktion360-demo_validate")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360DemoValidateV1

@Feature("/api/v1/aktion360-request-for-access_get-by-user")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360RequestForAccessGetByUserV1

@Feature("/api/v1/aktion360-request-for-access_get-by-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360RequestForAccessGetByIdV1

@Feature("/api/v1/aktion360-request-for-access_moderate")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360RequestForAccessModerateV1

@Feature("/api/v1/aktion360-request-for-access_get-by-accessid")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360RequestForAccessGetByAccessIdV1

@Feature("/api/v1/aktion360-request-for-access_get-by-period")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360RequestForAccessGetByPeriodV1

@Feature("/api/v1/action360-access-tree_get-by-access-account")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360AccessTreeGetByAccessAccountV1

@Feature("/api/v1/aktion360-access-for-account_validate")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360AccessForAccountValidateV1

@Feature("/api/v1/aktion360-access_get-by-account")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360AccessGetByAccountV1

@Feature("/api/v1/aktion360-access_check-by-customer")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360AccessCheckByCustomerV1
//endregion

// region [Customer]
@Feature("/api/v1/aktion360-welcome-letter_send")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360WelcomeLetterSendV1

@Feature("/api/v1/access-slave-task_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessSlaveTaskAddV1

@Feature("/api/v1/aktion360-autologin_send")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Aktion360AutologinSendV1
//endregion

// region [Licence]
@Feature(licenseGetParent)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseGetParent

@Feature(expensiveLicensesGetByOrderIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ExpensiveLicensesGetByOrderIds

@Feature(licenseGetSubscribeInfo)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseGetSubscribeInfo

@Feature(licenseCreateManually)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseCreateManually

@Feature(licenseReplaceLicenseMember)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseReplaceLicenseMember

@Feature("/api/v1/lic-upsert")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicUpsertV1

@Feature("/api/v1/license-task_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseTaskAddV1

@Feature("/api/v1/license_get-by-task-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseGetByTaskIdV1

@Feature("/api/v1/license-promocode_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicensePromocodeAddV1

@Feature("/api/v1/license_upgrade")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseUpgradeV1

@Feature("/api/v1/task-queue_get-grouped-by-program")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TaskQueueGetGroupedByProgramV1

@Feature("/api/v1/multiaccess_statistic_get-by-accessid")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MultiaccessStatisticGetByAccessIdV1

@Feature("/api/v1/license_upgrade-by-productid")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseUpgradeByProductIdV1

@Feature("/api/v1/access_change-master-user")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessChangeMasterUserV1

@Feature("/api/v1/access_get-previous-access-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessGetPreviousAccessIdV1

@Feature("/api/v1/access_get-subscription-by-block-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessGetSubscriptionByBlockIdV1

@Feature("/api/v1/access-ids_get-by-subscribe-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessIdsGetBySubscribeIdsV1

@Feature("/api/v1/access_get-last-sum-by-customer")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessGetLastSumByCustomer

@Feature("/api/v1/access_get-by-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessGetByIds

@Feature("/api/v1/license-states_get-by-subscribe-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseStatesGetBySubscribeIds

@Feature("/api/v1/license-states_get-by-subscribe-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseRequestsGetBySubscribeIds

@Feature("/api/v1/license-request_cancel")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseRequestCancelV1

@Feature(licenseGetChildData)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseGetChildData
// endregion

// region [Qa]
@Feature("/api/v1/qa_change-license-sales-on")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class QaChangeLicenseSalesOnV1
// endregion

// region [SalesOrder]
@Feature("/api/v1/order-contents_get-by-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrderContentsGetByIdsV1

@Feature("/api/v1/orders_get-to-create-logentries-batch-by-batch-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrdersGetToCreateLogentriesBatchByBatchIdV1

@Feature("/api/v1/subscribe_get-ids-count-by-params")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SubscribeGetIdsCountByParamsV1

@Feature("/api/v1/orders_get-to-create-logentries-batch-by-product-ids-by-customer-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrdersGetToCreateLogentriesBatchByProductIdsByCustomerIdV1

@Feature("/api/v1/orders_get-to-create-logentries-batch-by-product-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrdersGetToCreateLogentriesBatchByProductIdsV1

@Feature(ordersGetExtendedByCustomerIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrdersGetExtendedByCustomerIds
// endregion

// region [Storage]
@Feature(accessCancel)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessCancelV1

@Feature(accessSlaveAdd)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessSlaveAddV1

@Feature("/api/v1/access-slave_bulk-update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessSlaveBulkUpdateV1

@Feature("/api/v1/access-slave_remove")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessSlaveRemoveV1

@Feature(storageAccessAdd)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StorageAccessAddV1

@Feature("/api/v1/storage-access_deactivate")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StorageAccessDeactivateV1

@Feature(storageAccessGetByCode)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StorageAccessGetByCodeV1

@Feature(storageAccessGetById)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StorageAccessGetByIdV1

@Feature("/api/v1/storage-access_update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StorageAccessUpdateV1
// endregion