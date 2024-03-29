package com.br.stone.job_interview.rickandmortytrivia.network.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiClient {

    private val BASE_URL = "https://rickandmortyapi.com/api/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .build()
    }

    val characterService: CharacterService by lazy {
        retrofit.create(CharacterService::class.java)
    }
}