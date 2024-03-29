package com.br.stone.job_interview.rickandmortytrivia.data.repository

import com.br.stone.job_interview.rickandmortytrivia.network.service.CharacterService

class CharacterRepository(private val characterService: CharacterService ) {

    suspend fun getCharacters(page:String) = characterService.fetchData(page)

    suspend fun getCharacterById(id:String) = characterService.fetchCharacterById(id)

    suspend fun getCharacterByName(name:String) = characterService.fetchCharacterByName(name)

    suspend fun getCharacterByStatus(status:String) = characterService.fetchCharacterByStatus(status)


}