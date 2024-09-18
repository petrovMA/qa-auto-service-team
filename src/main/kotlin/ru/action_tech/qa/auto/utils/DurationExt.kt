package ru.action_tech.qa.auto.utils

import com.codeborne.selenide.Condition
import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.shouldHave
import ru.action_tech.qa.auto.core.utils.waiting.Wait
import java.time.Duration

fun Int.ms(): Duration = Duration.ofMillis(this.toLong())
fun Int.s(): Duration = Duration.ofSeconds(this.toLong())
fun Int.m(): Duration = Duration.ofMinutes(this.toLong())
fun Int.h(): Duration = Duration.ofHours(this.toLong())
fun Int.d(): Duration = Duration.ofDays(this.toLong())

fun Long.ms(): Duration = Duration.ofMillis(this)
fun Long.s(): Duration = Duration.ofSeconds(this)
fun Long.m(): Duration = Duration.ofMinutes(this)
fun Long.h(): Duration = Duration.ofHours(this)
fun Long.d(): Duration = Duration.ofDays(this)

fun <T> wait(
    timeoutDuration: Duration? = null,
    pollingIntervalDuration: Duration? = null,
    iterations: Int = -1,
    suppressException: Boolean = false,
    handleException: Throwable.() -> Unit = {},
    startTimeInMs: Long = System.currentTimeMillis(),
    script: () -> T
): T = Wait.until(
    timeoutInMs = timeoutDuration?.toMillis() ?: -1,
    pollingIntervalInMs = pollingIntervalDuration?.toMillis() ?: 100,
    iterations = iterations,
    suppressException = suppressException,
    handleException = handleException,
    startTimeInMs = startTimeInMs,
    script = script
)

fun untilTrue(
    timeoutDuration: Duration? = null,
    pollingIntervalDuration: Duration? = null,
    iterations: Int = -1,
    suppressException: Boolean = false,
    handleException: Throwable.() -> Unit = {},
    startTimeInMs: Long = System.currentTimeMillis(),
    script: () -> Boolean
): Boolean = Wait.untilTrue(
    timeoutInMs = timeoutDuration?.toMillis() ?: -1,
    pollingIntervalInMs = pollingIntervalDuration?.toMillis() ?: 100,
    iterations = iterations,
    suppressException = suppressException,
    handleException = handleException,
    startTimeInMs = startTimeInMs,
    script = script
)

fun <T> untilNotNull(
    timeoutDuration: Duration? = null,
    pollingIntervalDuration: Duration? = null,
    iterations: Int = -1,
    suppressException: Boolean = false,
    handleException: Throwable.() -> Unit = {},
    startTimeInMs: Long = System.currentTimeMillis(),
    script: () -> T?
): T {
    var result: T? = null
    untilTrue(
        timeoutDuration = timeoutDuration,
        pollingIntervalDuration = pollingIntervalDuration,
        iterations = iterations,
        suppressException = suppressException,
        handleException = handleException,
        startTimeInMs = startTimeInMs,
        script = {
            result = script()
            result != null
        }
    )

    return result!!
}

fun <T> untilNotEqualsValues(
    timeoutDuration: Duration? = null,
    pollingIntervalDuration: Duration? = null,
    iterations: Int = -1,
    suppressException: Boolean = false,
    handleException: Throwable.() -> Unit = {},
    startTimeInMs: Long = System.currentTimeMillis(),
    values: Set<T?>,
    script: () -> T?,
): T {
    var result: T? = null

    untilTrue(
        timeoutDuration = timeoutDuration,
        pollingIntervalDuration = pollingIntervalDuration,
        iterations = iterations,
        suppressException = suppressException,
        handleException = handleException,
        startTimeInMs = startTimeInMs,
        script = {
            result = script()
            !values.contains(result)
        }
    )

    return result!!
}

fun Element.waitIsDisplayed(timeoutDuration: Duration, pollingIntervalDuration: Duration) =
    this.waitIsDisplayed(timeoutDuration.toMillis(), pollingIntervalDuration.toMillis())

fun <T : Element> T.waitUntil(condition: Condition, timeoutDuration: Duration): T =
    shouldHave(condition, timeoutDuration.toMillis())