package ru.action_tech.qa.auto.utils.auth

import ru.action_tech.qa.auto.data.AUTO_ACTIONUSKA
import ru.action_tech.qa.auto.utils.identityApi

fun getAuthToken(
    login: String = AUTO_ACTIONUSKA.login,
    pass: String = AUTO_ACTIONUSKA.erm_pass!!
): String = identityApi.send(getToken(login = login, pass = pass)).jsonPath().getString("access_token")
