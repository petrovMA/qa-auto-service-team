package ru.action_tech.qa.auto.data

object FieldData {
    val PATTERN_FOR_ID = "[A-z,\\d]{8}-[A-z,\\d]{4}-[A-z,\\d]{4}-[A-z,\\d]{4}-[A-z,\\d]{12}".toPattern()
    val REGEX_FOR_ID = "[A-z,\\d]{8}-[A-z,\\d]{4}-[A-z,\\d]{4}-[A-z,\\d]{4}-[A-z,\\d]{12}".toRegex()
    val PATTERN_FOR_UKD = "\\d{4}-\\d{4}-\\d{4}-\\d{4}-\\d{4}".toPattern()
    val REGEX_FOR_UKD = "\\d{4}-\\d{4}-\\d{4}-\\d{4}-\\d{4}".toRegex()
    val REGEX_FOR_URL = "^(https?://)(.*)(\\..*)".toRegex()

    const val ZERO_ID = "00000000-0000-0000-0000-000000000000" //некоторые BR воспроизводятся только так
    const val FIRST_ID = "00000000-0000-0000-0000-000000000001" //для всех вспомогательных полей
    const val DEFAULT_ID = "3fa85f64-5717-4562-b3fc-2c963f66afa6" //сомнительно, но окей
    const val LAST_ID = "ffffffff-ffff-ffff-ffff-ffffffffffff"
    const val INVALID_ID = "123-test"

    const val ZERO_UKD = "0000-0000-0000-0000-0000"
    const val FIRST_UKD = "0000-0000-0000-0000-0001"
    const val LAST_UKD = "9999-9999-9999-9999-9999"
    const val INVALID_UKD = "123-test"

    const val INVALID_DATE = "20/02/2020"
    const val MAX_DATE = "9999-12-31T23:59"
    const val MIN_DATE = "1753-01-01T00:00"

    const val INVALID_EMAIL = "0@0.0"
    const val WRONG_EMAIL = "test-test@ya.ru"

    const val INVALID_TOKEN = "<|'[test]'|>"
    const val WRONG_TOKEN =
        "Bearer WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808-WWWWWwwwwwWWWWW_101_mmmmmMMMMMmmmmm-808"
}