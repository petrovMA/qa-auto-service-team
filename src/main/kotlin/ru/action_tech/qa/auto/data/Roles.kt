package ru.action_tech.qa.auto.data

import ru.action_tech.qa.auto.api_models.managers.v1.role.roles_get.RolesGetResponse

val MONITOR_RG by lazy { role("monitorrg") }
val TELE_MONITOR_RG by lazy { role("monitor_rg") }
val COORDINATOR by lazy { role("coordinator") }
val NAME_VALIDATION by lazy { role("name_validation") }
val WIRETAP_SUPERVISOR by lazy { role("wiretap_supervisor") }
val WIRETAP_TEAMLEADER by lazy { role("wiretap_teamleader") }
val WIRETAP_COORDINATOR by lazy { role("wiretap_coordinator") }
val SEARCH_ANONS by lazy { role("searchanons") }
val MONITORRG_BRANCHMANAGER by lazy { role("monitorrg_branchmanager") }
val MONITORRG_TEAMLEADER by lazy { role("monitorrg_teamleader") }
val MONITORRG_COORDINATOR by lazy { role("monitorrg_coordinator") }
val SD_MANAGER by lazy { role("sdmanager") }
val SD_SUPERVIZOR by lazy { role("sdsupervizor") }
val MOI_DELA by lazy { role("moidela") }
val ATTACH by lazy { role("attach") }
val DETACH by lazy { role("detach") }
val ALLOW_PUBLIC_API by lazy { role("allow_public_api") }
val DISMISS by lazy { role("dismiss") }
val ACCESS_MANAGEMENT by lazy { role("access_management") }
val ALLOW_EDIT_MANAGER by lazy { role("allow_edit_manager") }
val VTM_MONITOR by lazy { role("vtm_monitor") }
val CORP_CLIENT by lazy { role("corpclient") }
val BOSS_OKP by lazy { role("bossokp") }
val VTM_MAN by lazy { role("vtmman") }
val TOKEN_GRANT by lazy { role("tokengrant") }
val CHANGE_SUPPORT_MANAGER by lazy { role("change_support_manager") }
val ACCESS_EDIT_ORDER_WITH_PAYMENT by lazy { role("access_edit_order_with_payment") }
val ALLOW_PDISCOUNT by lazy { role("allow_pdiscount") }
val VTM_POSTCALL_HACK by lazy { role("vtm_postcall_hack") }
val BOSS_OKP_GROUP by lazy { roles.first { it.id == "f88742fd-f059-ea11-bba6-00155d627f03" } }
val ACCESS_BILL_REPORTS by lazy { role("access_bill_reports") }
val ALLOW_ORDER_WIZARD by lazy { role("allow_order_wizard") }
val REFUSE_MAIL by lazy { role("refuse_mail") }
val SL by lazy { role("sl") }
val PHONECALLS_REASSIGN by lazy { role("phonecalls_reassign") }
val MULTI_CAMP by lazy { role("multicamp") }
val ADV_MANAGER by lazy { role("adv_manager") }
val ADV_SUPERVISOR by lazy { role("adv_supervisor") }
val ADV_BOSS by lazy { role("adv_boss") }

fun role(alias: String?) = roles.first { alias == it.alias }

val roles by lazy {
    listOf(
        RolesGetResponse(
            alias = "sl",
            description = "Вход в раздел Стоп-Лист в Едином Рабочем Месте (ЕРМ)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "dc01f0ef-79f9-e811-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Стоп-Лист"
        ),
        RolesGetResponse(
            alias = "managers",
            description = "Открывает доступ к разделу менеджеры. На данный момент используется в рамках Бэк Офиса партнерской сети",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "c9e5ce06-7fff-e811-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Менеджеры"
        ),
        RolesGetResponse(
            alias = "reports",
            description = "Открывает доступ к разделу \"Отчеты\" в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "369d19d4-89ff-e811-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "6cf487f8-89ff-e811-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Статистика СС"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "e9b724b4-c101-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Отработка звонков"
        ),
        RolesGetResponse(
            alias = "dd",
            description = "Открывает доступ к разделу \"Демодоступ\" в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "3874edc4-da01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Демодоступ"
        ),
        RolesGetResponse(
            alias = "corpclient",
            description = "Открывает доступ к разделу \"Личные продажи\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "2a81f6ca-da01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Личные продажи // Корпоративные клиенты"
        ),
        RolesGetResponse(
            alias = "regprod",
            description = "Открывает доступ к разделу \"Регистрация продажи\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "998609e3-da01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Регистрация продаж"
        ),
        RolesGetResponse(
            alias = "freeclient",
            description = "Открывает доступ к разделу \"Свободные клиенты\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "eecb830d-db01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Свободные клиенты"
        ),
        RolesGetResponse(
            alias = "seminar",
            description = "Открывает доступ к разделу \"Семинары\" в Бэк Офисе Дилера",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "2bcc830d-db01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Семинары"
        ),
        RolesGetResponse(
            alias = "supclient",
            description = "Открывает доступ к разделу \"Сопровождаемые клиенты\" в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "81967f19-db01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Сопровождаемые клиенты"
        ),
        RolesGetResponse(
            alias = "attach",
            description = "Открывает доступ к функции \"Закрепить\" в рамках раздела \"Стоп-лист\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "28e5d049-db01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Стоп-Лист // Закрепить"
        ),
        RolesGetResponse(
            alias = "detach",
            description = "Открывает доступ к функции \"Открепить\" в рамках раздела \"Стоп-Лист\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "1498fc55-db01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Стоп-Лист // Открепить"
        ),
        RolesGetResponse(
            alias = "management",
            description = "Открывает доступ к разделу \"Управление\" в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "4e65f45b-db01-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Управление"
        ),
        RolesGetResponse(
            alias = "p4",
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "74d11201-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // P4_Персонал партнеров"
        ),
        RolesGetResponse(
            alias = "p5",
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "2f8a1407-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // P5_ДД и новые продажи дилеров за период"
        ),
        RolesGetResponse(
            alias = "s1",
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "647c300d-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // S1_Отработка действий сопровождения"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "95973413-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Актион-Бонус: Детализированный отчет по списаниям за период"
        ),
        RolesGetResponse(
            alias = "ddstat",
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "43ee3319-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // ДД Статистика"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "e11f7a25-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Звонки в работе"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "c213772b-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Звонки партнеров"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставляет доступ к одноименному отчету в БОД",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "38446f31-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Какой была переподписка на выбранную дату"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "b0c37537-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Контроль использования телефонии"
        ),
        RolesGetResponse(
            alias = "olap",
            description = "Открывает доступ к разделу Кубы Олап в отчетности Бэк Офиса Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "0e7f773d-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Кубы Olap"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "14d87643-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Неактивированные УКД"
        ),
        RolesGetResponse(
            alias = "Report5",
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "6d0f6c4f-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Партнеры - Клиенты к переподписке"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставление доступа к одноименному отчету в Бэк офисе дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "3e1c7c55-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Партнёры-Макродолжности"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставление доступа к одноименному отчету в БОД",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "3a827861-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Сетевые подключения по партнерам"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "ee288667-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Сопровождаемая база по СС"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к интерфейсу Счета в отчетности Бэк Офис Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "8e2c836d-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Счета"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к одноименному отчету, доступному в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "bd6e8b79-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Счета для школ"
        ),
        RolesGetResponse(
            alias = null,
            description = "Дает возможность смотреть и выгружать счета из приложения Бэк Офис Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "c7bc837f-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Счета-фактуры"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставление доступа к одноименному отчету в БОД",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "948d9885-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // ТМ взятые в работу"
        ),
        RolesGetResponse(
            alias = "xls",
            description = "Дает возможность выгрузки в Эксель по всему приложению Бэк Офиса Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "63c1af8b-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Экспорт Xls"
        ),
        RolesGetResponse(
            alias = null,
            description = "Открывает доступ к разделу \"Школы\" в Бэк Офисе Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "ea0466e0-8d02-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Школы"
        ),
        RolesGetResponse(
            alias = "mon",
            description = "Предоставление доступа к разделу монитор в бэк офисе дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "f215c11e-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор"
        ),
        RolesGetResponse(
            alias = null,
            description = "Дает доступ к монитору директора в рамках Бэк Офиса Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "f39ab82a-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Монитор директора"
        ),
        RolesGetResponse(
            alias = "monitor_rg",
            description = "Дает доступ к телевизионному монитору руководителя группы в рамках Бэк Офиса Дилера и ЕРМРГ (https://monitor.action-mcfr.ru/)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b50df630-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Доступ к телевизионному монитору"
        ),
        RolesGetResponse(
            alias = null,
            description = "Дает доступ к монитору руководителя филиала в рамках Бэк Офиса Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "e5b10337-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Монитор руководителя филиала"
        ),
        RolesGetResponse(
            alias = "wiretap",
            description = "Выдает доступ к прослушиванию разговоров в рамках мониторов руководителя",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "decc073d-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Прослушивание звонков"
        ),
        RolesGetResponse(
            alias = null,
            description = "Дает доступ к редактированию данных на прослушке в рамках Бэк Офиса Дилера",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "0f4a0e43-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Редактирование прослушки разговоров"
        ),
        RolesGetResponse(
            alias = null,
            description = "Редактирование данных в хороших разговорах в рамках приложения Бэк Офис Дилера",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "8fea0f49-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Редактирование хороших разговоров"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставляет доступ к хорошим разговорам в рамках единого рабочего места",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "39982b4f-9002-e911-bb9d-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Хорошие разговоры"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставляет доступ к интерфейсу импорта клиентов на интерфейсе \"Свободные клиенты\"",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "6e8a5566-c323-e911-bb9e-00155d627f03",
            isVisibleInErm = true,
            name = "Загрузка собственных баз"
        ),
        RolesGetResponse(
            alias = "admin",
            description = "Открывает доступ к разделу \"Администратор\" в панели admin.1gl.ru",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "2df60921-4b3e-e911-bb9e-00155d627f03",
            isVisibleInErm = false,
            name = "Администратор"
        ),
        RolesGetResponse(
            alias = "multicamp",
            description = "Включает механизм работы мультикампании в едином рабочем месте оператора.",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "bbe40b20-463f-e911-bb9e-00155d627f03",
            isVisibleInErm = true,
            name = "Мультикампании"
        ),
        RolesGetResponse(
            alias = null,
            description = "Роль которая позволяет управлять интерфейсом отправки на семинар",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "c3a2e7df-b74c-e911-bb9f-00155d627f03",
            isVisibleInErm = true,
            name = "Семинары // Приглашение на семинар"
        ),
        RolesGetResponse(
            alias = null,
            description = "Головная роль для функционала заказы в едином рабочем месте менеджера",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "f19740ab-7d62-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Заказы"
        ),
        RolesGetResponse(
            alias = "delalienorder",
            description = "Предоставление возможности удаления чужих заказов, другими словами роль позволяет удалить заказы созданные другими сотрудниками",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "029f71dc-7d62-e911-bb9f-00155d627f03",
            isVisibleInErm = true,
            name = "Заказы // Удаление чужих заказов"
        ),
        RolesGetResponse(
            alias = "changerequest",
            description = "Определяет доступность изменения данных клиентов и контактных лиц. Инициация изменений данных на стороне клиента.\nНа данный момент реализовано в БОДе, адрес https://partners.1gl.ru",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "e054644b-e764-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Модерация изменения данных"
        ),
        RolesGetResponse(
            alias = "backadmin",
            description = "Роль определяет возможность зайти в административную панель СРМ",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "bca4e207-ee64-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ в админ панель СРМ"
        ),
        RolesGetResponse(
            alias = "moderationClient",
            description = "Роль определяет доступность функционала подтверждения создания клиента.\nВ раздел попадают клиенты, которые при создании через БОД не прошли проверку на nalog.ru",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "205a47b0-f964-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Модерация создания клиента"
        ),
        RolesGetResponse(
            alias = "corporate",
            description = "Предоставление доступа к разделу корпоративные клиента в БОД",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "0aa1e0a4-ff64-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Корпоративный стоп-лист"
        ),
        RolesGetResponse(
            alias = "group_add",
            description = "Роль предоставляет доступ к разделу \"Согласование регистрации\". В рамках данного раздела создаются тикеты при регистрации продажи в БОДе с индивидуальной ценой. Ответственные за работу раздела \"Отдел дистрибуции СС\"",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "e83b4430-0065-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Согласование регистрации"
        ),
        RolesGetResponse(
            alias = "event_note",
            description = "Предоставление доступа к разделу новости в административной панели \nАдрес = http://admin.1gl.ru",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "38a39a42-0065-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Новости"
        ),
        RolesGetResponse(
            alias = "notifications_active",
            description = "Открывает доступ к разделу \"Уведомления\" в http://admin.1gl.ru/Home/Home\nРаздел позволяет создавать массовые сообщения для пользователей БОДа и SD",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "f630bd4e-0065-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Уведомления"
        ),
        RolesGetResponse(
            alias = "perm_phone_msg",
            description = "Данная роль управляет доступом к разделу \"Телефония\" на http://admin.1gl.ru/Home/PhoneCalls\nВ рамках данного раздела есть функционал выдачи добавочных, проверки качества связи. Позволяет изменить сервер использования телефонии, а также заблокировать телефонию партнеру",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "a2704767-0065-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Телефония"
        ),
        RolesGetResponse(
            alias = "user_admin",
            description = "Роль предоставляет доступ к разделу \"Пользователи\".\nВ данном разделе можно управлять партнерами, пользователями, блокировать вход, деактивировать партнера",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "420a5e8b-0065-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Пользователи"
        ),
        RolesGetResponse(
            alias = "branchManage",
            description = "Роль предоставляет доступ к разделу, в котором можно управлять структурой партнеров, а именно:\n1. Подразделениями\n2. Филиалами\n3. Позволяет управлять телефонами и названиями для ДД. В рамках данного раздела происходит синхронизация с порталом Home",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "2ce3079e-0065-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Структура партнеров"
        ),
        RolesGetResponse(
            alias = "apiStatistic",
            description = "Предоставляет доступ к разделу \"Работа API\" \nВ рамках данного раздела есть возможность управлять лимитами на пользование методов API Ahello партнёрами Актион - МЦФЭР",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "ca851eaa-0065-e911-bb9f-00155d627f03",
            isVisibleInErm = false,
            name = "Мониторинг API"
        ),
        RolesGetResponse(
            alias = null,
            description = "Интерфейс управления ролями пользователей СРМ",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "264c3796-107e-e911-bba0-00155d627f03",
            isVisibleInErm = false,
            name = "Управление ролями пользователя"
        ),
        RolesGetResponse(
            alias = null,
            description = "Интерфейс управления часто используемыми ссылками.",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "81d9aca8-107e-e911-bba0-00155d627f03",
            isVisibleInErm = false,
            name = "Ссылки"
        ),
        RolesGetResponse(
            alias = "school_tab_access",
            description = "Доступ к интерфейсу генерации УКД по школам. Для генерации УКД используется GUID события",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "66ab6112-e982-e911-bba1-00155d627f03",
            isVisibleInErm = false,
            name = "Генерация УКД по школам"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставление доступа к кубам, используется для партнерской сети",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "82b727eb-c290-e911-bba2-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к кубам"
        ),
        RolesGetResponse(
            alias = "deactivate360",
            description = "Деактивация ранее выданного демодоступа по продукту Актион 360. Деактивируется полностью весь демодоступ",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "51990ef5-4a93-e911-bba2-00155d627f03",
            isVisibleInErm = false,
            name = "Деактивация ДД А360"
        ),
        RolesGetResponse(
            alias = null,
            description = "Предоставляет возможность в БОД импортировать клиентов по файлу.\nИспользуется на разделе \"Свободные клиенты\"",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "273db9ce-3c96-e911-bba2-00155d627f03",
            isVisibleInErm = true,
            name = "Отчеты // Импорт клиентов партнеров по файлу с фильтрами"
        ),
        RolesGetResponse(
            alias = "bossokp",
            description = "Роль определяющая доступность фильтра менеджеров на странице Личные продажи \nТакже роль позволяет смотреть полную информацию по работе раздела ОКП",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "a87acd25-4397-e911-bba2-00155d627f03",
            isVisibleInErm = true,
            name = "Личные продажи // Руководитель ОКП"
        ),
        RolesGetResponse(
            alias = "6mon",
            description = "Предоставляет возможность сотруднику закреплять клиентов на 6 месяцев подряд, игнорируя правила ЕПРК\nДоступно в БОД\n\nЛашхиа Д.Т.\nРоль деактивирована по согласованию с бизнесом и не должна быть доступа для выбора на приложениях БОД, ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "48d02c0f-a4ae-e911-bba3-00155d627f03",
            isVisibleInErm = false,
            name = "Стоп-Лист // Закрепление на 6 месяцев"
        ),
        RolesGetResponse(
            alias = "30day",
            description = "Предоставляет возможность пользователю выдавать демодоступ клиенту на 30 календарных дней",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "8057ec53-d4b1-e911-bba3-00155d627f03",
            isVisibleInErm = true,
            name = "Демодоступ // Выдача корпоративных ДД на 30 дней"
        ),
        RolesGetResponse(
            alias = "printdocex",
            description = "Предоставляет доступ к расширенному списку шаблонов договоров для печати.",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b335b4e7-4ab7-e911-bba3-00155d627f03",
            isVisibleInErm = false,
            name = "Заказы // Печать договоров по дополнительному шаблону"
        ),
        RolesGetResponse(
            alias = "inforelise",
            description = "Роль предоставляет возможность прописать информацию о релизе в едином рабочем месте",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "8e7b95a2-09c0-e911-bba4-00155d627f03",
            isVisibleInErm = false,
            name = "Информация о релизе"
        ),
        RolesGetResponse(
            alias = "tokengrant",
            description = "Предоставляет возможность заходить под любым пользователем в Единое рабочее место",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "50d4218e-85c9-e911-bba4-00155d627f03",
            isVisibleInErm = false,
            name = "Авторизация под другим пользователем"
        ),
        RolesGetResponse(
            alias = "promoslova",
            description = "Предоставление доступа к табу промо-слова используемого на поиске приложения ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "8bb67f5b-bbe5-e911-bba4-00155d627f03",
            isVisibleInErm = false,
            name = "Расширенный поиск // Промо-слова"
        ),
        RolesGetResponse(
            alias = "searchanons",
            description = "Предоставление доступа к табу Анонсы используемому на поиске приложения единое рабочее место",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "99f6d481-bbe5-e911-bba4-00155d627f03",
            isVisibleInErm = true,
            name = "Расширенный поиск // Анонсы"
        ),
        RolesGetResponse(
            alias = "moidela",
            description = "Предоставление доступа к интерфейсу моих дел в едином рабочем месте",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b4a256ac-fae8-e911-bba4-00155d627f03",
            isVisibleInErm = true,
            name = "Мои дела"
        ),
        RolesGetResponse(
            alias = null,
            description = "Позволяет пользователю видеть все активные подразделения по всем партнерам",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "7c645743-69f9-e911-bba4-00155d627f03",
            isVisibleInErm = false,
            name = "Монитор // Администратор мониторов"
        ),
        RolesGetResponse(
            alias = "astadmin",
            description = "Доступ к админ-панели Asterisk  (на основании наличия этой роли будем передавать коллегам из Asterisk признак админ или нет)",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "b0bb33da-4810-ea11-bba4-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к админ-панели Asterisk"
        ),
        RolesGetResponse(
            alias = "viewqueue",
            description = "Доступ к вкладке \"Очередь\" личного кабинета ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "e1c4ed29-3f17-ea11-bba4-00155d627f03",
            isVisibleInErm = true,
            name = "Очередь звонков"
        ),
        RolesGetResponse(
            alias = "delorderscans",
            description = "Предоставляет возможность удалять любые сканы документов",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "09214f2f-f148-ea11-bba4-00155d627f03",
            isVisibleInErm = false,
            name = "Заказы // Удаление сканов документов загруженных к заказу"
        ),
        RolesGetResponse(
            alias = "operator_head_group",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "f88742fd-f059-ea11-bba6-00155d627f03",
            isVisibleInErm = false,
            name = "Личные продажи // Руководитель группы операторов"
        ),
        RolesGetResponse(
            alias = "vtmman",
            description = "Доступ к ВТМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "7b6f73ab-9f96-ea11-bba7-00155d627f03",
            isVisibleInErm = true,
            name = "ВТМ // Сотрудник ВТМ"
        ),
        RolesGetResponse(
            alias = "all_filials",
            description = "Предоставляет доступ ко всем филиалам в селекты на мониторах руководителя группы",
            groupId = "7578fc40-4f19-e911-bb9d-00155d627f03",
            groupName = "Функции руководителя группы",
            id = "faf1e6ae-87a1-ea11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Все филиалы"
        ),
        RolesGetResponse(
            alias = null,
            description = "Доступ к просмотру и обработке всех заявок на ДД 360",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "494cebfd-88d2-ea11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Админка360 // Администратор"
        ),
        RolesGetResponse(
            alias = null,
            description = "Доступ к просмотру и обработке заявок по своему подразделению на ДД 360",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "115b524d-89d2-ea11-bba7-00155d627f03",
            isVisibleInErm = true,
            name = "Админка360 // Супервизор"
        ),
        RolesGetResponse(
            alias = "multicamp_access",
            description = "Доступ к разделу мультикампании в мониторе руководителя групп.",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "0f45f56b-02d9-ea11-bba7-00155d627f03",
            isVisibleInErm = true,
            name = "Доступ к разделу мультикампании"
        ),
        RolesGetResponse(
            alias = "allow_deactivate_orders",
            description = "Даёт возможность закрывать свои счета менеджерам и РГ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "4cdcc587-dbe5-ea11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Заказы // Доступ к деактивации счетов"
        ),
        RolesGetResponse(
            alias = "allow_bill_without_phonecall",
            description = "Разрешить сотруднику создание заказа без даты перезвона по неоплаченному счёту в обход настройки на подразделении \"Обязательная дата звонка по счету\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "a1e0dd14-71e7-ea11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к созданию счёта без перезвона"
        ),
        RolesGetResponse(
            alias = "testing",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "1eb24fe1-65f2-ea11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к тестовому функционалу"
        ),
        RolesGetResponse(
            alias = "allow_order_block",
            description = "Разрешить сотруднику блокировать заказы в обход настройки на подразделении \"Запрет блокировки заказа\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "688d3eca-aaf2-ea11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Заказы // Доступ к блокировке заказа"
        ),
        RolesGetResponse(
            alias = "deactivate_license",
            description = "В рамках этой роли пользователь получается возможность деактивировать УКД в едином рабочем месте менеджера",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "60e4ee32-e5fb-ea11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "УКД // Деактивация УКД"
        ),
        RolesGetResponse(
            alias = "docdate_without_limits",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "46d21640-8b01-eb11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Неограниченное изменение дата документов"
        ),
        RolesGetResponse(
            alias = "coordinator",
            description = "Определяется авторизованного пользователя как координатора группы",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "f3d5bbd5-7a14-eb11-bba7-00155d627f03",
            isVisibleInErm = false,
            name = "Координатор"
        ),
        RolesGetResponse(
            alias = "monitorrg",
            description = "Роль ограничивает доступ к разделу монитора руководителя группы, доступному в едином рабочем месте руководителя по адресу : https://monitor.action-mcfr.ru",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "1fd4d5b1-6d23-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Доступ в монитор руководителя группы"
        ),
        RolesGetResponse(
            alias = "lprkk",
            description = "Роль предоставляет возможность управлять призаком ЛПР (лицо принимающее решение) на карточке клиента в едином рабочем месте менеджера. Используется в карточке звонка, карточке клиента, Связанных контактных лицах и дополнительных пользователях на УКД",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "592d3036-f228-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Управление ЛПР на карточке клиента"
        ),
        RolesGetResponse(
            alias = "depthwork",
            description = "Предоставляет доступ к разделу \"Углубленная работа\" в едином рабочем месте руководителя",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "9821d8b5-0836-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Доступ к углубленной работе"
        ),
        RolesGetResponse(
            alias = "m_td",
            description = "Роль выдает доступ к монитору \"трудовая дисциплина\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "a88e6c7d-e63e-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Монитор // Трудовая дисциплина"
        ),
        RolesGetResponse(
            alias = "m_sl",
            description = "Роль ограничивает доступ к монитору руководителя группы раздел  \"стоп-листы\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "6d37ef89-e63e-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Стоп-Лист // Доступ в монитор \"стоп-листы\""
        ),
        RolesGetResponse(
            alias = "hist_cardopen",
            description = "Доступ к истории открытия карточки клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "ea4b8495-5843-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к истории открытия карточки клиента"
        ),
        RolesGetResponse(
            alias = "hist_main",
            description = "Доступ к истории изменения основных параметров клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "bf3a2ebb-5843-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к истории изменения основных параметров клиента"
        ),
        RolesGetResponse(
            alias = "hist_address",
            description = "Доступ к истории изменения адресов клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления, менеджер.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "35b4dcdc-5843-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к истории изменения адресов клиента"
        ),
        RolesGetResponse(
            alias = "hist_contact",
            description = "Доступ к истории изменения контактных данных клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления, менеджер.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "c1c50bef-5843-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к истории изменения контактных данных клиента"
        ),
        RolesGetResponse(
            alias = "hist_autocall",
            description = "Доступ к истории автодозвонов клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "31164da5-5943-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Доступ к истории автодозвонов клиента"
        ),
        RolesGetResponse(
            alias = "hist_calls",
            description = "Доступ к истории выпадения звонков клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "a26b8ee6-5943-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к истории выпадения звонков клиента"
        ),
        RolesGetResponse(
            alias = "hist_support",
            description = "Доступ к истории сопровождения клиента.\nДоступна по умолчанию (ручное присвоение) никому.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "8803950e-5a43-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к истории сопровождения клиента"
        ),
        RolesGetResponse(
            alias = "hist_orderdel",
            description = "Доступ к истории удаления заказов клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления, менеджер.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "24961f3c-5a43-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Доступ к истории удаления заказов клиента"
        ),
        RolesGetResponse(
            alias = "hist_orderchange",
            description = "Доступ к истории изменения заказов клиента.\nДоступна по умолчанию (ручное присвоение) должностям: руководитель группы/филиала/направления, менеджер.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=233326040",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "40b2405c-5a43-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к истории изменения заказов клиента"
        ),
        RolesGetResponse(
            alias = "allheadpartners_access",
            description = "Может ли пользователь получать всех головных партнёров для поиска.\nРоль для семинаров - https://conf.action-media.ru/pages/viewpage.action?pageId=233335902",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "a744b987-8144-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Семинары // Доступ ко всем головным партнёрам"
        ),
        RolesGetResponse(
            alias = "phcall_m_c",
            description = "Позволяет пользователю получить доступ на создание ручного действия",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "43a143ab-7861-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Доступ к созданию ручного действия"
        ),
        RolesGetResponse(
            alias = "allow_pdiscount",
            description = "Роль даёт возможность добавлять в заказ позиции с индивидуальной ценой без согласования (если индивидуальная цена уже была согласована)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "8ea02f6e-1271-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Мастер заказа // Доступ на применение индивидуальной цены к позиции заказа"
        ),
        RolesGetResponse(
            alias = "allow_extpayscenarios",
            description = "Разрешить пользователю оформлять заказы с расширенным списком сценариев оплаты в МЗ.\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=272827324",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "ff0328ce-7c81-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Мастер заказа // Доступ к расширенному списку сценариев оплаты заказа"
        ),
        RolesGetResponse(
            alias = "access_management",
            description = "Роль даёт возможность получить расширенную карточку сотрудника (подробная информация вроде даты рождения, телефона, логина и список активных ролей ЕРМ)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "2d7d97e4-6c82-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Сотрудники // Доступ к расширенной карточке сотрудника"
        ),
        RolesGetResponse(
            alias = "allow_order_wizard",
            description = "Предоставляет доступ к интерфейсу мастера создания заказов на карточке звонка",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "00ade46a-5c85-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Доступ к мастеру заказа для партнеров"
        ),
        RolesGetResponse(
            alias = "allow_user_reg",
            description = "Доступ к созданию менеджеров в ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "7afd4e7c-a58b-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Доступ к регистрации пользователей"
        ),
        RolesGetResponse(
            alias = null,
            description = "Доступ к просмотру и созданию заявок в Админке 360",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "d97755db-6f8c-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Админка360 // Доступ"
        ),
        RolesGetResponse(
            alias = "partner",
            description = "Пользователь из подразделения с каналом продаж \"партнёры\".\nДаёт доступ к разделу \"Мои дела\" когда идёт в паре с ролью moidela",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "8a73d8da-4b8e-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Функционал для партнеров"
        ),
        RolesGetResponse(
            alias = "press",
            description = "Пользователь из подразделения с каналом продаж \"АП\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "be052e1e-4c8e-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Пользователь из подразделения с каналом продаж \"АП\""
        ),
        RolesGetResponse(
            alias = "ssdirection",
            description = "Пользователь из подразделения с направлением \"Справочные системы (новые)\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "0832b748-4c8e-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Пользователь из подразделения с направлением \"Справочные системы (новые)\""
        ),
        RolesGetResponse(
            alias = "sip",
            description = "Пользователь с флагом \"Пользуется SIP (freeswitch)\"",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "26fb57b9-4c8e-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Пользователь с флагом \"Пользуется SIP (freeswitch)\""
        ),
        RolesGetResponse(
            alias = "allow_docdate_change",
            description = "Проставление даты отгрузочных документов на любую дату не раньше текущей.\nОтличается от docdate_without_limit тем, что эта роль даёт доступ к функционалу, а другая ограничивает доступные даты.",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "34dcba88-bd96-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Отправка документов // Доступ к изменению даты отгрузочных документов"
        ),
        RolesGetResponse(
            alias = "allow_edit_manager",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "ed4454df-33a4-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Сотрудники // Доступ к редактированию менеджеров"
        ),
        RolesGetResponse(
            alias = "allow_client_without_email",
            description = "Роль дает право на создание физ. лица без заполнения имейл адреса",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "c72aa65d-52a7-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Создание клиента без имейла"
        ),
        RolesGetResponse(
            alias = "a360_access",
            description = "Доступ к интерфейсу стоп-лист А360 (Потенциальные Клиенты)\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=284431239",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b852c5e3-5eb9-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Управление стоп-листом А360: ПК"
        ),
        RolesGetResponse(
            alias = "phonecalls_reassign",
            description = "Доступ к разделу \"Смена ответственного на звонках\" в ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b53b2f25-d5be-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Смена ответственного на звонках"
        ),
        RolesGetResponse(
            alias = "import_customers_access",
            description = "Импорт клиентов по файлу",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "7ca92c3e-9fc3-eb11-bba9-00155d627f03",
            isVisibleInErm = true,
            name = "Загрузка своих клиентов // Импорт клиентов"
        ),
        RolesGetResponse(
            alias = "allow_changeordercustomer",
            description = "Доступ к функционалу смены плательщика на заказе",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "e9c6439e-83c7-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Заказы // Смена плательщика на заказе"
        ),
        RolesGetResponse(
            alias = "allow_docanydate_change",
            description = "Роль дает право на проставлении любой даты не ранее текущей",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "90fa95b9-93c7-eb11-bba9-00155d627f03",
            isVisibleInErm = false,
            name = "Отправка документов // Доступ к изменению даты отгрузочных документов на любой период"
        ),
        RolesGetResponse(
            alias = "video_meeting_monitoring",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "bc928810-6f2d-ef11-bbc3-ab5cd4759f6f",
            isVisibleInErm = false,
            name = "Мониторинг видеовстреч"
        ),
        RolesGetResponse(
            alias = "new_dic_receive",
            description = "Доступ к изменению способа доставки в заказах\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=442567355",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "896f81c6-9f33-ef11-bbc3-ab5cd4759f6f",
            isVisibleInErm = true,
            name = "Заказы // Доступ к изменению способа доставки в заказах"
        ),
        RolesGetResponse(
            alias = "adv_manager",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "98196e72-246d-ef11-bbc3-ab5cd4759f6f",
            isVisibleInErm = true,
            name = "Менеджер реклама"
        ),
        RolesGetResponse(
            alias = "adv_supervisor",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "2b9ae782-246d-ef11-bbc3-ab5cd4759f6f",
            isVisibleInErm = true,
            name = "Координатор реклама"
        ),
        RolesGetResponse(
            alias = "adv_boss",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "58b2c58f-246d-ef11-bbc3-ab5cd4759f6f",
            isVisibleInErm = true,
            name = "Руководитель реклама"
        ),
        RolesGetResponse(
            alias = "access_client",
            description = "Дает возможность видеть все данные по УКД и контактным данным клиента",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "0c7cadfa-5e9a-ee11-bbbf-b87905c9cf85",
            isVisibleInErm = false,
            name = "Доступ к расширенной карточке клиента"
        ),
        RolesGetResponse(
            alias = "access_bill_reports",
            description = "Предоставление возможности запрашивать в ЕРМ счета и счета фактуры, а также смотреть историю запроса документов.",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "3bd203d9-b1b6-ee11-bbbf-b87905c9cf85",
            isVisibleInErm = false,
            name = "Формирование счетов"
        ),
        RolesGetResponse(
            alias = "document_access_sd",
            description = "Расширенный доступ к скачиванию документов (СД)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b63442e3-ded4-eb11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Расширенный доступ к скачиванию документов (СД)"
        ),
        RolesGetResponse(
            alias = "document_access_rg",
            description = "Расширенный доступ к скачиванию документов (РГ)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "0b799feb-ded4-eb11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Расширенный доступ к скачиванию документов (РГ)"
        ),
        RolesGetResponse(
            alias = "a360_access_rk",
            description = "Доступ к интерфейсу стоп-лист А360 (Регулярные Клиенты)\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=284431239",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "299a7e95-20d8-eb11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Управление стоп-листом А360: РК"
        ),
        RolesGetResponse(
            alias = "a360_access_partner",
            description = "Доступ к интерфейсу стоп-лист А360 в рамках головного партнёра\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=284431239",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "3fb362f8-20d8-eb11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Управление стоп-листом А360 в рамках головного партнера"
        ),
        RolesGetResponse(
            alias = "allow_order_author_change",
            description = "Возможность назначить себя автором заказа с интернет-магазина",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "ae0fdf2b-45de-eb11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Заказы // Доступ к назначению себя автором заказа"
        ),
        RolesGetResponse(
            alias = "sdsupervizor",
            description = "SD супервизор",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "a1d8d4c2-65de-eb11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "SD супервизор"
        ),
        RolesGetResponse(
            alias = "allow_watch_others_orders",
            description = "Доступ к просмотру чужих заказов",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "5bafcf1e-18df-eb11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Заказы // Доступ к просмотру чужих заказов"
        ),
        RolesGetResponse(
            alias = "change_support_manager",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "1fb171ca-6ae8-eb11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Смена ответственного за сопровождение и расширение"
        ),
        RolesGetResponse(
            alias = "allow_ext_hide_ukd",
            description = "Доступ к просмотру информации о партнёре и менеджере сопровождения на чужих УКД",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "17416068-a7ee-eb11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "УКД // Доступ к просмотру столбцов на скрытом УКД"
        ),
        RolesGetResponse(
            alias = "konkurs2021",
            description = "Роль предоставляет доступ к интерфейсу просмотров результатов конкурса",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "c9f0ab83-47f1-eb11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Доступ к конкурсу 2021 - летим в Крым"
        ),
        RolesGetResponse(
            alias = "allow_corp_client",
            description = "Управление признаком корпоративного клиент\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=286113093",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "5b6999d7-b9f5-eb11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Управление признаком корпоративного клиент"
        ),
        RolesGetResponse(
            alias = "Selectionfizlits",
            description = null,
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "26b25a11-d542-ec11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Отчеты // Выборка физ. лиц по СС"
        ),
        RolesGetResponse(
            alias = "delslaves",
            description = "Роль позволяет удалять любых дополнительных пользователей (слейвов) в любом многопользовательском УКД",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "5d9be344-ea46-ec11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "УКД // Удаление дополнительных пользователей в УКД"
        ),
        RolesGetResponse(
            alias = "limited_allow_edit_manager",
            description = "Роль дает управление только на сотрудниках своего подразделения",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "5a3099c7-5348-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Сотрудники // Ограниченное редактирование сотрудников своего подразделения"
        ),
        RolesGetResponse(
            alias = "application_edit",
            description = "Пользователям с ролью доступно редактировать любые обращения",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "fa265181-6448-ec11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Редактирование любых обращений"
        ),
        RolesGetResponse(
            alias = "a360_ignore_analysis_pk_status",
            description = "Игнорирование статуса ПК по А360 при добавлении в куст",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "cf7660e8-0d49-ec11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Управление сделками // Игнорирование статуса ПК по А360 при добавлении в куст"
        ),
        RolesGetResponse(
            alias = "extended_work_with_document_basket",
            description = "Расширенная работа с корзиной документов (массовое добавление документов по заказу в корзину, массовое удаление документов из корзины)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "a149d8df-8d5d-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Расширенная работа с корзиной документов"
        ),
        RolesGetResponse(
            alias = "access_monitor",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "f6d4b113-3b62-ec11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Монитор // Доступ в монитор ВТМ"
        ),
        RolesGetResponse(
            alias = "vtm_monitor",
            description = "Доступ к разделу \"ВТМ монитор\"",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "69ea2ea7-9277-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Монитор // Доступ в монитор ВТМ Онлайн"
        ),
        RolesGetResponse(
            alias = "account_number",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "f8424d6c-1780-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Заказы // Доступ к галке \"Номер счета на доплату совпадает с номером основного счета\""
        ),
        RolesGetResponse(
            alias = "document_wizard_send",
            description = "Для отображения меню - Мастер отправки документов",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "94f06268-9e93-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Мастер отправки документов"
        ),
        RolesGetResponse(
            alias = "can_send_document_basket_by_edo",
            description = "Для Мастера отправки документов - разрешает отправлять корзину документов по ЭДО",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "29ae8435-6995-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Отправка документов // Отправление по ЭДО"
        ),
        RolesGetResponse(
            alias = "can_send_edo_files_as_signed_docs",
            description = "Для Мастера отправки документов - позволяет отправить любой файл как подписанный с нашей стороны документ (Договор, Счет, Акт)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "5ace32ec-6995-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Отправка документов // Отправка по ЭДО файлов как подписанных документов"
        ),
        RolesGetResponse(
            alias = "dismiss",
            description = "Роль дает возможность помечать уволенных сотрудников лейблом \"уволен\" в ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "6c50dea4-39a1-ec11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Сотрудники // Увольнение сотрудников"
        ),
        RolesGetResponse(
            alias = "view_act",
            description = "Доступ к табу \"Акты сверок\" в документах в карточке клиента",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b5fbe893-eab4-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Доступ к табу \"Акты сверок\""
        ),
        RolesGetResponse(
            alias = "snils_ optional",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "058df5ea-76c1-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Сотрудники // Необязательное поле СНИЛС в форме регистрации сотрудника ЕРМ"
        ),
        RolesGetResponse(
            alias = "copy_dd",
            description = "Роль предоставляет пользователю доступ к копированию ссылки на демодоступ при выдаче его клиенту",
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "d3d43b2d-e9d1-ec11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Демодоступ // Скопировать ссылку на ДД"
        ),
        RolesGetResponse(
            alias = "name_validation",
            description = "Валидация ФИО физика в ЕРМ в форме создания, редактирования и выдаче ДД",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "3f9d9608-bd1f-ed11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Валидация ФИО физика в форме создания и редактирования"
        ),
        RolesGetResponse(
            alias = "monitorrg_coordinator",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "12ba0291-f022-ed11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Монитор // Доступ к монитору руководителя - руководитель направления"
        ),
        RolesGetResponse(
            alias = "monitorrg_branchmanager",
            description = "Доступ руководителей филиала к монитору РГ https://monitor.action-mcfr.ru/monitors",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "1d94eca6-f022-ed11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Монитор // Доступ к монитору руководителя - руководитель филиала"
        ),
        RolesGetResponse(
            alias = "monitorrg_teamleader",
            description = "Доступ руководителей группы к монитору РГ https://monitor.action-mcfr.ru/monitors",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "9099dfca-f022-ed11-bbbc-bcda0251696c",
            isVisibleInErm = true,
            name = "Монитор // Доступ к монитору руководителя - руководитель группы"
        ),
        RolesGetResponse(
            alias = "create_dismissal_user",
            description = "Доступ к созданию пользователя в ЕРМ, который был уволен менее полугода назад",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "6da4ab6e-ac24-ed11-bbbc-bcda0251696c",
            isVisibleInErm = false,
            name = "Доступ к созданию пользователя, который был уволен менее полугода назад"
        ),
        RolesGetResponse(
            alias = "wiretap_new",
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "63e70af2-299e-ed11-bbbe-e4b749ae09c7",
            isVisibleInErm = false,
            name = "Монитор // Прослушка звонков - временная роль"
        ),
        RolesGetResponse(
            alias = "wiretap_supervisor",
            description = "Прослушивание всех звонков (без разделения на внутренние и партнеры) и оценка всех звонков\nУдаление или редактирование всех оценок",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "7e7cf909-e6ce-ed11-bbbe-e4b749ae09c7",
            isVisibleInErm = true,
            name = "Монитор // Прослушка - супервизор"
        ),
        RolesGetResponse(
            alias = "wiretap_teamleader",
            description = "Прослушивание всех звонков (с разделением по партнерам) и оценка всех звонков.\nУдаление или редактирование только своих оценок",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "55c48443-e6ce-ed11-bbbe-e4b749ae09c7",
            isVisibleInErm = true,
            name = "Монитор // Прослушка - руководитель группы"
        ),
        RolesGetResponse(
            alias = "wiretap_coordinator",
            description = "Прослушивание всех звонков (без разделения на внутренние и партнеры) и оценка всех звонков\nУдаление или редактирование только своих оценок",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "7b2a506f-e6ce-ed11-bbbe-e4b749ae09c7",
            isVisibleInErm = true,
            name = "Монитор // Прослушка - координатор"
        ),
        RolesGetResponse(
            alias = "allow_partner_affixing",
            description = "Проставление ID партнера на физических лицах \nBCKLG-46887 / Косорукова Марина / https://erm.action-mcfr.ru/erm/Helper",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b7fb0ec5-afcf-ed11-bbbe-e4b749ae09c7",
            isVisibleInErm = false,
            name = "Хелпер // Доступ к заливке ID партнера"
        ),
        RolesGetResponse(
            alias = null,
            description = "QA роль максимального кол-во закрепления в сопровождении",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "80c3c518-9eff-ed11-bbbe-e4b749ae09c7",
            isVisibleInErm = false,
            name = "QA_MaxCustomerStopList"
        ),
        RolesGetResponse(
            alias = "allow_public_api",
            description = "Доступ к интеграционному сервису crm.public-api",
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "507710df-cb3d-ee11-bbbe-e4b749ae09c7",
            isVisibleInErm = false,
            name = "Доступ к Public API"
        ),
        RolesGetResponse(
            alias = "telephony_admin",
            description = null,
            groupId = "f03e5caa-e164-e911-bb9f-00155d627f03",
            groupName = "Администратор",
            id = "c4751529-3664-ee11-bbbe-e4b749ae09c7",
            isVisibleInErm = false,
            name = "Доступ к админке телефонии"
        ),
        RolesGetResponse(
            alias = "update_admin",
            description = "Открывает доступ к  разделу \"Администрирование\" в рамках карточки УКД",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "68c63661-fe73-ee11-bbbe-e4b749ae09c7",
            isVisibleInErm = true,
            name = "УКД // Администрирование"
        ),
        RolesGetResponse(
            alias = "refuse_mail",
            description = "Роль для сотрудников сервиса.\nВ ЕРМ в разделе «Личные данные» доп. раздел «Отписка от рассылок и звонков»",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "a8a11921-948e-ee11-bbbe-e4b749ae09c7",
            isVisibleInErm = true,
            name = "Отписка от звонков и рассылок"
        ),
        RolesGetResponse(
            alias = "service_unhide_ukd",
            description = "Роль на просмотр УКД партнеров и \"партнерских\" заказов, в которых Р/С указан НОЧУ 262 по задаче BCKLG-54821\n\nhttps://conf.action-media.ru/pages/viewpage.action?pageId=276991238",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "b00a6b14-1590-ee11-bbbe-e4b749ae09c7",
            isVisibleInErm = false,
            name = "УКД // Просмотр УКД партнеров"
        ),
        RolesGetResponse(
            alias = "vtm_postcall_hack",
            description = "Роль дает доступ к работе с карточкой входящего звонка по истечении поствызова, при наличии роли карточки входящих звонков не будут автоматически уходить в отложенные, после окончания времени поствызова",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "fbde8914-fef8-eb11-bbb6-f54d679fc4d6",
            isVisibleInErm = false,
            name = "ВТМ // Доступ к работе с карточкой по истечении поствызова ВТМ"
        ),
        RolesGetResponse(
            alias = "sdmanager",
            description = "Открывает доступ для возможности работы с SD (обращениями Service Desk) в ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "c6a088cd-a6fb-eb11-bbb6-f54d679fc4d6",
            isVisibleInErm = false,
            name = "SD менеджер"
        ),
        RolesGetResponse(
            alias = "allow_net_order_edit",
            description = "https://conf.action-media.ru/pages/viewpage.action?pageId=292898048",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "6005b16a-81fe-eb11-bbb6-f54d679fc4d6",
            isVisibleInErm = false,
            name = "Доступ к редактированию заказов, выставленных в интернет-магазине"
        ),
        RolesGetResponse(
            alias = "access_edit_order_with_payment",
            description = "Пользователю после поступления денежных средств а также реализации или частичной реализации, не доступно редактировать параметры заказа, т.е нельзя редактировать полностью/частично оплаченный или полностью/частично отгруженный заказ.",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "e8c851f4-fd03-ec11-bbb6-f54d679fc4d6",
            isVisibleInErm = false,
            name = "Доступ к редактированию заказа с датой оплаты"
        ),
        RolesGetResponse(
            alias = "Shipment_Report",
            description = null,
            groupId = "4a2e1ed8-4d19-e911-bb9d-00155d627f03",
            groupName = "Бэк офис дилера",
            id = "399fced9-9010-ec11-bbb6-f54d679fc4d6",
            isVisibleInErm = true,
            name = "Отчеты // Отчет по отгрузкам"
        ),
        RolesGetResponse(
            alias = "userchange",
            description = "Делает доступным поле Пользователь  на лицензии (для продуктов А 360, Академии)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "1d206fd5-db19-ec11-bbb6-f54d679fc4d6",
            isVisibleInErm = true,
            name = "УКД // Смена пользователя на лицензии"
        ),
        RolesGetResponse(
            alias = "userdetach",
            description = "Дает доступ к кнопке \"открепить\" на лицензиии (кроме продуктов А 360, СС+, Академия)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "d5f216f6-db19-ec11-bbb6-f54d679fc4d6",
            isVisibleInErm = true,
            name = "УКД // Открепление пользователя с лицензии"
        ),
        RolesGetResponse(
            alias = null,
            description = null,
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "69d860b0-981b-ec11-bbb6-f54d679fc4d6",
            isVisibleInErm = false,
            name = "Слияние клиентов с битриксами"
        ),
        RolesGetResponse(
            alias = "school_workplace",
            description = "Роль дает право сотруднику отправлять запрос на отправку электронной копии выписок из протокола ОТ через хэлпер.",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "07ed905e-6fe0-ee11-bbc1-f77d8960ae8a",
            isVisibleInErm = true,
            name = "Школы-рабочее место"
        ),
        RolesGetResponse(
            alias = "service_desk_email",
            description = "Роль выделена для сотрудников сервиса, чтобы  в ЕРМ при отправке документов выходили шаблоны маркетинговой кампании Сервис-деск (служебные кампании)",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "01064a64-3ef3-ee11-bbc1-f77d8960ae8a",
            isVisibleInErm = false,
            name = "Отправка документов // Доступ для отправки шаблонов кампании Сервис-деск (служебные кампании)"
        ),
        RolesGetResponse(
            alias = "service_desk_email",
            description = "Роль доступна сотрудникам Сервиса для отображения шаблонов  маркетинговой кампании Сервис-деск (служебные кампании) при отправке документов в ЕРМ",
            groupId = "dc3733a9-5493-e911-bba2-00155d627f03",
            groupName = "Единое рабочее место",
            id = "4eae73e9-3ef3-ee11-bbc1-f77d8960ae8a",
            isVisibleInErm = true,
            name = "Доступ к шаблонам кампании Сервис-деск (служебные кампании)"
        ),
    )
}
