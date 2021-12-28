package com.vamarmu.marvel.data.remote

import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.domain.MarvelImage
import com.vamarmu.marvel.data.remote.models.CharacterResponse
import com.vamarmu.marvel.data.remote.models.ImageResponse


fun ImageResponse.toMarvelImage() = MarvelImage(
    path = this.path,
    extension = this.extension
)

fun CharacterResponse.toMarvelCharacter() = MarvelCharacter(
    id = this.id,
    name = this.name,
    description = this.description,
    thumbnail = this.thumbnail?.toMarvelImage(),
    resourceUri = this.resourceUri
)

fun List<CharacterResponse>.toListMarvelCharacter()=
    this.map { it.toMarvelCharacter() }