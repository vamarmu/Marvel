package com.vamarmu.data.source

import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.domain.MarvelDetailCharacter


interface RemoteDataSource {

    suspend fun getCharacters() : List<MarvelCharacter>?

    suspend fun getDetailCharacter(id : Int) : MarvelDetailCharacter
}