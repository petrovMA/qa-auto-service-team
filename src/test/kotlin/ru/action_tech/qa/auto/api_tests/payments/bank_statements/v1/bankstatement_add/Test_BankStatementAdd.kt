package ru.action_tech.qa.auto.api_tests.payments.bank_statements.v1.bankstatement_add

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Payments
import ru.action_tech.qa.auto.api_models.payments.BankStatementAddV1
import ru.action_tech.qa.auto.api_models.payments.PaymentsRequests
import ru.action_tech.qa.auto.api_models.payments.bankStatementAdd
import ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_add.request.*
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.data.FieldData
import ru.action_tech.qa.auto.utils.getStringTime
import ru.action_tech.qa.auto.utils.paymentsCrmClient
import java.net.HttpURLConnection


class Test_BankStatementAdd {

    private val dateTime by lazy { getStringTime() }

    private val request by lazy {
        PaymentsRequests.bankStatementAdd(
            BankStatementAddRequest(
                isDistributed = false,
                sum = 1,
                paymentOrderNumber = (100000..999999).random().toString(),
                payerName = (100000..999999).random().toString(),
                payerInn = (100000..999999).random().toString(),
                bankStatementDate = dateTime,
                payerPaymentAccount = (100000..999999).random().toString(),
                recipientPaymentAccount = (100000..999999).random().toString(),
                paymentPurpose = (100000..999999).random().toString(),
                stringorderowner = Stringorderowner(
                    businessunitid = "1B191CC2-DB50-E711-BB08-78E3B502DA44",
                    id = "003A5957-F3CD-4671-8201-0F477D1D3A08",
                    name = "SYSTEM S"
                ),
                owner = Owner(
                    id = "003A5957-F3CD-4671-8201-0F477D1D3A08",
                    name = "SYSTEM S"
                ),
                author = Author(
                    id = "003A5957-F3CD-4671-8201-0F477D1D3A08",
                    name = "SYSTEM S"
                ),
                file = File(
                    id = "0712E628-8F8E-4286-9D96-1B424D121F5C",
                    transactioncurrency = Transactioncurrency(
                        id = "B83B6F5D-324F-E011-A4A1-F4CE46B88C62",
                        name = "рубль"
                    )
                ),
                datedischargebankclient = dateTime,
                payerKPP = (100000..999999).random().toString(),
                bicBankCustomer = (100000..999999).random().toString(),
                corrAccountBankCustomer = (100000..999999).random().toString(),
                benefAccount = (100000..999999).random().toString(),
                priority = 1,
                customerAccountNt = (100000..999999).random().toString(),
                nameBankCustomer = (100000..999999).random().toString(),
                supposedOrderNumber = (1000000000..9999999999).random().toString(),
                actionAccountId = ActionAccountId(
                    id = "FED199F0-85EF-EB11-BBBC-BCDA0251696C",
                    name = "Р/с для автотестов"
                )
            )
        ).apply { verify = { statusCode(HttpURLConnection.HTTP_OK) } }
    }


    @Test
    @Requirements("REQCRM-311")
    @Sale_Payments
    @BankStatementAddV1
    @Response_200_Ok
    @DisplayName("$bankStatementAdd -> 200 Ok")
    @AllureId("145833")
    fun test_BankStatementAddPositive() {
        val response = paymentsCrmClient.send(request)
        assertTrue(response.id?.matches(FieldData.PATTERN_FOR_ID) ?: false)
        assertTrue(response.name?.matches("\\d+".toRegex()) ?: false)
    }
}