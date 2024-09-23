package ru.action_tech.qa.auto.api_models.shipment

import io.qameta.allure.Feature

// region [Sendings]
@Feature(totalSendingsQtyGetByCustomerId)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TotalSendingsQtyGetByCustomerId
// endregion

@Feature(batchGetByIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BatchGetByIdsV1

@Feature(sendingContentsGetBySendingId)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SendingContentsGetBySendingIdV1

@Feature(sendingsContentsGetBySendingIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SendingsContentsGetBySendingIdsV1

@Feature(sendingsGetByCustomerId)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SendingsGetByCustomerIdV1

@Feature(receiveCasesGetByIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ReceiveCasesGetByIdsV1

@Feature(packageFormatGetByIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PackageFormatGetByIdsV1

@Feature(trackNumbersGetBySendingIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TrackNumbersGetBySendingIdsV1