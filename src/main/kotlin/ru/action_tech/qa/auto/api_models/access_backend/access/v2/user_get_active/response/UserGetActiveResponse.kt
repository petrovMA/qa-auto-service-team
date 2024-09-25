package ru.action_tech.qa.auto.api_models.access_backend.access.v2.user_get_active.response

data class UserGetActiveResponse(
    val entities: List<Entity>?
) {
    data class Entity(
        val core: Core?,
        val data: List<Data?>?,
        val deletedData: List<DeletedData?>?
    ) {
        data class Core(
            val id: String,
            val createTimestamp: String,
            val isTest: Boolean,
            val isDeleted: Boolean
        )

        data class Data(
            val key: String?,
            val value: Any?,
            val timestamp: String,
            val version: Int,
            val source: String?
        )

        data class DeletedData(
            val key: String?,
            val value: Any?,
            val timestamp: String,
            val version: Int,
            val source: String?
        )
    }
}