package se.magictechnology.pia14android20apr

import kotlinx.serialization.Serializable

@Serializable
data class PiaconfigAPI(val welcometext: String, val menutypes: List<MenuType>)

@Serializable
data class MenuType(
    val menukey : String,
    val title : String,
    val description : String
)

@Serializable
data class RestuarantsAPI(val restaurants: List<Restaurant>)

@Serializable
data class Restaurant(
    val address : String,
    val description : String,
    val lat : Double,
    val lng : Double
)


@Serializable
data class MenulistAPI(val menu: List<MenuItem>)

@Serializable
data class MenuItem(
    val title : String,
    val description : String,
    val price : String,
    val menutype : String,
    val image : String
)


@Serializable
data class NewsAPI(val news: List<NewsItem>)


@Serializable
data class NewsItem(
    val title : String,
    val description : String,
    val date : String,
    val image : String?
)

