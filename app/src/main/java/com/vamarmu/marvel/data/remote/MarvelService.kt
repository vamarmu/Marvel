package com.vamarmu.marvel.data.remote

import com.vamarmu.marvel.data.remote.models.CharacterDataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface MarvelService {

    @GET("characters")
    suspend fun getCharacters(): Response<CharacterDataWrapperResponse>

}