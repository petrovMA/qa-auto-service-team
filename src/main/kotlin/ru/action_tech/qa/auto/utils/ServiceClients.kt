package ru.action_tech.qa.auto.utils

import ru.action_tech.qa.auto.core.api.ApiClient
import ru.action_tech.qa.auto.utils.url_builder.*

//region [identity]
val identityApi by lazy { ApiClient(IDENTITY_URL) }

//region [arm-seller]
val asteriskArmSellerClient by lazy { ApiClient(url = ASTERISK_ARM_SELLER_URL) }
val customerserviceArmSellerClient by lazy { ApiClient(url = CUSTOMERSERVICE_ARM_SELLER_URL) }
val dictionaryArmSellerClient by lazy { ApiClient(url = DICTIONARY_ARM_SELLER_URL) }
val ermBackendArmSellerClient by lazy { ApiClient(url = ERM_BACKEND_ARM_SELLER_URL) }
val eventsArmSellerClient by lazy { ApiClient(url = EVENTS_ARM_SELLER_URL) }
val hubArmSellerClient by lazy { ApiClient(url = HUB_ARM_SELLER_URL) }
val loyaltyserviceArmSellerClient by lazy { ApiClient(url = LOYALTYSERVICE_ARM_SELLER_URL) }
val managersArmSellerClient by lazy { ApiClient(url = MANAGERS_ARM_SELLER_URL) }
val monitorBackendArmSellerClient by lazy { ApiClient(url = MONITOR_BACKEND_ARM_SELLER_URL) }
val partnersArmSellerClient by lazy { ApiClient(url = PARTNERS_ARM_SELLER_URL) }
val phonecallsArmSellerClient by lazy { ApiClient(url = PHONECALLS_ARM_SELLER_URL) }
val qaArmSellerClient by lazy { ApiClient(url = QA_ARM_SELLER_URL) }
val scriptArmSellerClient by lazy { ApiClient(url = SCRIPT_ARM_SELLER_URL) }
val settingsArmSellerClient by lazy { ApiClient(url = SETTINGS_ARM_SELLER_URL) }
val shipmentArmSellerClient by lazy { ApiClient(url = SHIPMENT_ARM_SELLER_URL) }
val statArmSellerClient by lazy { ApiClient(url = STAT_ARM_SELLER_URL) }
val stoplistArmSellerClient by lazy { ApiClient(url = STOPLIST_ARM_SELLER_URL) }
val telephonyAdminBackendArmSellerClient by lazy { ApiClient(url = TELEPHONY_ADMIN_BACKEND_ARM_SELLER_URL) }
val telephonyArmSellerClient by lazy { ApiClient(url = TELEPHONY_ARM_SELLER_URL) }
val userserviceArmSellerClient by lazy { ApiClient(url = USERSERVICE_ARM_SELLER_URL) }
//endregion

//region [crm]
val accessesCrmClient by lazy { ApiClient(url = ACCESSES_CRM_URL) }
val addressesCrmClient by lazy { ApiClient(url = ADDRESSES_CRM_URL) }
val admin360BackendCrmClient by lazy { ApiClient(url = ADMIN360_BACKEND_CRM_URL) }
val applicationsBackendCrmClient by lazy { ApiClient(url = APPLICATIONS_BACKEND_CRM_URL) }
val crmApiCrmClient by lazy { ApiClient(url = CRM_API_CRM_URL) }
val demosCrmClient by lazy { ApiClient(url = DEMOS_CRM_URL) }
val documentsCrmClient by lazy { ApiClient(url = DOCUMENTS_CRM_URL) }
val filesCrmClient by lazy { ApiClient(url = FILES_CRM_URL) }
val ordersCrmClient by lazy { ApiClient(url = ORDERS_CRM_URL) }
val paymentsCrmClient by lazy { ApiClient(url = PAYMENTS_CRM_URL) }
val productCrmClient by lazy { ApiClient(url = PRODUCT_CRM_URL) }
val publicApiCrmClient by lazy { ApiClient(url = PUBLIC_API_CRM_URL) }
val receiptsCrmClient by lazy { ApiClient(url = RECEIPTS_CRM_URL) }
val schoolCrmClient by lazy { ApiClient(url = SCHOOL_CRM_URL) }
val shipmentCrmClient by lazy { ApiClient(url = SHIPMENT_CRM_URL) }
val supportsCrmClient by lazy { ApiClient(url = SUPPORTS_CRM_URL) }
//endregion

//region [srvc]
val incidentsSrvcClient by lazy { ApiClient(url = INCIDENTS_SRVC_URL) }
val serviceBackendSrvcClient by lazy { ApiClient(url = SERVICE_BACKEND_SRVC_URL) }
//endregion

//region [bod]
val partnersBodClient by lazy { ApiClient(url = PARTNERS_BOD_URL) }
// endregion

//region [s3]
val crmS3Client by lazy { ApiClient(url = CRM_S3_URL) }
val crmS3TechClient by lazy { ApiClient(url = CRM_S3_TECH_URL) }
//endregion

//region [EXTERNAL-SERVICES]
val accessBackendStoragesClient by lazy { ApiClient(url = ACCESS_BACKEND_STORAGES_URL) }
val onlineHelperBackendChatsClient by lazy { ApiClient(url = ONLINE_HELPER_BACKEND_CHATS_URL) }
//endregion