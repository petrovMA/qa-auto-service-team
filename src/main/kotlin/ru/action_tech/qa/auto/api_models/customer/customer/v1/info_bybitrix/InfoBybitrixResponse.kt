package ru.action_tech.qa.auto.api_models.customer.customer.v1.info_bybitrix

import ru.action_tech.qa.auto.api_models.customer.customer.v1.contacts.ContactsResponse

data class InfoBybitrixResponse(
    val bitrixId: String?,
    val bonusBalance: Int?,
    val bonusLevel: String?,
    val id2PhoneIsSubmitted: Boolean?,
    val email: String?,
    val contactInfo: List<ContactInfo>?,
    val inn: String?,
    val innSecondary: String?,
    val kpp: String?,
    val id2Phonenumber: String?,
    val id2PhoneNumber: String?,
    val supportStatus: String?,
    val supportStatusA360: String?,
    val supportUSStatus: String?,
    val scopeAccount: String?,
    val region: String?,
    val regionId: String?,
    val taxation: Int?,
    val customerSize: Int?,
    val factAddress: String?,
    val legalAddress: String?,
    val legalFormId: String?,
    val country: String?,
    val countryId: String?,
    val timeShift: Int,
    val customerSegmentType: String?,
    val nalogStateId: String?,
    val lpr: Boolean,
    val canBeLpr: Boolean,
    val isCorpClient: Boolean,
    val flagsUnsubmitted: Boolean,
    val isContactsHidden: Boolean,
    val jobTitleId: String?,
    val jobTitleName: String?,
    val jobTitleCatalogId: String?,
    val jobTitleCatalogName: String?,
    val customerSizeName: String?,
    val income: Double?,
    val accountingType: String?,
    val parentAccountId: String?,
    val canCreateAct: Boolean?,
    val id: String,
    val customerType: Int,
    val pin: String?,
    val name: String?,
    val firstName: String?,
    val middleName: String?,
    val lastName: String?,
    val bonusLevelId: Int?,
    val partnerId: String?,
    val isInvoiceForEachPosition: Boolean?,
    val lockDescription: Int?
) {
    data class ContactInfo(
        val contactId: String,
        val name: String?,
        val type: Int,
        val countryCode: String?,
        val contactInfoId: String?,
        val countryId: String?,
        val iso: String?,
        val extension: String?,
        val sort: Int?,
        val createdOn: String?,
        val recommendedCallTime: Int?,
        val comment: String?,
        val isBlocked: Boolean,
        val validationStatuses: List<ContactsResponse.ContactInfo.ValidationStatuses>?
    )
}