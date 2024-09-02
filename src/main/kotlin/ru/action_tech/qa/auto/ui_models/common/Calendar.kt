package ru.action_tech.qa.auto.ui_models.common

import com.codeborne.selenide.Condition.*
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.selenide.elements.annotations.CanBeNotVisible
import ru.action_tech.qa.auto.core.utils.DateTimeUtils.TOMORROW
import ru.action_tech.qa.auto.core.utils.monthName
import java.time.LocalDate


val newCalendar by NewCalendar()
val oldCalendar by OldCalendar()
val calendarFrom by CalendarFrom()
val calendarTo by CalendarTo()

class NewCalendar(private val calendarWrapper: Element = css("[data-test=a-calendar-wrapper]")) :
    Element by calendarWrapper {
    val dayItem get() = DayItem
    val calendarPopover by css("[data-test=a-calendar-popover-text]")
    private val calendarTitle by css("[data-test=a-calendar-title]")
    private val yearAndMonthTitle by css(".vc-nav-title")
    private val yearLeftArrow by css(".vc-nav-arrow.is-left")
    private val yearRightArrow by css(".vc-nav-arrow.is-right")
    private val yearItem get() = YearItem
    private val monthItem get() = MonthItem

    private class YearItem(val year: Int) : Element by css(".vc-nav-items [data-id='$year']") {
        companion object {
            operator fun get(year: Int) = YearItem(year = year)
        }
    }

    private class MonthItem(val year: Int, val month: Int) :
        Element by css(".vc-nav-items [data-id='$year.${month.toString().padStart(2, '0')}']") {
        companion object {
            operator fun get(year: Int, month: Int) = MonthItem(year = year, month = month)
        }
    }

    class DayItem(val day: Int) : Element by css(".vc-day.in-month.day-$day .vc-day-content") {
        companion object {
            operator fun get(day: Int) = DayItem(day = day)
        }
    }

    fun selectDate(date: LocalDate) {
        selectDateWithoutClosing(date = date)

        "Проверяем, что календарь закрыт" {
            calendarWrapper.should(disappear)
        }
    }

    fun selectDateWithoutClosing(date: LocalDate) {
        selectYearAndMonth(year = date.year, month = date.monthValue)

        "Проверяем, что день ${date.dayOfMonth} доступен для выбора" {
            dayItem[date.dayOfMonth].should(appear, not(have(cssClass("vc-disabled"))))
        }

        "Выбираем день ${date.dayOfMonth}" {
            dayItem[date.dayOfMonth].click
        }
    }

    /**
     * Выбор завтрашнего дня в календаре по сокращённому пути по сравнению с [selectDate], т. е. без выбора года и месяца.
     * Для случая, когда после выбора дня календарь закрывается (в этом отличие от [selectTomorrowWithoutClosing]).
     */
    fun selectTomorrow() {
        selectTomorrowWithoutClosing()

        "Проверяем, что календарь закрыт" {
            calendarWrapper.should(disappear)
        }
    }

    /**
     * Выбор завтрашнего дня в календаре по сокращённому пути по сравнению с [selectDate], т. е. без выбора года и месяца.
     * Для случая, когда после выбора дня календарь не закрывается (в этом отличие от [selectTomorrow]).
     */
    fun selectTomorrowWithoutClosing() {
        "Проверяем, что календарь открыт" {
            calendarWrapper.should(appear)
        }

        "Проверяем, что день ${TOMORROW.dayOfMonth} доступен для выбора" {
            dayItem[TOMORROW.dayOfMonth].should(appear, not(have(cssClass("vc-disabled"))))
        }

        "Выбираем день ${TOMORROW.dayOfMonth}" {
            dayItem[TOMORROW.dayOfMonth].click
        }
    }

    /**
     * Выбора года и месяца в календаре. После выполнения календарь остаётся открытым.
     * Удобно, например, для дальнейшей валидации доступных и недоступных для выбора дней, включая проверку всплывающего сообщения.
     */
    fun selectYearAndMonth(date: LocalDate) {
        selectYearAndMonth(year = date.year, month = date.monthValue)
    }

    /**
     * Выбора года и месяца в календаре. После выполнения календарь остаётся открытым.
     * Удобно, например, для дальнейшей валидации доступных и недоступных для выбора дней, включая проверку всплывающего сообщения.
     */
    fun selectYearAndMonth(year: Int, month: Int) {
        "Проверяем, что календарь открыт" {
            calendarWrapper.should(appear)
        }

        "Открываем окно выбора месяца и года" {
            calendarTitle.click
        }

        "Проверяем, что окно выбора месяца и года открыто" {
            yearAndMonthTitle.should(appear)
        }

        "Переключаемся на выбор года" {
            yearAndMonthTitle.click
        }

        var (left, right) = "Проверяем, что выводится диапазон значений для выбора года" {
            yearAndMonthTitle.should(matchText("\\d{4} - \\d{4}"))
            Regex("(\\d{4}) - (\\d{4})").find(yearAndMonthTitle.text)?.destructured?.toList()?.map { it.toInt() }
                ?: listOf(year, year)
        }

        "Перелистываем влево страницу с выбором года, пока не дойдём до $year-го года" {
            while (year < left) {
                left -= 12
                right -= 12

                "Проверяем, что кнопка переключения на диапазон лет $left—$right активна" {
                    yearLeftArrow.shouldBe(enabled)
                }

                "Переключаемся на диапазон лет $left—$right" {
                    yearLeftArrow.click
                }

                "Проверяем, что текущий диапазон лет $left—$right" {
                    yearAndMonthTitle.should(text("$left - $right"))
                }
            }
        }

        "Перелистываем вправо страницу с выбором года, пока не дойдём до $year-го года" {
            while (year > right) {
                left += 12
                right += 12

                "Проверяем, что кнопка переключения на диапазон лет $left—$right активна" {
                    yearRightArrow.shouldBe(enabled)
                }

                "Переключаемся на диапазон лет $left—$right" {
                    yearRightArrow.click
                }

                "Проверяем, что текущий диапазон лет $left—$right" {
                    yearAndMonthTitle.should(text("$left - $right"))
                }
            }
        }

        "Проверяем, что год $year доступен для выбора" {
            yearItem[year].shouldBe(visible, enabled)
        }

        "Выбираем год $year" {
            yearItem[year].click
        }

        "Проверяем, что год $year выбран" {
            yearItem[year].should(disappear)
            yearAndMonthTitle.shouldHave(text(year.toString()))
        }

        "Проверяем, что месяц $month доступен для выбора" {
            monthItem[year, month].shouldBe(visible, enabled)
        }

        "Выбираем месяц $month или закрываем окно выбора месяца, если месяц $month уже выбран" {
            // TODO Убрать ветвление, если будет доработан календарь, чтобы по клику на активный месяц окошко выбора месяца закрывалось.
            (if (monthItem[year, month].has(cssClass("is-active"))) calendarTitle else monthItem[year, month]).click
        }

        "Проверяем, что месяц $month выбран" {
            monthItem[year, month].should(disappear)
        }
    }
}

class OldCalendar :
    Element by xpath("//*[contains(@class,'aui-row dropable') or contains(@class,'datetime-picker') or @class='aui-calendar__picker__main']") {
    private val availableDayButtons by xpath("//*[contains(@class,'aui-calendar__picker__content__day') and not (contains(@class,'disabled') or contains(@class,'anothermonth'))]")
    private val nextMonthButton by xpath("//*[contains(@class, 'icon-arrow-right')]")

    fun chooseDay(date: LocalDate) {
        val day = date.dayOfMonth.toString()
        if (availableDayButtons[day].count < 1 || day == "1") {
            nextMonthButton.click
        }
        availableDayButtons.all.first { it.text == day }.click
    }
}

class CalendarFrom : PeriodCalendar(), Element by xpath("//*[contains(@class,'aui-calendar aui-mr-sm')]")
class CalendarTo : PeriodCalendar(), Element by xpath("//*[@class='aui-calendar']")

abstract class PeriodCalendar : Element {
    private val monthYearBlock by MonthYearBlock()
    private val dayButtons by css(".aui-calendar__picker__content__day:not(.anothermonth)")

    @CanBeNotVisible
    val listOfMonthsOrYearsNew by xpath("//*[@class='aui-dropdown__menu__item' or @class='aui-dropdown__menu__item is-active']")

    fun chooseDate(date: LocalDate) {
        monthYearBlock.year.click
        listOfMonthsOrYearsNew[date.year.toString()].click
        monthYearBlock.month.click
        listOfMonthsOrYearsNew[date.monthName()].click
        val day = date.dayOfMonth.toString()
        dayButtons.all.first { it.text == day }.click
    }

    class MonthYearBlock :
        Element by xpath("//*[(@class='aui-calendar__picker__head' or contains(@class, 'month-name ui header'))]") {
        val month by xpath("//*[contains(@class,'month')] | (//*[@class='month-name ui header']//span)[1]")
        val year by xpath("//*[contains(@class,'year')] | (//*[@class='month-name ui header']//span)[2]")
    }
}
