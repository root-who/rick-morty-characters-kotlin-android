package com.br.stone.job_interview.rickandmortytrivia.network.service

import com.br.stone.job_interview.rickandmortytrivia.data.model.Character
import com.br.stone.job_interview.rickandmortytrivia.data.model.CharacterApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character/")
    suspend fun fetchData(@Query("page") page:String): CharacterApiResponse

    @GET("character/{id}")
    suspend fun fetchCharacterById(@Path("id") id:String): Character

    @GET("character/")
    suspend fun fetchCharacterByName(@Query("name") name:String): CharacterApiResponse
    @GET("character/")
    suspend fun fetchCharacterByStatus(@Query("status") status:String): CharacterApiResponse
}