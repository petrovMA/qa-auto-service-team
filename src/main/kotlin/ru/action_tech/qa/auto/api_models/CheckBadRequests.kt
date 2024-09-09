package ru.action_tech.qa.auto.api_models

import io.qameta.allure.Step
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import ru.action_tech.qa.auto.core.api.ApiClient
import ru.action_tech.qa.auto.core.api.Request
import ru.action_tech.qa.auto.core.assertions.assertEqual
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.serialization.facade.Serializable
import ru.action_tech.qa.auto.utils.deserialize
import java.net.HttpURLConnection


object CheckBadRequests {

    internal fun checkNoContent(apiClient: ApiClient, request: Request) {
        apiClient.send(
            request.apply {
                verify = { statusCode(HttpURLConnection.HTTP_NO_CONTENT) }
            }
        ).apply {
            "check statusCode".assertEqual(statusCode, HttpURLConnection.HTTP_NO_CONTENT)
            "check statusLine".assertTrue(statusLine.contains("No Content"))
        }
    }

    internal fun checkUnauthorized(apiClient: ApiClient, request: Request) {
        apiClient.send(
            request.apply {
                verify = { statusCode(HttpURLConnection.HTTP_UNAUTHORIZED) }
            }
        ).apply {
            "check statusCode".assertEqual(statusCode, HttpURLConnection.HTTP_UNAUTHORIZED)
            "check statusLine".assertTrue(statusLine.contains("Unauthorized"))
        }
    }

    internal fun checkForbidden(apiClient: ApiClient, request: Request) {
        apiClient.send(
            request.apply {
                verify = { statusCode(HttpURLConnection.HTTP_FORBIDDEN) }
            }
        ).apply {
            "check statusCode".assertEqual(statusCode, HttpURLConnection.HTTP_FORBIDDEN)
            "check statusLine".assertTrue(statusLine.contains("Forbidden"))
        }
    }

    internal fun checkNotFound(apiClient: ApiClient, request: Request) {
        apiClient.send(
            request.apply {
                verify = { statusCode(HttpURLConnection.HTTP_NOT_FOUND) }
            }
        ).apply {
            "check statusCode".assertEqual(statusCode, HttpURLConnection.HTTP_NOT_FOUND)
            "check statusLine".assertTrue(statusLine.contains("Not Found"))
        }
    }

    internal fun checkBR(
        apiClient: ApiClient,
        request: Request,
        expected: BrokenRuleWithoutCode,
        jsonCompareMode: JSONCompareMode = JSONCompareMode.STRICT,
        statusCode: Int = HttpURLConnection.HTTP_BAD_REQUEST,
        assertion: (expected: BrokenRuleWithoutCode, actual: String, compareMode: JSONCompareMode) -> Unit =
            { exp, act, jsonCompare -> JSONAssert.assertEquals(exp.toString(), act, jsonCompare) }
    ) {
        "Проверить код и сообщение об ошибке в ответе" {
            apiClient.send(
                request.apply {
                    verify = { statusCode(statusCode) }
                }
            ).asString().apply { assertion(expected, this, jsonCompareMode) }
        }
    }

    internal fun checkBR(
        apiClient: ApiClient,
        request: Request,
        expected: BrokenRuleWithDevMessage,
        jsonCompareMode: JSONCompareMode = JSONCompareMode.STRICT
    ) {
        "Проверить код и сообщение об ошибке в ответе" {
            apiClient.send(
                request.apply {
                    verify = { statusCode(HttpURLConnection.HTTP_BAD_REQUEST) }
                }
            ).asString().apply {
                JSONAssert.assertEquals(expected.toString(), this, jsonCompareMode)
            }
        }
    }

    internal fun checkBR(apiClient: ApiClient, request: Request, expected: Set<BrokenRule>) {
        "Проверить массив кодов и сообщений об ошибке в ответе" {
            val deserializedResponse = apiClient.send(
                request.apply {
                    verify = { statusCode(HttpURLConnection.HTTP_BAD_REQUEST) }
                }
            ).deserialize<Array<BrokenRule>>()

            var isFindErrorInfo = true
            for (errorInfo in deserializedResponse) {
                var isFindBR = false
                for (br in expected) {
                    if (errorInfo.code == br.code && errorInfo.message == br.message) {
                        isFindBR = true
                    }
                }
                if (!isFindBR) {
                    isFindErrorInfo = false
                    break
                }
            }
            assertTrue(isFindErrorInfo)
        }
    }

    internal fun checkBRTech(apiClient: ApiClient, request: Request, expected: Set<BrokenRuleTechnical>) {
        "Проверить массив кодов и сообщений об ошибке в ответе" {
            val deserializedResponse = apiClient.send(
                request.apply {
                    verify = { statusCode(HttpURLConnection.HTTP_BAD_REQUEST) }
                }
            ).deserialize<Array<BrokenRule>>()

            var isFindErrorInfo = true
            for (errorInfo in deserializedResponse) {
                var isFindBR = false
                for (br in expected) {
                    if (errorInfo.message.contains(br.message1) &&
                        errorInfo.message.contains(br.message2) &&
                        errorInfo.code == br.code
                    ) {
                        isFindBR = true
                    }
                }
                if (!isFindBR) {
                    isFindErrorInfo = false
                    break
                }
            }
            assertTrue(isFindErrorInfo)
        }
    }

    fun brokenRuleNotValid(value: Any = "", code: Int = 0) = BrokenRule(code, "The value '$value' is not valid.")

    fun brokenRuleInvalid(value: Any = "", code: Int = 0) = BrokenRule(code, "The value '$value' is invalid.")

    fun brWrongJsonFormat(char: String = "", path: String = "", line: String = "", position: String = ""): BrokenRule {
        return BrokenRule(
            code = 0,
            message = "Invalid property identifier character: $char. Path '$path', line $line, position $position."
        )
    }

    @Step("Проверить ответ 'Unauthorized'")
    internal fun testBRUnauthorized(
        apiClient: ApiClient,
        request: Request
    ) {
        apiClient.send(
            request.apply {
                verify = { statusCode(HttpURLConnection.HTTP_UNAUTHORIZED) }
            }
        ).apply {
            assertEqual(statusCode, 401)
            assertTrue(statusLine.contains("Unauthorized"))
        }
    }

    internal fun checkBRUnauthorizedList(apiClient: ApiClient, tests: Map<String, Request>) =
        tests.forEach { (testName, request) ->
            testName { testBRUnauthorized(apiClient, request) }
        }

    data class BrokenRule(val code: Int = 0, val message: String) : Serializable {
        override fun toString(): String = serialize.strict.toJson()
    }

    data class BrokenRuleWithDevMessage(
        val code: Int = 0,
        val developerMessage: Any? = null,
        val messages: List<String>
    ) : Serializable {
        override fun toString(): String = serialize.strict.toJson()
    }

    data class BrokenRuleWithoutCode(val message: String) : Serializable {
        override fun toString(): String = serialize.strict.toJson()
    }

    data class BrokenRuleTechnical(
        val code: Int = 0,
        val message1: String,
        val message2: String
    ) : Serializable {
        override fun toString(): String = serialize.strict.toJson()
    }
}