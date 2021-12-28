package com.vamarmu.marvel.data.remote

import com.vamarmu.data.source.RemoteDataSource
import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.domain.MarvelDetailCharacter
import com.vamarmu.marvel.data.remote.models.CharacterDataWrapperResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelDataSource @Inject constructor(
    private val marvelService : MarvelService
    ) : RemoteDataSource {

    override suspend fun getCharacters(): List<MarvelCharacter>? {
        val response: Response<CharacterDataWrapperResponse> = marvelService.getCharacters()
        return response.body()?.data?.results?.toListMarvelCharacter()
    }

    override suspend fun getDetailCharacter(
        id: Int
    ): MarvelDetailCharacter {
        TODO("Not yet implemented")
    }
}