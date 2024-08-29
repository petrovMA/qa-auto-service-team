package ru.action_tech.qa.auto.data

import ru.action_tech.qa.auto.api_models.dictionary.getcountry.GetCountryResponse
import ru.action_tech.qa.auto.utils.uuid

enum class Country(val countryName: String, val code: String, val id: String) {
    RUS("Россия", "+7", id = "89867ae0-3b4e-4a33-9246-4eae3e22e850"),
    BEL("Белоруссия", "+375", id = "497e09a7-b11f-e511-80fb-78e3b502da44"),
    KZ("Казахстан", "+7", id = "901faa56-cb34-43f7-9a39-146b17919bbc"),
    UKR("Украина", "+380", id = "17694759-dda8-4854-88bf-4c93ebe03d63"),
    UZ("Узбекистан", "+998", id = "04785279-ba31-4587-8c9e-aba1100a9621"),

}

val getCountryList by lazy {
    listOf(
        GetCountryResponse(
            countryId = "91318d75-2f13-464b-85a9-4915a71a9cca".uuid,
            name = "Азербайджан",
            showInShowcase = true,
            countryCode = "az",
            iso = "az",
            code = "994",
            phoneMask = "1111-11-11"
        ),
        GetCountryResponse(
            countryId = "7316bbd0-c792-48fe-9622-8cf160ec04e9".uuid,
            name = "Армения",
            showInShowcase = true,
            countryCode = "am",
            iso = "am",
            code = "374",
            phoneMask = "111-11-11"
        ),
        GetCountryResponse(
            countryId = "497e09a7-b11f-e511-80fb-78e3b502da44".uuid,
            name = "Белоруссия",
            showInShowcase = true,
            countryCode = "by",
            iso = "by",
            code = "375",
            phoneMask = "111 111-111"
        ),
        GetCountryResponse(
            countryId = "0236f8c9-56ed-437e-bab9-554c68d27ce1".uuid,
            name = "Грузия",
            showInShowcase = true,
            countryCode = "ge",
            iso = "ge",
            code = "995",
            phoneMask = "1111-11-11"
        ),
        GetCountryResponse(
            countryId = "901faa56-cb34-43f7-9a39-146b17919bbc".uuid,
            name = "Казахстан",
            showInShowcase = true,
            countryCode = "kz",
            iso = "kz",
            code = "7",
            phoneMask = "111 111-11-11"
        ),
        GetCountryResponse(
            countryId = "e17783a3-d640-e911-bb9e-00155d627f03".uuid,
            name = "Кыргызстан",
            showInShowcase = true,
            countryCode = "kg",
            iso = "kg",
            code = "996",
            phoneMask = "111-11-11"
        ),
        GetCountryResponse(
            countryId = "e85b4c1b-b21a-46e4-8bc9-26c29a341c3c".uuid,
            name = "Молдавия",
            showInShowcase = true,
            countryCode = "md",
            iso = "md",
            code = "373",
            phoneMask = "111 1-11-11"
        ),
        GetCountryResponse(
            countryId = "89867ae0-3b4e-4a33-9246-4eae3e22e850".uuid,
            name = "Россия",
            showInShowcase = true,
            countryCode = "ru",
            iso = "ru",
            code = "7",
            phoneMask = "111 111-11-11"
        ),
        GetCountryResponse(
            countryId = "0580d541-0624-4271-bd30-aaaad37220ea".uuid,
            name = "Таджикистан",
            showInShowcase = true,
            countryCode = "tj",
            iso = "tj",
            code = "992",
            phoneMask = "1111-11-11"
        ),
        GetCountryResponse(
            countryId = "e827b660-4f4f-4515-a780-2403f07e3a23".uuid,
            name = "Туркменистан",
            showInShowcase = true,
            countryCode = "tm",
            iso = "tm",
            code = "996",
            phoneMask = "1111-11-11"
        ),
        GetCountryResponse(
            countryId = Country.UZ.id.uuid,
            name = "Узбекистан",
            showInShowcase = true,
            countryCode = "uz",
            iso = "uz",
            code = "998",
            phoneMask = "11-111-1111"
        ),
        GetCountryResponse(
            countryId = "17694759-dda8-4854-88bf-4c93ebe03d63".uuid,
            name = "Украина",
            showInShowcase = true,
            countryCode = "ua",
            iso = "ua",
            code = "380",
            phoneMask = "111 111-111"
        )
    )
}
