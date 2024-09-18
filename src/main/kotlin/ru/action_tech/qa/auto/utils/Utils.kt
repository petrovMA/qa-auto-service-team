package ru.action_tech.qa.auto.utils

import com.aspose.cells.PdfSaveOptions
import com.aspose.cells.Workbook
import com.codeborne.selenide.Selectors.by
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import de.redsix.pdfcompare.CompareResultImpl
import de.redsix.pdfcompare.PdfComparator
import de.redsix.pdfcompare.env.SimpleEnvironment
import io.qameta.allure.Attachment
import io.restassured.builder.RequestSpecBuilder
import io.restassured.response.Response
import org.apache.commons.lang3.math.NumberUtils
import org.jetbrains.kotlin.com.google.gson.Gson
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils.randomNumeric
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.commons.generator.entity.user.FIO
import ru.action_tech.qa.auto.core.commons.generator.entity.user.Gender
import ru.action_tech.qa.auto.core.commons.generator.entity.user.Gender.*
import ru.action_tech.qa.auto.core.selenide.elements.*
import ru.action_tech.qa.auto.core.serialization.Mapper
import ru.action_tech.qa.auto.data.firstNameList
import ru.action_tech.qa.auto.data.middleNameList
import ru.action_tech.qa.auto.utils.auth.getToken
import ru.action_tech.qa.auto.utils.auth.publicApiToken
import ru.action_tech.qa.auto.utils.auth.tokenActionushka
import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.ByteArrayOutputStream
import java.io.File
import java.math.RoundingMode
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random

fun objToJson(obj: Any): String = Gson().toJson(obj)

fun Response.getValue(path: String): String = this.jsonPath().getString(path)

//Метод сделан для таблиц, которые пересчитываются при скроле
inline fun <reified T : Element> T.scrollToAndCheck(checkerInter: (T) -> Boolean, upperBound: Int = 100): T {
    var arr: Elements<T> = this.all
    var arrSize = arr.size
    for (i in 0..upperBound) {
        if (arrSize == i + 1) {
            arr = this.all
            arrSize = this.all.size
        }
        arr[i].scrollTo
        if (checkerInter(arr[i])) {
            return arr[i]
        }
    }
    throw NoSuchElementException("Нет такого элемента в списе")
}

fun String.getValueWithoutSymbolAndSpaces() = this.replace(Regex("""[^A-Za-z0-9*$]"""), "")

fun getRandom(range: Int) = Random.nextInt(range)

fun isAllElementsContainsText(element: Element, textToCheck: String) =
    element.all.none { !it.text.contains(textToCheck) }

fun getFileFromResources(pathToFile: Path) =
    File(URLDecoder.decode(ClassLoader.getSystemResource(pathToFile.toString()).file, "UTF-8"))

fun getFileFromListByName(name: String, list: List<File>): File? =
    list.find { it.toString().lowercase().contains(name.lowercase()) }

@Attachment(value = "{name}", type = "application/txt", fileExtension = "txt")
@Suppress("UNUSED_PARAMETER")
fun attachData(name: String, text: String) = text.toByteArray()

fun comparePdf(expected: File, actual: File, differenceInPercent: Double = 0.3) {

    @Suppress("UNUSED_PARAMETER")
    @Attachment(value = "{0}", type = "application/pdf", fileExtension = "pdf")
    fun attachPDF(fileName: String, pdf: ByteArray) = pdf

    val compareResult = PdfComparator(expected, actual, CompareResultImpl())
        .withEnvironment(SimpleEnvironment().setAllowedDiffInPercent(differenceInPercent)).compare()
    val outputStream = ByteArrayOutputStream()

    val result = compareResult.writeTo(outputStream)

    try {
        assertTrue(result)
    } catch (error: AssertionError) {
        attachPDF("PDFComparisonResult", outputStream.toByteArray())
        throw error
    }
}

fun getRandomNumberToString(startRange: Long = 1000000000, endRange: Long = 9999999999) =
    (startRange..endRange).random().toString()

fun getRandomRussianNumberToString(startRange: Long = 100000000, endRange: Long = 999999999): String {
    val nums = intArrayOf(3, 4, 8, 9)
    return nums.random().toString() + (startRange..endRange).random().toString()
}

fun getRandomString(length: Int): String {
    val allowedChars = ('А'..'Я') + ('а'..'я')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}

fun getRandomRussianNumberWithPrefix98(): String = "98" + getRandomRussianNumberToString()

/**
 * Преобразует из "8001112233" в "+7 800 111-22-33".
 */
fun prettifyRussianPhone(phone: String) = phone.replace(Regex("(\\d{3})(\\d{3})(\\d{2})(\\d{2})"), "+7 $1 $2-$3-$4")

fun excel2Pdf(incomingFile: File): File {
    val pdfSaveOptions = PdfSaveOptions()
    pdfSaveOptions.onePagePerSheet = true

    val workbook = Workbook(incomingFile.path)
    val outputFile = incomingFile.path.replaceAfterLast(".", "pdf")
    workbook.save(outputFile, pdfSaveOptions)
    return File(outputFile)
}

fun replaceCommaToDot(text: String) = text.replace(",", ".")

fun replaceDotToComma(text: String) = text.replace(".", ",")

fun roundDouble(number: Double, n: Int) = String.format("%.${n}f", number)

fun closeSystemPopup() {
    Robot().apply {
        Thread.sleep(5000)
        keyPress(KeyEvent.VK_ESCAPE)
        keyRelease(KeyEvent.VK_ESCAPE)
        keyPress(KeyEvent.VK_ESCAPE)
        keyRelease(KeyEvent.VK_ESCAPE)
    }
}

val Any.uuid: UUID get() = UUID.fromString(this as String)

fun dataTest(dataTest: String) = find(by("data-test", dataTest))

fun dropdown(label: String) = xpath("//*[text()='$label']/../*[@data-test='aui-dropdown']")

fun getTokenByLogin(login: String, token: String? = tokenActionushka) = identityApi
    .send(getToken(login = login, grantType = "token", token = token))
    .getValue("access_token")

fun getPublicApiTokenByLogin(login: String, token: String? = publicApiToken) = identityApi
    .send(getToken(login = login, clientId = "public-api", grantType = "token", token = token))
    .getValue("access_token")

fun randomSnils() = Array(3) { randomNumeric(3) }.joinToString("-") + ' ' + randomNumeric(2)

fun randomName(gender: Gender = UNKNOWN, lastName: String? = null) = when (gender) {
    MALE -> 1
    FEMALE -> 2
    else -> (1..2).random()
}.let { genderType ->
    FIO(
        lastName = lastName ?: if (genderType == 1) "Автотестов" else "Автотестова",
        firstName = firstNameList.filter { it.genderType == genderType }.random().name,
        middleName = middleNameList.filter { it.genderType == genderType }.random().name
    )
}


val nonNullMapper: ObjectMapper = ObjectMapper().apply { setSerializationInclusion(JsonInclude.Include.NON_NULL) }

fun RequestSpecBuilder.setBody(body: Any?, isNonNull: Boolean): RequestSpecBuilder = if (isNonNull) {
    setBody(nonNullMapper.writeValueAsString(body))
} else {
    setBody(body)
}

fun String.priceToDouble(): Double = this
    .replace(Regex("[^\\d,]"), "")
    .replace(",", ".")
    .toDouble()

fun Double.round(decimalPlaces: Int): Double =
    NumberUtils.toScaledBigDecimal(this, decimalPlaces, RoundingMode.HALF_UP).toDouble()

inline fun <reified T> String.deserialize(): T = Mapper.json(strict = false).readValue(this)
inline fun <reified T> Response.deserialize(): T = body().asString().deserialize()
inline fun <reified T> JsonNode.deserialize(): T = toString().deserialize()

fun getStringTime(time: Instant = Instant.now(), formatter: DateTimeFormatter = DateTimeFormatter.ISO_INSTANT) =
    formatter.format(time)!!

fun getStringTime(time: LocalDate, formatter: DateTimeFormatter = DateTimeFormatter.ISO_INSTANT) =
    formatter.format(time)!!

fun getStringTime(time: LocalDate, pattern: String) = DateTimeFormatter.ofPattern(pattern).format(time)!!

fun <T> resourceFile(clazz: Class<T>, name: String): File = File(clazz.getResource(name)!!.file)

fun String.urlEncode(enc: String = StandardCharsets.UTF_8.toString()): String = java.net.URLEncoder.encode(this, enc)
