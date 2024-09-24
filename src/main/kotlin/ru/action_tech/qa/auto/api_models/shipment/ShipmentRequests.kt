package ru.action_tech.qa.auto.api_models.shipment

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.shipment.batch_get_by_ids.BatchGetByIdsResponse
import ru.action_tech.qa.auto.api_models.shipment.sending_contents.sendings_contents_get_by_sending_ids.SendingsContentsGetBySendingIdsResponse
import ru.action_tech.qa.auto.api_models.shipment.sendings.v1.receive_cases_get_by_ids.PackageFormatGetByIdsResponse
import ru.action_tech.qa.auto.api_models.shipment.sendings.v1.sendings_get_by_customer_id.SendingsGetByCustomerIdResponse
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.common_models.CommonDto
import ru.action_tech.qa.auto.utils.http.QueryParams


object ShipmentRequests {

    //region [ProductReturns]
    fun totalSendingsQtyGetByCustomerId(id: String? = null, limitSendingData: String? = null) = TRequest(
        model = Model<Int>(),
        desc = "Получить список отправлений клиента",
        spec = {
            setContentType(ContentType.JSON)
            id?.let { addQueryParam(QueryParams.ID, it) }
            limitSendingData?.let { addQueryParam(QueryParams.LIMIT_SENDING_DATA, it) }
        },
        send = { get(totalSendingsQtyGetByCustomerId) }
    )


    fun batchGetByIds(ids: List<String>? = null) = TRequest(
        desc = "Метод получения батча по ID (массовый)",
        model = Model<Array<BatchGetByIdsResponse>>(),
        spec = {
            ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get(batchGetByIds) }
    )

    fun sendingContentsGetBySendingId(sendingId: String? = null) = TRequest(
        desc = "Метод получения позиции отправления по ID отправления",
        model = Model<List<SendingsGetByCustomerIdResponse>>(),
        spec = { sendingId?.let { addQueryParam(QueryParams.SENDING_ID, it) } },
        send = { get(sendingContentsGetBySendingId) }
    )

    fun sendingsContentsGetBySendingIds(ids: List<String>? = null) = TRequest(
        desc = "Метод получения позиций отправления по ID отправлений",
        model = Model<Array<SendingsContentsGetBySendingIdsResponse>>(),
        spec = {
            ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get(sendingsContentsGetBySendingIds) }
    )

    fun sendingsGetByCustomerId(id: String? = null, limitSendingData: Boolean? = null) = TRequest(
        desc = "Список отправлений клиента по ID клиента, за последний год или все",
        model = Model<List<SendingsGetByCustomerIdResponse>>(),
        spec = {
            id?.let { addQueryParam(QueryParams.ID, it) }
            limitSendingData?.let { addQueryParam(QueryParams.LIMIT_SENDING_DATA, it) }
        },
        send = { get(sendingsGetByCustomerId) }
    )

    fun packageFormatGetByIds(ids: List<String>? = null) = TRequest(
        desc = "Метод получения форматов отправки На входе список PackageFormatId",
        model = Model<Array<PackageFormatGetByIdsResponse>>(),
        spec = {
            ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get(packageFormatGetByIds) }
    )

    fun receiveCasesGetByIds(ids: List<String>? = null) = TRequest(
        desc = "Метод для получения почтовых служб",
        model = Model<Array<CommonDto>>(),
        spec = {
            ids?.let {
                addQueryParam(
                    QueryParams.IDS,
                    it.joinToString(separator = ",", prefix = "[", postfix = "]") { id -> "'$id'" })
            }
        },
        send = { get(receiveCasesGetByIds) }
    )
}