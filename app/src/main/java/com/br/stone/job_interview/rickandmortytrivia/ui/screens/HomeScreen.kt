package com.br.stone.job_interview.rickandmortytrivia.ui.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.br.stone.job_interview.rickandmortytrivia.ui.components.CharacterList
import com.br.stone.job_interview.rickandmortytrivia.ui.components.Filter
import com.br.stone.job_interview.rickandmortytrivia.ui.viewmodel.CharacterViewModel


@Composable
fun HomeScreen(onCharacterSelected: (Int) -> Unit, characterViewModel:CharacterViewModel){
    val characters = characterViewModel.charactersLiveData.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Filter()
        CharacterList(characters = characters, onCharacterSelected)
    }
}