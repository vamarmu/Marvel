package com.vamarmu.marvel.ui.list

import com.vamarmu.domain.MarvelImage

data class ItemDataView(
    val id : Int,
    val thumbnail : MarvelImage?,
    val title : String
)
