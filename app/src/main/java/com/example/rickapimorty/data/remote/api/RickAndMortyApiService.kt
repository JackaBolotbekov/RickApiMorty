package com.example.rickapimorty.data.remote.api

import com.example.rickapimorty.data.model.RickAndMortyResponse
import com.example.rickapimorty.data.model.detail.CharactersDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {

    @GET("character")
    fun getCharacter(
        @Query("page") page: Int
    ): Call<RickAndMortyResponse>

    @GET("character/{id}")
    fun getSingleCharacter(
        @Path("id") id: Int
    ): Call<CharactersDetail>
}