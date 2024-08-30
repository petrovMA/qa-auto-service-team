package ru.action_tech.qa.auto.api_models.erm_backend

import io.qameta.allure.Feature

// region [Erm_Backend]
@Feature(licenseCreateManually)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseCreateManuallyV1

@Feature(licenseGetSubscribeInfo)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseGetBySubscribeInfoV1

@Feature(licenseChangeMember)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseChangeMemberV1

@Feature(licenseGetSubscribeInfo)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseGetSubscribeInfoV1

@Feature(paymentScenarioGetList)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentScenarioGetListV1

@Feature(priceLevelSearch)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PriceLevelSearchV1

@Feature(priceLevelsGetForLicenseUpgrade)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PriceLevelsGetForLicenseUpgradeV1

@Feature(editionGetForDemoAccess)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class EditionGetForDemoAccessV1

@Feature(mainProductsGet)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MainProductsGetV1

@Feature(a360DealsGetByBusinessUnit)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealsGetByBusinessUnitV1

@Feature(paymentGet)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentGetV1

@Feature(basketGroupGetListByPriceLevelV3)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BasketGroupGetListByPriceLevelV3

@Feature(basketGroupGetListByPriceLevelV4)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BasketGroupGetListByPriceLevelV4

@Feature(getSearchPromoword)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class GetSearchPromowordV1

@Feature(getPromoword)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class GetPromowordV1

@Feature(getPublication)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class GetPublicationV1

@Feature(getPreviewByPublication)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class GetPreviewByPublicationV1

@Feature(mainProductGetList)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MainProductGetListV1

@Feature(directionGetListByCampaign)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DirectionGetListByCampaignV1

@Feature(priceLevelGetListByCustomer)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PriceLevelGetListByCustomerV1

@Feature(versionSearch)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class VersionSearchV1

@Feature(mainProductTypeGetListBySalesProductType)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MainProductTypeGetListBySalesProductTypeV1

@Feature(orderDocumentsCreate)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrderDocumentsCreateV1

@Feature(orderDocumentsHistoryGet)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrderDocumentsHistoryGetV1

@Feature(orderGetListForPartner)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrderGetListForPartnerV1

@Feature(orderGetListByCustomer)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrderGetListByCustomer

@Feature("/api/v1/analysis-customers_get-by-a360-deals-customer-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AnalysisCustomersGetByA360DealsCustomerIdsV1

@Feature("/api/v1/a360-deals-regular_get-by-business-unit")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealsRegularGetByBusinessUnitV1

@Feature("/api/v1/calc-manual-support-files_create")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CalcManualSupportFilesCreateV1

@Feature("/api/v1/calc-manual-support-contacts_create")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CalcManualSupportContactsCreateV1

@Feature("/api/v1/calc-manual-support-files_get-by-author-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CalcManualSupportFilesGetByAuthorIdV1

@Feature("/api/v1/documents_get-by-order-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentsGetByOrderIdsV1

@Feature("/api/v1/incident-files_get-by-incident-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class IncidentFilesGetByIncidentIdV1

@Feature("/api/v2/working-rules_get-by-customer")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class WorkingRulesGetByCustomerV2

@Feature("/api/v1/access-slaves_add")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessSlavesAddV1

@Feature(accessSlavesGetV2)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessSlavesGetV2

@Feature(orderGetListByAuthors)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OrderGetListByAuthors
// endregion


// region [Support]
@Feature(supportsChangeManager)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsChangeManager

@Feature(supportsGetByManager)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SupportsGetByManager
// endregion


// region [EmailTemplates]
@Feature(documentsGetByOrderAndCustomer)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentsGetByOrderAndCustomer
// endregion


// region [A360Deal]
@Feature(a360DealsGet)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealsGetV1

@Feature(a360DealAdd)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealAddV1

@Feature(a360DealDetach)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealDetachV1

@Feature(a360DealUpdate)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealUpdateV1

@Feature(a360DealsModerationGet)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealsModerationGetV1

@Feature(customerRecommendedPricesGet)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerRecommendedPricesGetV1

@Feature(a360DealsManagerUpdate)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealsManagerUpdate

@Feature(a360DealsManagerLimitsUpdate)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealsManagerLimitsUpdate

@Feature(a360DealManagersLimitGetByIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealManagersLimitGetByIds

@Feature(a360DealReattach)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealReattach

@Feature(a360DealRegularUpdate)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class A360DealRegularUpdate
// endregion


// region [DocumentBasket]
@Feature(documentBasketGetAvailableSendMethods)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketGetAvailableSendMethods

@Feature(documentBasketContentCanBeAdded)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketContentCanBeAdded

@Feature(documentBasketGetExtendedInfo)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketGetExtendedInfo

@Feature(documentBasketGetExtendedInfoEdo)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketGetExtendedInfoEdo

@Feature(basketContentAdd)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BasketContentAdd

@Feature(basketContentDelete)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BasketContentDelete

@Feature(documentBasketGetFileDocumentSubtypesEdo)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketGetFileDocumentSubtypesEdo

@Feature(documentBasketGetAvailableEdoProviders)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketGetAvailableEdoProviders

@Feature(documentBasketProcessEmail)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketProcessEmail

@Feature(documentBasketProcessSuspendPrint)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketProcessSuspendPrint

@Feature(offerGetByMainProductOrOrder)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class OfferGetByMainProductOrOrder

@Feature(documentBasketProcess)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DocumentBasketProcess

@Feature(basketContentFileUpload)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BasketContentFileUpload
// endregion

// region [DemoAccess]
@Feature(demoAccessListByCustomer)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DemoAccessListByCustomer
// endregion

// region [License]
@Feature(accessChangeMasterUser)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AccessChangeMasterUser
// endregion


// region [Invoices]
@Feature(invoicesGetByAccountId)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class InvoicesGetByAccountId

@Feature(invoicesDownload)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class InvoicesDownload
// endregion