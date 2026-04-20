package se.magictechnology.pia14android20apr

import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val title : String,
    val description : String,
    val price : String,
    val menutype : String,
    val image : String
)

