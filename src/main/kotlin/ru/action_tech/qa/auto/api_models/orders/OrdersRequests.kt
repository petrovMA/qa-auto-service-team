package ru.action_tech.qa.auto.api_models.orders

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderRequest
import ru.action_tech.qa.auto.api_models.orders.master.v2.order_create.CreateOrderResponse
import ru.action_tech.qa.auto.api_models.orders.orders.v1.order.OrdersResponse
import ru.action_tech.qa.auto.api_models.orders.qa.delete_order.DeleteOrderRequest
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.http.Headers
import ru.action_tech.qa.auto.utils.http.QueryParams
import ru.action_tech.qa.auto.utils.url_builder.X_PATH_KEY_ORDERS

object OrdersRequests {

    fun getOrder(orderId: String?, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<OrdersResponse>(),
        desc = "Получаем заказ",
        spec = {
            addQueryParam(QueryParams.ID, orderId)
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { get(orders) }
    )

    fun qaOrderDelete(
        request: DeleteOrderRequest,
        xPathKey: String? = X_PATH_KEY_ORDERS,
        token: String? = tokenAutoActionushka
    ) = TRequest(
        desc = "Удаляем заказ (qa-ручка)",
        model = Model<Boolean>(),
        spec = {
            xPathKey?.let { addHeader(Headers.X_PATH_KEY, it) }
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setContentType(ContentType.JSON)
            setBody(request)
        },
        send = { post(orderDelete) }
    )

    fun createOrderV2(request: CreateOrderRequest, token: String? = tokenAutoActionushka) = TRequest(
        model = Model<CreateOrderResponse>(),
        desc = "Создание заказа",
        spec = {
            setContentType(ContentType.JSON)
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
            setBody(request)
        },
        send = { post(orderCreateV2) }
    )
}