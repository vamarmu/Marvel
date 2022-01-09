package com.vamarmu.marvel.data.remote

import com.vamarmu.marvel.data.remote.models.CharacterResponse
import com.vamarmu.marvel.data.remote.models.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 50,
    ): Response<DataWrapperResponse<CharacterResponse>>


    @GET("characters/{characterId}")
    suspend fun getCharactersId(@Path("characterId") id : Int): Response<DataWrapperResponse<CharacterResponse>>

}