package ru.action_tech.qa.auto.api_models.shipment.batch_get_by_ids

data class BatchGetByIdsResponse(
    val actionResultId: String?,
    val actionTypeId: Int?,
    val advanceAmount: Int?,
    val advanceDateFrom: String?,
    val advanceDateTo: String?,
    val batchDate: String?,
    val batchNr: String?,
    val campaignId: String?,
    val checkPayment: Boolean?,
    val checkStock: Boolean?,
    val checkZipCodeAdvances: Boolean?,
    val checkZipCodeOrders: Boolean?,
    val checkZipcode: Boolean?,
    val description: String?,
    val doneAmount: Int?,
    val errorName: String?,
    val filialId: String?,
    val fssId: String?,
    val id: String,
    val invoiceAlgorithmBlock: Int?,
    val invoiceAmount: Int?,
    val invoiceGenerateInvoiceDateFrom: String?,
    val invoiceGenerateInvoiceDateTo: String?,
    val invoiceIncludeSeparate: Boolean?,
    val isClosed: Boolean?,
    val isDefaultBatch: Boolean?,
    val isTemplate: Boolean?,
    val packageFormatId: String?,
    val postFirmId: String?,
    val receiveCaseId: String?,
    val sendingAmount: Int?,
    val sendingDateFrom: String?,
    val sqlId: String?,
    val stockId: String?,
    val temp: String?,
    val templateId: String?
)