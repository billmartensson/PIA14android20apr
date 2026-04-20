package se.magictechnology.pia14android20apr

import kotlinx.serialization.Serializable

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

