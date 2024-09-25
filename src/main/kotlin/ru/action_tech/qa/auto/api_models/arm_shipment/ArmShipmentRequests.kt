package ru.action_tech.qa.auto.api_models.arm_shipment

import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.api_models.arm_shipment.v1.sending_get_list_by_customer.response.SendingGetListByCustomerResponse
import ru.action_tech.qa.auto.utils.http.QueryParams


object ArmShipmentRequests {

    fun sendingGetListByCustomer(id: String? = null, limitSendingData: Any? = null, type: String? = null) = TRequest(
        desc = "Получить отправления клиента",
        model = Model<List<SendingGetListByCustomerResponse>>(),
        spec = {
            id?.let { addQueryParam(QueryParams.ID, it) }
            limitSendingData?.let { addQueryParam(QueryParams.LIMIT_SENDING_DATA, it) }
            type?.let { addQueryParam(QueryParams.TYPE, it) }
        },
        send = { get(sendingGetListByCustomerV1) }
    )
}