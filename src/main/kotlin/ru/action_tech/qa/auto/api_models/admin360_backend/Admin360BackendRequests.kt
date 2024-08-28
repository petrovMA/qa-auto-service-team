package ru.action_tech.qa.auto.api_models.admin360_backend

import io.restassured.http.ContentType
import ru.action_tech.qa.auto.core.api.Model
import ru.action_tech.qa.auto.core.api.TRequest
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka
import ru.action_tech.qa.auto.utils.common_models.CommonDtoNameNullable
import ru.action_tech.qa.auto.utils.http.Headers


object Admin360BackendRequests {

    fun jobTitlesGet(token: String? = tokenAutoActionushka) = TRequest(
        desc = "Должности клиента",
        model = Model<Array<CommonDtoNameNullable>>(),
        spec = {
            setContentType(ContentType.JSON)
            token?.let { addHeader(Headers.AUTHORIZATION, "Bearer $it") }
        },
        send = { get("$apiV1/jobtitles_get") }
    )
}
