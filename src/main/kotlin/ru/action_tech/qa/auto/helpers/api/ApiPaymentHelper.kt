package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.qa.v1.payment_create.QaPaymentCreateRequest
import ru.action_tech.qa.auto.api_models.payments.qa.v1.payment_create.QaPaymentCreateRequest.RegMoney
import ru.action_tech.qa.auto.api_models.payments.qa.v1.payment_create.QaPaymentInstallmentCreateRequest
import ru.action_tech.qa.auto.data.BankAccounts
import ru.action_tech.qa.auto.data.Company
import ru.action_tech.qa.auto.utils.paymentsCrmClient

object ApiPaymentHelper {

    fun createPaymentForOrder(
        orderId: String,
        subscribeId: String,
        sum: Double = 23364.00,
        accountId: String
    ): String {
        return paymentsCrmClient.send(
            PaymentsRequests.qaPaymentCreate(
                orderId = orderId,
                request = QaPaymentCreateRequest(
                    accountId = accountId,
                    actionAccountId = BankAccounts.BANK_ACCOUNT_FOR_AUTOTEST.id,
                    regMoneys = listOf(
                        RegMoney(
                            subscribeId = subscribeId,
                            summ = sum
                        )
                    )
                )
            )
        )
    }

    fun createPaymentInstallmentForOrder(
        orderId: String,
        subscribeId: String,
        paymentDate: String,
        paymentAmount: Double = 10000.00,
        orderItemAmount: Double = 10000.00,
    ): String {
        return paymentsCrmClient.send(
            PaymentsRequests.qaPaymentInstallmentCreate(
                request = QaPaymentInstallmentCreateRequest(
                    orderId = orderId,
                    actionAccountId = BankAccounts.BANK_ACCOUNT_FOR_AUTOTEST.id,
                    paymentAmount = paymentAmount,
                    paymentDate = paymentDate,
                    customerEmail = "test@mail.ru",
                    customerId = Company.PAID_DEMO_ACCESS_COMPANY.id!!,
                    orderItemInstallmentDiscounts = listOf(
                        QaPaymentInstallmentCreateRequest.OrderItemInstallmentDiscounts(
                            orderItemId = subscribeId,
                            orderItemAmount = orderItemAmount
                        )
                    )
                )
            )
        )
    }
}
