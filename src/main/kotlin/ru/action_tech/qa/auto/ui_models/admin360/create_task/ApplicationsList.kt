package ru.action_tech.qa.auto.ui_models.admin360.create_task

import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.getValue
import ru.action_tech.qa.auto.core.selenide.elements.xpath


class ApplicationsList : Element by xpath("(//*[contains(@class,'action-admin360-mytasks')])[1]") {
    val calendarDateInput by xpath("(//*[contains(@class,'aui-calendar-range-wrapper')])[1]")
    val searchInput by xpath("//input[contains(@placeholder, 'Поиск по')]")
    val searchButton by xpath("//button[contains(text(), 'Поиск')]")
    val applicationsTable get() = ApplicationsTable

    fun applicationsTable(tableName: String) = ApplicationsTable(tableName)

    class ApplicationsTable(name: String) :
        Element by xpath("//*[contains(text(), '$name')]/..//*[@data-test='aui-table']") {
        val header by xpath("//*[contains(@class,'aui-table__header')]")
        val applicationTableRow by ApplicationsForModerationTableRow()

        companion object {
            operator fun get(tableName: String) = ApplicationsTable(tableName)
        }
    }
}