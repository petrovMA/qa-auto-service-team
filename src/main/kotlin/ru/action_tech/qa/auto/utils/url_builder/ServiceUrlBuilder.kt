package ru.action_tech.qa.auto.utils.url_builder

import ru.action_tech.qa.auto.core.commons.platform.IServiceUrlBuilder
import ru.action_tech.qa.auto.core.properties.ENV
import ru.action_tech.qa.auto.core.utils.test_env.Environment
import ru.action_tech.qa.auto.core.utils.test_env.TestEnvUtils.env

enum class ServiceUrlBuilder(
    override val serviceName: String,
    override val productName: String,
    override val protocol: String = HTTP,
    override val domain: String = ASERVICES,
    val techUrl: Boolean = true
) : IServiceUrlBuilder {

    //region [arm-seller]
    ERM_SSR_FRONTEND_ARM_SELLER(serviceName = "erm-ssr-frontend", productName = ARM_SELLER) {
        override val url = when (env) {
            Environment.DEV -> super.url
            Environment.RC -> super.url
            Environment.PROD -> "https://erm.action-mcfr.ru/login"
            else -> throw IllegalArgumentException("Unknown environment: $ENV")
        }
    },
    MONITOR_FRONTEND_ARM_SELLER(serviceName = "monitor-frontend", productName = ARM_SELLER) {
        override val url = when (env) {
            Environment.DEV -> super.url
            Environment.RC -> super.url
            Environment.PROD -> "https://monitor.action-mcfr.ru/login"
            else -> throw IllegalArgumentException("Unknown environment: $ENV")
        }
    },
    A360("admin360-frontend", "crm") {
        override val url: String
            get() = when (ENV) {
                "dev" -> super.url
                "rc" -> super.url
                "prod" -> "https://admin360.action-mcfr.ru/"
                else -> throw IllegalArgumentException("Unknown ENV = $ENV")
            }
    },
    ASTERISK_ARM_SELLER(serviceName = "asterisk", productName = ARM_SELLER),
    USERSERVICE_ARM_SELLER(serviceName = "userservice", productName = ARM_SELLER),
    SETTINGS_ARM_SELLER(serviceName = "settings", productName = ARM_SELLER),
    CUSTOMERSERVICE_ARM_SELLER(serviceName = "customerservice", productName = ARM_SELLER),
    STAT_ARM_SELLER(serviceName = "stat", productName = ARM_SELLER),
    MANAGERS_ARM_SELLER(serviceName = "managers", productName = ARM_SELLER),
    PHONECALLS_ARM_SELLER(serviceName = "phonecalls", productName = ARM_SELLER),
    LOYALTYSERVICE_ARM_SELLER(serviceName = "loyaltyservice", productName = ARM_SELLER),
    ERM_BACKEND_ARM_SELLER(serviceName = "erm-backend", productName = ARM_SELLER),
    SCRIPT_ARM_SELLER(serviceName = "script", productName = ARM_SELLER),
    DICTIONARY_ARM_SELLER(serviceName = "dictionary", productName = ARM_SELLER),
    SHIPMENT_ARM_SELLER(serviceName = "shipment", productName = ARM_SELLER),
    STOPLIST_ARM_SELLER(serviceName = "stoplist", productName = ARM_SELLER),
    HUB_ARM_SELLER(serviceName = "hub", productName = ARM_SELLER),
    TELEPHONY_ADMIN_BACKEND_ARM_SELLER(serviceName = "telephony-admin-backend", productName = ARM_SELLER),
    TELEPHONY_ARM_SELLER(serviceName = "telephony", productName = ARM_SELLER),
    MONITOR_BACKEND_ARM_SELLER(serviceName = "monitor-backend", productName = ARM_SELLER),
    EVENTS_ARM_SELLER(serviceName = "events", productName = ARM_SELLER),
    QA_ARM_SELLER(serviceName = "qa", productName = ARM_SELLER),
    PARTNERS_ARM_SELLER(serviceName = "partners", productName = ARM_SELLER),
    //endregion

    //region [crm]
    ADMIN360_FRONTEND_CRM(serviceName = "admin360-frontend", productName = CRM) {
        override val url = when (env) {
            Environment.DEV -> super.url
            Environment.RC -> super.url
            Environment.PROD -> "https://admin360.action-mcfr.ru/"
            else -> throw IllegalArgumentException("Unknown environment: $ENV")
        }
    },
    ERM("erm-ssr-frontend", "arm-seller") {
        override val url: String
            get() = when (ENV) {
                "dev" -> super.url
                "rc" -> super.url
                "prod" -> "https://erm.action-mcfr.ru/login"
                else -> throw IllegalArgumentException("Unknown ENV = $ENV")
            }
    },
    SCHOOL_CRM(serviceName = "school", productName = CRM),
    FILES_CRM(serviceName = "files", productName = CRM),
    PUBLIC_API_CRM(serviceName = "public-api", productName = CRM),
    SUPPORTS_CRM(serviceName = "supports", productName = CRM),
    ACCESSES_CRM(serviceName = "accesses", productName = CRM),
    PAYMENTS_CRM(serviceName = "payments", productName = CRM),
    ADDRESSES_CRM(serviceName = "addresses", productName = CRM),
    RECEIPTS_CRM(serviceName = "receipts", productName = CRM),
    ORDERS_CRM(serviceName = "orders", productName = CRM),
    DOCUMENTS_CRM(serviceName = "documents", productName = CRM),
    DEMOS_CRM(serviceName = "demos", productName = CRM),
    PRODUCT_CRM(serviceName = "product", productName = CRM),
    APPLICATIONS_BACKEND_CRM(serviceName = "applications-backend", productName = CRM),
    ADMIN360_BACKEND_CRM(serviceName = "admin360-backend", productName = CRM),
    SHIPMENT_CRM(serviceName = "shipment", productName = CRM),
    CRM_API_CRM(serviceName = "crm-api", productName = CRM, protocol = HTTPS) {
        override val url = "$protocol://$serviceName.$ENV.$productName.$domain"
    },
    //endregion

    //region [srvc]
    INCIDENTS_SRVC(serviceName = "incidents", productName = SRVC, protocol = HTTPS),
    SERVICE_BACKEND_SRVC(serviceName = "service-backend", productName = SRVC, protocol = HTTPS),
    //endregion

    //region [bod]
    PARTNERS_BOD(serviceName = "partners", productName = "bod", protocol = HTTPS) {
        override val url = "$protocol://api.$serviceName.action-mcfr.ru"
    },
    //endregion

    //region [s3]
    CRM_S3_TECH(serviceName = "crm", productName = S3, protocol = HTTPS) {
        override val url = when (env) {
            Environment.PROD -> "$protocol://$productName.$domain/$serviceName${ENV.lowercase()}:$serviceName"
            else -> "$protocol://$productName.dev.$domain/$serviceName${ENV.lowercase()}:$serviceName"
        }
    },
    CRM_S3(serviceName = "crm", productName = S3, protocol = HTTPS, techUrl = false) {
        override val url = when (env) {
            Environment.PROD -> "$protocol://api.erm.action-mcfr.ru/$productName/"
            else -> "$protocol://$productName.dev.$domain/$serviceName${ENV.lowercase()}:$serviceName/"
        }
    },
    //endregion

    //region [EXTERNAL-SERVICES]
    ACCESS_BACKEND_STORAGES(serviceName = "access-backend", productName = STORAGES),
    ONLINE_HELPER_BACKEND_CHATS(serviceName = "online-helper-backend", productName = CHATS);
    //endregion
}