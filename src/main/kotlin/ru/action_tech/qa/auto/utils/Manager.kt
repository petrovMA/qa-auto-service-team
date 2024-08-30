package ru.action_tech.qa.auto.utils

import ru.action_tech.qa.auto.api_models.common.OperatorHoldResponse
import ru.action_tech.qa.auto.api_models.managers.ManagersRequests
import ru.action_tech.qa.auto.api_models.managers.ManagersRequests.managerUpdate
import ru.action_tech.qa.auto.api_models.managers.ManagersRequests.operatorHold
import ru.action_tech.qa.auto.api_models.managers.ManagersRequests.userRolesDelete
import ru.action_tech.qa.auto.api_models.managers.qa.operator_hold.OperatorHoldRequest
import ru.action_tech.qa.auto.api_models.managers.qa.user_roles_delete.UserRolesDeleteRequest
import ru.action_tech.qa.auto.api_models.managers.v1.manager_update.ManagerUpdateRequest
import ru.action_tech.qa.auto.api_models.managers.v1.role.roles_get.RolesGetResponse
import ru.action_tech.qa.auto.api_models.managers.v1.role.user_roles_add.UserRolesAddRequest
import ru.action_tech.qa.auto.utils.junit.threadLocalOperator
import ru.action_tech.qa.auto.utils.junit.threadOperatorsCSVObject
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.serialization.facade.deserialize
import ru.action_tech.qa.auto.core.utils.waiting.Wait
import ru.action_tech.qa.auto.utils.auth.tokenActionushka
import ru.action_tech.qa.auto.utils.http.Headers.DATE
import ru.action_tech.qa.auto.utils.http.Headers.X_OPERATION_ID
import java.net.HttpURLConnection.HTTP_OK


class Manager private constructor(
    val holdId: Int,
    val id: String?,
    val login: String?,
    val password: String?,
    val fio: String?,
    val manager: OperatorHoldResponse.Manager,
) {
    companion object {
        fun holdManagerForTest(
            qaOperatorType: Int = 1, //Тип оператора
            holdingTimeInSeconds: String = HOLD_ENTITY_TIME_SECONDS,
            meta: String? = null,
            password: String = "1qaz@WSX",
        ) = "Получение оператора для теста" {
            Wait.until(
                timeoutInMs = HOLD_RETRIES_TIMEOUT_IN_MILLIS,
                pollingIntervalInMs = 1000,
                test = { statusCode == HTTP_OK },
                script = {
                    managersArmSellerClient.send(
                        operatorHold(OperatorHoldRequest(qaOperatorType, meta, holdingTimeInSeconds))
                    )
                }
            ).let {
                it.headers.let { headers ->
                    if (COLLECT_DATA_FOR_OPERATOR_CSV) {
                        threadOperatorsCSVObject.get().startHoldTime.add(headers[DATE].value)
                        threadOperatorsCSVObject.get().startXOperationId.add(headers[X_OPERATION_ID].value)
                    }
                }
                val operator = OperatorHoldResponse.deserialize(it.asString())
                managersArmSellerClient.send(userRolesDelete(UserRolesDeleteRequest(operator.manager.systemUserId)))
                managersArmSellerClient.send(
                    managerUpdate(
                        ManagerUpdateRequest(
                            managerId = operator.manager.systemUserId,
                            lockedCallIs = false
                        )
                    )
                )
                if (COLLECT_DATA_FOR_OPERATOR_CSV) {
                    threadOperatorsCSVObject.get().operatorId.add(operator.operatorId.toString())
                }
                Manager(
                    holdId = operator.operatorId,
                    login = operator.manager.email,
                    password = password,
                    fio = operator.manager.fullName,
                    id = operator.manager.systemUserId,
                    manager = operator.manager
                ).apply {
                    threadLocalOperator.get().add(this)
                }
            }
        }
    }

    fun addRoles(vararg roles: RolesGetResponse) = managersArmSellerClient.send(
        ManagersRequests.postUserRolesAdd(
            request = UserRolesAddRequest(
                userId = id,
                roleIds = roles.map { it.id }
            ),
            token = tokenActionushka
        )
    )
}