package ru.action_tech.qa.auto.api_models.accesses.license.v1.license_task_add

data class LicenseTaskAddRequest(
    val accountId: String? = null,
    val actionId: String? = null,
    val activateOn: String? = null,
    val activatedContactId: String? = null,
    val authCode: String? = null,
    val bitrixId: Int? = null,
    val blockReason: Int? = null,
    val bonus: Int? = null,
    val bonusOrderId: String? = null,
    val bonusSumm: Int? = null,
    val comment: String? = null,
    val commentModifiedBy: String? = null,
    val commentModifiedOn: String? = null,
    val commonId: String? = null,
    val consumptionStatusModifiedOn: String? = null,
    val contactId: String? = null,
    val contractPaymentDate: String? = null,
    val createdBy: String? = null,
    val createdOn: String? = null,
    val digitalSignatureNumber: Int? = null,
    val doneOn: String? = null,
    val extensionPartnerId: String? = null,
    val extensionSysUserId: String? = null,
    val giveUkd: Int? = null,
    val id: String? = null,
    val individualSaleApproval: Boolean? = null,
    val instantAccess: Boolean? = null,
    val isAutoActivated: Boolean? = null,
    val isAutoBlocked: Boolean? = null,
    val isAutoRegistered: Boolean? = null,
    val isCalcAutoActivation: Boolean? = null,
    val isCalcShiftDates: Boolean? = null,
    val isEmailSent: Boolean? = null,
    val isExternalRegistration: Boolean? = null,
    val isPastPeriod: Boolean? = null,
    val isRegisteredByAnotherPartner: Boolean? = null,
    val isRegisteredInAp: Boolean? = null,
    val isRegisteredInMcfr: Boolean? = null,
    val isSupportPasedFromErm: Boolean? = null,
    val isTrackRefresh: Boolean? = null,
    val isUpgrade: Boolean? = null,
    val licenseTypeCode: Int? = null,
    val loginActivated: String? = null,
    val managerComment: String? = null,
    val maxSupportCalls: Int? = null,
    val mcfrRkCode: Int? = null,
    val parentLicId: String? = null,
    val parentServiceActivatedOn: String? = null,
    val partnerAmount: Int? = null,
    val paymentScenarioId: String? = null,
    val period: Int? = null,
    val periodType: Int? = null,
    val plannedPaymentDate: String? = null,
    val prevSeviceExpiresOn: String? = null,
    val priceLevelId: String? = null,
    val priceListAmount: Int? = null,
    val productId: String? = null,
    val productProgram: Int? = null,
    val promoCodeDiscount: Int? = null,
    val renewalsNumber: Int? = null,
    val resubNumber: Int? = null,
    val result: String? = null,
    val resultSupportLicId: String? = null,
    val resultSupportLicModifiedBy: String? = null,
    val resultSupportLicModifiedOn: String? = null,
    val salesBizUnitId: String? = null,
    val salesContactId: String? = null,
    val salesOn: String? = null,
    val salesPartnerId: String? = null,
    val salesSubsId: String? = null,
    val salesSysUserId: String? = null,
    val schoolCollectionDocumentsId: String? = null,
    val schoolContractLinkCreatedOn: String? = null,
    val schoolDiploma: String? = null,
    val schoolGroupId: String? = null,
    val schoolNumberDeparture: String? = null,
    val schoolRateId: String? = null,
    val schoolStatement: String? = null,
    val schoolTestPassedOn: String? = null,
    val schoolTreaty: String? = null,
    val sendPrimaryEmailSchoolDocsDate: String? = null,
    val sendSecondaryEmailSchoolDocsDate: String? = null,
    val serviceAccessOn: String? = null,
    val serviceActivateOn: String? = null,
    val serviceExpiresOn: String? = null,
    val setId: String? = null,
    val status: Int? = null,
    val superSchoolInviteId: String? = null,
    val supportPartnerId: String? = null,
    val supportSysUserId: String? = null,
    val type: Int? = null,
    val upgradedLicId: String? = null,
    val usedByAccountId: String? = null,
    val usedByContactId: String? = null,
    val userCount: Int? = null,
    val userTokenId: String? = null,
    val version: Int? = null,
    val versionDate: String? = null,
    val wasActivated: Boolean? = null,
    val whenResub: Int? = null
)