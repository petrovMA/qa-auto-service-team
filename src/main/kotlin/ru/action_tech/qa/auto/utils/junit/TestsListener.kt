package ru.action_tech.qa.auto.utils.junit

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import ru.action_tech.qa.auto.api_models.managers.ManagersRequests.operatorsUnholdByIds
import ru.action_tech.qa.auto.api_models.managers.qa.operators_unhold_by_ids.OperatorsUnholdByIdsRequest
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.logging.LogUtils.logListenerEventIfError
import ru.action_tech.qa.auto.core.properties.TEMP_PATH
import ru.action_tech.qa.auto.core.utils.createAndAppend
import ru.action_tech.qa.auto.utils.COLLECT_DATA_FOR_OPERATOR_CSV
import ru.action_tech.qa.auto.utils.Manager
import ru.action_tech.qa.auto.utils.http.Headers.DATE
import ru.action_tech.qa.auto.utils.http.Headers.X_OPERATION_ID
import ru.action_tech.qa.auto.utils.managersArmSellerClient
import java.nio.file.Paths

internal val threadLocalOperator by lazy { ThreadLocal.withInitial { mutableSetOf<Manager>() } }
internal val threadOperatorsCSVObject by lazy { ThreadLocal.withInitial { OperatorCSVObject() } }

@Volatile
var flag = true

class OperatorCSVObject(
    var testClass: String = "",
    var operatorId: ArrayList<String> = arrayListOf(),
    var startHoldTime: ArrayList<String> = arrayListOf(),
    var startXOperationId: ArrayList<String> = arrayListOf(),
    var endHoldTime: String = "",
    var endXOperationId: String = ""
)

class TestsListener : AfterEachCallback, BeforeEachCallback {

    override fun afterEach(context: ExtensionContext?) {
        "Post test fixture" {
            threadLocalOperator.takeUnless { it.get().isEmpty() }?.apply {
                unHoldOperators()
            }
            "Logging to file" {
                Paths.get(TEMP_PATH.toString(), "artifacts", "operators.csv").toFile()
                    .createAndAppend(prepareStringForOperatorCSV(threadOperatorsCSVObject.get()))
            }
        }
    }

    private fun prepareStringForOperatorCSV(csvObject: OperatorCSVObject) = StringBuilder().apply {
        csvObject.operatorId.forEachIndexed { index, _ ->
            append("${csvObject.testClass};")
            append("${csvObject.operatorId[index]};")
            append("${csvObject.startHoldTime[index]};")
            append("${csvObject.startXOperationId[index]};")
            append("${csvObject.endHoldTime};")
            append("${csvObject.endXOperationId};")
            append("\n")
        }

    }.toString()

    private fun unHoldOperators() {
        logListenerEventIfError("[JUNIT][AFTER EACH] UnHold Operators") {
            managersArmSellerClient.send(
                operatorsUnholdByIds(
                    OperatorsUnholdByIdsRequest(
                        ids = threadLocalOperator.get().map { it.holdId.toString() })
                )
            )
                .let {
                    if (COLLECT_DATA_FOR_OPERATOR_CSV) {
                        threadOperatorsCSVObject.get().endXOperationId = it.headers[X_OPERATION_ID].value
                        threadOperatorsCSVObject.get().endHoldTime = it.headers[DATE].value
                    }
                }
        }
    }

    override fun beforeEach(context: ExtensionContext?) {
        threadLocalOperator.get().clear()
        threadOperatorsCSVObject.set(OperatorCSVObject())
        if (COLLECT_DATA_FOR_OPERATOR_CSV && flag) {
            Paths.get(TEMP_PATH.toString(), "artifacts", "operators.csv").toFile().createAndAppend(
                prepareStringForOperatorCSV(
                    OperatorCSVObject(
                        testClass = "TestClass",
                        operatorId = arrayListOf("OperatorId"),
                        startHoldTime = arrayListOf("StartHoldTime"),
                        startXOperationId = arrayListOf("Start X-Operation-Id"),
                        endHoldTime = "EndHoldTime",
                        endXOperationId = "End X-Operation-Id"
                    )
                )
            )
            flag = false
        }
        threadOperatorsCSVObject.get().testClass = context!!.testClass.toString()
    }
}