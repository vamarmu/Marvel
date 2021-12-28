package com.vamarmu.domain

data class MarvelCharacter(

    val id : Int?,
    val name :String?,
    val description:String?,
    val thumbnail : MarvelImage?,
    val resourceUri : String?
)