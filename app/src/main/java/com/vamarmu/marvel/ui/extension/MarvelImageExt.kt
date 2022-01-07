package com.vamarmu.marvel.ui.extension

import com.vamarmu.domain.AspectRatioImage
import com.vamarmu.domain.MarvelImage


fun MarvelImage?.getUrl() = this?.let {
    "$path.$extension".replace("http://", "https://")
}

fun MarvelImage?.getUrlWithAspectRatio(aspectRatio: AspectRatioImage = AspectRatioImage.standard_fantastic) = this?.let {
    "$path/${aspectRatio.name}.$extension".replace("http://", "https://")
}