package com.vamarmu.marvel.data.remote

import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.domain.MarvelImage
import com.vamarmu.domain.MarvelResourceList
import com.vamarmu.domain.MarvelResourceSummary
import com.vamarmu.marvel.data.remote.models.CharacterResponse
import com.vamarmu.marvel.data.remote.models.ImageResponse
import com.vamarmu.marvel.data.remote.models.ResourceListResponse
import com.vamarmu.marvel.data.remote.models.ResourceSummaryResponse


fun CharacterResponse.toMarvelCharacter(): MarvelCharacter = MarvelCharacter(
    id = this.id,
    name = this.name,
    description = this.description,
    thumbnail = this.thumbnail?.toMarvelImage(),
    resourceUri = this.resourceUri,
    comics = this.comics.toMarvelResourceList(),
    stories = this.stories.toMarvelResourceList(),
    events = this.events.toMarvelResourceList(),
    series = this.series.toMarvelResourceList()
)

fun ImageResponse.toMarvelImage() = MarvelImage(
    path = this.path,
    extension = this.extension
)

fun List<CharacterResponse>.toListMarvelCharacter()=
    this.map { it.toMarvelCharacter() }

fun ResourceListResponse.toMarvelResourceList() = MarvelResourceList(
    collectionURI = this.collectionURI,
    items = this.items?.map { it.toMarvelResourceSummary() }
)

fun ResourceSummaryResponse.toMarvelResourceSummary() = MarvelResourceSummary(
    resourceUri = this.resourceUri,
    name = this.name,
    type = this.type
)