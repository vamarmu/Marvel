package com.vamarmu.marvel.ui.extension

import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.domain.MarvelImage
import com.vamarmu.marvel.ui.list.Item

fun MarvelCharacter.toItem() = Item(
    title = this.name?:"",
    thumb = this.thumbnail.getUrl()
)

fun List<MarvelCharacter>.toListItem() = this.map { it.toItem() }


fun MarvelImage?.getUrl() = this?.let { "$path.$extension".replace("http://", "https://") } ?:""