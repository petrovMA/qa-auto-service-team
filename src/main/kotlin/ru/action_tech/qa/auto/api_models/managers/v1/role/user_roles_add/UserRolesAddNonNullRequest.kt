package ru.action_tech.qa.auto.api_models.managers.v1.role.user_roles_add

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserRolesAddNonNullRequest(val roleIds: Any?, val userId: Any?)