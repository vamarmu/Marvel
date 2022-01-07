package com.vamarmu.domain

data class MarvelCharacter(

    val id : Int?,
    val name :String?,
    val description:String?,
    val thumbnail : MarvelImage?,
    val resourceUri : String?,
    val comics : MarvelResourceList,
    val stories : MarvelResourceList,
    val events : MarvelResourceList,
    val series : MarvelResourceList,
)

data class MarvelResourceList (
    val collectionURI : String?,
    val items : List<MarvelResourceSummary>?
)


data class MarvelResourceSummary(
    val resourceUri: String?,
    val name :String?,
    val type : String? = null
)
