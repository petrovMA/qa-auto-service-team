package ru.action_tech.qa.auto.api_models.erm_backend

const val licenseCreateManually = "/api/v1/license_create-manually"
const val licenseGetSubscribeInfo = "/api/v1/license_get-susbcribe-info"
const val licenseChangeMember = "/api/v1/license_change-member"
const val paymentScenarioGetList = "/api/v1/payment-scenario_get-list"
const val priceLevelSearch = "/api/v1/price-level_search"
const val paymentGet = "/api/v1/payment_get"
const val basketGroupGetListByPriceLevelV3 = "/api/v3/basket-group_get-list-by-price-level"
const val basketGroupGetListByPriceLevelV4 = "/api/v4/basket-group_get-list-by-price-level"

const val priceLevelsGetForLicenseUpgrade = "/api/v1/price-levels_get-for-license-upgrade"
const val editionGetForDemoAccess = "/api/v1/edition_get-for-demoaccess"

const val mainProductsGet = "/api/v1/main-products_get"
const val a360DealsGetByBusinessUnit = "/api/v1/a360-deals_get-by-business-unit"
const val getSearchPromoword = "/api/v1/get_search-promoword"
const val getPromoword = "/api/v1/get_promoword"
const val getPublication = "/api/v1/get_publication"
const val getPreviewByPublication = "/api/v1/get_preview-by-publication"
const val mainProductGetList = "/api/v1/main-product_get-list"
const val directionGetListByCampaign = "/api/v1/direction_get-list-by-campaign"
const val priceLevelGetListByCustomer = "/api/v1/price-level_get-list-by-customer"
const val versionSearch = "/api/v1/version_search"
const val mainProductTypeGetListBySalesProductType = "/api/v1/main-product-type_get-list-by-sales-product-type"
const val orderDocumentsCreate = "/api/v1/order-documents_create"
const val orderDocumentsHistoryGet = "/api/v1/order-documents-history_get"
const val accessSlavesAdd = "/api/v1/access-slaves_add"
const val accessSlavesGetV2 = "/api/v2/access-slaves_get"

const val orderGetListForPartner = "/api/v1/order_get-list-for-partner"
const val orderGetListByCustomer = "/api/v1/order/get-list-by-customer"

const val orderGetListByAuthors = "/api/v1/order_get-list-by-authors"

// region [Customer]
const val customerGetById = "/api/v1/customer_get-by-id"
// endregion

// region [Support]
const val supportsChangeManager = "/api/support/v1/supports_change-manager"
const val supportsGetByManager = "/api/v1/supports_get-by-manager"
// endregion

// region [EmailTemplates]
const val documentsGetByOrderAndCustomer = "/api/v1/documents_get-by-order-and-customer"
// endregion

// region [A360Deal]
const val a360DealsGet = "/api/v1/a360-deals_get"
const val a360DealAdd = "/api/v1/a360-deal_add"
const val a360DealDetach = "/api/v1/a360-deal_detach"
const val a360DealUpdate = "/api/v1/a360-deal_update"
const val a360DealsModerationGet = "/api/v1/a360-deals-moderation_get"
const val customerRecommendedPricesGet = "/api/v1/customer-recommended-prices_get"
const val a360DealManagersLimitGetByIds = "/api/v1/a360-deal-managers-limits_get-by-ids"
const val a360DealRegularUpdate = "/api/v1/a360-deal-regular_update"
const val a360DealsManagerUpdate = "/api/v1/a360-deals-manager_update"
const val a360DealsManagerLimitsUpdate = "/api/v1/a360-deal-managers-limits_update"
const val a360DealReattach = "/api/v1/a360-deal_reattach"
// endregion

// region [DocumentBasket]
const val documentBasketContentCanBeAdded = "/api/v1/document-basket-content_can-be-added"
const val documentBasketGetAvailableSendMethods = "/api/v1/document-basket_get-available-send-methods"
const val documentBasketGetAvailableEdoProviders = "/api/v1/document-basket_get-available-edo-providers"
const val documentBasketGetExtendedInfo = "/api/v1/document-basket_get-extended-info"
const val documentBasketGetExtendedInfoEdo = "/api/v1/document-basket_get-extended-info-edo"
const val basketContentAdd = "/api/v1/basket-content_add"
const val basketContentDelete = "/api/v1/basket-content_delete"
const val documentBasketGetFileDocumentSubtypesEdo = "/api/v1/document-basket_get-file-document-subtypes-edo"
const val documentBasketProcessEmail = "/api/v1/document-basket_process-email"
const val documentBasketProcessSuspendPrint = "/api/v1/document-basket_process-suspend-print"
const val offerGetByMainProductOrOrder = "/api/v1/offer_get-by-main-product-or-order"
const val documentBasketProcess = "/api/v1/document-basket_process"
const val basketContentFileUpload = "/api/v1/basket-content-file_upload"
// endregion

// region [DemoAccess]
const val demoAccessListByCustomer = "/api/v1/demo-access/list-by-customer"
//

// region [License]
const val accessChangeMasterUser = "/api/v1/access_change-master-user"
// endregion

// region [Invoices]
const val invoicesGetByAccountId = "/api/v1/invoices_get-by-accountId"
const val invoicesDownload = "/api/v2/invoices_download"
// endregion
