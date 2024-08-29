package ru.action_tech.qa.auto.ui_models.erm.client_card_tabs

import com.codeborne.selenide.Selectors.byText
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.selenide.elements.annotations.CanBeNotVisible
import ru.action_tech.qa.auto.core.selenide.elements.annotations.WithoutContext
import ru.action_tech.qa.auto.core.uikit.button
import ru.action_tech.qa.auto.ui_models.common.DropdownWithXpathNew
import ru.action_tech.qa.auto.ui_models.common.activeDropdown
import ru.action_tech.qa.auto.ui_models.common.dropdownWithTitleNew

class OrderTab : Element by xpath("//*[@data-test='orders-cc']") {
    val header by OrderHeader()

    @CanBeNotVisible(scroll = true)
    val cell by OrderCell()
    val sellStatus by xpath("//div[@class='four wide column']")
    val sellInfo by xpath("//div[@class='q-mt-sm']")
    val clientInfo by xpath("//h3[.='Клиент']/following-sibling::*")

    @CanBeNotVisible(scroll = true)
    val currentOrder by CurrentOrder()
    val clientOrdersButton by xpath("//*[@data-test='mainBtn']")
    val intersectionButton by xpath("//*[@data-test='relatedBtn']")
    val ordersFilter by xpath("//*[@class='aui-dropdown__field__value']/..")
    val lockIcon by xpath("//*[contains(@class,'icon-lock')]")
    val nextButton by xpath("//*[contains(text(),'Следующая')]")
    val actionsDropdown by css("[data-test=actions] [data-test=aui-dropdown]")
    val actionItem by css("[data-test=aui-dropdown-item]")
    val okButton by css("[data-test=changeDocDatePopup] .aui-confirm__footer__button:first-of-type")
    val cancelButton by css("[data-test=changeDocDatePopup] .aui-confirm__footer__button:last-of-type")
    val participantInfo by xpath("//div[@data-test='erm-order-main']//div[@class='a-flex']/span")

    class OrderHeader : Element by xpath("//thead//*[@data-test='aui-table-row']") {
        val orderNumberFilter by DropdownWithXpathNew(xpath = "//*[contains(text(),'№')]/..//following-sibling::*[@data-test='aui-table-header-filter']//i")
    }

    fun selectFilter(filterName: String) {
        dropdownWithTitleNew["//*[@data-test='orders-cc']//*[@class='aui-dropdown__field__value']/.."] select filterName
    }

    fun workWithOrderChoose(action: String) {
        "Открываем список действий по заказу" {
            actionsDropdown.click
        }
        "Проверяем, что список открыт" {
            actionsDropdown.shouldBe(activeDropdown)
        }
        "Выбираем в списке действие '$text'" {
            actionsDropdown.find(byText(action)).click
        }
    }
}

class OrderCell : Element by xpath("//tbody/*[@data-test='aui-table-row']") {
    val orderNumber by xpath("//div")
}

class CurrentOrder : Element by xpath("//*[@data-test='erm-order-main']") {
    val orderName by css("[data-test=orderName]")
    val orderId by css("[data-test=orderNumber]")
    val redLockIcon by xpath("//*[@class='red lock alternate icon']")
    val paymentStatus by xpath("//*[@data-test='orderStatus']")
    val dropDownWithActions by xpath("//*[contains(text(),'Работа с заказом')]")
    val openCallButton by xpath("//*[contains(text(),'Открыть разговор')]")
    val documentsLink by xpath("//div[@data-test='documentsLink']/div[contains(text(),'Документы')]")
    val productsTitle by xpath("//*[@data-test='orderProducts']//*[@data-test='aui-h3']")
    val paymentType by xpath("//*[@data-test='paymentType']")
    val action by xpath("//*[@data-test='aui-dropdown-item']")
    val orderStatus by xpath("//*[@data-test='orderStatus']")
    val unavailableMsg by xpath("//*[@data-test='unavailableMsg']")
    val registerUkdButton by xpath("//span[contains(text(), 'Зарегистрировать УКД')]/..")

    val orderWorkDropdown by xpath("//*[@data-test='aui-dropdown']")
    val workWithOrderOptionsList by xpath("//*[@class='aui-dropdown__menu__item']")
    val unlockedIcon by xpath("//*[contains(@class,'unlock')]")
    val lockedIcon by xpath("//*[contains(@class,'icon-lock')]")
    val checkBox by xpath("//*[@data-test='isRealize']")

    // Документы
    val clientForClosingDocument get() = dropdownWithTitleNew["//*[@data-test='relatedContacts']"]
    val downloadButton by xpath("//*[@data-test='downloadBtn']")
    val printLabelButton by xpath("//button[contains(text(),'Напечатать этикетку')]")
    val sendToAgreement by button["Согласовать"]
    val titleUploadedDocuments by xpath("//*[contains(text(),'Загруженные файлы')]")
    val uploadedDocuments by UploadedDocuments()
    val titleDeletedDocuments by xpath("//*[contains(text(),'Удаленные файлы')]")
    val deletedDocuments by DeletedDocuments()
    val templatesBlock by TemplatesBlock()
    val titleClosingDocuments by xpath("//*[contains(text(),'Закрывающие документы')]")
    val closingDocuments by ClosingDocuments()
    val ukdParticipants by UkdParticipants()

    @CanBeNotVisible
    val clientsTitle by xpath("//*[@data-test='infoBlock']//*[@data-test='aui-h3']")
    val orderProductItem by OrderProductItem()

    @CanBeNotVisible
    val moneyInfoBlock by MoneyInfoBlock()

    @CanBeNotVisible
    val infoBlock by InfoBlock()

    @CanBeNotVisible
    val field
        get() = Field

    @CanBeNotVisible
    @WithoutContext
    val payments by xpath("//*[@class='caption' and contains(.,'Продажа')]//following-sibling::div")
    val closeButton by xpath("//*[contains(@class, 'icon-cross-bold')]")
    val salesProcedure by SalesProcedure()

    class Field(title: String) :
    //        Element by xpath("//*[contains(@class,'caption') and contains(.,)]//following-sibling::div[1]") {
        Element by xpath("//span[contains(text(),'$title')]/../*[2]") {

        companion object {
            operator fun get(name: String) = Field(name)
        }
    }

    class UkdParticipants : Element by xpath("//*[@data-test='aui-table']//table") {
        val header by xpath("//thead/tr[@data-test='aui-table-row']")
        val row by Row()

        class Row : Element by xpath("//tbody/tr[@data-test='aui-table-row']") {
            val cell by xpath("//td[@data-test='aui-table-cell']")
        }
    }
}

class OrderProductItem : Element by xpath("//tbody/tr[@data-test='aui-table-row']") {
    val cell by xpath("//td[@data-test='aui-table-cell']")
    val unlockedIcon by xpath("//*[contains(@class,'unlock')]")
    val lockedIcon by xpath("//*[contains(@class,'icon-lock')]")
    val turn by xpath("//*[contains(text(),'Свернуть')]")
    val deleteButton by xpath("//*[contains(text(),'Удалить')]")
    val openUkdButton by xpath("//*[contains(text(),'Открыть УКД')]")

    @CanBeNotVisible(alignToTop = false)
    val ukdValue = dropdownWithTitleNew["//div[text()='Пользователь УКД']/../div[@data-test='aui-dropdown']"]
}

class MoneyInfoBlock : Element by xpath("//*[@data-test='orderSummary']") {
    val moneyBlock by xpath("//*[contains(text(),'Начислено')]/..")
    val bonusesSpent by xpath("//*[contains(text(),'Потрачено')]")
    val economy by xpath("//*[contains(text(),'Экономия')]/following-sibling::div")
    val leftToPay by xpath("//*[@data-test='leftToPay']")
    val sum by xpath("//*[@data-test='sum']")
    val realSum by xpath("//*[@data-test='realSum']")
    val saving by xpath("//*[@data-test='saving']")
    val promocode by xpath("//*[@data-test='certificate']//*[@data-test='clipboard']")
    val paymentType by xpath("//*[@data-test='paymentType']")
    val paymentStatus by xpath("//*[@data-test='paymentStatus']")
    val paymentStatusName by xpath("//*[@data-test='paymentStatus']//preceding-sibling::*[contains(@class, 'aui-text')]")
    val installmentDiscountPercent by xpath("//*[@data-test='createKP']")
    val installmentDiscountPercentName by xpath("//*[@data-test='installmentDiscountPercent']//preceding-sibling::*[contains(@class, 'label')]")
}

class SalesProcedure : Element by xpath("//*[@data-test='aui-accordion']") {
    val title by xpath("//*[contains(text(),'Процедуры продаж')]")
    val formKP by xpath("//*[@data-test='createKP']")
    val formTZ by xpath("//*[@data-test='createTZ']")
    val withPrint by xpath("//*[contains(text(),'С печатью')]")
    val withDateAndNumber by xpath("//*[contains(text(),'С номером и датой')]")
}

class UploadedDocuments : Element by xpath("//*[contains(text(),'Загруженные файлы')]/../following-sibling::div[1]") {
    @WithoutContext
    val uploadedDocumentRow by UploadedDocumentRow()

}

class UploadedDocumentRow : Element by xpath("//*[contains(@class,'content active')]") {
    val checkbox by xpath("//*[@class='bold ui checkbox']")
    val closeIcon by xpath("//*[@data-test='deleteBtn']")

}

class DeletedDocuments : Element by xpath("//*[contains(text(),'Удаленные файлы')]/../following-sibling::div[1]") {
    val uploadedDocumentRow by DeletedDocumentRow()
}

class DeletedDocumentRow : Element by xpath("//div[@data-test='file']") {
    val checkbox by xpath("//*[@class='bold ui checkbox']")
}

class TemplatesBlock : Element by xpath("//*[contains(text(),'Шаблоны')]/../following-sibling::div[1]") {
    val checkBoxes by xpath("//*[@data-test='aui-checkbox']/..")
    val radioButton by xpath("//div[@data-test='billOptionRadio']")
}

class ClosingDocuments :
    Element by xpath("//*[contains(text(),'Закрывающие документы')]/../following-sibling::div[1]") {
    val checkBoxes by xpath("//div[@data-test=\"aui-checkbox\"]/following-sibling::*[contains(@class, 'aui-checkbox')]")

    @WithoutContext
    val title by xpath("//*[contains(text(),'Закрывающие документы')]")


    fun chooseProduct(product: String) {
        dropdownWithTitleNew["//*[@data-test='products']//*[@data-test='aui-dropdown']"] select product
    }

    fun chooseType(type: String) {
        dropdownWithTitleNew["//*[@data-test='invoicesTemplates']//*[@data-test='aui-dropdown']"] select type
    }

}

val uploadDocumentsList: Element by xpath("//div[@data-test='aui-popup-menu']/div[@data-test='aui-popup-menu-item']")

class InfoBlock : Element by xpath("//*[@data-test='infoBlock']")
