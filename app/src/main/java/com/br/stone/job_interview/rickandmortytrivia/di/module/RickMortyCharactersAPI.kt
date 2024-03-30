package com.br.stone.job_interview.rickandmortytrivia.di.module

import com.br.stone.job_interview.rickandmortytrivia.network.service.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RickMortyCharactersAPI {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterService(retrofit:Retrofit): CharacterService{
        return retrofit.create(CharacterService::class.java)
    }



}