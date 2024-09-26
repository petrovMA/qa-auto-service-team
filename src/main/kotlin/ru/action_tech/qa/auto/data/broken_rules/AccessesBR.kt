package ru.action_tech.qa.auto.data.broken_rules

import ru.action_tech.qa.auto.api_models.CheckBadRequests.BrokenRule

object AccessesBR {
    val BR_100 by lazy { BrokenRule(code = 100, message = "Неверные параметры или модель запроса") }
    val BR_122 by lazy { BrokenRule(code = 122, message = "Не найдена заявка на создание лицензии") }
    val BR_124 by lazy { BrokenRule(code = 124, message = "Заявка на создание лицензии уже обработана") }
    val BR_130 by lazy { BrokenRule(code = 130, message = "Пустой или неправильный Customer Id") }
    val BR_132 by lazy { BrokenRule(code = 132, message = "В заказе нет содержимого с таким Id") }
    val BR_1000 by lazy { BrokenRule(code = 1000, message = "Клиент не найден") }
}