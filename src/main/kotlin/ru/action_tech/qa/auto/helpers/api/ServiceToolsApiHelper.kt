package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.core.assertions.assertFalse
import ru.action_tech.qa.auto.utils.*
import ru.action_tech.qa.auto.utils.auth.getToken
import ru.action_tech.qa.auto.utils.auth.tokenActionushka

object ServiceToolsApiHelper {

    /** Получить для менеджера токен ЕРМ */
    fun getErmTokenForManager(login: String): String =
        identityApi.send(getToken(login = login, grantType = "token", token = tokenActionushka))
            .jsonPath()
            .getString("access_token")!!
            .apply { assertFalse(isNullOrBlank()) }
}