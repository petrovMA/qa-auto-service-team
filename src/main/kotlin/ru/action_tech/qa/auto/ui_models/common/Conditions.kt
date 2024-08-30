package ru.action_tech.qa.auto.ui_models.common

import com.codeborne.selenide.CheckResult
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.attributeMatching
import com.codeborne.selenide.Driver
import org.openqa.selenium.WebElement
import java.time.LocalTime
import java.util.function.BiPredicate

fun timeAfter(time: LocalTime) =
    TimeCondition(time, "time after $time") { actual, expected -> actual.isAfter(expected) }

fun timeBefore(time: LocalTime) =
    TimeCondition(time, "time before $time") { actual, expected -> actual.isBefore(expected) }

fun timeEquals(time: LocalTime) = TimeCondition(time, "time = $time") { actual, expected -> actual == expected }

class TimeCondition(
    val time: LocalTime,
    message: String,
    private val biPredicate: BiPredicate<LocalTime, LocalTime>,
) : Condition(message) {

    override fun check(driver: Driver, element: WebElement) = CheckResult(
        biPredicate.test(LocalTime.parse("00:" + element.text.trim()), time), "time=${element.text.trim()}"
    )
}

fun classMatching(regex: String) = attributeMatching("class", regex)
fun valueMatching(regex: String) = attributeMatching("value", regex)
