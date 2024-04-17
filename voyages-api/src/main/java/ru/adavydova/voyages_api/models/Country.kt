package ru.adavydova.voyages_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String
) {
    fun getCountryCode(): String? {
        return when(name){
            "Албания" -> "AL"
            "Аргентина" -> "AR"
            "Армения" -> "AM"
            "Австралия"-> "AU"
            "Австрия" -> "AT"
            "Беларусь" -> "BY"
            "Бельгия" -> "BE"
            "Бразилия" -> "BR"
            "Болгария" -> "BG"
            "Канада" -> "CA"
            "Чили" -> "CL"
            "Колумбия" -> "CO"
            "Хорватия" -> "HR"
            "Кипр" -> "CY"
            "Чешская Республика" -> "CZ"
            "Дания" -> "DK"
            "Эстония" -> "EE"
            "Финляндия" -> "FI"
            "Франция" -> "FR"
            "Грузия" -> "GE"
            "Германия" -> "DE"
            "Греция" -> "GR"
            "Гонконг" -> "HK"
            "Венгрия" -> "HU"
            "Исландия" -> "IS"
            "Индия" -> "IN"
            "Ирландия" -> "IE"
            "Израиль" -> "IL"
            "Италия" -> "IT"
            "Япония" -> "JP"
            "Казахстан" -> "KZ"
            "Латвия" -> "LV"
            "Литва" -> "LT"
            "Люксембург" -> "LU"
            "Мальта" -> "MT"
            "Черногория" -> "ME"
            "Нидерланды" -> "NL"
            "Новая Зеландия" -> "NZ"
            "Норвегия" -> "NO"
            "Панама" -> "PA"
            "Польша" -> "PL"
            "Португалия" -> "PT"
            "Румыния" -> "RO"
            "Россия" -> "RU"
            "Сербия" -> "RS"
            "Сингапур" -> "SG"
            "Словакия" -> "SK"
            "ЮАР" -> "ZA"
            "Испания" -> "ES"
            "Швеция" -> "SE"
            "Швейцария"-> "CH"
            "Танзания"-> "TZ"
            "Тайланд" -> "TH"
            "Турция" -> "TR"
            "Украина" -> "UA"
            "Объединенные Арабские Эмираты" -> "AE"
            "Великобритания" -> "GB"
            "США" -> "US"
            "Узбекистан" -> "UZ"
            "Ватикан" -> "VA"
            else -> null
        }
    }
}
