package ru.action_tech.qa.auto.api_models.accesses.license.v1.response

data class AccessGetSubscriptionByBlockIdResponse(
    val accountId: String,
    val actionId: String?,
    val activateOn: String,
    val activatedContactId: String,
    val authCode: String,
    val base: BaseResponse,
    val bitrixId: Int?,
    val blockReason: Int?,
    val bonus: Int?,
    val bonusOrderId: String?,
    val bushAction360Id: String?,
    val comment: String?,
    val commentModifiedBy: String?,
    val commentModifiedOn: String?,
    val consumptionStatusModifiedOn: String?,
    val contactId: String?,
    val contractPaymentDate: String?,
    val digitalSignatureNumber: Int?,
    val extensionPartnerId: String?,
    val extensionSystemUserId: String?,
    val factActionId: String?,
    val giveUkd: Int?,
    val id: String,
    val individualSaleApproval: Boolean?,
    val instantAccess: Boolean,
    val isAutoActivated: Boolean,
    val isAutoBlocked: Boolean?,
    val isAutoRegistered: Boolean,
    val isBonusEmailSent: Boolean?,
    val isBonusProcessed: Boolean?,
    val isEmailSent: Boolean?,
    val isExternalRegistration: Boolean?,
    val isPaidLicenseBonusEmailSent: Boolean?,
    val isPastPeriod: Boolean?,
    val isRegisteredByAnotherPartner: Boolean?,
    val isRegisteredInAp: Boolean?,
    val isRegisteredInMcfr: Boolean?,
    val isSupportPasedFromErm: Boolean?,
    val isTrackRefresh: Boolean?,
    val isUpgrade: Boolean,
    val licenseTypeCode: Int?,
    val licenseUsers: List<LicenseUserResponse>?,
    val loginActivated: String,
    val managerComment: String?,
    val maxSupportCalls: Int?,
    val mcfrRkCode: Int?,
    val modifiedOnLicensesUsers: String?,
    val parentAccessId: String?,
    val parentLicensesId: String?,
    val parentServiceActivatedOn: String?,
    val partnerAmount: Int,
    val partnerAmountBase: Int,
    val partnerSubscribeId: String?,
    val paymentScenarioId: String?,
    val period: Int,
    val periodType: Int,
    val plannedPaymentDate: String?,
    val prevSeviceExpiresOn: String?,
    val previousAccessId: String?,
    val priceLevelId: String,
    val priceListAmount: Int?,
    val priceListAmountBase: Int?,
    val productId: String,
    val productProgram: Int,
    val promoCodeDiscount: Int?,
    val promoCodeDiscountBase: Int?,
    val renewalsNumber: Int?,
    val resubNumber: Int,
    val resultSupportLicensesId: String?,
    val resultSupportLicensesModifiedBy: String?,
    val resultSupportLicensesModifiedOn: String?,
    val salesBizUnitId: String?,
    val salesContactId: String,
    val salesOn: String,
    val salesPartnerId: String,
    val salesSubscribeId: String,
    val salesSystemUserId: String,
    val schoolCollectionDocumentsId: String?,
    val schoolContractLinkCreatedOn: String?,
    val schoolDeliveryMethod: Int?,
    val schoolDiploma: String?,
    val schoolGroupId: String?,
    val schoolNumberDeparture: String?,
    val schoolRateId: String?,
    val schoolStatement: String?,
    val schoolTestPassedOn: String?,
    val schoolTreaty: String?,
    val sendPrimaryEmailSchoolDocsDate: String?,
    val sendSecondaryEmailSchoolDocsDate: String?,
    val serviceAccessOn: String?,
    val serviceActivateOn: String,
    val serviceExpiresOn: String,
    val setId: String?,
    val status: Int,
    val superSchoolInviteId: String?,
    val supportBizUnitId: String?,
    val supportPartnerId: String,
    val supportSystemUserId: String,
    val type: Int,
    val upgradedLicId: String?,
    val usedByAccountId: String?,
    val usedByContactId: String?,
    val userCount: Int?,
    val userTokenId: String?,
    val version: Int,
    val versionDate: String,
    val wasActivated: Boolean,
    val whenResub: Int
)