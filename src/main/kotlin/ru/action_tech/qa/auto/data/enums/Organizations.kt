package ru.action_tech.qa.auto.data.enums

enum class Organizations(val id: String, val orgName: String, val inn: String? = "", val pin: String) {
    ORG_FOR_ISSUING_ACCESS(
        "71B6818D-D667-49B8-A655-641DBF749920",
        "Автотест на выдачу демодоступа в А360",
        "4261993739",
        "6739170801"
    ),
}