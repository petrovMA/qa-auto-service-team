package ru.action_tech.qa.auto.utils

import ru.action_tech.qa.auto.core.utils.DateTimeUtils
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.time.*
import java.time.temporal.TemporalAdjusters
import java.util.*

fun getLastWorkingDay(month: YearMonth = YearMonth.now()): LocalDate {
    val weekends = listOf(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)
    val holidays = listOf(MonthDay.of(Month.DECEMBER, 31))
    var date = month.atEndOfMonth()

    while (date.dayOfMonth > 0) {
        if (date.dayOfWeek !in weekends && MonthDay.from(date) !in holidays) {
            return date
        } else {
            date = date.minusDays(1)
        }
    }

    throw IllegalStateException("Ошибка при определении последнего рабочего дня в месяце")
}

/**
 * Скорее всего, метод не нужен с учётом нового календаря, достаточно методов в стандартной библиотеке Java.
 */
fun getDateWithShortMonth(
    date: String,
    patternTo: String = "dd MMM yyyy",
    patternFrom: String = "yyyy-MM-dd",
    withDot: Boolean = false,
    isParental: Boolean = false,
): String {
    val dateFormat = SimpleDateFormat(patternFrom).parse(date)
    return if (!withDot) {
        val format = SimpleDateFormat(
            patternTo,
            deleteDotToAbbreviationMonths(DateFormatSymbols(Locale("ru")), isParental)
        )

        format.format(dateFormat)
    } else SimpleDateFormat(patternTo, Locale("ru")).format(dateFormat)
}

fun dateOfFirstDayOfMonth(): LocalDate {
    val cal = Calendar.getInstance()
    cal.set(Calendar.DAY_OF_MONTH, 1)
    val now = DateTimeUtils.TODAY
    return LocalDate.of(now.year, now.month, 1)
}

fun dateOfLastDayOfMonth(): String {
    return TemporalAdjusters.lastDayOfMonth()
        .adjustInto(LocalDate.now()).toString()
}

fun isLastWorkingDay(day: LocalDate): Boolean {
    val nextDay = day.plusDays(1)
    val next2Days = day.plusDays(2)
    return nextDay.toString() == dateOfLastDayOfMonth() && nextDay.dayOfWeek.value in 6..7 ||
            next2Days.toString() == dateOfLastDayOfMonth() && next2Days.dayOfWeek.value == 7 ||
            dateOfLastDayOfMonth() == day.toString()
}

/**
 * Скорее всего, метод не нужен с учётом нового календаря, в т. ч. замена "мая -> май" не нужна.
 */
fun deleteDotToAbbreviationMonths(
    dateFormatSymbols: DateFormatSymbols,
    isParental: Boolean = false,
): DateFormatSymbols {
    val shortMonths = dateFormatSymbols.shortMonths
    for (i in shortMonths.indices) {
        shortMonths[i] = when {
            shortMonths[i].lowercase() == "мая" ->
                if (isParental) {
                    shortMonths[i].replace("я", "й")
                } else {
                    shortMonths[i]
                }

            else -> shortMonths[i].replace(".", "")
        }

        shortMonths[i] = when {
            shortMonths[i].length > 3 -> shortMonths[i].replace(".$".toRegex(), "")
            else -> shortMonths[i]
        }
    }
    dateFormatSymbols.shortMonths = shortMonths

    return dateFormatSymbols
}
