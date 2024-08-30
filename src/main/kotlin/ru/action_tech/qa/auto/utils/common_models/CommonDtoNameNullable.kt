package ru.action_tech.qa.auto.utils.common_models

import ru.action_tech.qa.auto.core.serialization.facade.Serializable

data class CommonDtoNameNullable(val id: String, val name: String?) : Serializable { override fun toString(): String = serialize.strict.toJson() }