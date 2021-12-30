package com.vamarmu.marvel.ui.extension

import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.marvel.ui.list.ItemDataView

fun MarvelCharacter.toItem() = ItemDataView(
    id = this.id?:0,
    title = this.name?:"",
    thumbnail = this.thumbnail
)

fun List<MarvelCharacter>.toListItem() = this.map { it.toItem() }

