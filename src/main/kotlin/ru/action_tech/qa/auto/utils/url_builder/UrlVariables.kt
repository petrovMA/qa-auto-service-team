package ru.action_tech.qa.auto.utils.url_builder

import ru.action_tech.qa.auto.core.properties.TProperty

//region [identity]
val IDENTITY_URL by TProperty.notNullable<String>()

//region [arm-seller]
val ERM_SSR_FRONTEND_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.ERM_SSR_FRONTEND_ARM_SELLER.url }

val ASTERISK_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.ASTERISK_ARM_SELLER.url }
val CUSTOMERSERVICE_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.CUSTOMERSERVICE_ARM_SELLER.url }
val DICTIONARY_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.DICTIONARY_ARM_SELLER.url }
val ERM_BACKEND_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.ERM_BACKEND_ARM_SELLER.url }
val EVENTS_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.EVENTS_ARM_SELLER.url }
val HUB_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.HUB_ARM_SELLER.url }
val LOYALTYSERVICE_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.LOYALTYSERVICE_ARM_SELLER.url }
val MANAGERS_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.MANAGERS_ARM_SELLER.url }
val MONITOR_BACKEND_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.MONITOR_BACKEND_ARM_SELLER.url }
val PARTNERS_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.PARTNERS_ARM_SELLER.url }
val PHONECALLS_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.PHONECALLS_ARM_SELLER.url }
val QA_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.QA_ARM_SELLER.url }
val SCRIPT_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.SCRIPT_ARM_SELLER.url }
val SETTINGS_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.SETTINGS_ARM_SELLER.url }
val SHIPMENT_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.SHIPMENT_ARM_SELLER.url }
val STAT_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.STAT_ARM_SELLER.url }
val STOPLIST_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.STOPLIST_ARM_SELLER.url }
val TELEPHONY_ADMIN_BACKEND_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.TELEPHONY_ADMIN_BACKEND_ARM_SELLER.url }
val TELEPHONY_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.TELEPHONY_ARM_SELLER.url }
val USERSERVICE_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.USERSERVICE_ARM_SELLER.url }
//endregion

//region [crm]
val ADMIN360_FRONTEND_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.ADMIN360_FRONTEND_CRM.url }
val MONITOR_FRONTEND_ARM_SELLER_URL by TProperty.notNullable { ServiceUrlBuilder.MONITOR_FRONTEND_ARM_SELLER.url }

val ACCESSES_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.ACCESSES_CRM.url }
val ADDRESSES_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.ADDRESSES_CRM.url }
val ADMIN360_BACKEND_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.ADMIN360_BACKEND_CRM.url }
val APPLICATIONS_BACKEND_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.APPLICATIONS_BACKEND_CRM.url }
val CRM_API_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.CRM_API_CRM.url }
val DEMOS_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.DEMOS_CRM.url }
val DOCUMENTS_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.DOCUMENTS_CRM.url }
val FILES_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.FILES_CRM.url }
val ORDERS_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.ORDERS_CRM.url }
val PAYMENTS_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.PAYMENTS_CRM.url }
val PRODUCT_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.PRODUCT_CRM.url }
val PUBLIC_API_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.PUBLIC_API_CRM.url }
val RECEIPTS_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.RECEIPTS_CRM.url }
val SCHOOL_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.SCHOOL_CRM.url }
val SHIPMENT_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.SHIPMENT_CRM.url }
val SUPPORTS_CRM_URL by TProperty.notNullable { ServiceUrlBuilder.SUPPORTS_CRM.url }
//endregion

//region [srvc]
val INCIDENTS_SRVC_URL by TProperty.notNullable { ServiceUrlBuilder.INCIDENTS_SRVC.url }
val SERVICE_BACKEND_SRVC_URL by TProperty.notNullable { ServiceUrlBuilder.SERVICE_BACKEND_SRVC.url }
//endregion

//region [bod]
val PARTNERS_BOD_URL by TProperty.notNullable { ServiceUrlBuilder.PARTNERS_BOD.url }
//endregion

//region [s3]
val CRM_S3_URL by TProperty.notNullable { ServiceUrlBuilder.CRM_S3.url }
val CRM_S3_TECH_URL by TProperty.notNullable { ServiceUrlBuilder.CRM_S3_TECH.url }
//endregion

//region [EXTERNAL-SERVICES]
val ACCESS_BACKEND_STORAGES_URL by TProperty.notNullable { ServiceUrlBuilder.ACCESS_BACKEND_STORAGES.url }
val ONLINE_HELPER_BACKEND_CHATS_URL by TProperty.notNullable { ServiceUrlBuilder.ONLINE_HELPER_BACKEND_CHATS.url }
//endregion

//region [x-path-key]
val X_PATH_KEY_ACCESSES by TProperty.notNullable<String>(vaultPath = { "/qa-auto/qa-auto-erm-ssr/X_PATH_KEY_ACCESSES" })
val X_PATH_KEY_INCIDENTS by TProperty.notNullable<String>(vaultPath = { "/qa-auto/qa-auto-erm-ssr/X_PATH_KEY_INCIDENTS" })
val X_PATH_KEY_ORDERS by TProperty.notNullable<String>(vaultPath = { "/qa-auto/qa-auto-erm-ssr/X_PATH_KEY_ORDERS" })
val X_PATH_KEY_PARTNERS by TProperty.notNullable<String>(vaultPath = { "/qa-auto/qa-auto-erm-ssr/X_PATH_KEY_PARTNERS" })
val X_PATH_KEY_PAYMENTS by TProperty.notNullable<String>(vaultPath = { "/qa-auto/qa-auto-erm-ssr/X_PATH_KEY_PAYMENTS" })
val X_PATH_KEY_PUBLIC_API by TProperty.notNullable<String>(vaultPath = { "/qa-auto/qa-auto-erm-ssr/X_PATH_KEY_PUBLIC_API" })
val X_PATH_KEY_SUPPORTS by TProperty.notNullable<String>(vaultPath = { "/qa-auto/qa-auto-erm-ssr/X_PATH_KEY_SUPPORTS" })
//endregion

//region [ServiceUrlBuilder constants]
const val HTTP = "http"
const val HTTPS = "https"
const val ARM_SELLER = "arm-seller"
const val CRM = "crm"
const val SRVC = "srvc"
const val STORAGES = "storages"
const val CHATS = "chats"
const val S3 = "s3"
const val ASERVICES = "aservices.tech"
//endregion