package ru.action_tech.qa.auto.utils.after_each_if_env_prod

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.properties.ENV

class AfterEachIfEnvProdExtension : AfterEachCallback {
    override fun afterEach(context: ExtensionContext) {
        val testInstance = context.requiredTestInstance
        val methods = testInstance::class.java.methods

        methods.forEach { method ->
            val annotation = method.getAnnotation(AfterEachIfEnvProd::class.java)
            if (annotation != null) {
                if (ENV == "prod") {
                    "Выполнение постусловий для PROD" { method.invoke(testInstance) }
                } else {
                    "ENV = $ENV, Постусловия выполняются только для ENV = prod" {}
                }
            }
        }
    }
}