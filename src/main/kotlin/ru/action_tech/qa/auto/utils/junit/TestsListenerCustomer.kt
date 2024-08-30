package ru.action_tech.qa.auto.utils.junit

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import ru.action_tech.qa.auto.api_models.customer.CustomersRequests.customersUnholdByIds
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customer_hold.CustomerHoldResponse
import ru.action_tech.qa.auto.api_models.customer.qa.customers.customers_unhold_by_ids.CustomersUnholdByIdsRequest
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.logging.LogUtils.logListenerEventIfError
import ru.action_tech.qa.auto.core.properties.TEMP_PATH
import ru.action_tech.qa.auto.core.utils.createAndAppend
import ru.action_tech.qa.auto.utils.COLLECT_DATA_FOR_CUSTOMER_CSV
import ru.action_tech.qa.auto.utils.customerServiceArmSellerClient
import ru.action_tech.qa.auto.utils.http.Headers.DATE
import ru.action_tech.qa.auto.utils.http.Headers.X_OPERATION_ID
import java.nio.file.Paths

internal val threadLocalCustomer by lazy { ThreadLocal.withInitial { mutableSetOf<CustomerHoldResponse>() } }
internal val threadCustomersCSVObject by lazy { ThreadLocal.withInitial { CustomerCSVObject() } }

@Volatile
var indicator = true

class CustomerCSVObject(
    var testClass: String = "",
    var customerId: ArrayList<String> = arrayListOf(),
    var startHoldTime: ArrayList<String> = arrayListOf(),
    var startXOperationId: ArrayList<String> = arrayListOf(),
    var endHoldTime: String = "",
    var endXOperationId: String = ""
)

class TestsListenerCustomer : AfterEachCallback, BeforeEachCallback {

    override fun afterEach(context: ExtensionContext) {
        "Post test fixture" {
            threadLocalCustomer.takeUnless { it.get().isEmpty() }?.apply {
                unHoldCustomers()
            }
            "Logging to file" {
                Paths.get(TEMP_PATH.toString(), "artifacts", "customers.csv").toFile()
                    .createAndAppend(prepareStringForCustomerCSV(threadCustomersCSVObject.get()))
            }
        }
    }

    private fun prepareStringForCustomerCSV(csvObject: CustomerCSVObject) = StringBuilder().apply {
        csvObject.customerId.forEachIndexed { index, _ ->
            append("${csvObject.testClass};")
            append("${csvObject.customerId[index]};")
            append("${csvObject.startHoldTime[index]};")
            append("${csvObject.startXOperationId[index]};")
            append("${csvObject.endHoldTime};")
            append("${csvObject.endXOperationId};")
            append("\n")
        }

    }.toString()

    private fun unHoldCustomers() {
        logListenerEventIfError("[JUNIT][AFTER EACH] UnHold Customers") {
            customerServiceArmSellerClient.send(
                customersUnholdByIds(
                    CustomersUnholdByIdsRequest(
                        ids = threadLocalCustomer.get().map { it.id.toString() })
                )
            )
                .let {
                    if (COLLECT_DATA_FOR_CUSTOMER_CSV) {
                        threadCustomersCSVObject.get().endXOperationId = it.headers[X_OPERATION_ID].value
                        threadCustomersCSVObject.get().endHoldTime = it.headers[DATE].value
                    }
                }
        }
    }

    override fun beforeEach(context: ExtensionContext) {
        threadLocalCustomer.get().clear()
        threadCustomersCSVObject.set(CustomerCSVObject())
        if (COLLECT_DATA_FOR_CUSTOMER_CSV && indicator) {
            Paths.get(TEMP_PATH.toString(), "artifacts", "customers.csv").toFile().createAndAppend(
                prepareStringForCustomerCSV(
                    CustomerCSVObject(
                        testClass = "TestClass",
                        customerId = arrayListOf("CustomerId"),
                        startHoldTime = arrayListOf("StartHoldTime"),
                        startXOperationId = arrayListOf("Start X-Operation-Id"),
                        endHoldTime = "EndHoldTime",
                        endXOperationId = "End X-Operation-Id"
                    )
                )
            )
            indicator = false
        }
        threadCustomersCSVObject.get().testClass = context.testClass.toString()
    }
}