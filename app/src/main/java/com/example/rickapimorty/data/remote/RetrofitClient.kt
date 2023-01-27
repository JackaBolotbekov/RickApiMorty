package com.example.rickapimorty.data.remote

import com.example.rickapimorty.data.remote.api.RickAndMortyApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val rickAndMortyApiService: RickAndMortyApiService = retrofit.create(RickAndMortyApiService::class.java)
}