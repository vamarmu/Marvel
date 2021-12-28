package com.vamarmu.data.repository

import com.vamarmu.data.source.RemoteDataSource
import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.domain.MarvelDetailCharacter

class Repository (
    private val remoteDataSource: RemoteDataSource){

    suspend fun getCharacters( ) : List<MarvelCharacter>? {
        return remoteDataSource.getCharacters()
    }

    suspend fun getDetailCharacter( id : Int) : MarvelDetailCharacter {
        return remoteDataSource.getDetailCharacter(id = id)
    }


}