package ru.action_tech.qa.auto.api_models.payments

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range.request.PaymentsGetByCustomerIdByPaymentDateRangeRequest
import ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_customer_id_by_payment_date_range.response.PaymentsGetByCustomerIdByPaymentDateRangeResponse
import ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_by_subscribe_ids.response.PaymentsGetBySubscribeIdsResponse
import ru.action_tech.qa.auto.api_models.payments.payments.v1.payments_get_list_by_customer.PaymentsGetListByCustomerResponse
import ru.action_tech.qa.auto.api_models.payments.qa.v1.payment_create.QaPaymentCreateRequest
import ru.action_tech.qa.auto.api_models.payments.qa.v1.payment_create.QaPaymentInstallmentCreateRequest
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.customer_balance_get.request.CustomerBalanceGetRequest
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.customer_balance_get.response.CustomerBalanceGetResponse
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.payment_balance_get_list_by_payment.request.PaymentBalanceGetListByPaymentRequest
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.payment_balance_get_list_by_payment.response.PaymentBalanceGetListByPaymentResponse
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_create.request.TransactionCreateRequest
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_get_list_by_payment.request.TransactionGetListByPaymentRequest
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transaction_get_list_by_payment.response.TransactionGetListByPaymentResponse
import ru.action_tech.qa.auto.api_models.payments.transactions.v1.transactions_get_list_by_sendings.TransactionGetLisBySendingsResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenActionushka
import ru.action_tech.qa.auto.utils.auth.tokenArm
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams
import ru.action_tech.qa.auto.utils.setBody
import ru.action_tech.qa.auto.utils.url_builder.X_PATH_KEY_PAYMENTS

object PaymentsRequests {

    fun paymentsGetPaidOrdersByIds(
        ids: List<String?>? = null,
        dateFrom: String? = null,
        dateTo: String? = null,
        token: String? = tokenArm
    ) = TRequest(
        desc = "Фильтрация оплат по дате",
        model = Model<List<String>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            dateFrom?.let { addQueryParam(QueryParams.FROM, it) }
            dateTo?.let { addQueryParam(QueryParams.TO, it) }
            ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
            setUrlEncodingEnabled(true)
        },
        send = { get(paymentsGetPaidOrdersByIds) }
    )

    fun customerBalanceGet(request: CustomerBalanceGetRequest, token: String = tokenArm) = TRequest(
        desc = "Получение баланса по клиенту",
        model = Model<CustomerBalanceGetResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            request.customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
            request.paymentAccountId?.let { addQueryParam(QueryParams.PAYMENT_ACCOUNT_ID, it) }
            request.dateFrom?.let { addQueryParam(QueryParams.DATE_FROM, it) }
        },
        send = { get(customerBalanceGet) }
    )

    fun paymentBalanceGetListByPayment(
        request: PaymentBalanceGetListByPaymentRequest,
        token: String = tokenArm
    ) = TRequest(
        desc = "Получение баланса по списку оплат",
        model = Model<Array<PaymentBalanceGetListByPaymentResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            request.ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
            request.dateFrom?.let { addQueryParam(QueryParams.DATE_FROM, it) }
        },
        send = { get(paymentBalanceGetListByPayment) }
    )

    fun transactionGetListByPayment(request: TransactionGetListByPaymentRequest, token: String = tokenArm) = TRequest(
        desc = "Получение ДДС (транзакций) по списку оплат",
        model = Model<Array<TransactionGetListByPaymentResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            request.ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
        },
        send = { get(transactionGetListByPayment) }
    )

    fun transactionCreate(
        request: TransactionCreateRequest,
        isNonNull: Boolean = true, token: String = tokenArm
    ) = TRequest(
        desc = "Создание операции ДДС (транзакции)",
        model = Model<Boolean>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setBody(request, isNonNull)
        },
        send = { post(transactionCreate) }
    )

    fun qaPaymentDelete(
        paymentId: String? = null,
        token: String? = tokenAutoActionushka,
        xpath: String? = X_PATH_KEY_PAYMENTS
    ) = Request(
        desc = "Удаление оплаты для тестового заказа",
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            xpath?.let { addHeader(Headers.X_PATH, it) }
            addQueryParam(QueryParams.PAYMENT_ID, paymentId)
        },
        send = { delete(qaPaymentDelete) }
    )

    fun qaPaymentCreate(
        orderId: String? = null,
        request: QaPaymentCreateRequest,
        token: String? = tokenAutoActionushka,
        xpath: String? = X_PATH_KEY_PAYMENTS,
        isNonNull: Boolean = false
    ) = TRequest(
        desc = "Создаем оплату для заказа",
        model = Model<String>(),
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            xpath?.let { addHeader(Headers.X_PATH, it) }
            orderId?.let { addQueryParam(QueryParams.ORDER_ID, it) }
            setBody(request, isNonNull)
            setContentType(ContentType.JSON)
        },
        send = { post(qaPaymentCreate) }
    )

    fun qaPaymentInstallmentCreate(
        request: QaPaymentInstallmentCreateRequest,
        token: String? = tokenAutoActionushka,
        xpath: String? = X_PATH_KEY_PAYMENTS,
        isNonNull: Boolean = false
    ) = TRequest(
        desc = "Создаем частичную оплату для заказа",
        model = Model<String>(),
        spec = {
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            xpath?.let { addHeader(Headers.X_PATH, it) }
            setBody(request, isNonNull)
            setContentType(ContentType.JSON)
        },
        send = { post(qaPaymentCreateInstallment) }
    )

    fun paymentsGetListByCustomer(ids: Array<String?>?, token: String = tokenArm) = TRequest(
        desc = "Получение ДДС (транзакций) по списку оплат",
        model = Model<Array<PaymentsGetListByCustomerResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            ids?.let { addQueryParam(QueryParams.IDS, it) }
            setUrlEncodingEnabled(true)
        },
        send = { get(paymentsGetListByCustomer) }
    )

    fun paymentsGetByCustomerIdByPaymentDateRange(
        request: PaymentsGetByCustomerIdByPaymentDateRangeRequest? = null,
        token: String = tokenArm
    ) = TRequest(
        desc = "Получение оплат клиента по диапазону даты оплаты",
        model = Model<Array<PaymentsGetByCustomerIdByPaymentDateRangeResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            request?.customerId?.let { addQueryParam(QueryParams.CUSTOMER_ID, it) }
            request?.from?.let { addQueryParam(QueryParams.FROM, it) }
            request?.to?.let { addQueryParam(QueryParams.TO, it) }
        },
        send = { get(paymentsGetByCustomerIdByPaymentDateRange) }
    )

    fun paymentsGetBySubscribeIds(subscriberIds: List<String>? = null, token: String = tokenArm) = TRequest(
        desc = "Получение оплат клиента ids содержимых заказов",
        model = Model<Array<PaymentsGetBySubscribeIdsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            subscriberIds?.let {
                addQueryParam(
                    QueryParams.SUBSCRIBE_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
        },
        send = { get(paymentsGetBySubscribeIds) }
    )

    fun bankStatementAdd(
        request: ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_add.request.BankStatementAddRequest, isNonNull: Boolean = true,
        token: String = tokenArm
    ) = TRequest(
        desc = "Добавление строки выписки",
        model = Model<ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_add.response.BankStatementAddResponse>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            setBody(request, isNonNull)
        },
        send = { post(bankStatementAdd) }
    )

    fun bankStatementGetListByPayment(
        request: ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_get_list_by_payment.request.BankStatementGetListByPaymentRequest,
        token: String = tokenArm
    ) = TRequest(
        desc = "Получение строк выписки по списку оплат",
        model = Model<Array<ru.action_tech.qa.auto.api_models.payments.bank_statements.v1.bankstatement_get_list_by_payment.response.BankStatementGetListByPaymentResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            request.ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
        },
        send = { get(bankStatementGetListByPayment) }
    )

    fun transactionGetListBySendings(sendingIds: List<String?>?, token: String = tokenActionushka) = TRequest(
        desc = "Получение ДДС (транзакций) по списку отправлений",
        model = Model<Array<TransactionGetLisBySendingsResponse>>(),
        spec = {
            setContentType(ContentType.JSON)
            addHeader(Headers.AUTHORIZATION, "Bearer $token")
            sendingIds?.let {
                addQueryParam(
                    QueryParams.SENDING_IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" }
                )
            }
        },
        send = { get(transactionGetListBySendings) }
    )
}