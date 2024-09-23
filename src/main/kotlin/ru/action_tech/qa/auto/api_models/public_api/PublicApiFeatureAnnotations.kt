package ru.action_tech.qa.auto.api_models.public_api

import io.qameta.allure.Feature

// region [Customer]
@Feature(customerGetByPinV3)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerGetByPinV3
// endregion

// region [Document]
@Feature(documentSendMail)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentSendMail

@Feature(contractTemplatesGetOrderById)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ContractTemplatesGetOrderById

@Feature(billsGetByOrdersIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BillsGetByOrdersIds
// endregion

// region [Manager]
@Feature(managerSetStopListLimit)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagerSetStopListLimit
// endregion

// region [MasterOrder]
@Feature(orderCreateByRobot)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrderCreateByRobot
// endregion

// region [StopList]
@Feature(stopListsGetByPartnerId)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListsGetByPartnerId

@Feature(stopListBindPublicApi)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListBind

@Feature(stopListBindNewCustomerPublicApi)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListBindNewCustomer
// endregion

@Feature("/api/v1/contact-lpr_update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ContactLprUpdate

@Feature("/api/v1/test_posts-public")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TestPostsPublic

@Feature("/api/v1/customer-support-info_get-by-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerSupportInfoGetById

@Feature("/api/v2/customer_get-by-pin")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerGetByPin

@Feature("/api/v1/customer-with-robot-events_get-by-email")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerWithRobotEventsGetByEmail

@Feature("/api/v1/units")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class UnitsV1

@Feature("/api/v2/campaign_get-by-action-number")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CampaignGetByActionNumberV2

@Feature("/api/v1/product-info_get-by-action-number")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ProductInfoGetByActionNumberV1

@Feature("/api/v1/customer-with-robot-events_get-by-bitrixId")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerWithRobotEventsGetByBitrixId

@Feature("/api/v1/customer-with-robot-events_get-by-phonenumber")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerWithRobotEventsGetByPhonenumber

@Feature("/api/v1/user-head-status_get-by-bitrix-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class UserHeadStatusGetByBitrixIdV1

@Feature("/api/v1/payment_create-installment")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentCreateInstallment

@Feature("/api/v2/customer_contact-update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerContactUpdateV2

@Feature("/api/v1/phonecalls_complete")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhonecallsCompleteV1

@Feature("/api/v1/phonecalls_get-campaigns")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhonecallsGetCampaignsV1

@Feature("/api/v1/demo-access_create")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DemoAccessCreateV1

@Feature("/api/v1/okp/phonecalls_get-by-campaign")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OkpPhonecallsGetByCampaignV1

@Feature("/api/v1/okp/phonecalls_get-by-primary")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhonecallsGetByPrimaryV1

@Feature("/api/v1/phonecalls_get-by-campaign")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhonecallsGetByCampaignV1

@Feature("/api/v1/okp/phonecalls_get-by-customer")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OkpPhoneCallsGetByCustomerV1

@Feature("/api/v1/phonecalls_import")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhoneCallsImportV1

@Feature("/api/v1/phonecalls_import-mp3")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhoneCallsImportMp3V1

@Feature("/api/v1/phonecalls-owner_change")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhoneCallsOwnerChangeV1

@Feature("/api/v1/open-phonecalls_get-by-users")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OpenPhoneCallsGetByUsersV1

@Feature("/api/v1/customer_get-by-phonenumber")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerGetByPhonenumberV1

@Feature("/api/v2/customer_connect-contact")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerConnectContactV2

@Feature("/api/v2/customer_disconnect-contact")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerDisconnectContactV2

@Feature("/api/v2/customer_jobtitles")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerJobtitlesV2

@Feature("/api/v1/bill_send")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BillSendV1

@Feature("/api/v2/customer_search")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerSearchV2

@Feature("/api/v1/roles_get")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class RolesGetV1

@Feature("/api/v1/manager_get")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagerGetV1

@Feature("/api/v1/managers_get-list")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagersGetListV1

@Feature("/api/v1/managers_get-by-business-unit")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagersGetByBusinessUnitV1

@Feature("/api/v1/manager-roles_get")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagerRolesGetV1

@Feature("/api/v1/manager-roles_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagerRolesAddV1

@Feature("/api/v1/manager-roles_delete")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagerRolesDeleteV1

@Feature("/api/v1/manager_update")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagerUpdateV1

@Feature("/api/v1/manager_create")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagerCreateV1

@Feature("/api/v1/managers_get-by-partners")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ManagersGetByPartnersV1

@Feature("/api/v1/get_registration-request")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class GetRegistrationRequestV1

@Feature("/api/v1/get_manager-with-roles")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class GetManagersWithRolesV1

@Feature("/api/v1/stoplist_get-list-by-manager")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListGetListByManagerV1

@Feature("/api/v1/stoplist_manager-change")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StopListManagerChangeV1

@Feature("/api/v1/supports_get-by-manager")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsGetByManagerV1

@Feature("/api/v1/supports_change-manager")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsChangeManagerV1

@Feature("/api/v1/customer_check-is-own360-by-partner-and-email")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerCheckIsOwn360ByPartnerAndEmailV1

@Feature("api/v2/phonecalls_get-by-campaign")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PhonecallsGetByCampaignV2

@Feature("/api/v2/customer_accounts-bycontact")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerAccountsByContactV2

@Feature("/api/v2/customer_get-by-phonenumber")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerGetByPhonenumberV2