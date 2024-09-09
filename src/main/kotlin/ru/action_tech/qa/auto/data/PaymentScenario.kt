package ru.action_tech.qa.auto.data

import ru.action_tech.qa.auto.utils.common_models.CommonDtoNullable

val SCENARIO_SCHEDULED_PAYMENT by lazy {
    CommonDtoNullable(
        id = "5E884EBC-96E7-EA11-BBAC-00155DFB3F03",
        name = "Оплата по графику"
    )
}

val SCENARIO_QUARTERLY_PAYMENT by lazy {
    CommonDtoNullable(
        id = "C27C867C-188C-E811-A239-00155DFB5103",
        name = "Ежеквартальная оплата"
    )
}

val SCENARIO_30_70 by lazy {
    CommonDtoNullable(
        id = "9B4C0B6C-B8D7-E511-92C2-78E3B502DA44",
        name = "30% на 70%"
    )
}

val SCENARIO_MONTHLY_FEE by lazy {
    CommonDtoNullable(
        id = "95DC94DD-79DC-E511-873D-78E3B502F220",
        name = "Ежемесячная оплата"
    )
}

val SCENARIO_50_50 by lazy {
    CommonDtoNullable(
        id = "5B5AC11E-F3BB-EC11-BBBC-BCDA0251696C",
        name = "50% на 50%"
    )
}

val SCENARIO_ADVANCE by lazy {
    CommonDtoNullable(
        id = "cf97e615-b4d7-e511-92c2-78e3b502da44",
        name = "Авансовый"
    )
}

val SCENARIO_POSTPAID by lazy {
    CommonDtoNullable(
        id = "772DF75F-B8D7-E511-92C2-78E3B502DA44".lowercase(),
        name = "Постоплата"
    )
}