package ru.action_tech.qa.auto.ui_models.admin360.create_task

import ru.action_tech.qa.auto.core.selenide.elements.Element
import ru.action_tech.qa.auto.core.selenide.elements.xpath

class ApplicationsForModerationTableRow : Element by xpath("//*[@data-test='aui-table-row']") {
    val createDateText by xpath("(//*[@data-test='aui-table-cell'])[1]")
    val partnerText by xpath("(//*[@data-test='aui-table-cell'])[2]")
    val authorText by xpath("(//*[@data-test='aui-table-cell'])[3]")
    val organizationText by xpath("(//*[@data-test='aui-table-cell'])[4]")
    val innText by xpath("(//*[@data-test='aui-table-cell'])[5]")
}