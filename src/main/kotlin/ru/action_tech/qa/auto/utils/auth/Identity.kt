package ru.action_tech.qa.auto.utils.auth

import ru.action_tech.qa.auto.core.api.ApiClient
import ru.action_tech.qa.auto.erm.api.IDENTITY_URL
import ru.action_tech.qa.auto.erm.data.AUTO_ACTIONUSKA

fun getAuthToken(
    login: String = AUTO_ACTIONUSKA.login,
    pass: String = AUTO_ACTIONUSKA.erm_pass!!
): String = identityApi.send(getToken(login = login, pass = pass)).jsonPath().getString("access_token")
