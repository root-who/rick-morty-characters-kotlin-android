package com.br.stone.job_interview.rickandmortytrivia.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.stone.job_interview.rickandmortytrivia.data.model.Character
import com.br.stone.job_interview.rickandmortytrivia.data.repository.CharacterRepository
import com.br.stone.job_interview.rickandmortytrivia.network.service.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class CharacterViewModel(
    private val repository: CharacterRepository
    = CharacterRepository(ApiClient.characterService)
) : ViewModel() {

    val charactersLiveData : MutableState<List<Character>> = mutableStateOf(listOf())
    val characterByIdLiveData  = mutableStateOf<Character?>(null)


    init {
        fetchCharacters()
    }

    fun getCharacterByID(id: Int) {
        characterByIdLiveData.value = null
        viewModelScope.launch{
            val response = repository.getCharacterById(id.toString())
            characterByIdLiveData.value = response
        }
    }

    private fun fetchCharacterByPage(page: Int){
        viewModelScope.launch {
            val response = repository.getCharacters(page.toString()).results
            charactersLiveData.value = response

        }
    }
    private fun fetchCharacterByName(name: String){
        viewModelScope.launch {
            val response = repository.getCharacterByName(name).results
            charactersLiveData.value = response

        }
    }
    private fun fetchCharacterByStatus(status: String){
        viewModelScope.launch {
            val response = repository.getCharacterByStatus(status).results
            charactersLiveData.value = response

        }
    }


    private fun fetchCharacters(){
        viewModelScope.launch {
            val response = repository.getCharacters("1").results
            charactersLiveData.value = response
        }

    }
}
