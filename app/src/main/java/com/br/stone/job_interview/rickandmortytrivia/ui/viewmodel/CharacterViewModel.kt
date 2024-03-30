package com.br.stone.job_interview.rickandmortytrivia.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.stone.job_interview.rickandmortytrivia.data.model.Character
import com.br.stone.job_interview.rickandmortytrivia.data.model.CharacterApiResponse
import com.br.stone.job_interview.rickandmortytrivia.data.repository.CharacterRepository
import com.br.stone.job_interview.rickandmortytrivia.network.service.ApiClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException


class CharacterViewModel(
    private val repository: CharacterRepository
    = CharacterRepository(ApiClient.characterService)
) : ViewModel() {

    val charactersLiveData : MutableState<CharacterApiResponse?> = mutableStateOf(null)
    val characterByIdLiveData  = mutableStateOf<Character?>(null)
    val charactersCurrentPage  = mutableIntStateOf(1)
    val characterslastPage = mutableStateOf<Int?>(1)
    val apiRequestError = mutableStateOf<String?>(null)



    init {
        fetchCharacters()
    }

    fun getCharacterByID(id: Int) {
        characterByIdLiveData.value = null
        viewModelScope.launch{
            try{
                val response = repository.getCharacterById(id.toString())
                characterByIdLiveData.value = response
                apiRequestError.value = null
            }
            catch (e: HttpException) {
                charactersLiveData.value = null
                apiRequestError.value = "Opss... sounds like it happen an error during searching this character, try again later please :)"
            }

        }


    }

    fun fetchCharacterByPage(page: Int, onResetScroll:()-> Unit){
        viewModelScope.launch {
            try{
                val response = repository.getCharacters(page.toString())
                charactersLiveData.value = response
                charactersCurrentPage.intValue = page
                characterslastPage.value = response.info.pages
                apiRequestError.value = null
                delay(20)
                onResetScroll()
            }
            catch (e: HttpException) {
                charactersLiveData.value = null
                apiRequestError.value = "Opss... sounds like it happen an error during searching this characters page, try again later please :)"
            }
        }
    }
    fun fetchCharacterByFilter(status: String?, name:String?, onResetScroll:()-> Unit ){
        viewModelScope.launch {
            try{
                val response = repository.getCharacterByFilter(status, name)
                charactersLiveData.value = response
                charactersCurrentPage.intValue = 1
                characterslastPage.value = response.info.pages
                apiRequestError.value = null
            }
            catch (e: HttpException) {
                charactersLiveData.value = null
                apiRequestError.value = "Opss... sounds like it happen an error during filtering or does not exist characters with this combined filters, try again please  :)"
            }


        }
    }


    private fun fetchCharacters(){
        viewModelScope.launch {
            val response = repository.getCharacters("1")
            charactersLiveData.value = response
            charactersCurrentPage.intValue = 1
            characterslastPage.value = response.info.pages
            apiRequestError.value = null
        }

    }
}
