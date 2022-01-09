package com.vamarmu.marvel.data.remote

import com.vamarmu.data.source.RemoteDataSource
import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.marvel.data.remote.models.DataWrapperResponse
import com.vamarmu.marvel.data.remote.models.CharacterResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelDataSource @Inject constructor(
    private val marvelService : MarvelService
    ) : RemoteDataSource {


    override suspend fun getCharacters(offset: Int): List<MarvelCharacter>? {
        val response: Response<DataWrapperResponse<CharacterResponse>> = marvelService.getCharacters(offset)
        return response.body()?.data?.results?.toListMarvelCharacter()
    }

    override suspend fun getDetailCharacter(
        id: Int
    ): MarvelCharacter? {
        val response: Response<DataWrapperResponse<CharacterResponse>> = marvelService.getCharactersId(id)
        return response.body()?.data?.results?.toListMarvelCharacter()?.firstOrNull()
    }
}