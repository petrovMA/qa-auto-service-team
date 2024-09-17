package ru.action_tech.qa.auto.api_models.payments

import io.qameta.allure.Feature

@Feature(paymentsGetPaidOrdersByIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentsGetPaidOrdersByIds

@Feature(customerBalanceGet)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CustomerBalanceGetV1

@Feature(paymentBalanceGetListByPayment)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentBalanceGetListByPaymentV1

@Feature(transactionGetListByPayment)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TransactionGetListByPaymentV1

@Feature("/api/v1/transaction_get-list-by-sendings")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TransactionGetListBySendingsV1

@Feature("/api/v1/transaction_delete-by-ids")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TransactionDeleteByIdsV1

@Feature(transactionCreate)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TransactionCreateV1

@Feature(paymentsGetListByCustomer)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentsGetListByCustomerV1

@Feature("/api/v1/payments_remove-advance-id")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentsRemoveAdvanceIdV1

@Feature(paymentsGetByCustomerIdByPaymentDateRange)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentsGetByCustomerIdByPaymentDateRangeV1

@Feature(paymentsGetBySubscribeIds)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PaymentsGetBySubscribeIdsV1

@Feature(bankStatementGetListByPayment)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BankStatementGetListByPaymentV1

@Feature(bankStatementAdd)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BankStatementAddV1