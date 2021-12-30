package com.vamarmu.data.source

import com.vamarmu.domain.MarvelCharacter


interface RemoteDataSource {

    suspend fun getCharacters() : List<MarvelCharacter>?

    suspend fun getDetailCharacter(id : Int) : MarvelCharacter?
}