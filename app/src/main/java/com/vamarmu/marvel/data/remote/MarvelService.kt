package com.vamarmu.marvel.data.remote

import com.vamarmu.marvel.data.remote.models.CharacterDataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.Path

interface MarvelService {

    @GET("characters")
    suspend fun getCharacters(): Response<CharacterDataWrapperResponse>


    @GET("characters/{characterId}")
    suspend fun getCharactersId(@Path("characterId") id : Int): Response<CharacterDataWrapperResponse>

}