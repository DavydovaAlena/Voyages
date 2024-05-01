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

    fun getCountryImage(): String {
        return when(slug){
            "albania" -> "https://images.unsplash.com/photo-1576709501191-a9ccd791f174?q=80&w=1064&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "argentina" -> "https://images.unsplash.com/photo-1626368185783-7c928d6f0133?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "armenia" -> "https://images.unsplash.com/photo-1583610261946-5d88e555be93?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "australia"-> "https://images.unsplash.com/photo-1494233892892-84542a694e72?q=80&w=1065&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "austria" -> "https://images.unsplash.com/photo-1578763748270-d3b2ae8035c1?q=80&w=1061&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "belarus" -> "https://images.unsplash.com/photo-1604042834213-db512237efdf?q=80&w=1065&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "belgium" -> "https://images.unsplash.com/photo-1602518529037-e127b28c6acb?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "brazil" -> "https://images.unsplash.com/photo-1516834611397-8d633eaec5d0?q=80&w=1035&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "bulgaria" -> "https://images.unsplash.com/photo-1590603038171-01e7a8f8e9ee?q=80&w=1064&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "canada" -> "https://images.unsplash.com/photo-1572731013456-5ed911024bfa?q=80&w=1064&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "chile" -> "https://images.unsplash.com/photo-1556741495-4a9f3c6935e8?q=80&w=1029&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "colombia" -> "https://images.unsplash.com/photo-1578398192993-b64a40ecb690?q=80&w=1035&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "croatia" -> "https://images.unsplash.com/photo-1587049521765-7a44f3673ba4?q=80&w=1064&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "cyprus" -> "https://images.unsplash.com/photo-1628338517010-2099cf634003?q=80&w=1035&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "czechia" -> "https://images.unsplash.com/photo-1563804026626-f0225ec1817a?q=80&w=1036&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "china" -> "https://images.unsplash.com/photo-1516545595035-b494dd0161e4?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "denmark" -> "https://images.unsplash.com/photo-1534684105949-56869170677f?q=80&w=1171&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "estonia" -> "https://images.unsplash.com/photo-1601297830297-738d875c18c8?q=80&w=951&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "finland" -> "https://images.unsplash.com/photo-1556275088-e1157e8549fb?q=80&w=1035&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "france" -> "https://images.unsplash.com/photo-1503917988258-f87a78e3c995?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "georgia" -> "https://images.unsplash.com/photo-1589308799410-3720367edbb5?q=80&w=994&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "germany" -> "https://images.unsplash.com/photo-1449452198679-05c7fd30f416?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "greece" -> "https://images.unsplash.com/photo-1603565816030-6b389eeb23cb?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "hong-kong" -> "https://images.unsplash.com/photo-1577283617116-cad711fc556d?q=80&w=1065&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "hungary" -> "https://images.unsplash.com/photo-1541343672885-9be56236302a?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "iceland" -> "https://images.unsplash.com/photo-1531168556467-80aace0d0144?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "india" -> "https://images.unsplash.com/photo-1585506942812-e72b29cef752?q=80&w=1028&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "ireland" -> "https://images.unsplash.com/photo-1593091781860-a3ed7144fc20?q=80&w=1024&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "israel" -> "https://images.unsplash.com/photo-1592989847276-d9d6a8dab73d?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "italy" -> "https://images.unsplash.com/photo-1569416078500-3857b00616f8?q=80&w=1036&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "japan" -> "https://images.unsplash.com/photo-1491884662610-dfcd28f30cfb?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "kazakhstan" -> "https://images.unsplash.com/photo-1602680120344-d17114b4a92f?q=80&w=1031&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "latvia" -> "https://images.unsplash.com/photo-1566297558982-b511b3690b94?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "lithuania" -> "https://images.unsplash.com/photo-1622134093410-ba321c0a6955?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "luxembourg" -> "https://images.unsplash.com/photo-1564591419939-c067a954ec9d?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "malta" -> "https://images.unsplash.com/photo-1562923928-6078542d1ad1?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "montenegro" -> "https://images.unsplash.com/photo-1587551329971-31ef450a12f3?q=80&w=1226&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "netherlands" -> "https://images.unsplash.com/photo-1600530874602-1f02aed1cada?q=80&w=1064&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "new-zealand" -> "https://images.unsplash.com/photo-1528287942171-fbe365d1d9ac?q=80&w=1160&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "norway" -> "https://images.unsplash.com/photo-1527004013197-933c4bb611b3?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "panama" -> "https://images.unsplash.com/photo-1561588779-25db6ec67cf1?q=80&w=1227&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "poland" -> "https://images.unsplash.com/photo-1576926545793-c6c17a013b79?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "portugal" -> "https://images.unsplash.com/photo-1511968822213-92de73315bba?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "puerto-rico"-> "https://images.unsplash.com/photo-1579687196614-2004f5cd4b7d?q=80&w=2127&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "romania" -> "https://images.unsplash.com/photo-1600120965871-88f31feadee6?q=80&w=1227&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "russia" -> "https://images.unsplash.com/photo-1547448415-e9f5b28e570d?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "serbia" -> "https://images.unsplash.com/photo-1625922870181-d215f15d1fe8?q=80&w=1227&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "singapore" -> "https://images.unsplash.com/photo-1604481332827-8ad11f846761?q=80&w=1227&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "slovakia" -> "https://images.unsplash.com/photo-1562779346-e43d30d2e647?q=80&w=1064&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "slovenia" -> "https://images.unsplash.com/photo-1584520156104-f9a32b3270aa?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "south-africa" -> "https://images.unsplash.com/photo-1602367381755-effb73319501?q=80&w=1066&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "spain" -> "https://images.unsplash.com/photo-1559386081-325882507af7?q=80&w=1036&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "sweden" -> "https://images.unsplash.com/photo-1557470513-25d1365ef477?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "switzerland"-> "https://images.unsplash.com/photo-1516490701444-1daf45984537?q=80&w=1227&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "tanzania"-> "https://images.unsplash.com/photo-1633187822727-076af509bd65?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "thailand" -> "https://images.unsplash.com/photo-1612229370908-5d1648e1d0a3?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "turkey" -> "https://images.unsplash.com/photo-1617002424329-cdf48dadb1ad?q=80&w=988&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "ukraine" -> "https://images.unsplash.com/photo-1571577550347-2baf404d212b?q=80&w=1035&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "united-arab-emirates" -> "https://images.unsplash.com/photo-1584551246679-0daf3d275d0f?q=80&w=1064&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "united-kingdom" -> "https://images.unsplash.com/photo-1581881594162-1ff4485d2d64?q=80&w=1035&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "united-states" -> "https://images.unsplash.com/photo-1572925192237-6ff8e0599888?q=80&w=1065&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "uzbekistan" -> "https://images.unsplash.com/photo-1665739825146-a83b4aeaf3fe?q=80&w=983&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            "vatican" -> "https://images.unsplash.com/photo-1602940614745-b01c749443e4?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            else -> ""
        }
    }
    fun getCountryCode(): String? {
        return when(slug){
            "albania" -> "AL"
            "argentina" -> "AR"
            "armenia" -> "AM"
            "australia"-> "AU"
            "austria" -> "AT"
            "belarus" -> "BY"
            "belgium" -> "BE"
            "brazil" -> "BR"
            "bulgaria" -> "BG"
            "canada" -> "CA"
            "chile" -> "CL"
            "china"-> "CN"
            "colombia" -> "CO"
            "croatia" -> "HR"
            "cyprus" -> "CY"
            "czechia" -> "CZ"
            "denmark" -> "DK"
            "estonia" -> "EE"
            "finland" -> "FI"
            "france" -> "FR"
            "georgia" -> "GE"
            "germany" -> "DE"
            "greece" -> "GR"
            "hong-kong" -> "HK"
            "hungary" -> "HU"
            "iceland" -> "IS"
            "india" -> "IN"
            "ireland" -> "IE"
            "israel" -> "IL"
            "italy" -> "IT"
            "japan" -> "JP"
            "kazakhstan" -> "KZ"
            "latvia" -> "LV"
            "lithuania" -> "LT"
            "luxembourg" -> "LU"
            "malta" -> "MT"
            "montenegro" -> "ME"
            "netherlands" -> "NL"
            "new-zealand" -> "NZ"
            "norway" -> "NO"
            "panama" -> "PA"
            "poland" -> "PL"
            "portugal" -> "PT"
            "puerto-rico"-> "PR"
            "romania" -> "RO"
            "russia" -> "RU"
            "serbia" -> "RS"
            "singapore" -> "SG"
            "slovakia" -> "SK"
            "slovenia" -> "SI"
            "south-africa" -> "ZA"
            "spain" -> "ES"
            "sweden" -> "SE"
            "switzerland"-> "CH"
            "tanzania"-> "TZ"
            "thailand" -> "TH"
            "turkey" -> "TR"
            "ukraine" -> "UA"
            "united-arab-emirates" -> "AE"
            "united-kingdom" -> "GB"
            "united-states" -> "US"
            "uzbekistan" -> "UZ"
            "vatican" -> "VA"
            else -> null
        }
    }
}
